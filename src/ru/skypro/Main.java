package ru.skypro;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int year = 2015;
        printIsLeapYear(year);
        System.out.println();

        printRecommendApplicationVersion(1, 2022);
        System.out.println();

        System.out.println("Количество дней доставки " + getDeliveryDistance(19));

        findAndPrintDuplicatesIfAny("abcdefghijjkk");

        int[] arr = new int[]{3, 2, 1, 6, 5};
        reverseArray(arr);
        System.out.println("Обратный массив " + Arrays.toString(arr));

    }
    public static void printIsLeapYear(int year) {
        boolean yearIsLeap = isLeap(year);
        printIsLeapYearResult(year, yearIsLeap);
    }
    public static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static void printIsLeapYearResult(int year, boolean yearIsLeap) {
        if (yearIsLeap) {
            System.out.println(year + " высокосный");
        } else {
            System.out.println(year + " не является высокосным");
        }
    }

    public static void printRecommendApplicationVersion(int clientOS, int deviceYear) {
        boolean deviceIsOld = isDeviceOld(deviceYear);
        System.out.println("Установите ");
        if (deviceIsOld) {
            System.out.print("lite ");
        }
        System.out.print("версию для ");
        if (clientOS == 0) {
            System.out.println("iOS");
        } else {
            System.out.println("Android");
        }
    }

    public static boolean isDeviceOld(int deviceYear) {
        int currentYear = LocalDate.now().getYear();
        return deviceYear <= currentYear;
    }
    public static int getDeliveryDistance(int distance) {
        int daysNumber = 0;
        if (distance < 20) {
            daysNumber = daysNumber + 1;
        }
        if (distance >= 20 && distance < 60) {
            daysNumber = daysNumber + 2;
        }
        if (distance >= 60 && distance < 100) {
            daysNumber = daysNumber + 3;
        }
        return  daysNumber;
    }
    public static void findAndPrintDuplicatesIfAny(String text) {
        char[] letters = text.toCharArray();
        boolean isDuplicateExists = false;
        for (int i = 1; i < letters.length; i++) {
            if (letters[i] == letters[i - 1]) {
                System.out.println("Найден дубль по символу " + letters[i]);
                isDuplicateExists = true;
                break;
            }
        }
        if (!isDuplicateExists) {
            System.out.println("Дублей не найдено");
        }
    }

    public static void reverseArray(int[] arr) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        while (leftIndex < rightIndex) {
            int temp = arr[leftIndex];
            arr[leftIndex] = arr[rightIndex];
            arr[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
    }

}
