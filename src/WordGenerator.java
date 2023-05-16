package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordGenerator {
    public BufferedReader read() throws FileNotFoundException {
        return new BufferedReader(new FileReader("d:\\listword.txt"));
    }
    public String[] write() throws IOException {
        BufferedReader reader = read();
        ArrayList<String> list = new ArrayList<>();
        String word;
        while ((word = reader.readLine()) != null) {
            if (!word.isEmpty()) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
    public String generateWord() {
        String[] words;
        try {
            words = write();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words[(int) (Math.random() * words.length)];
    }
}