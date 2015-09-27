package com.romannumeral

class Calculator {

    static String convert(Integer num) {
        String romanNumeral = ""
        while (num > 0) {
            (num, romanNumeral) = checkNumAndString({n->n<50}, romanNumeral, num, "X", 10)
            (num, romanNumeral) = checkNumAndString({n->n<10}, romanNumeral, num, "V", 5)
            (num, romanNumeral) = checkNumAndString({n->n==4}, romanNumeral, num, "IV", 4)
            (num, romanNumeral) = checkNumAndString({n->n<=3},romanNumeral, num, "I", 1)
        }
        return romanNumeral
    }


    private static List checkNumAndString(Closure predicate,String romanNumeral, int inNumber, String addString, int checkDigit) {
        if(predicate(inNumber)){
            romanNumeral += addString
            inNumber -= checkDigit
        }
        [inNumber, romanNumeral]
    }

}
