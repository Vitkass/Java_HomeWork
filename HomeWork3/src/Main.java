import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) {

        String root = System.getProperty("user.dir");
        ArrayList<String> out_lines =  new ArrayList<String>();

        try(BufferedReader reader = new BufferedReader(new FileReader(root+"/src/notes3.txt")))
        {
            // читаем построчно
            String line;
            while((line=reader.readLine())!=null){

                out_lines.add(line);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        HashMap<String, Integer> params = new HashMap();
        List<String> unic_words = new ArrayList<>();
        for (String line: out_lines){
            String[] words = line.split(" ");
            for (String word: words){
                word = word.replace("!", "").replace(".", "").replace(",", "");
                if (!params.containsKey(word)){
                    params.put(word, 0);
                    unic_words.add(word);
                }
                params.put(word, params.get(word) + 1);
            }
        }

        Collections.sort(unic_words);

        System.out.println("Задание 1: Подсчитайте количество различных слов в файле.");
        System.out.println(unic_words.size()); //1

        Comparator<String> stringLengthComparator = new StringLengthSort();
        Collections.sort(unic_words, stringLengthComparator);
        System.out.println("Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).");
        System.out.println("По возрастанию");
        System.out.println(unic_words);
        Collections.sort(unic_words, String.CASE_INSENSITIVE_ORDER);
        System.out.println("По тексту");
        System.out.println(unic_words);
        System.out.println("Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.");
        System.out.println(params); //3
        System.out.println("Задание 4: Выведите на экран все строки файла в обратном порядке.");
        Help.reversLines(out_lines); // 4
        System.out.println("Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.");
        ReverseIterator<String> reverseIterator = new ReverseIterator<>(unic_words);
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }
        System.out.println("Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.");
        Help.randomString(out_lines, 2); // 6



    }
}
