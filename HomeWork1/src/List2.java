import java.util.Scanner;


public class List2 {



    private static int[] find_max(int[] list_number, int start, int finish){


        int max = 0;
        int pointer = start;

        while (start<finish){
            if(list_number[start]>max){
                max = list_number[start];
                pointer = start+1;
                start++;
            }

        }

        int[] out = new int[2];
        out[0] = max;
        out[1] = pointer;

        return out;
    }

    public static void main(String[] args) {
        Scanner scam = new Scanner(System.in);
        int count = scam.nextInt();
        int[] number_list = new int[count];
        for (int i=0; i<count; i++){
            number_list[i] = scam.nextInt();
        }

        int start = scam.nextInt();
        int finish = scam.nextInt();

        int[] answer = find_max(number_list, start, finish);

        System.out.print(answer[0]);
        System.out.print(" ");
        System.out.print(answer[1]);




    }


}
