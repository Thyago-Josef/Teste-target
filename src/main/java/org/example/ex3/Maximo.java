package org.example.ex3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Maximo {
    public static String FaturamentoDiaMaximo(String jsonArray) throws Exception {
        Faturamento faturamento = new Faturamento("dia", 0.0);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> listaFaturamento = objectMapper.readValue(jsonArray, new TypeReference<List<Map<String, Object>>>() {});

        double maximo = -Double.MAX_VALUE;
        int diaMaximo = -1;

        for (Map<String, Object> item : listaFaturamento) {
            Double valor = (Double) item.get("valor");
            Integer dia = (Integer) item.get("dia");
            if (valor != null && valor > maximo) {
                maximo = valor;
                diaMaximo = dia;
            }
        }

        faturamento.setDia(String.valueOf(diaMaximo));
        faturamento.setValor(maximo);

        return faturamento.toString();

    }
}
