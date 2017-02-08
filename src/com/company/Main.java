package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*Дана строка, Вам требуется преобразовать все идущие подряд пробелы в один.
        Дана строка. Разбить строку, не разрывая слова, на подстроки таким образом,
                чтобы в каждой строке количество символов не превышало заданное.
        Создать программу, которая будет проверять, является ли слово из пяти букв,
                введённое пользователем, палиндромом (примеры: «комок», «ротор»). Если введено слово не из 5 букв,
                то сообщать об ошибке. Программа должна нормально обрабатывать слово,
                даже если в нём использованы символы разного регистра.
                Например, слова «Комок» или «РОТОР» следует также считать палиндромами.*/

        separateString(" Sergey Lavrynenko Oleksandrovich ", 5);
        System.out.println();

        palindromString();
        System.out.println();

        removeSpaces("   три пробела             снова три пробела   ");

    }

    public static void separateString(String s, int maxCharsInOneWord){
        StringBuilder stringBuilder = new StringBuilder(s.trim());

        List<String> separatedStringList = new ArrayList<>();

        int startIndex = 0;
        int indexLastChar = 0;

        for (int i = 0; i < stringBuilder.length(); i++){
            if (Character.isSpaceChar(stringBuilder.charAt(i))){
                if (i-startIndex>maxCharsInOneWord){
                    indexLastChar = startIndex+maxCharsInOneWord;
                    separatedStringList.add(stringBuilder.substring(startIndex, indexLastChar));
                    startIndex = ++i;
                }else {
                    separatedStringList.add(stringBuilder.substring(startIndex, i));
                    startIndex = ++i;
                }
            }else if (startIndex > 0 && i == stringBuilder.length()-1){
                if (i-startIndex>maxCharsInOneWord){
                    indexLastChar = startIndex+maxCharsInOneWord;
                    separatedStringList.add(stringBuilder.substring(startIndex, indexLastChar));
                }else {

                    separatedStringList.add(stringBuilder.substring(startIndex, ++i));
                }
            }
        }

        System.out.println("enter List = " + separatedStringList.get(0) + "," + separatedStringList.get(1) + "," + separatedStringList.get(2));
    }

    public static void palindromString(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово из пяти букв: ");
        StringBuilder stringBuilder = new StringBuilder(scanner.nextLine().trim());

        if (stringBuilder.length() != 5){
            System.out.println("Слово должно быть из пяти букв!!!!");
            palindromString();
        }else {
            String revers = stringBuilder.toString();

            if (revers.equalsIgnoreCase(stringBuilder.reverse().toString()))
                System.out.println("Это слово ПАЛИНДРОМ!");
            else
                System.out.println("Hе ПАЛИНДРОМ!!");
        }
    }

    public static String removeSpaces(String s){

        System.out.println("Входная строка = " + s);

        List<Integer> spaceIndex = new ArrayList<>();
        String result =  s.trim();

        StringBuilder stringBuilder = new StringBuilder(result);

        for (int i = 0; i < stringBuilder.length(); i++){
            if (Character.isSpaceChar(stringBuilder.charAt(i))) {
                int k = ++i;
                while (Character.isSpaceChar(stringBuilder.charAt(k))) {
                    spaceIndex.add(k);
                    k++;
                }
            }
        }

        stringBuilder.delete(spaceIndex.get(0), spaceIndex.get(spaceIndex.size()-1)+1);
        System.out.println("После удаления лишних пробелов между словами = " + stringBuilder);

        return result;
    }
}