package org.example;

import org.neo4j.driver.*;
import org.neo4j.driver.AuthTokens;
import picocli.CommandLine;

public class Main
{
    DirectoryRepostiory directoryRepostiory = new DirectoryRepostiory();
    public static void main( String[] args ){
        int exitCode = new CommandLine(new MainCommand()).execute(args);
        System.exit(exitCode);
    }
}
