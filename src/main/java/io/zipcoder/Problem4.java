package io.zipcoder;

import java.util.Arrays;
import java.util.HashMap;

public class Problem4 {
//Please note that preeeety much none of this actually works.
    public static void main(String[] args){
        Problem4 test = new Problem4();
        System.out.println("Input: bacabbb\nOutput: "+test.craftedAnagramPalindrome("bacabbb"));
        System.out.println("Input: baabbb\nOutput: "+test.craftedAnagramPalindrome("bacabbb"));
        System.out.println("Input: bacab\nOutput: "+test.craftedAnagramPalindrome("bacabbb"));
        System.out.println("Input: baczzabbb\nOutput: "+test.craftedAnagramPalindrome("bacabbb"));
        System.out.println("Input: baczabbb\nOutput: "+test.craftedAnagramPalindrome("bacabbb"));
    }

    public HashMap<String, Integer> charCounter(String input){
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        for (char c: input.toCharArray())
        {
            if (counter.containsKey(""+c)){
                counter.put(""+c, counter.get(""+c)+1);
            } else{
                counter.put(""+c, 1);
            }
        }
        return counter;
    }

    public boolean isPossiblePalindrome(HashMap<String, Integer> charCounter){
        //Can only be a palindrome if there are 0 or 1 character key that is an odd count
        boolean oddMappingAlreadyFound=false;

        for (Integer i : charCounter.values()){
            if (i%2!=0 && !oddMappingAlreadyFound){
                oddMappingAlreadyFound=true;
            } else if (i%2!=0 && oddMappingAlreadyFound){
                return false;
            }
        }
        return true;
    }

    public String craftedAnagramPalindrome(String input){
        //Craft palindrome by starting putting half of all even chars down,
        //then the odd chars if present, then the remaining half of all even chars.
        StringBuilder returnMe = new StringBuilder();
        HashMap<String, Integer> charMap = charCounter(input);
        if (!isPossiblePalindrome(charMap)){
            return ("Not a possible Palindrome");
        }
        for (char c='a'; c<='z'; c++){
            if (charMap.containsKey(""+c))
            {
                if (charMap.get(""+c)%2==0) {
                    for (int i = 0; i < (charMap.get("" + c) / 2); i++) {
                        returnMe.append("" + c);
                    }
                } else{
                    for (int i = 0; i < (charMap.get("" + c)); i++) {
                        returnMe.append("" + c);
                    }
                }
            }
        }

        for (char c='z'; c>='a'; c--){
            if (charMap.containsKey(""+c))
            {
                if (charMap.get(""+c)%2==0) {
                    for (int i = 0; i < (charMap.get("" + c) / 2); i++) {
                        returnMe.append("" + c);
                    }
                }
            }
        }

        return returnMe.toString();
    }

}
