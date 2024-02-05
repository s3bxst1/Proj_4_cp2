import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();
            List<String> shortWords = collectShortWords(selectedFile);

            //sout
            System.out.println("Short words from the file:");
            for (String word : shortWords) {
                System.out.println(word);
            }
        }
    }

    // Method to collect 5 letters and under words from the file
    public static List<String> collectShortWords(java.io.File file) {
        List<String> shortWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.length() < 5) {
                        shortWords.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shortWords;
    }
}
// implenting filter
class ShortWordFilter implements Filter<String> {
    @Override
    public boolean accept(String word) {
        return word.length() < 5;
    }
}