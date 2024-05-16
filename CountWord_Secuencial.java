package pack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountWord_Secuencial {
    public static void main(String[] args) {
        String[] archives = {"C:\\Users\\Yo\\Desktop\\WordCount\\archivo1.txt","C:\\Users\\Yo\\Desktop\\WordCount\\archivo2.txt","C:\\Users\\Yo\\Desktop\\WordCount\\archivo3.txt"};
        Map<String, Integer> countWords = new HashMap<>();
        
        int totalWords = 0;
        
        for (String archive : archives) {
            try (BufferedReader br = new BufferedReader(new FileReader(archive))) {
                String lineText;

                while ((lineText = br.readLine()) != null) {
                    String[] words = lineText.split("\\s+");

                    for (String word : words) {
                        word = word.toLowerCase();
                        countWords.put(word, countWords.getOrDefault(word, 0) + 1);
                        totalWords++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Map.Entry<String, Integer> inPut : countWords.entrySet()) {
            System.out.println("Palabra: " + inPut.getKey() + ", Cantidad: " + inPut.getValue());
        }
        System.out.println("Total de palabras encontradas: " + totalWords);
    }
}