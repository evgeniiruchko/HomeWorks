package ru.GeekBrains.gb.JavaSyntax;

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
        boolean gameOver = false;

        initMap();

//Данные для отладки
//        map = new char[][]{
//                {'O', '*', 'O', 'X', 'O'},
//                {'O', 'X', 'X', 'X', 'O'},
//                {'X', '*', 'X', 'X', 'X'},
//                {'O', 'O', 'X', 'O', 'X'},
//                {'X', 'X', 'X', 'O', '*'},
//        };

        do {
            humanTurn();
            if (isVictory(DOT_X)){
                System.out.println("Человек выйграл");
                gameOver = true;
                break;
            }
            if (isDraw()){
                System.out.println("Ничья");
                gameOver = true;
                break;
            }

            //compTurn();
            compTurnTest();
            if (isVictory(DOT_O)){
                System.out.println("Машина выйграла");
                gameOver = true;
                break;
            }
            if (isDraw()){
                System.out.println("Ничья");
                gameOver = true;
                break;
            }
        }while (gameOver == false);


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
            y = in.nextInt() - 1;
            x = in.nextInt() - 1;
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

    public static void compTurnTest(){
        int countX, countY, x = -1 ,y = -1;
        for (int i = 0; i < SIZE; i++){
            countX = 0;
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == DOT_X){
                    countX++;
                }
                if (countX == 0 && map[i][j] == DOT_EMPTY && j <= SIZE - COUNTFORWIN){
                    if (map[i][j+1] == DOT_X) {
                        x = i;
                        y = j;
                        countX++;
                    }
                }
                if (countX != 0 && map[i][j] == DOT_EMPTY && x == -1 && y == -1){
                    x = i;
                    y = j;
                    countX++;
                }



                if (map[i][j] == DOT_O){
                    countX = 0;
                    x = -1;
                    y = -1;
                }

                if (countX == COUNTFORWIN){
                    break;
                }

            }
            if (countX == COUNTFORWIN){
                break;
            }
            x = -1;
            y = -1;
        }
        if (x == -1 || y == -1){
            Random random = new Random();
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isValidFild(x,y));
        }
        map[x][y] = DOT_O;
        System.out.println("Ход машины");
        printMap();
    }

    public static boolean isDraw(){
        for (int row = 0; row < SIZE; row++){
            for (int column = 0; column < SIZE; column++){
                if (map[row][column] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isVictory(char dot){
        int horizontScore;
        int verticalScore;
        int diagonalScore;
        for (int i = 0; i <= SIZE -1; i++){
            for (int j = 0; j <= SIZE - COUNTFORWIN; j++){
                horizontScore = 0;
                verticalScore = 0;
                diagonalScore = 0;
//проверка по горизонтали и по вертикали
                for (int count = 1; count <= COUNTFORWIN; count++){
                    if (map[i][j + count - 1] == dot){
                        horizontScore++;
                    }
                    else{
                        horizontScore = 0;
                    }
                    if (map[j + count - 1][i] == dot){
                        verticalScore++;
                    }
                    else{
                        verticalScore = 0;
                    }
//Проверка по диагоналям
                    if (i <= SIZE - COUNTFORWIN) {
                        if (map[i + count - 1][j + count - 1] == dot) {
                            diagonalScore++;
                        } else {
                            diagonalScore = 0;
                        }
                    }
                    if (i >= COUNTFORWIN - 1) {
                        if (map[Math.abs(j + count - 1)][Math.abs(i - count + 1)] == dot) {
                            diagonalScore++;
                        } else {
                            diagonalScore = 0;
                        }
                    }
                    if (verticalScore == COUNTFORWIN || horizontScore == COUNTFORWIN || diagonalScore == COUNTFORWIN){
                        return true;
                    }
                }
            }
        }
//Проверка по диагоналям старая версия. Выше более оптимизировано
//        for (int column = 0; column <= SIZE - COUNTFORWIN; column++) {
////по диагонали направо вниз
//            for (int row = 0; row <= SIZE - COUNTFORWIN; row++) {
//                diagonalScore = 0;
//                for (int i = 1; i <= COUNTFORWIN; i++){
//                    if (map[column + i - 1][row + i - 1] == dot){
//                        diagonalScore++;
//                        if (diagonalScore == COUNTFORWIN){
//                            return true;
//                        }
//                    } else{
//                        diagonalScore = 0;
//                    }
//                }
//            }
////по диагонали налево вниз
//            for (int row = SIZE - 1; row >= COUNTFORWIN - 1; row--) {
//                diagonalScore = 0;
//                for (int i = 1; i <= COUNTFORWIN; i++){
//                    if (map[column + i - 1][row - i + 1] == dot){
//                        diagonalScore++;
//                        if (diagonalScore == COUNTFORWIN){
//                            return true;
//                        }
//                    } else{
//                        diagonalScore = 0;
//                    }
//                }
//            }
//
//        }
        return false;
    }


}
