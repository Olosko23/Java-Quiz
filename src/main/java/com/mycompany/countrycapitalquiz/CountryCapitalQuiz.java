/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.countrycapitalquiz;

/**
 *
 * @author Olosko
 */
import java.util.Scanner;

public class CountryCapitalQuiz {

    private static final String[] countries = {
        "France", "Germany", "Italy", "Japan", "Spain", "Canada", "Australia", "Brazil", "India", "China"
    };

    private static final String[] capitals = {
        "Paris", "Berlin", "Rome", "Tokyo", "Madrid", "Ottawa", "Canberra", "Brasília", "New Delhi", "Beijing"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Country Capital Quiz!");
        for (int i = 0; i < 10; i++) {
            int questionIndex = (int) (Math.random() * countries.length);
            String country = countries[questionIndex];
            String correctCapital = capitals[questionIndex];

            System.out.println("Question " + (i + 1) + ": What is the capital of " + country + "?");

            String[] options = generateOptions(correctCapital, capitals);
            shuffleArray(options);

            for (int j = 0; j < options.length; j++) {
                System.out.println((char) ('A' + j) + ". " + options[j]);
            }

            System.out.print("Your answer: ");
            char userChoice = Character.toUpperCase(scanner.next().charAt(0));

            char correctChoice = (char) ('A' + indexOfCorrectAnswer(correctCapital, options));

            if (userChoice == correctChoice) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + correctChoice + ". " + correctCapital);
            }
            System.out.println();
        }

        System.out.println("Quiz completed! Your score: " + score + "/10");
    }

    private static String[] generateOptions(String correctAnswer, String[] allAnswers) {
        String[] options = new String[3];
        options[0] = correctAnswer;
        options[1] = getRandomAnswer(allAnswers, correctAnswer);
        options[2] = getRandomAnswer(allAnswers, correctAnswer);

        return options;
    }

    private static String getRandomAnswer(String[] allAnswers, String excludeAnswer) {
        String answer;
        do {
            answer = allAnswers[(int) (Math.random() * allAnswers.length)];
        } while (answer.equals(excludeAnswer));
        return answer;
    }

    private static void shuffleArray(String[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int index = (int) (Math.random() * (i + 1));
            String temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    private static int indexOfCorrectAnswer(String correctAnswer, String[] options) {
        for (int i = 0; i < options.length; i++) {
            if (correctAnswer.equals(options[i])) {
                return i;
            }
        }
        return -1;
    }
}
