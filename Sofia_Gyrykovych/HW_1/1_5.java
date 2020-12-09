package com.company;

public class Task1_5 {
    public Task1_5() {
    }

    public static void main(String[] args) {
        for(int i = args.length; i > 0; --i) {
            System.out.println("args[" + i + "] : " + args[i]);
        }

    }
}