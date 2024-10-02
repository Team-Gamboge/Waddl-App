package com.northcoders.gamboge.waddl.model;

import androidx.databinding.Bindable;

public class Quote {

    private String q;
    private String a;
    private String h;


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
