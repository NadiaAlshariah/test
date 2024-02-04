package org.example;

import picocli.CommandLine;

@CommandLine.Command(name = "init")
public class InitCommand implements Runnable {
    @Override
    public void run(){
        System.out.println("The folder has been initiated");
    }
}
