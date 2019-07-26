# openapi-docgen
Generates standalone html documentation from openapi yaml.

### Prerequisites

You must have node installed.

### Modules

This project contains two modules:
1. The `core` library, which wraps Node's `redoc-cli` library (and installs it if it is not present on your system)
1. A `openapi-docgen-maven-plugin` module.  This is a Maven plugin that you can use as part of your build process to generate the documentation during the Maven lifecycle.

### Using the openapi-docgen Maven plugin

```$xslt
    <build>
        <plugins>
            <plugin>
                <groupId>com.markstickel.openapi</groupId>
                <artifactId>openapi-docgen-maven-plugin</artifactId>
                <version>1.0</version>
                <executions>
                    <execution>
                        <id>generate-openapi-doc</id>
                        <phase>generate-resources</phase>
                        <inherited>false</inherited>
                        <configuration>
                            <input>petstore.yml</input>
                            <output>target/petstore-api.html</output>
                        </configuration>
                        <goals>
                            <goal>docgen</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

```

This configuration triggers the plugin during Maven's `generate-resources` phase.

#### Arguments

* `input`: the filename of a yaml- or json-formatted OpenAPI document to read in
* `output`: the filename to write the generated HTML to.

 