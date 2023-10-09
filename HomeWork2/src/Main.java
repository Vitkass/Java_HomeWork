import java.io.*;
import java.util.*;



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
        HashMap<String, String> params = new HashMap<String, String>();

        for (String line: out_lines){
            if (line.equals("Trade: {") || line.equals("}")) {
                continue;
            }

            line = line.strip();
            String[] line_words = line.split("=");
            params.put(line_words[0], line_words[1].replace("}","").replace("{",""));
        }

        for (String word : params.keySet()){
            System.out.println(word + " " + params.get(word));
        }

        int price = Integer.parseInt(params.get("carType"));
        String carType = params.get("carType");

        // 1 Способ

        switch (carType){
            case "HATCHBACK":
                Trade1 HatchbackTrade = new Trade1(carType, price);
            case "SEDAN":
                Trade1 SedanTrade = new Trade1(carType, price);
            case "SUV":
                Trade1 SuvTrade = new Trade1(carType, price);
            case "PICKUP":
                Trade1 PickupTrade = new Trade1(carType, price);
        }

        //2 Способ

        Trade2.Type trade = Trade2.Type.valueOf(carType);

    }
}



class Trade1 {

    String carType;
    int price;

    public Trade1(String carType, int price) {
        this.carType = carType;
        this.price = price;
    }
}

class Trade2 {

    int price;
    Type carType;


    enum Type{
        HATCHBACK,
        SEDAN,
        SUV,
        PICKUP;

        //abstract void createTrade(Trade2 trade);

    }
}