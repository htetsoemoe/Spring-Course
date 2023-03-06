package com.demo;

public class TextReport extends AbstractReport{
    @Override
    void appendHeader() {
        System.out.println("Appending Text Header.");
    }

    @Override
    void appendText(String text) {
        System.out.println("Appending Text.");
    }

    @Override
    void appendFooter() {
        System.out.println("Appending Footer.");
    }
}
