package me.nobugs.ui.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    public static String generateRandomString() {
        return "test_" + RandomStringUtils.randomAlphabetic(10);
    }

    public static String generateRandomPassword() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String generateRandomZipCode() {
        return RandomStringUtils.randomNumeric(5);
    }

    public static String generateRandomSSN() {
        String area = RandomStringUtils.randomNumeric(3);    // First part: AAA
        String group = RandomStringUtils.randomNumeric(2);   // Second part: GG
        String serial = RandomStringUtils.randomNumeric(4);  // Third part: SSSS

        return area + "-" + group + "-" + serial;
    }
}
