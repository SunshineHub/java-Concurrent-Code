package com.zyl.usertest;

import java.io.IOException;

public class Example {

    public static void main(String[] args) throws IOException {
        System.out.println("Hit enter to print a report, x to exit.");
        byte[] input = new byte[1];
        while (System.in.read(input) > 0) {
            if (input[0] == 'x') {
                break;
            }
            System.out.println(new Messenger().getMessage());
        }
    }

}

class Messenger {
    String a = "aa";
    String b = "bb";
    String getMessage() {
        return "Hello world1!" + a + b;
    }
}