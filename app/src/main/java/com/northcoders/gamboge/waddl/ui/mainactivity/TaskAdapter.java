package com.northcoders.gamboge.waddl.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.northcoders.gamboge.waddl.R;
import com.northcoders.gamboge.waddl.databinding.TaskItemBinding;
import com.northcoders.gamboge.waddl.model.Task;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private Context context;
    private List<Task> taskList;
    private RecyclerViewInterface recyclerInterface;

    public TaskAdapter(Context context, List<Task> taskList, RecyclerViewInterface recyclerInterface) {
        this.context = context;
        this.taskList = taskList;
        this.recyclerInterface = recyclerInterface;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        private TaskItemBinding taskItemBinding;
        public TaskViewHolder(TaskItemBinding taskItemBinding, RecyclerViewInterface recyclerInterface) {
            super(taskItemBinding.getRoot());
            this.taskItemBinding = taskItemBinding;

            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TaskItemBinding taskItemBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.task_item,
                        parent,
                        false);
        return new TaskViewHolder(taskItemBinding, recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskItemBinding.setTask(task);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
