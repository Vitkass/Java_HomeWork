import java.util.Scanner;

public class Cycle1 {

    private static int[] find_max_min(int[] list_number){

        int min = 30000;
        int max = 0;

        for(int nums: list_number){
            if (nums>max){
                max = nums;
            }

            if (nums<min){
                min = nums;
            }

        }

        int[] out = new int[2];
        out[0] = min;
        out[1] = max;

        return out;
    }


    public static void main(String[] args) {
        Scanner scam = new Scanner(System.in);
        int count = scam.nextInt();
        int[] number_list = new int[count];
        for (int i=0; i<count; i++){
            number_list[i] = scam.nextInt();
        }

        int[] answer = find_max_min(number_list);

        System.out.println(answer[0]+" "+answer[1]);

    }
}
