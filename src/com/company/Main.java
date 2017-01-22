package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //24 задача
        printFibonacci(10);
        //25 задача
        printVampir();

    }

    public static void printFibonacci(int count){
        if (count>0) {
            int third;
            int first = 1, second = 1;
            if (count == 1)
                System.out.print(first);
            else if (count == 2)
                System.out.print(first + ", " + second);
            else {
                System.out.print(first + ", " + second);
                for (int i = 2; i < count; i++) {
                    third = first + second;
                    first = second;
                    second = third;
                    System.out.print(", " + third);
                }
            }
            System.out.println(".");
        }

    }

    public static void printVampir(){
        for(int dvuzn1 = 10; dvuzn1 < 100; dvuzn1++){
            for(int dvuzn2 = dvuzn1; dvuzn2 < 100; dvuzn2++){

                int res = dvuzn1*dvuzn2;

                char[] resChar = Integer.toString(res).toCharArray();//res преобразовываем в строку, затем записываем в массив символов
                Arrays.sort(resChar); //сортировка массива символов

                String x = Integer.toString(dvuzn1);//так само поступаем с каждым множителем
                String y = Integer.toString(dvuzn2);
                String z = x + y;//складываем символы множителей в значение из 4 символов
                char[] p = z.toCharArray();//записываем в массив
                Arrays.sort(p); //сортировка массива символов

                if(Arrays.equals(resChar, p)) { //сравниваем отсортированые масивы
                    System.out.println(dvuzn1+" * "+dvuzn2+" = "+res);
                }

            }
        }
    }
}
