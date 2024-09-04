package org.example.ex3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Media {



    public static double calcularMediaFaturamento(String jsonArray) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> listaFaturamento = objectMapper.readValue(jsonArray, new TypeReference<List<Map<String, Object>>>() {});

        double soma = 0.0;
        int count = 0;

        String dia = "";



        for (Map<String, Object> item : listaFaturamento) {
            Double valor = (Double) item.get("valor");
            if (valor != null && valor > 0.0) {
                soma += valor;
                count++;
            }
        }

        return count > 0 ? soma / count : 0;
    }

}
