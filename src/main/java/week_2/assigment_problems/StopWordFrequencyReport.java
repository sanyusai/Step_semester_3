import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StopWordFrequencyReport {

    static boolean isStopWord(String word) {

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        for (int i = 0; i < stopWords.length; i++) {
            if (word.equals(stopWords[i])) {
                return true;
            }
        }

        return false;
    }

    static void printFilteredWordFrequency(String feedback) {

        String cleanedText = feedback.toLowerCase();

        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");
        cleanedText = cleanedText.replace("!", "");
        cleanedText = cleanedText.replace("?", "");

        String[] words = cleanedText.split("\\s+");

        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            if (word.length() == 0 || isStopWord(word)) {
                continue;
            }

            if (frequencyMap.containsKey(word)) {
                frequencyMap.put(word, frequencyMap.get(word) + 1);
            } else {
                frequencyMap.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequencyMap.entrySet());

        entries.sort((entry1, entry2) ->
                entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter feedback:");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}

