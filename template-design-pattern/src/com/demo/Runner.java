package com.demo;


import java.nio.file.Paths;

public class Runner {
    public static void main(String[] args) {
        new PdfReport()
                .generateReport(Paths.get("report.pdf"), "report content");

        System.out.println();

        new XlsReport()
                .generateReport(Paths.get("report.xls"), "report content");

        System.out.println();

        new TextReport()
                .generateReport(Paths.get("report.txt"), "report content");
    }
}
