package com.wangch.usertest;

public class JiaFa {

    private static int add(int a, int b){
        int c = a ^ b;
        int d = a & b;
        if(d == 0) return c;
        return add(c, d << 1);
    }

    public static void main(String[] args) {
        System.out.println(add(4, 50));
    }
}
