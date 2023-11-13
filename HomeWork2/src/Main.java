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

        System.out.println(out_lines);
        HashMap<String, String> params = new HashMap();

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

        int price = Integer.parseInt(params.get("price"));
        String carType = params.get("carType");

        // 1 Способ

        switch (carType){
            case "HATCHBACK":
                HatchBackTrade HatchbackTrade = new HatchBackTrade(price);
            case "SEDAN":
                SedanTrade SedanTrade = new SedanTrade(price);
            case "SUV":
                SuvTrade SuvTrade = new SuvTrade(price);
            case "PICKUP":
                PickupTrade PickupTrade = new PickupTrade(price);
        }

        //2 Способ
        Trade someTrade = null;
        switch (carType){
            case "HATCHBACK":
                TradeType.HatchBack.createTrade(someTrade, price);
            case "SEDAN":
                TradeType.Sedan.createTrade(someTrade, price);
            case "SUV":
                TradeType.Suv.createTrade(someTrade, price);
            case "PICKUP":
                TradeType.PickUp.createTrade(someTrade, price);
        }

    }
}
