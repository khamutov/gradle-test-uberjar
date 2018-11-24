package ru.butik.autotest;

import org.testng.TestNG;

public class Main {
    public static void main(String[] args) {
        TestNG testSuite = new TestNG();
        testSuite.setTestClasses(new Class[] { SimpleTest.class });
        testSuite.setDefaultSuiteName("My Test Suite");
        testSuite.setDefaultTestName("My Test");
        testSuite.run();
    }
}
