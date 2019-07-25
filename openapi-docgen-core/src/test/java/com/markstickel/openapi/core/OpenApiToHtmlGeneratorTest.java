package com.markstickel.openapi.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenApiToHtmlGeneratorTest {

    private OpenApiToHtmlGenerator generator;

    @BeforeEach
    public void setUp() throws IOException {
        generator = new OpenApiToHtmlGenerator();
    }

    @Test
    public void testGenerateHtml() throws IOException {
        String output = "target/output.html";
        generator.generate("src/test/resources/test.yaml", output);
        assertTrue(new File(output).exists());
    }
}
