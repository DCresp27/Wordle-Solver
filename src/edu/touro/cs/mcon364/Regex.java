package edu.touro.cs.mcon364;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {

    }

    //matches a proper name like Bob, Smith, Joey
    public static boolean properName(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        String regex = "^[A-Z][a-z]{2,}$"; //https://www.quora.com/Can-you-have-a-single-letter-as-a-legal-first-name#:~:text=Yes%2C%20but%20it%20depends%20on,without%20the%20appended%20%E2%80%9Cdot.%E2%80%9D
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();

    }

    //matches a number (integer or decimal, positive or negative) 12, 43.23, -34.5, +98.7, 0, 0.0230 (but not 023)
    static boolean integer(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean found;
        String regex = "^[+-]?(?:[1-9]\\d*|0)(?:\\.\\d+)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();

    }


    //Matches an ancestor like father, mother, great-great-grandmother.
    static boolean ancestor(String s){

        if (s == null || s.length() == 0) {
            return false;
        }
        String regex = "^(?:great-)*father$|^(?:great-)*mother$|^great-great-grandmother$|^great-great-great-grandfather$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        boolean found = matcher.find();
        return found;
    }
}
