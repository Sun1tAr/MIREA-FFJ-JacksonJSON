package my.learn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.learn.client.JsonHttpClient;
import my.learn.model.Currency;
import my.learn.model.DailyCurrency;
import my.learn.utils.Serializer;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        JsonHttpClient client = new JsonHttpClient();
        String currencies = client.getCurrencies();
        System.out.println(currencies);

        ObjectMapper mapper = Serializer.getMapper();
        DailyCurrency dailyCurrency = null;
        try {
            dailyCurrency = mapper.readValue(currencies, DailyCurrency.class);
            System.out.println(mapper.writeValueAsString(dailyCurrency));
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(dailyCurrency);


    }

}