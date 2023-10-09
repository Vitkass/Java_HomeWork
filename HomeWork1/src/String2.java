import java.util.Scanner;


public class String2 {

    private static String ReversString(String string_to_revers){
        String[] word_list = string_to_revers.split(" ");
        int words_count = word_list.length;
        for (int i = 0; i<words_count/2;i++){
            String temp = word_list[i];
            word_list[i] = word_list[words_count-1-i];
            word_list[words_count-1-i] = temp;
        }

        return String.join(" ", word_list);
    }

    public static void main(String[] args) {
        Scanner scam = new Scanner(System.in);
        String countLine = scam.nextLine();
        int count = Integer.parseInt(countLine);
        String[] line_list = new String[count];


        int i = 0;
        while (i < count) {
            String nex_line = scam.nextLine();
            line_list[i] = nex_line;
            i++;
        }

        for (String line: line_list){
            System.out.println(ReversString(line));
        }

    }


}
