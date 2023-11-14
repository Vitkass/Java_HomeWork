import java.util.ArrayList;
import java.util.HashMap;

class Help{



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

    public static void reversLines(ArrayList<String> lines){

        for (String line: lines) {
            System.out.println(reversLine(line));
        }

    }

    public static void randomString(ArrayList<String> lines, int line_number){

        System.out.println(lines[line_number-1]);
    }

}
