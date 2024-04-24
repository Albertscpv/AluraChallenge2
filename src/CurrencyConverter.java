import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;

public class CurrencyConverter {
    //Method to Exchange the currency
    public static void main(String[] args) {
        System.out.println("Welcome to ConvertCurrency.io: ");
        System.out.println("You can type every currency to convert: ");
        System.out.println("*****************************************");
        System.out.println("Remember the base code, Example: Euros = EUR");
        Scanner input = new Scanner(System.in);
        System.out.println("Type a currency to convert: ");
        var base = input.nextLine();
        System.out.println("Type the currency to get the result: ");
        var sec = input.nextLine();
        System.out.println("Type the amount to convert: ");
        var amount = input.nextLine();
        exchangeCurrency(base, sec, Double.parseDouble(amount));
    }
    public static void exchangeCurrency(String baseCurrency, String exchangeCoin, double amount ){
//        String apiKey = "6fd6e680427552e01adf6e8e";
        String base_url = "https://v6.exchangerate-api.com/v6/6fd6e680427552e01adf6e8e/latest/" + baseCurrency;
        try{
            HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(base_url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200){
                Gson gson = new Gson();
                CurrencyData currencyData = gson.fromJson(response.body(), CurrencyData.class);

                double  conversionRate =    currencyData.conversion_rates.get(exchangeCoin);

                double total = amount * conversionRate;

                System.out.println(amount + " " + baseCurrency + " equals to  " + total +" "+ exchangeCoin);
            }
        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
}
