package edu.touro.cs.mcon364;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class WordleGame {

    private static List<Character> alphabet1 = new ArrayList<>();
    private static List<Character> alphabet2 = new ArrayList<>();
    private static List<Character> alphabet3 = new ArrayList<>();
    private static List<Character> alphabet4 = new ArrayList<>();
    private static List<Character> alphabet5 = new ArrayList<>();
    private static List<String> validWordleWords;
    private static String[] wordsArray;
    private static List<String> filteredWords = new ArrayList<>();
    private static List<Character> charNeededInTheWord = new ArrayList<>();
    private static int counter = 0;


//    public static void main(String[] args) {
//        WordleGame.wordleMatches(null);
//
//    }

    public static List<String> wordleMatches(List<List<WordleResponse>> wr) {

        fillUpList(alphabet1);
        fillUpList(alphabet2);
        fillUpList(alphabet3);
        fillUpList(alphabet4);
        fillUpList(alphabet5);
        getWordlePossibilitiesFromFile();

        for (int word = 0; word < wr.size(); word++) {
            for (int letter = 0; letter < wr.get(word).size(); letter++) {
                if (wr.get(word).get(letter).resp == LetterResponse.WRONG_LETTER) {
                    checkIfContainsAndRemove(alphabet1, letter, word, wr);
                    checkIfContainsAndRemove(alphabet2, letter, word, wr);
                    checkIfContainsAndRemove(alphabet3, letter, word, wr);
                    checkIfContainsAndRemove(alphabet4, letter, word, wr);
                    checkIfContainsAndRemove(alphabet5, letter, word, wr);
                }


                switch (letter) {
                    case 0 -> selectRemainingLetters(alphabet1, 0, letter, word, wr);
                    case 1 -> selectRemainingLetters(alphabet2, 1, letter, word, wr);
                    case 2 -> selectRemainingLetters(alphabet3, 2, letter, word, wr);
                    case 3 -> selectRemainingLetters(alphabet4, 3, letter, word, wr);
                    case 4 -> selectRemainingLetters(alphabet5, 4, letter, word, wr);
                    default -> {
                    }
                }


            }

            String regex = generateRegex();
            for (String w : validWordleWords) {
                if (w.matches(regex)) {
                    filteredWords.add(w);
                }
            }

//            validWordleWords.removeIf(w -> !alphabet1.contains(w.charAt(0)));
//            validWordleWords.removeIf(w -> !alphabet2.contains(w.charAt(1)));
//            validWordleWords.removeIf(w -> !alphabet3.contains(w.charAt(2)));
//            validWordleWords.removeIf(w-> !alphabet4.contains(w.charAt(3)));
//            validWordleWords.removeIf(w -> !alphabet5.contains(w.charAt(4)));
        }


        charNeededInTheWord.clear();
        return filteredWords;


    }

    private static void checkIfContainsAndRemove(List<Character> alphabet, int letter, int word, List<List<WordleResponse>> wr) {
        if (alphabet.contains(wr.get(word).get(letter).c))
            alphabet.remove((Character) wr.get(word).get(letter).c);


    }


    private static void selectRemainingLetters(List<Character> alphabet, int alphabetListNum, int letter, int word, List<List<WordleResponse>> wr) {
        if (wr.get(word).get(letter).resp == LetterResponse.WRONG_LOCATION) {
            charNeededInTheWord.add((Character)(wr.get(word).get(letter).c));
            alphabet.remove((Character) wr.get(word).get(letter).c);
            counter++;

        } else if (wr.get(word).get(letter).resp == LetterResponse.CORRECT_LOCATION) {
            Character letterToKeep = wr.get(word).get(letter).c;
            alphabet.removeIf(s -> !s.equals(letterToKeep));
        }

    }

    private static void getWordlePossibilitiesFromFile() {
        File file = new File("src/edu/touro/cs/mcon364/WordleWords");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            validWordleWords = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                validWordleWords.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        wordsArray = validWordleWords.toArray(new String[0]);
//
//        //Print the words to verify that they were read correctly
//        for (String word : wordsArray) {
//            System.out.println(word);}
    }


    private static void fillUpList(List<Character> alphabet) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            alphabet.add(ch);
        }


    }

    private static String generateRegex() {
        StringBuilder regexBuilder = new StringBuilder("\\b");
        //StringJoiner joiner = new StringJoiner(")(?=.*", "(?=.*",);
        for (Character c : charNeededInTheWord) {
            regexBuilder.append("(?=.*");
            regexBuilder.append(c);
            regexBuilder.append(")");
            //joiner.add(c + "");
        }
        for (int i = 0; i < 5; i++) {
            List<Character> array = null;
            switch (i) {
                case 0:
                    array = alphabet1;
                    break;
                case 1:
                    array = alphabet2;
                    break;
                case 2:
                    array = alphabet3;
                    break;
                case 3:
                    array = alphabet4;
                    break;
                case 4:
                    array = alphabet5;
                    break;
            }
            if (array != null) {
                if (array.size() > 0) {
                    regexBuilder.append("[");
                    for (Character c : array) {
                        regexBuilder.append(c);
                    }
                    regexBuilder.append("]");
                } else {
                    regexBuilder.append("\\w");
                }
            }
        }

        //regexBuilder.append(".+");
        regexBuilder.append("\\b"); // \\b matches word boundaries
        return regexBuilder.toString();

    }

}
