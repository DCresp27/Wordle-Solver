package edu.touro.cs.mcon364;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordleTest {


    List<List<WordleResponse>> listOfWords = new ArrayList<>();
    List<String> validWords = new ArrayList<>();





    @Test
    public void testWordle1() {
        List<WordleResponse> list = new ArrayList<>();
        list.add(new WordleResponse('p', 0, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('l', 1, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('s', 2, LetterResponse.WRONG_LOCATION));
        list.add(new WordleResponse('y', 3, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('a', 4, LetterResponse.WRONG_LOCATION));
        listOfWords.add(list);
        validWords = WordleGame.wordleMatches(listOfWords);
        System.out.println(validWords);
        assertTrue(validWords.contains("plays"));
        listOfWords.clear();
        validWords.clear();

        list.add(new WordleResponse('a', 0, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('w', 1, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('a', 2, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('x', 3, LetterResponse.WRONG_LOCATION));
        list.add(new WordleResponse('e', 4, LetterResponse.CORRECT_LOCATION));
        listOfWords.add(list);
        validWords = WordleGame.wordleMatches(listOfWords);

        System.out.println(validWords);
        //assertTrue(validWords.contains("plays"));





    }


    @Test
    public void testWordle2() {
        List<WordleResponse> list = new ArrayList<>();
        list.add(new WordleResponse('a', 0, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('w', 1, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('a', 2, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('x', 3, LetterResponse.WRONG_LOCATION));
        list.add(new WordleResponse('e', 4, LetterResponse.CORRECT_LOCATION));
        listOfWords.add(list);
        validWords = WordleGame.wordleMatches(listOfWords);
        System.out.println(validWords);
    }


    @Test
    public void testWordle3() {
        List<WordleResponse> list = new ArrayList<>();
        list.add(new WordleResponse('a', 0, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('w', 1, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('a', 2, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('x', 3, LetterResponse.WRONG_LOCATION));
        list.add(new WordleResponse('e', 4, LetterResponse.CORRECT_LOCATION));
        listOfWords.add(list);
        validWords = WordleGame.wordleMatches(listOfWords);
        System.out.println(validWords);
        assertTrue(validWords.isEmpty());
    }

    @Test
    public void testWordle4() {
        List<WordleResponse> list = new ArrayList<>();
        list.add(new WordleResponse('a', 0, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('w', 1, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('a', 2, LetterResponse.CORRECT_LOCATION));
        list.add(new WordleResponse('x', 3, LetterResponse.WRONG_LETTER));
        list.add(new WordleResponse('e', 4, LetterResponse.CORRECT_LOCATION));
        listOfWords.add(list);
        validWords = WordleGame.wordleMatches(listOfWords);
        System.out.println(validWords);
        assertTrue(validWords.contains("awake"));
        assertTrue(validWords.contains("aware"));
        assertTrue(validWords.contains("awave"));
    }
}
