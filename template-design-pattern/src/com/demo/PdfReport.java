package com.demo;

public class PdfReport extends AbstractReport{
    @Override
    void appendHeader() {
        System.out.println("Appending Pdf Header.");
    }

    @Override
    void appendText(String text) {
        System.out.println("Appending Pdf Text.");
    }

    @Override
    void appendFooter() {
        System.out.println("Appending Pdf Footer.");
    }
}
