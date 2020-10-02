package edu.frostburg.cosc489;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileSorter fs = new FileSorter();
        try {
            BufferedReader input = new BufferedReader(new FileReader(new File("./84kWords_random.txt")));
            String line = null;
            while ((line = input.readLine()) != null) {
                // Removes words with less than five letters
                if (line.length() < 5) continue;

                if (line.length() == 5) {
                    fs.addWord(line);

                } else {
                    if (line.length() > 7) line = "TOO HECKIN LONG";

                    fs.addWord(line);
                }

            }

            input.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        fs.sortLists();
        try {
            fs.writeToFile("output.txt");
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
