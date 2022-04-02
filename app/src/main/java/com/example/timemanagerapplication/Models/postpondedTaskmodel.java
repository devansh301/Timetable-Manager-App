package com.example.timemanagerapplication.Models;

import java.util.SplittableRandom;

public class postpondedTaskmodel
{
    String header,desc;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public postpondedTaskmodel(String header, String desc){
        this.header = header;
        this.desc = desc;
    }
}
