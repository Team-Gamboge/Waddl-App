package com.northcoders.gamboge.waddl.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.gson.annotations.SerializedName;

public class Task extends BaseObservable implements Parcelable {

    private Long id;
    private String title;
    private String description;
    @SerializedName("completed")
    private boolean isCompleted;
    public static String PARCEL_KEY = "WADDL_TASK";

    public Task() {
    }

    public Task(boolean isCompleted, String description, String title, Long id) {
        this.isCompleted = isCompleted;
        this.description = description;
        this.title = title;
        this.id = id;
    }

    protected Task(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        title = in.readString();
        description = in.readString();
        isCompleted = in.readByte() != 0;
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
        notifyPropertyChanged(BR.isCompleted);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeByte((byte) (isCompleted ? 1 : 0));
    }
}
