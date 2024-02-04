package org.example;

import picocli.CommandLine;

@CommandLine.Command(name = "",
        description = "My awesome command-line app",
        subcommands = InitCommand.class
    )
public class MainCommand implements Runnable {
    @Override
    public void run() {
    }
}