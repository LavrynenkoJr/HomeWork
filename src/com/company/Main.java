package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        maxtToCenterFromArrayDiagonal(createArray(5));

        //24 задача
        //printFibonacci(10);
        //25 задача
       // printVampir();

    }

    public static int[][] createArray(int n){
        int[][] array = new int[n][n];

        Random random = new Random();

        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < n*n) {
            set.add(random.nextInt(100));
        }

        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()) {
           for (int i = 0; i < n; i++) {
               for (int k = 0; k < n; k++) {
                   array[i][k] = iterator.next();
               }
           }
        }

        for (int i = 0; i < n; i++) {
            for (int p = 0; p < n; p++) {
                System.out.print(array[i][p] + "\t");
            }
            System.out.println();
        }
        return array;
    }

    public static void maxtToCenterFromArrayDiagonal(int[][] array){
        System.out.println("maxtToCenterFromArrayDiagonal");

        int inrvers = array.length;

        int maxStroka = 0;
        int maxStolbec = 0;

        for (int i = 0; i < array.length; i++){
            inrvers--;

            if (array[i][i] > array[i][inrvers] && array[i][i] > array[maxStroka][maxStolbec]){
                maxStroka = i;
                maxStolbec = i;
            }else if (array[i][inrvers] > array[i][i] && array[i][inrvers] > array[maxStroka][maxStolbec]) {
                maxStroka = i;
                maxStolbec = inrvers;
            }
        }

        int max = array[maxStroka][maxStolbec];
        array[maxStroka][maxStolbec] = array[array.length/2][array.length/2];
        array[array.length/2][array.length/2] = max;

        for (int i = 0; i < array.length; i++){
            for (int k = 0; k < array.length; k++){
                System.out.print(array[i][k] + "\t");
            }
            System.out.println();
        }
    }

   /* public static void printFibonacci(int count){
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

    }*/

    /*public static void printVampir(){
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
    }*/
}
