package com.limestonedigital.test;

import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        int value = 12365375;
        String digits = String.valueOf(value);

        for (char digit : digits.toCharArray()) {
            if (digit < '1' || digit > '7') {
                System.out.println("Sorry but your digits should be in the range of [1, 7]");
                System.exit(-1);
            }
        }

        Set<Character> digitsSet = new TreeSet<>();
        for (char digit : digits.toCharArray()) {
            digitsSet.add(digit);
        }

        StringBuilder sortedDigits = new StringBuilder();
        digitsSet.forEach(sortedDigits::append);
        digits = sortedDigits.toString();

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < digits.length()) {
            if (i < digits.length() - 1 && (digits.charAt(i) + 1 == digits.charAt(i + 1))) {
                result.append(digits.charAt(i));
                int j = i;
                int incrementer = 0;
                while (j < digits.length() && (digits.charAt(j) == digits.charAt(i) + incrementer)) {
                    j++;
                    incrementer++;
                }
                result.append('-')
                        .append(digits.charAt(j - 1))
                        .append(',');
                i = j;
            } else {
                result.append(digits.charAt(i))
                        .append(',');
                i++;
            }
        }
        result.deleteCharAt(result.length() - 1);
        digits = result.toString();
        System.out.println(digits);
    }
}
