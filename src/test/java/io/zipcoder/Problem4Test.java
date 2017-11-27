package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Problem4Test {

    @Test
    public void testCharCounter(){
        HashMap<String, Integer> expected = new HashMap<String, Integer>();
        String input="aaaabbbbccc";
        Problem4 test = new Problem4();
        HashMap<String, Integer> charCounterMap = test.charCounter(input);
        //Not sure how to test this. For every character, make it a key,
        // then increment a counter each time that key is seen in the string again.

//        for (Integer i : expected.values()){ //
//            Assert.assertEquals(i, charCounterMap.get(expected.));
//        }


    }

    @Test
    public void testIsPossiblePalindrome(){
        Problem4 test = new Problem4();
        String input="aab";
        HashMap<String, Integer> charCounter = test.charCounter(input);
        Assert.assertTrue(test.isPossiblePalindrome(charCounter));

        input="aabbbbc";
        charCounter = test.charCounter(input);
        Assert.assertTrue(test.isPossiblePalindrome(charCounter));

        input="abc";
        charCounter=test.charCounter(input);
        Assert.assertFalse(test.isPossiblePalindrome(charCounter));
    }

    @Test
    public void testCraftedAnagramPalindrome(){
        Problem4 test = new Problem4();

        String input="aab";
        String expected="aba";
        String actual=test.craftedAnagramPalindrome(input);

        Assert.assertEquals(expected, actual);

        input="aabbbbc";
        expected="abbcbba";
        actual=test.craftedAnagramPalindrome(input);

        Assert.assertEquals(expected, actual);

        input="bacabbb";
        expected="abbcbba";
        actual=test.craftedAnagramPalindrome(input);

        Assert.assertEquals(expected, actual);



    }

}
