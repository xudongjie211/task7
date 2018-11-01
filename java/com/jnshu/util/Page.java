package com.jnshu.util;

import java.util.List;

public class Page {
    int start = 0;
    int count = 5;
    int last = 0;
    public void calculateLast(int total){
        if(total%count==0){
            last = total-count;
        }else {
            last = total-total%count;
        }
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
    	if(start>=0){
        this.start = start;
    	}
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

}