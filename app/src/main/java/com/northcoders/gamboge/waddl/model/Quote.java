package com.northcoders.gamboge.waddl.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Quote extends BaseObservable {


    private String content;



    public Quote(String q) {
        this.content = q;
    }

    public Quote() {
    }

    @Bindable
    public String getContent() {
        return content;
    }


}
