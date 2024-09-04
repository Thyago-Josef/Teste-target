package org.example.ex3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Minimo {

    public static String FaturamentoMinimo(String jsonArray) throws Exception {
        Faturamento faturamento = new Faturamento("dia", 0.0);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> listaFaturamento = objectMapper.readValue(jsonArray, new TypeReference<List<Map<String, Object>>>() {});

        double minimo = Double.MAX_VALUE;
        int diaMinimo = -1;

        for (Map<String, Object> item : listaFaturamento) {
            Double valor = (Double) item.get("valor");
            Integer dia = (Integer) item.get("dia");
            if (valor != null && valor < minimo && valor > 0.0) {
                minimo = valor;
                diaMinimo = dia;
            }
        }

        faturamento.setDia(String.valueOf(diaMinimo));
        faturamento.setValor(minimo);

        return faturamento.toString();

    }

}





