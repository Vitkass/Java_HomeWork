import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        String root = System.getProperty("user.dir");
        HashMap<String, String> words = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(root+"/src/words.txt")))
        {
            // читаем построчно
            String line;
            while((line=reader.readLine())!=null){

                String[] word_line = line.split(":");
                words.put(word_line[0], word_line[1]);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        Set<String> key_words = words.keySet();

        // 1 Найдите по словарю слова, начинающиеся с буквы n
        List<String> startWithN = key_words.stream()
                .filter(word -> word.startsWith("n"))
                .collect(Collectors.toList());
        System.out.println(startWithN);

        // 2 Найдите по словарю слова, длиной 7 символов
        List<String> length7Words = key_words.stream()
                .filter(word -> word.length() == 7)
                .collect(Collectors.toList());
        System.out.println(length7Words);

        // 3 Сгруппировать слова по первым трем буквам
        Map<String, List<String>> groupedByFirst3Letters = key_words.stream()
                .collect(Collectors.groupingBy(word-> word.substring(0, Math.min(3, word.length()))));
        System.out.println(groupedByFirst3Letters);

        // 4 Подсчитайте гласные, используемые в словах.
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        Map<Character, Long> vowelCount = key_words.stream()
                .flatMap(word -> word.chars().mapToObj(c->(char) c))
                .filter(c-> vowels.contains(c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(vowelCount);

        // 5 Найдите слова, начинающиеся с букв от a до h.
        List<String> aToHWords = key_words.stream()
                .filter(word-> word.charAt(0) >= 'a' && word.charAt(0) <= 'h')
                .collect(Collectors.toList());

        System.out.println(aToHWords);

        // 6 Найдите палиндромы в словаре. Палиндром — это слово, число, фраза или другая последовательность символов, которая читается как в прямом, так и в обратном направлении, например мадам
        List<String> palindroms = key_words.stream()
                .filter(word-> word.equals(new StringBuilder(word).reverse().toString()))
                .collect(Collectors.toList());

        System.out.println(palindroms);

        // 7 Найдите слова, начинающиеся на букву a и заканчивающиеся на букву z.

        List<String> aToZWords = key_words.stream()
                .filter(word-> word.charAt(0) >= 'a' && word.charAt(0) <= 'z')
                .collect(Collectors.toList());

        System.out.println(aToZWords);

        // 8 Найдите самое длинное слово в словаре

        String longestWord = key_words.stream()
                .max((word1, word2) -> Integer.compare(word1.length(), word2.length()))
                .orElse(null);

        System.out.println(longestWord);


    }
}