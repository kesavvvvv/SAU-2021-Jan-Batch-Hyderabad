import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        long startTime = System.nanoTime();

        List<String> book = Files.readAllLines(Paths.get("book.txt"));
        List<Word> word = new ArrayList<>();
        List<Para> para = new ArrayList<>();
        List<Sentence> sentence = new ArrayList<>();

        int threads = 8;

        int lines = book.size();
        int parts = lines / threads;
        int z = 0;

        for (int i = 1; i < threads; i++) {
            List<String> part = book.subList(z, parts * i);
            word.add(new Word(part));
            para.add(new Para(part));
            sentence.add(new Sentence(part));
            z = parts * i;
        }
        List<String> part = book.subList(z, lines);
        word.add(new Word(part));
        para.add(new Para(part));
        sentence.add(new Sentence(part));

        for (Word t : word) {
            t.start();
        }
        for (Para t : para) {
            t.start();
        }
        for (Sentence t : sentence) {
            t.start();
        }
        for (Word t : word) {
            t.join();
        }
        for (Para t : para) {
            t.join();
        }
        for (Sentence t : sentence) {
            t.join();
        }

        Integer WordCount = 0;
        Integer ParaCount = 0;
        Integer SentenceCount = 0;
        for (Word t : word) {
            WordCount += t.getWordCount();
        }
        for (Sentence t : sentence) {
            SentenceCount += t.getSentenceCount();
        }
        for (Para t : para) {
            ParaCount += t.getParagraphCount();
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time taken for " + threads + " thread(s): "+ totalTime/ 1000000 + " ms");
        System.out.println("Words: " + WordCount + "\nSentences: " + SentenceCount + "\nParagraphs: " + ParaCount);

    }

}
