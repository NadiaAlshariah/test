package org.example;

import picocli.CommandLine;

@CommandLine.Command(name = "init")
public class InitCommand implements Runnable {
    DirectoryRepostiory directoryRepostiory = new DirectoryRepostiory();

    @Override
    public void run(){
        String path = System.getProperty("user.dir");
        Directory directory = new Directory(path);
        directoryRepostiory.saveDirectory(directory);
        System.out.println("repository has been initialized");
        //directoryRepostiory.findById(path);
    }
}
