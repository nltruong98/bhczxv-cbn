/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javapbt1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai9 {
    public static int[] config;
    public static int n;

    public static void init(int n) {
        config = new int[n];
        config[0] = n;
        for (int i = 1; i < n; i++) {
            config[i] = 0;
        }
    }

    public static void show() {
        System.out.print("- " + n + " = " + config[0]);
        for (int i = 1; i < n && config[i] != 0; i++) {
            System.out.print(" + " + config[i]);
        }
        System.out.println();
    }

    public static void nextConfig() {
        int i = n - 1, s = n;
        while (config[i] == 0 || config[i] == 1) {
            i--;
        }
        config[i]--;
        for (int j = 0; j <= i; j++) {
            s -= config[j];
        }
        i++;
        for (; s > 0; i++) {
            if (s < config[i - 1]) {
                config[i] = s;
            } else {
                config[i] = config[i - 1];
            }
            s -= config[i];
        }
        for (; i < n; i++) {
            config[i] = 0;
        }
    }

    public static void listConfig() {
        show();
        while (config[0] != 1) {
            nextConfig();
            show();
        }
    }

    public static void main(String[] args) {
        System.out.println("Phân tích số thành tổng");
        System.out.println("------------------------------------");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhập số n: ");
            n = sc.nextInt();
        }
        System.out.println("------------------------------------");
        System.out.println("Có thể phân tích " + n + " thành các tổng:");
        init(n);
        listConfig();
    }
}
