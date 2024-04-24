import com.google.gson.Gson;

import java.io.FileWriter;

public class SaveData {
    private static void saveInfoInJson(String baseCurrency, String exchangeCurrency, double amount, double total){
        try(FileWriter fileWriter = new FileWriter("CurrencyConverted.txt")){
        Gson gson = new Gson();
        Totals totals = new Totals(baseCurrency, exchangeCurrency, amount, total);

        gson.toJson(totals,fileWriter);
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
