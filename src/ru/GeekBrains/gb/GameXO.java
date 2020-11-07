package ru.GeekBrains.gb;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class GameXO {
    public static final int SIZE = 5;
    public static final int COUNTFORWIN = 4;
    public static char[][] map;

    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '*';

    public static void runGameXO(){
        initMap();

        do {
            humanTurn();
            System.out.println(isVictory(DOT_X));

            compTurn();

        }while (true);


    }


    public static void initMap(){
        map = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++){
            for (int column = 0; column < SIZE; column++){
                map[row][column] = DOT_EMPTY;
            }
        }
        printMap();
    }

    public static void printMap(){
        for (int row = 0; row <= SIZE; row++){
            for (int column = 0; column <= SIZE; column++){
                if (row == 0){
                    System.out.print(column + " ");
                } else if (column == 0){
                    System.out.print(row + " ");
                } else if (row <= SIZE || column <= SIZE){
                    System.out.print(map[row-1][column-1] + " ");
                }
            }
            System.out.println();
        }
    }


    public static boolean isValidFild(int row, int column){
        if (row < 0 || row >= SIZE || column < 0 || column >= SIZE){
            return false;
        }
        if (map[row][column] == DOT_EMPTY){
            return true;
        }
        return false;
    }

    public static void humanTurn(){
        Scanner in = new Scanner(System.in);
        int x, y;
        System.out.println("введите координаты x и y");
        do {
            x = in.nextInt() - 1;
            y = in.nextInt() - 1;
            if (!isValidFild(x,y)){
                System.out.println("Неверно. Введите от 1 до " + SIZE);
            }
        } while (!isValidFild(x,y));
        map[x][y] = DOT_X;
        printMap();
    }

    public static void compTurn(){
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isValidFild(x,y));
        map[x][y] = DOT_O;
        System.out.println("Ход машины");
        printMap();
    }

    public static boolean isVictory(char dot){
        int horizontScore = 0;
        int verticalScore = 0;
        int diagonalScore = 0;
//сначала сверяю всё по горизонтали
        for (int row = 0; row <= SIZE - 1; row++){
            for (int column = 0; column < SIZE - 1; column++){
                if (map[row][column] == dot && map[row][column+1] == dot){
                    horizontScore++;
                    if (horizontScore == COUNTFORWIN-1){
                        return true;
                    }
                } else {
                    horizontScore = 0;
                }
            }
        }
//тоже самое, но по вертикали
        for (int column = 0; column <= SIZE-1; column++){
            for (int row = 0; row < SIZE-1; row++){
                if (map[row][column] == dot && map[row + 1][column] == dot){
                    verticalScore++;
                    if (verticalScore == COUNTFORWIN-1){
                        return true;
                    }
                } else {
                    verticalScore = 0;
                }
            }
        }
//по диагонали вправо вниз
        for (int column = 0; column <= SIZE - COUNTFORWIN; column++) {
            for (int row = 0; row <= SIZE - COUNTFORWIN; row++) {
                for (int i = 1; i <= COUNTFORWIN; i++){
                    if (map[column + i - 1][row + i - 1] == dot){
                        diagonalScore++;
                        if (diagonalScore == COUNTFORWIN){
                            return true;
                        }
                    } else{
                        diagonalScore = 0;
                    }
                }
            }
        }
//по диагонали слева вниз
        for (int column = 0; column <= SIZE - COUNTFORWIN; column++) {
            for (int row = SIZE - 1; row >= SIZE - COUNTFORWIN; row--) { //тут поправить, а то уходит в минус
                for (int i = 1; i <= COUNTFORWIN; i++){
                    if (map[column + i - 1][row - i + 1] == dot){
                        diagonalScore++;
                        if (diagonalScore == COUNTFORWIN){
                            return true;
                        }
                    } else{
                        diagonalScore = 0;
                    }
                }
            }
        }
        return false;
    }


}
