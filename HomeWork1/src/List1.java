import java.util.Scanner;


public class List1 {

    private static int[] String_to_List(String[] string_to_list, int count){
        int[] int_list = new int[count];
        int i = 0;
        while (i<count){
            int_list[i] = Integer.parseInt(string_to_list[i]);
            i++;
        }

        return int_list;
    }

    private static int count_number(int[] list_number, int find_number){
        int amount = 0;
        for(int i: list_number){
            if (i==find_number){
                amount++;
            }
        }

        return amount;
    }

    public static void main(String[] args) {
        Scanner scam = new Scanner(System.in);
        int count = scam.nextInt();
        scam.nextLine();
        String list_line = scam.nextLine();
        int[] int_list = String_to_List(list_line.split(" "),count);
        int find = scam.nextInt();

        int answer = count_number(int_list, find);

        System.out.println(answer);
    }


}
