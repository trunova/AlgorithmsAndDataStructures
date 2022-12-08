package com.company;

public class Last3Sum {
    private Integer num1 = null;
    private Integer num2 = null;
    private Integer num3 = null;

    public void put(int num){
        if (num1 != null && num2 != null && num3 != null){
            num2 = num1;
            num3 = num2;
            num1 = null;
        }
        if ( num1 != null){
            num1 = num;
        } else if (num2 != null){
            num2 = num;
        }else if (num3 != null){
            num3 = num;
        }
    }

    public int getLast3Sum(){
        int s = 0;
        if (num1 != null)
            s += num1;
        if (num2 != null)
            s += num1;
        if (num3 != null)
            s += num1;
        return s;
    }
}
