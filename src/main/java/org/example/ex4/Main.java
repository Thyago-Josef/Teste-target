package org.example.ex4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ex3.Faturamento;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Valor estados = new Valor();

        try {
            JSONArray jsonArray = new JSONArray(estados.jsonArray);
            double total = 0;
            // Primeiro, calculamos o valor total
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                total += parseCurrency(obj.getString("valor"));
            }

            // Em seguida, calculamos e exibimos o percentual para cada estado
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String estado = obj.getString("estado");
                double valor = parseCurrency(obj.getString("valor"));
                double percentual = (valor / total) * 100;

                System.out.printf("%s: %.2f%%\n", estado, percentual);
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static double parseCurrency(String currency) throws ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.forLanguageTag("pt-BR"));
        Number number = format.parse(currency.replace("R$", "").trim());
        return number.doubleValue();
    }
}
