package com.mastercard.assignment.unittests.stringtools;

import com.mastercard.assignment.library.objects.IntStringPair;
import com.mastercard.assignment.utilities.utilities;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.io.IOException;

import static com.mastercard.assignment.StringTools.FindLongestWordAndLength;
import static org.junit.Assert.assertEquals;

/**
 * Created by rezakabiri on 6/25/18.
 */
public class FindLongestWordAndLengthMethodTest {

    private void compareResults(IntStringPair expectedResult, IntStringPair actualResult) {
        assertEquals(expectedResult.getIntVal(), actualResult.getIntVal());
        assertEquals(expectedResult.getStringVal(), actualResult.getStringVal());
    }

    @Test()
    public void givenOneCharStringThen1AndSameString() throws InvalidValue{

        String oneCharString = "a";

        IntStringPair expectedResult = new IntStringPair(1, oneCharString);
        IntStringPair actualResult = FindLongestWordAndLength(oneCharString);

        compareResults(expectedResult, actualResult);
    }

    @Test()
    public void givenOneWordStringThenSameString() throws InvalidValue{

        String oneWordString = "abcd ";

        IntStringPair expectedResult = new IntStringPair(4, "abcd");
        IntStringPair actualResult = FindLongestWordAndLength(oneWordString);

        compareResults(expectedResult, actualResult);
    }

    @Test()
    public void givenTheCowJumpedOverTheMoonThenReturn6AndJumped() throws InvalidValue{

        String myString = "The cow jumped over the moon.";

        IntStringPair expectedResult = new IntStringPair(6, "jumped");
        IntStringPair actualResult = FindLongestWordAndLength(myString);

        compareResults(expectedResult, actualResult);
    }

    @Test()
    public void givenStringThenMethodShouldReturnTheFirstLongestWord() throws InvalidValue{

        String testString = "The cow jumped overai the moon." ;

        IntStringPair expectedResult = new IntStringPair(6, "jumped");
        IntStringPair actualResult = FindLongestWordAndLength(testString);

        compareResults(expectedResult, actualResult);
    }

    @Test()
    public void givenPermutaionsOfSentenceWithOnlyOneLongestWordThenBothProduceSameResults() throws InvalidValue{

        String myFirstString = "The cow jumped over the moon.";
        String mySecondString = "the moon over The cow jumped.";

        IntStringPair frstStringResult = FindLongestWordAndLength(myFirstString);
        IntStringPair scndStringResutl = FindLongestWordAndLength(mySecondString);

        compareResults(frstStringResult, scndStringResutl);
    }

    @Test()
    public void givenUpperCaseAndLowerCaseVersionThenShouldBeIdentical() throws InvalidValue{
        String myFirstString = "the cow jumped over the moon.";
        String mySecondString = myFirstString.toUpperCase();

        IntStringPair frstStringResult = FindLongestWordAndLength(myFirstString);
        IntStringPair scndStringResutl = FindLongestWordAndLength(mySecondString);

        compareResults(frstStringResult, scndStringResutl);
    }

    @Test(expected = InvalidValue.class)
    public void givenEmptyStringThenThrowException() throws InvalidValue{

        String emptyString = "";
        FindLongestWordAndLength(emptyString);
    }

    @Test(expected = InvalidValue.class)
    public void givenSpaceCharacterThenThrowException() throws InvalidValue{

        String spaceString = " ";
        FindLongestWordAndLength(spaceString);
    }

    @Test(expected = InvalidValue.class)
    public void givenNonAlphaNumericStringThenThrowException() throws InvalidValue{

        String thisString = ",$ *( ; / \n";
        FindLongestWordAndLength(thisString);
    }

    @Test(timeout=50)
    public void givenLongStringShakespearTxtThenItShouldNotTakeMoreThan50ms() throws IOException, InvalidValue {

        String shakespearText = utilities.readTextFileFromResources("shakespear.txt");
        FindLongestWordAndLength(shakespearText);
    }

    @Test(timeout=50)
    public void givenShortString500TimesThenItShouldNotTakeMoreThan50ms() throws IOException, InvalidValue {

        String shortString = "the cow jumped over the moon.";
        int maxIterNum = 500;
        for (int i = 0; i < maxIterNum; i++){
            FindLongestWordAndLength(shortString);
        }
    }
}
