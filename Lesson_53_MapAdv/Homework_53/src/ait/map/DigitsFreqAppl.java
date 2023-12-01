package ait.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DigitsFreqAppl {
    static Random random = new Random();

    public static void main(String[] args) {
        /*
        TODO Homework: Generate 1_000_000 random int positive numbers
        and calculate digits frequency
        18374, 9832, 67, 3525
        [1] -> 1
        [2] -> 2
        [3] -> 3
        [4] -> 1
        ...
         */
        int numberOfIntegers = 1_000_000;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        Random random = new Random();
        for (int i = 0; i < numberOfIntegers; i++) {
            int randomNumber = random.nextInt(Integer.MAX_VALUE); // Генеруємо випадкове ціле число
            countDigits(frequencyMap, randomNumber); // Підрахунок цифр у числі та оновлення частоти
        }

        displayFrequency(frequencyMap); // Виведення результатів
    }

    private static void countDigits(Map<Integer, Integer> frequencyMap, int number) {
        while (number > 0) {
            int digit = number % 10; // Отримання останньої цифри числа
            frequencyMap.put(digit, frequencyMap.getOrDefault(digit, 0) + 1); // Оновлення частоти цифри
            number /= 10; // Переход до наступної цифри
        }
    }

    private static void displayFrequency(Map<Integer, Integer> frequencyMap) {
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("Digit " + entry.getKey() + " occurs " + entry.getValue() + " times.");
        }
    }
}

