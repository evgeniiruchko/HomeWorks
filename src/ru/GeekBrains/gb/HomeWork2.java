package ru.GeekBrains.gb;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.OptionalInt;

public class HomeWork2 {

    public static void RunHomeWork2(){
        int arr[] = {2, 2, 2, 1, 2, 2, 10, 1, 0}; //используется в 6 и 7 заданиях
        int offset = -2;              //используется в 7 задании

        System.out.println("1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. \n    С помощью цикла и условия заменить 0 на 1, 1 на 0;");
        ReplacingInArray();

        System.out.println("2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;");
        ArraySize8();

        System.out.println("3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;");
        ArrayMultiply2();

        System.out.println("4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), \nи с помощью цикла(-ов) заполнить его диагональные элементы единицами;");
        SquareArray();

        System.out.println("5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);");
        MinMaxElements();

        System.out.println("6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, " +
                "\nесли в массиве есть место, в котором сумма левой и правой части массива равны. " +
                "\nПримеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, " +
                "\nграница показана символами ||, эти символы в массив не входят.");

        System.out.println(isChekArray(arr) + "\n");

        System.out.println("7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным)," +
                "\n при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.");

        System.out.println("Смещение: " +offset);
        System.out.println("Исходный   массив: " +Arrays.toString(arr));
        offsetElements( arr, offset);
    }

    public static void ReplacingInArray(){
        int oneZero[], oneZeroConvert[];
        oneZero = new int[10];
        oneZeroConvert = new int[10];
        for (int i = 0; i < oneZero.length; i++){
            oneZero[i] = (int) (Math.random() * 2);
            oneZeroConvert[i] = oneZero[i] == 0 ?   1 :  0;
        }
        System.out.println("Исходный   массив: " + Arrays.toString(oneZero));
        System.out.println("Изменённый массив: " + Arrays.toString(oneZeroConvert) +"\n");
    }

    public static void ArraySize8(){
        int array8[];
        array8 = new int[8];
        for (int i = 0; i< array8.length; i++){
            array8[i] = i * 3;
        }
        System.out.println(Arrays.toString(array8) +"\n");
    }

    public static void ArrayMultiply2(){
        int arr[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный   массив: " + Arrays.toString(arr));
        for (int i = 0; i< arr.length; i++){
            if (arr[i] < 6) arr[i] *= 2;
        }
        System.out.println("Изменённый массив: " + Arrays.toString(arr) +"\n");
    }

    public static void SquareArray(){
        int sqarr[][];
        sqarr = new int[5][5];
        for (int i = 0; i < sqarr.length; i++){
            for (int j = 0; j < sqarr.length; j++){
                sqarr[i][j] = i == j ? 1 : (int) (Math.random() * 9);
                System.out.print(sqarr[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void MinMaxElements(){
        int max = 0, min = 100, array[];
        array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }
        System.out.println("Исходный   массив: " + Arrays.toString(array));

        /* Среда разработки подсказала мне такие поиски MIN и MAX
        OptionalInt min = Arrays.stream(array).min();
        OptionalInt max = Arrays.stream(array).max();
         * но в ввыводе писалось "OptionalInt[ЗНАЧЕНИЕ]" не смог убрать надпись "OptionalInt"
         * поэтому сделал свой рассчёт
        */
        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Максимальный элемент массива: " + max + "\n");
    }

    public static boolean isChekArray(int array[]){
        int summArray, summTmp = 0;
        Boolean res = null;
        System.out.println("Исходный   массив: " + Arrays.toString(array));
        summArray = Arrays.stream(array).sum();
        if (summArray % 2 == 0){
            for (int i = 0; i < array.length; i++){
                summTmp += array[i];
                if (summArray / 2 == summTmp){
                    res = true;
                    break;
                }
                if (summArray / 2 < summTmp){
                    res = false;
                    break;
                }
            }
        }
        else
            res = false;
        return res;
    }

    public static void offsetElements( int arr[], int n){
        int tmp;
        if (n < 0) {
            for (int j = 0; j > n; j--) {
                tmp = arr[0];
                for (int i = 0; i < arr.length - 1; i++)
                    arr[i] = arr[i + 1];
                arr[arr.length - 1] = tmp;
            }
        } else if (n > 0) {
            for (int j = 0; j < n; j++) {
                tmp = arr[arr.length-1];
                for (int i = arr.length - 1; i > 0; i--)
                    arr[i] = arr[i - 1];
                arr[0] = tmp;
            }
        }

        System.out.println("Изменённый массив: " +Arrays.toString(arr));
    }
}
