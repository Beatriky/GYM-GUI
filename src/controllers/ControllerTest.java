package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ControllerTest {
    private boolean happy = false;
    private String name;

    public ControllerTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHappy() {
        return happy;
    }

    public void playWith() {
        happy = true;
    }

    public void printHappyMessage() {
        if (!happy)
            throw new IllegalStateException();
        System.out.println("I'm happy!");
    }

    public String getHappyMessage() {
        if (!happy)
            throw new IllegalStateException();
        return "I'm happy!";
    }

    static void readFile(String encoding) throws IOException {
    String path = "C:\\Users\\Admints\\IdeaProjects\\GYM1final\\src\\resources\\save.txt";
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
           System.out.println(encoded+encoding);
        }

    static void writeFile(String content){
    //String content = "Hello SaveFile! I will try to save the username and password for the logged in person here!";
    String path = "C:\\Users\\Admints\\IdeaProjects\\GYM1final\\src\\resources\\save.txt";
    try {
        Files.write(Paths.get(path), content.getBytes());
    } catch(IOException e)  {
        e.printStackTrace();
    }}
    public static void main(String[] args) {
        writeFile("usenrmdsa");
            try (Scanner scanner = new Scanner( new File("C:\\Users\\Admints\\IdeaProjects\\GYM1final\\src\\resources\\save.txt"), "UTF-8" )) {
                String text = scanner.useDelimiter("\\A").next();
                System.out.println(text);
            }
         catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

}

