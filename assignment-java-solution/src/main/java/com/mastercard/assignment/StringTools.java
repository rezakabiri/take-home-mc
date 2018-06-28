package com.mastercard.assignment;

import com.mastercard.assignment.library.objects.IntStringPair;
import org.omg.CORBA.DynAnyPackage.InvalidValue;
import com.mastercard.assignment.utilities.*;

import java.io.*;

/**
 * Created by rezakabiri on 6/25/18.
 * <p>
 * Assignment:
 * 1) create a class with a method to return the length and longest word
 * in a sentence. For example, “The cow jumped over the moon.”
 * should return 6 and “jumped”.
 *
 * 2) create unit test for the created method
 *
 * 3) explain assumptions in comment
 *
 * 4) create readme file
 *
 * 5) share via GitHub
 *
 * <p>
 * Assumptions:
 * 1) It is assumed that only alphanumeric characters are allowed and
 * anything else should be neglected/omitted. If all characters in string
 * are un-allowed then the string should be considered an empty string.
 *
 * 2) Also, it is assumed that for empty strings the method should raise an Exception.
 *
 * 3) The method should return the first longest word in the input String.
 *
 * 4) The method is not case-sensitive and will always return the lowercase.
 */


public class StringTools {

    public StringTools() {}

    public static IntStringPair FindLongestWordAndLength(String inputString) throws InvalidValue {
        IntStringPair results = new IntStringPair(-1, "");

        inputString = inputString.replaceAll("[^A-Za-z0-9 ]", " ");
        String[] myStringList = inputString.split(" ");

        for (String word : myStringList) {

            if (!word.trim().equals("")){

                int wordLength = word.length();

                if (results.getIntVal() < wordLength){

                    results.setIntVal(wordLength);
                    results.setStringVal(word.toLowerCase());
                }
            }
        }

        if (results.getIntVal() == -1){

            throw new InvalidValue("There is no alpha-numeric character in the input string. ");

        } else{

            return results;
        }

    }

    public static void main(String[] args) throws IOException, InvalidValue {

        // some experiment for load testing purposes
        // first experiment
        long startTime = System.nanoTime();
        String shakespearText = utilities.readTextFileFromResources("shakespearText.txt");
        IntStringPair result = StringTools.FindLongestWordAndLength(shakespearText);

        long endTime = System.nanoTime();
        long timeSpent = endTime - startTime;
        System.out.println("Time spent is = " + String.valueOf((double) (timeSpent/1000000)) + " miliseconds.");
        System.out.println("Longest character is \'" + String.valueOf(result.getStringVal()) + "\'.");
        System.out.println("And it has a length of " + String.valueOf(result.getIntVal()) + ".");

        // second experiment
        String shortString = "The cow jumped over the moon.";
        int maxIterNum = 500;
        startTime = System.nanoTime();
        for (int i=0; i < maxIterNum; i++){
            FindLongestWordAndLength(shortString);
        }
        endTime = System.nanoTime();
        timeSpent = endTime - startTime;
        System.out.println("Time spent is = " + String.valueOf((double) (timeSpent/1000000)) + " miliseconds.");
    }
}


