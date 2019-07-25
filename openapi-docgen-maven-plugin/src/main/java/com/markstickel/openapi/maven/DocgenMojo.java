package com.markstickel.openapi.maven;

import com.markstickel.openapi.core.OpenApiToHtmlGenerator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;

@Mojo(name = "docgen")
public class DocgenMojo extends AbstractMojo {

    @Parameter(property = "input", defaultValue = "openapi.yml")
    private String input;

    @Parameter(property = "output", defaultValue = "openapi.html")
    private String output;

    private OpenApiToHtmlGenerator generator;

    public DocgenMojo() throws IOException {
        generator = new OpenApiToHtmlGenerator();
    }

    public void execute() {
        getLog().info("File to use to generate docs: " + input + "; output file: " + output);
        try {
            generator.generate(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}