package com.northcoders.gamboge.waddl.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Task extends BaseObservable {

    private long id;
    private String title;
    private String description;
    private boolean isCompleted;

    public Task() {
    }

    public Task(boolean isCompleted, String description, String title, long id) {
        this.isCompleted = isCompleted;
        this.description = description;
        this.title = title;
        this.id = id;
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);

    }
    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
        notifyPropertyChanged(BR.completed);
    }
}
