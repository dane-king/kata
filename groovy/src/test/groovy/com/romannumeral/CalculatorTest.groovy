package com.romannumeral

import spock.lang.Specification

class CalculatorTest extends Specification {
    def "should convert numbers to roman numerals"() {

        expect:
        Calculator.CONVERT.get(num) == roman_numeral

        where:
        num | roman_numeral
        1   | "I"
        2   | "II"
        5   | "V"
        10  | "X"
    }
}