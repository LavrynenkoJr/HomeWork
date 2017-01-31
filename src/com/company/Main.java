package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
        1.  Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
        Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
        2.  Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
        Удалить из словаря всех людей, родившихся летом.
         */
        countEqualsByStringFromMap("Алексей");
        removeAllWhoBbornInSummer();

        /*
        Дана действительная квадратная матрица порядка N (N – нечетное), все элементы которой различны.
        Найти наибольший элемент среди стоящих на главной и побочной диагоналях и поменять его местами с элементом,
        стоящим на пересечении этих диагоналей.
         */
        maxtToCenterFromArrayDiagonal(createArray(5));

        //24 задача
        //printFibonacci(10);
        //25 задача
       // printVampir();

    }

    private static void removeAllWhoBbornInSummer() {

        Map<String, Date> mapBorn = new HashMap<>();
        mapBorn.put("Viktor1", new Date(1990,0,10));
        mapBorn.put("Viktor2", new Date(1990,2,10));
        mapBorn.put("Viktor3", new Date(1990,3,10));
        mapBorn.put("Viktor4", new Date(1990,4,10));
        mapBorn.put("Viktor5", new Date(1990,6,10));//leto month 7
        mapBorn.put("Viktor6", new Date(1990,6,10));//leto month 7
        mapBorn.put("Viktor7", new Date(1990,7,10));//leto month 8
        mapBorn.put("Viktor8", new Date(1990,8,10));
        mapBorn.put("Viktor9", new Date(1990,9,10));
        mapBorn.put("Viktor10", new Date(1990,11,10));

        System.out.println(mapBorn);

        for(Iterator<Map.Entry<String, Date>> entryIterator = mapBorn.entrySet().iterator(); entryIterator.hasNext(); ) {
            Map.Entry<String, Date> entry = entryIterator.next();
            if(entry.getValue().getMonth()>4 && entry.getValue().getMonth()<8) {
                entryIterator.remove();
                System.out.println("Удаляем = " + entry.getKey());
            }
        }
        System.out.println(mapBorn);
    }

    public static void countEqualsByStringFromMap(String name){
        int countNames = 0;
        int countSurname = 0;

        Map<String, String> map = new HashMap<>();
        map.put("Фамилия1","Андрей");
        map.put("Фамилия2","Анатолий");
        map.put("Фамилия3","Владимир");
        map.put("Фамилия4","Павел");
        map.put("Фамилия5","Сергей");
        map.put("Фамилия6","Алексей");
        map.put("Фамилия7","Алексей");
        map.put("Фамилия8","Алексей");
        map.put("Фамилия9","Алексей");
        map.put("Фамилия10","Алексей");

        for (Map.Entry<String, String> names: map.entrySet()) {
            if (names.getValue().equals(name)){
                countNames++;
            }else if (names.getKey().equals(name)){
                countSurname++;
            }
        }
        System.out.println("Совпадающих имен = " + countNames);
        System.out.println("Совпадающих фамилий = " + countSurname);
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
