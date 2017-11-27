package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Problem4Test {

    @Test
    public void testCharCounter(){

        String input="aaaabbbbccc";
        Problem4 test = new Problem4();

        int[] expected =   {4,4,3,0,0,
                            0,0,0,0,0,
                            0,0,0,0,0,
                            0,0,0,0,0,
                            0,0,0,0,0,0};

        int[] actual = test.charCounter(input);

        for (int i=0; i<26; i++){
            Assert.assertEquals(expected[i], actual[i]);
        }
        input = "baczzabbb";
        int[] expected2 =  {2,4,1,0,0,
                            0,0,0,0,0,
                            0,0,0,0,0,
                            0,0,0,0,0,
                            0,0,0,0,0,2};

        int[] actual2 = test.charCounter(input);

        for (int i=0; i<26; i++){
            Assert.assertEquals(expected2[i], actual2[i]);
        }
        input="baczabbb";
        int[] expected3 =  {2,4,1,0,0,
                            0,0,0,0,0,
                            0,0,0,0,0,
                            0,0,0,0,0,
                            0,0,0,0,0,1};

        int[] actual3 = test.charCounter(input);

        for (int i=0; i<26; i++){
            Assert.assertEquals(expected3[i], actual3[i]);
        }

    }

    @Test
    public void testIsPossiblePalindrome(){
        Problem4 test = new Problem4();
        String input="aab";
        int[] charCounter = test.charCounter(input);
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

        String inputnot="aabz";
        String expectednot="Not a possible palindrome";
        String actualnot=test.craftedAnagramPalindrome(inputnot);

        Assert.assertEquals(expectednot, actualnot);

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
