package com.test;

import com.test.interfaces.InterfaceCalc;

public class UseInterfaceCalc {

    public static void main(String[] args) {
        final InterfaceCalc calc = (a, b) -> {
            System.out.println("Result Add : " + (a + b));
            System.out.println("Result Sub : " + (a - b));
            System.out.println("Result Mul : " + a * b);
            System.out.println("Result Div : " + a / b);
        };

        calc.calc(1, 1);
        calc.calc(3, 3);
        calc.calc(5, 2);

    }

}
