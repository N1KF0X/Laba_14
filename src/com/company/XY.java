package com.company;

import java.io.Serializable;

public class XY implements Serializable {
    private double x;
    private double y;
    public XY(double x){
        this.x = x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void findY(){
        this.y = Math.sin(x);
        System.out.println(y);
    }
}
