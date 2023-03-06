package com.demo;

public class XlsReport extends AbstractReport{
    @Override
    void appendHeader() {
        System.out.println("Appending Xls Header.");
    }

    @Override
    void appendText(String text) {
        System.out.println("Appending Xls Text.");
    }

    @Override
    void appendFooter() {
        System.out.println("Appending Xls Footer.");
    }
}
