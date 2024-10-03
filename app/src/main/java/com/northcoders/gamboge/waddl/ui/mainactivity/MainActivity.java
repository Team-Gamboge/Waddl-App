package com.northcoders.gamboge.waddl.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.gamboge.waddl.R;
import com.northcoders.gamboge.waddl.databinding.ActivityMainBinding;
import com.northcoders.gamboge.waddl.model.Quote;
import com.northcoders.gamboge.waddl.model.Task;
import com.northcoders.gamboge.waddl.ui.updatetaskactivity.UpdateTaskActivity;
import com.northcoders.gamboge.waddl.ui.updatetaskactivity.UpdateTaskActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private RecyclerView recyclerView;
    private ArrayList<Task> taskList;
    private TaskAdapter taskAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private MainActivityClickHandler clickHandler;
    private TextView quoteTextView;
    private Quote quote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickHandler = new MainActivityClickHandler(this, viewModel);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClickHandler(clickHandler);
        quoteTextView = binding.quoteTextView;
        binding.setQuote(quote);

        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        getAllTasks();
        getQuote();
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
    }

    private void getAllTasks() {
        viewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasksFromLiveData) {

                taskList = (ArrayList<Task>) tasksFromLiveData;

                displayInRecyclerView();
            }
        });
    }

    public void getQuote() {
        viewModel.getQuote().observe(this, new Observer<List<Quote>>() {
            @Override
            public void onChanged(List<Quote> quoteFromLiveData) {

                quote = quoteFromLiveData.get(0);
                quote.notifyChange();

                quoteTextView.setText(quote.getQ());
            }
        });
    }

    private void displayInRecyclerView() {
        recyclerView = binding.recyclerView;
        taskAdapter = new TaskAdapter(this, taskList, this);
        recyclerView.setAdapter(taskAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();
        taskAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, UpdateTaskActivity.class);
        intent.putExtra(Task.PARCEL_KEY, taskList.get(position));
        startActivity(intent);
    }
}