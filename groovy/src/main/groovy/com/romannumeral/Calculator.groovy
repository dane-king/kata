package com.romannumeral

class Calculator {

    static String convert(Integer num) {
        String romanNumeral = ""
        while (num > 0) {
            if (num <= 3) {
                romanNumeral += "I"
                num = num - 1
            } else if (num == 4) {
                romanNumeral += "IV"
                num = num - 4
            } else if (num < 10) {
                romanNumeral += "V"
                num = num - 5
            } else if (num < 50) {
                romanNumeral += "X"
                num = num - 10
            }
        }
        return romanNumeral
    }
}
