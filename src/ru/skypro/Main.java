package ru.skypro;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println("Напечатать только нечетные числа в консоль ");
        printOodNumber();

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
        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(nums);
    }

    private static void printEvenNumber() {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        Set<Object> numbAsSet = new HashSet<>();
        /**
         * заполняю множество, чтобы избежать повторений
         */
        for (Integer num : nums) {
            if (num % 2 == 0) {
                numbAsSet.add(num);
            }
        }
        System.out.println(numbAsSet);
    }

    /**
     * произвольный текст разбиваю на список по пробелу
     * doubleValue - заполняю множество  повторений/ Только повторений
     * удалить все повторения, используя итератор
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
        List<String> doubleValue = new ArrayList<>();

        for (int i = 0; i < listFromText.size(); i++) {
            int nextIndex = listFromText.lastIndexOf(listFromText.get(i));
            if (i != nextIndex) {
                doubleValue.add(listFromText.get(i));
            }
        }
        Iterator<String> iterator = listFromText.iterator();

        while (iterator.hasNext()) {
            //String stringFromLoop = iterator.next();
            if (doubleValue.contains(iterator.next())) {
                iterator.remove();
            }
        }
        System.out.println(listFromText);
    }

    private static void countDouble() {
        String text = "В качестве отладочной информации возьмите произвольный набор " +
                "слов или текст  в котором встречаются повторения " +
                "Это может быть произвольный набор слов " +
                "литературный текст или произвольное предложение";
        List<String> listFromText = new ArrayList<>(List.of(text.split(" ")));
        Iterator<String> iterator = listFromText.iterator();
        int counterDouble = 0;

        while (iterator.hasNext()) {
            String stringFromLoop = iterator.next(); // запомнили слово
            iterator.remove();   // удалили его
            if (listFromText.contains(stringFromLoop)) {
                // если слово все-таки еще осталось
                counterDouble = counterDouble + 2;
                System.out.print(stringFromLoop + ' ');
            }
        }
        System.out.print("\n");
        System.out.println(counterDouble);

    }
}

