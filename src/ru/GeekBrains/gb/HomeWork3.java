package ru.GeekBrains.gb;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    public static void RunHomeWork3(){
        // первое задание 3 урока
        byte newGame = 1;
        Scanner inNewGame = new Scanner(System.in);
        System.out.println("Я хочу сыграть с тобой в игру. Ты должен угадать число от 0 до 9 с трёх попыток. Время пошло");
        while (newGame == 1) {
            guessNumber();
            System.out.print("Сыграем ещё раз? 1 - да, 0 - я с тобой больше не играю: ");
            newGame = inNewGame.nextByte();
            if (newGame !=0 && newGame !=1) {
                System.out.println("Я же просил, 0 или 1, будем считать, что ты хочешь ещё раз сыграть");
                newGame = 1;
            }
        }

        // второе задание 3 урока
        System.out.println("Теперь угадываем слово. Варианты: \n apple, orange, lemon, banana, apricot, avocado, broccoli, carrot, cherry, garlic, grape, melon,\nleak, kiwi, mango, mushroom, nut, olive, pea, peanut, pear, pepper, pineapple, pumpkin, potato");
        guessWord();
    }

    public static void guessNumber(){
        byte attemptCount = 1, userNumber;
        String resultGame = null;
        Random random = new Random();
        Scanner inNumber = new Scanner(System.in);
        byte randomNumber = (byte)random.nextInt(10);
        do {
            System.out.print(attemptCount + " попытка: ");
            userNumber = inNumber.nextByte();
            if (randomNumber == userNumber){
                resultGame = "Ты выйграл!";
                System.out.println(resultGame);
                break;
            } else if (randomNumber < userNumber){
                resultGame = "Загаданное число меньше";
            } else{
                resultGame = "Загаданное число больше";
            }
            attemptCount++;
            if (attemptCount < 4){
                System.out.println(resultGame);
            }
        } while (attemptCount < 4);

        if (attemptCount == 4){
            System.out.println("Ты проиграл! Я загадал число " + randomNumber);
        }
    }

    public static void guessWord(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String userWord = "", resultString = "";
        byte lengthStirng;
        Scanner inWord = new Scanner(System.in);
        Random random = new Random();
        byte randomIndexWord = (byte)random.nextInt(words.length);
        String randomWord = words[randomIndexWord];
        //System.out.println("Загаданное слово: " + randomWord + "  " + randomWord.charAt(1));  //вывод для проверки. Убрать
        while (randomWord != userWord){
            System.out.print("Вводи слово: ");
            userWord = inWord.nextLine();
            if (randomWord.equals(userWord)){
                System.out.println("Поздравляю, ты прошёл испытания");
                break;
            } else{
                resultString = "";
                lengthStirng = (byte) ((randomWord.length() < userWord.length()) ? randomWord.length() : userWord.length());
                for (byte i = 0; i < 14; i++){
                    if (i < lengthStirng){
                        if (randomWord.charAt(i) == userWord.charAt(i))
                        {
                            resultString = resultString + userWord.charAt(i);
                        } else{
                            resultString = resultString + "#";
                        }
                    } else{
                        resultString = resultString + "#";
                    }
                }
                System.out.println(resultString);
            }
        }
    }
}
