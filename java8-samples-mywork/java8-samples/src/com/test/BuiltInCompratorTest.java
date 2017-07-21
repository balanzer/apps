/**
 *
 */
package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author VarathM
 *
 */
public class BuiltInCompratorTest {

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

        for (final String val : values) {
            System.out.println(val);
        }
        System.out.println("**************");
        Collections.sort(values);

        final Comparator<String> comp = (s1, s2) -> {
            return s1.compareToIgnoreCase(s2);
        };

        Collections.sort(values, comp);

        for (final String val : values) {
            System.out.println(val);
        }
        System.out.println("**************");

    }

}
