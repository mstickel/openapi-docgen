package com.markstickel.openapi.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class OpenApiToHtmlGenerator {

    private static final Logger logger = LoggerFactory.getLogger(OpenApiToHtmlGenerator.class);
    private static final String EXECUTABLE = "redoc-cli";

    public OpenApiToHtmlGenerator() throws IOException {
        initializeExecutable();
    }

    public void generate(String input, String output) throws IOException {
        Process process = Runtime.getRuntime().exec(EXECUTABLE + " bundle" + (output != null ? " --output " + output : "") + " " + input);
        Scanner scanner = new Scanner(process.getInputStream());
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            logger.info(line);
        }
    }

    private boolean initializeExecutable() throws IOException {
        Scanner scanner = new Scanner(Runtime.getRuntime().exec("npm list " + EXECUTABLE + " -g").getInputStream());
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.contains(EXECUTABLE)) {
                logger.info(EXECUTABLE + " is already installed: " + line.substring(line.indexOf("@") + 1));
                return true;
            }
        }
        logger.info(EXECUTABLE + " was not installed; installing now...");
        Runtime.getRuntime().exec("npm install " + EXECUTABLE + " -g");
        logger.info(EXECUTABLE + " has been installed.");
        return false;
    }
}
