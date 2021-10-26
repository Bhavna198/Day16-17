package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

class Permutation {
    public static ArrayList<String> permutation(String str, ArrayList<String> list) {
        int length = str.length();
        if (length == 1) {
            list.add(str);
            return list;
        }

        list = permutation(str.substring(0, length - 1), list);
        int ls = list.size();
        char ap = str.charAt(length - 1);
        for (int i = 0; i < ls; i++) {
            String temp = list.get(i);
            int tl = temp.length();
            for (int j = 0; j <= tl; j++) {
                list.add(temp.substring(0, j) + ap + temp.substring(j, tl));
            }
        }

        while (true) {
            String temp = list.get(0);
            if (temp.length() < length)
                list.remove(temp);
            else
                break;
        }

        return list;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String str= sc.next();
        ArrayList<String> list = new ArrayList<>();
        list = permutation(str, list);
        System.out.println("Total Permutations : " + list.size());
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

    }
}