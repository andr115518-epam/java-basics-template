package com.epam.izh.rd.online.service;

import sun.security.util.ArrayUtil;
import java.util.Arrays;
import java.util.ArrayList;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     * <p>
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 == value2) {
            return 0;
        } else if (value1 < value2) {
            return -1;
        } else return 1;
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return (value1 > value2) ? value1 : value2;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int maxFromArray = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxFromArray) {
                maxFromArray = values[i];
            }
        }
        ;
        return maxFromArray;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sumArray = 0;
        for (int i = 0; i < values.length; i++) {
            sumArray = sumArray + values[i];
        }
        return sumArray;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int[] evenArray;
        int counterEven = 0;
        int counterEvenAdd = 0;
        for (int i = 0; i < values.length; i++) {
            if ((values[i] % 2) == 0) {
                counterEven++;
            }
        }
        evenArray = new int[counterEven];
        for (int i = 0; i < values.length; i++) {
            if ((values[i] % 2) == 0) {
                evenArray[counterEvenAdd] = values[i];
                counterEvenAdd++;
            }
        }
        return evenArray;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        int factorial = 1;
        for (int i = 1; i <= initialVal; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    /**
     * Метод возвращает число, которое находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     * <p>
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     * <p>
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        int fibVal = 0;
        int fibValBef = 0;
        int fibValAft = 1;
        for (int i = 2; i <= number; i++) {
            fibVal = fibValBef + fibValAft;
            fibValBef = fibValAft;
            fibValAft = fibVal;
        }
        if (number >= 2) {
            return fibVal;
        } else if (number == 1) {
            return 1L;
        } else return 0L;
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        Arrays.sort(values);
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     * <p>
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        if (number < 2) {
            return false;
        }
        double prim = Math.sqrt(number);
        for (int i = 2; i <= prim; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     * <p>
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        for (int i = 0, j = values.length - 1; i < j; i++, j--) {
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
        return values;
    }
}