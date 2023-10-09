import java.io.*;
import java.util.*;


class Help{

    public static void showArray(ArrayList<word> array){
        for (word i: array){
            System.out.println(i.word);
        }
    }

    public  static String replaceTrash(String str){
        str = str.replace("!", "");
        str = str.replace("?", "");
        str = str.replace(".", "");

        return str;
    }

    public static void showHashmap(HashMap<String, Integer> hashmap){
        for (String word : hashmap.keySet())
        {
            System.out.println(word + " " + hashmap.get(word));
        }

    }

    private static String reversLine(String line){
        String[] split_line = line.split(" ");
        int len = split_line.length;
        for (int i = 0; i < len/2; i++){
            String temp = split_line[i];
            split_line[i] = split_line[len-i-1];
            split_line[len-i-1] = temp;
        }

        return String.join(" ", split_line);
    }

    public static void reversLines(String[] lines){

        for (String line: lines) {
            System.out.println(reversLine(line));
        }

    }

    public static void randomString(String[] lines, int line_number){

        System.out.println(lines[line_number-1]);
    }

}


public class Main {
    public static void main(String[] args) {

        String root = System.getProperty("user.dir");
        String out_line = "";

        try(FileReader reader = new FileReader(root+"/src/notes3.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                out_line = out_line + (char)c;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


        String[] out_lines = out_line.split("\n");
        ArrayList<word> words_array = new ArrayList<>();


        for (int i = 0; i<out_lines.length; i++){

            String[] line_words = out_lines[i].split(" ");
            for (int j=0; j<line_words.length; j++){
                words_array.add(new word(Help.replaceTrash(line_words[j]),line_words.length));
            }
        }

        Collections.sort(words_array, new Comparator<word>() {
            @Override
            public int compare(word o1, word o2) {

                int result = o1.word.length() - o2.word.length();
                if (result == 0){
                    return o1.word.toLowerCase().compareTo(o2.word.toLowerCase());
                } else if (result < 0) {
                    return -1;

                } else {
                    return 1;
                }
            }
        });

        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

        for (word word: words_array){
            if (!wordCount.containsKey(word.word))
            {
                wordCount.put(word.word, 0);
            }
            wordCount.put(word.word, wordCount.get(word.word) + 1);
        }



        System.out.println("Задание 1: Подсчитайте количество различных слов в файле.");
        System.out.println(words_array.size()); //1

        System.out.println("Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).");
        Help.showArray(words_array); //2

        System.out.println("Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.");
        Help.showHashmap(wordCount); //3

        System.out.println("Задание 4: Выведите на экран все строки файла в обратном порядке.");
        Help.reversLines(out_lines); // 4

        System.out.println("Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.");
        ListIterator<word> iterator = words_array.listIterator(words_array.size());
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous().word);
        }  //5

        System.out.println("Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.");
        Help.randomString(out_lines, 2); // 6





    }
}

class word {

    String word;
    int line_length;

    public word(String word, int line_length){
        this.word = word;
        this.line_length = line_length;

    }
}
