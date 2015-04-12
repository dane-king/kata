package com.romannumeral

import spock.lang.Specification

class CalculatorTest extends Specification {
    def "should convert numbers to roman numerals"() {

        expect:
        Calculator.convert(num) == roman_numeral

        where:
        num | roman_numeral
        1   | "I"
        2   | "II"
        3  | "III"
        4  | "IV"
        5   | "V"
        7  | "VII"
        10  | "X"
        13 | "XIII"
        14 | "XIV"
    }
}