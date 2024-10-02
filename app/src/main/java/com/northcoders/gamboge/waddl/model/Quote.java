package com.northcoders.gamboge.waddl.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Quote extends BaseObservable {

    private String q;


    public Quote(String q) {
        this.q = q;
    }

    public Quote() {
    }

    @Bindable
    public String getQ() {
        return q;
    }


}
