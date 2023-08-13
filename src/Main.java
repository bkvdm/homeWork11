import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void printYearIdentified(int singYear) {
        if (singYear == 1) {
            System.out.println("Год високосный");
        } else System.out.println("Год невисокосный");

    }

    public static int checkYear(int year) {
        int yearIdentified = 0;
        if ((year % 4) == 0) {
            yearIdentified = 1;
        } else if ((year % 100) == 0) {
            yearIdentified = 0;
        } else if ((year % 400) == 0) {
            yearIdentified = 1;
        }
        return yearIdentified;
    }

    public static int deviceDefinition(int clientOS, int clientDeviceYear) {
        int deviceKnown = 0;
        int currentYear = LocalDate.now().getYear();
        if (clientOS == 1) {
            deviceKnown = deviceKnown + 11;
            if (clientDeviceYear < currentYear)
                deviceKnown = deviceKnown - 1;
        } else if (clientOS == 0) {
            deviceKnown = deviceKnown + 21;
            if (clientDeviceYear < currentYear)
                deviceKnown = deviceKnown - 1;
        } else if (clientOS != 0 && clientOS != 1) {
            deviceKnown = deviceKnown - 1;
        }
        return deviceKnown;
    }

    public static void printLinkApplication(int deviceKnow) {
        if (deviceKnow == 11) {
            System.out.println("Установите версию приложения для Android по ссылке:");
        } else if (deviceKnow == 21) {
            System.out.println("Установите версию приложения для iOS по ссылке:");
        } else if (deviceKnow == 10) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке:");
        } else if (deviceKnow == 20) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке:");
        } else if (deviceKnow == -1) {
            System.out.println("Операционная система вашего устройства не определена. Мы не можем предложить приложение для вашего устройства");
        }
    }

    public static void deliveryAnalysis(int deliveryDistance) {
        short deliveryMax = 100;
        int deliveryTime = 0;
        boolean deliverySpeedOne = (deliveryDistance > 0 && deliveryDistance <= 20);
        boolean deliverySpeedTwo = (deliveryDistance > 20 && deliveryDistance <= 60);
        boolean deliverySpeedThree = (deliveryDistance > 60 && deliveryDistance <= deliveryMax);
        if (deliveryDistance <= deliveryMax && deliveryDistance != 0) {
            if (deliverySpeedOne) {
                deliveryTime = deliveryTime + 1;
                System.out.println("Потребуется дней " + deliveryTime);
            } else if (deliverySpeedTwo) {
                deliveryTime = deliveryTime + 2;
                System.out.println("Потребуется дней " + deliveryTime);
            } else if (deliverySpeedThree) {
                deliveryTime = deliveryTime + 3;
                System.out.println("Потребуется дней " + deliveryTime);
            }
        } else if (deliveryDistance > deliveryMax) {
            System.out.println("Мы не доставляем на расстояния больше, чем на " + deliveryMax + " км");
        } else {
            System.out.println("Вы не указали расстояние " + deliveryDistance + " Хотите оформить самовывоз?");
        }
    }

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        System.out.println("Задача 1");
        short year = 2027;
        int singYear = checkYear(year);
        printYearIdentified(singYear);
    }

    public static void task2() {
        System.out.println("Задача 2");
        int clientDeviceYear = 2014;
        int clientOS = 1;
        int deviceKnown = deviceDefinition(clientOS, clientDeviceYear);
        printLinkApplication(deviceKnown);
    }

    public static void task3() {
        System.out.println("Задача 3");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите расстояние доставки:");
        int deliveryDistance = scanner.nextInt();
        deliveryAnalysis(deliveryDistance);
    }
}

