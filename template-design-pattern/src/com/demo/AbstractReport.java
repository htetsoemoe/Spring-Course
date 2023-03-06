package com.demo;

import java.nio.file.Path;

public abstract class AbstractReport {

    public void generateReport(Path file, String text) {
        openFile(file);

        appendHeader();
        appendText(text);
        appendFooter();

        closeFile();
    }

    private void openFile(Path file) {
        System.out.println("Opening File : " + file.toFile().getName());
    }

    abstract void appendHeader();

    abstract void appendText(String text);

    abstract void appendFooter();

    private void closeFile() {
        System.out.println("Closing File.");
    }

}
