package io.testomat.e2e_tests_manufactura.utils;


public class StringParsers {

    public static Integer parseIntegerFromString(String targetText) {
        String digitText = targetText.replaceAll("\\D+", "");
        return Integer.parseInt(digitText);
    }

    public static Double parseDoubleFromString(String targetText) {
        String digitText = targetText.replaceAll("^([0-9.]+).*", "$1");
        return Double.parseDouble(digitText);
    }
}
