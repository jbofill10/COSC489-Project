package edu.frostburg.cosc489;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileSorter {

    private ArrayList<String> lengthOfFive = new ArrayList<>();
    private ArrayList<String> otherWords = new ArrayList<>();

    public void addWord(String word) {
        if (word.length() < 5) return;

        if (word.length() == 5) {
            this.lengthOfFive.add(word);

        } else {
            this.otherWords.add(word);
        }
    }

    /**
     * Sorts each of the different lists alphabetically
     */
    public void sortLists() {
        Collections.sort(this.lengthOfFive);
        Collections.sort(this.otherWords);

    }

    /**
     * Organizes words to be written
     * @param dest destination to save file
     */
    public void writeToFile(String dest) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("./" + dest));

        writeOutList(this.lengthOfFive, writer);
        writer.write("\n");
        writeOutList(this.otherWords, writer);
        writer.close();


    }

    /**
     * Writes out words to a file
     * @param list Words being written
     * @param writer the file writer
     * @throws IOException
     */
    private void writeOutList(ArrayList<String> list, BufferedWriter writer) throws IOException {
        String word = "";
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).length() > 7) word = "TOO HECKIN LONG";
            else
                word = list.get(i);

            if(i == list.size() - 1){
                writer.write(word);

                continue;
            }
            writer.write(word);
            writer.write("\n");
        }
    }

}
