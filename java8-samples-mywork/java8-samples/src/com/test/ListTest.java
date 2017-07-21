/**
 *
 */
package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author VarathM
 *
 */
public class ListTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final List<String> values = new ArrayList<>();
        values.add("AAA");
        values.add("Abc");
        values.add("ABC");
        values.add("BBB");
        values.add("BCA");
        values.add("ABC");
        values.add("AAB");

        values.forEach((str) -> {
            System.out.println("Value ->" + str);
        });

    }

}
