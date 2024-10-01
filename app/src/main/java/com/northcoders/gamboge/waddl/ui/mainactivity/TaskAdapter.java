package com.northcoders.gamboge.waddl.ui.mainactivity;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.northcoders.gamboge.waddl.databinding.TaskItemBinding;

import com.northcoders.gamboge.waddl.model.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private Context context;
    private List<Task> taskList;

    public TaskAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TaskItemBinding taskItemBinding;
        public TaskViewHolder(TaskItemBinding taskItemBinding) {
            super(taskItemBinding.getRoot());
            this.taskItemBinding = taskItemBinding;
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
        return new TaskViewHolder(taskItemBinding);
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
