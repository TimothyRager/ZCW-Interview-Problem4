package io.zipcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args){
        Problem4 test = new Problem4();

        Scanner in = new Scanner(System.in);

        System.out.println("\nInput: bacabbb\nOutput: "+test.craftedAnagramPalindrome("bacabbb"));
        System.out.println("\nInput: baabbb\nOutput: "+test.craftedAnagramPalindrome("baabbb"));
        System.out.println("\nInput: bacab\nOutput: "+test.craftedAnagramPalindrome("bacab"));
        System.out.println("\nInput: baczzabbb\nOutput: "+test.craftedAnagramPalindrome("baczzabbb"));
        System.out.println("\nInput: baczabbb\nOutput: "+test.craftedAnagramPalindrome("baczabbb"));

        System.out.print("Please enter a string of lower-case english characters: ");
        String input = in.nextLine();
        input=input.trim();
        System.out.println("\nInput: "+input+"\nOutput: "+test.craftedAnagramPalindrome(input));
    }

    public int[] charCounter(String input){
        //Each index corresponds to a-z, count occurrences
        int[] counter={0,0,0,0,0,
                       0,0,0,0,0,
                       0,0,0,0,0,
                       0,0,0,0,0,
                       0,0,0,0,0,0};

        for (char c : input.toCharArray()){
            counter[c-'a']++;
        }

        return counter;
    }

    public boolean isPossiblePalindrome(int[] charCounter){
        //Can only be a palindrome if there are 0 or 1 character key that is an odd count
        int oddFound=0;

        for (int i: charCounter){
            if (i%2!=0){
                oddFound++;
            }
            if (oddFound>1){
                return false;
            }
        }
        return true;
    }

    public String craftedAnagramPalindrome(String input){
        //Craft palindrome by starting putting half of all even chars down,
        //then the odd chars if present, then the remaining half of all even chars.
        int[] charCounter = charCounter(input);
        StringBuilder builder = new StringBuilder();

        if (!isPossiblePalindrome(charCounter)){
            return "Not a possible palindrome";
        }

        for (char c='a'; c<='z'; c++){
            if (charCounter[c-'a']%2==0) {
                for (int i = 0; i < charCounter[c-'a'] / 2; i++) {
                    builder.append(c);
                }
            }
        }//Build the first half of the palindrome

        for (int i=0; i<26; i++){
            if (charCounter[i]%2!=0){
                for (int j=0; j<charCounter[i]; j++) {
                    builder.append(Character.toString((char)(i+'a')));
                }
            }
        }//put odds in the middle

        //Put the rest of the evens at the end in reverse order from putting in
        for (char c='z'; c>='a'; c--){
            if (charCounter[c-'a']%2==0) {
                for (int i = 0; i < charCounter[c-'a'] / 2; i++) {
                    builder.append(c);
                }
            }
        }

        return builder.toString();
    }

}
