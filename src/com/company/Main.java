package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {





        Scanner in = new Scanner(System.in);
        System.out.println("Введите инфиксную запись, которую хотите преобразовать:");
        String input = in.nextLine();
        ToPostfixNot postfixNot = new ToPostfixNot(input);
        String postResult = postfixNot.transform();
        System.out.printf("Полученная постфиксная запись:\n%s\n",postResult);
        StringBuilder builder1 = new StringBuilder(input);
        String temp = builder1.reverse().toString();
        char [] array = temp.toCharArray();
        for (int i = 0; i < array.length; i++){
            if (array[i] == '(') array[i] = ')';
            else if (array[i] == ')') array[i] = '(';
        }
        temp = new String(array);
        ToPostfixNot preFixNot = new ToPostfixNot(temp);
        temp = preFixNot.transform();
        StringBuilder builder2 = new StringBuilder(temp);
        System.out.printf("Полученная префиксная запись:\n%s\n",builder2.reverse().toString());
    }
}
