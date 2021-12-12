package ru.skypro;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println("Напечатать только нечетные числа в консоль ");
        printOodNumber();
        System.out.print("\n");
        System.out.println("Задание 2");
        System.out.println("Напечатать только четные числа  в консоль без повторения");
        printEvenNumber();

        System.out.println("Задание 3");
        System.out.println("Напечатать уникальные слова из списка слов, в котором могут встречаться дубли. ");
        printOriginal();

        System.out.println("Задание 4");
        System.out.println("Вывести  в консоль все количество дублей из списка слов. ");
        countDouble();
    }


    /**
     * пройти по коллекции и в случае необходимости удалить нужный элемент.
     * Получить его можно с помощью метода iterator(),
     **/
    private static void printOodNumber() {

        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        for (int num : nums) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
    }

    private static void printEvenNumber() {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        Set<Integer> numbAsSet = new HashSet<>();
         // заполняю множество, чтобы избежать повторений
        for (int num : nums) {
            if (num % 2 == 0) {
                numbAsSet.add(num);
            }
        }
        System.out.println(numbAsSet);
    }

    /**
     * произвольный текст разбиваю на список по пробелу
     * textAsSet - заполняю множество  уникальных значений
     */
    private static void printOriginal() {
        String text = "Ночь улица фонарь аптека " +
                "Бессмысленный и тусклый свет " +
                "Живи еще хоть четверть века " +
                "Все будет так Исхода нет " +
                "Умрешь начнешь опять сначала " +
                "И повторится все как встарь " +
                "Ночь ледяная рябь канала " +
                "Аптека улица фонарь ";

        List<String> listFromText = new ArrayList<>(List.of(text.split(" ")));
        Set<String> textAsSet = new HashSet<>();

        for (String oneValue : listFromText) {
            if (textAsSet.contains(oneValue)) {
                textAsSet.remove(oneValue);
            } else {
                textAsSet.add(oneValue);
            }
        }
        System.out.println(textAsSet);
    }

    private static void countDouble() {
        String text = "В качестве отладочной информации возьмите произвольный набор " +
                "слов или текст  в котором встречаются повторения " +
                "Это может быть произвольный набор слов " +
                "литературный текст или произвольное предложение";
        List<String> listFromText = new ArrayList<>(List.of(text.split(" ")));
        Set<String> textAsSet = new HashSet<>();
        int counterDouble = 0;
        for (String oneValue : listFromText) {
            if (textAsSet.contains(oneValue)) {
                counterDouble = counterDouble + 2;
                System.out.print(oneValue + " ");
                continue;
            }
            textAsSet.add(oneValue);
        }
        System.out.print("\n");
        System.out.println(counterDouble);

    }
}

