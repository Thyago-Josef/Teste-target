package org.example.ex3;


import static org.example.ex3.Media.calcularMediaFaturamento;
import static org.example.ex3.Minimo.FaturamentoMinimo;

public class Main {
    public static void main(String[] args) throws Exception {

        Valores valores = new Valores();
        String js = valores.jsonArray;

        double mediaFaturamento = calcularMediaFaturamento(js);

        String minimoFaturamento = FaturamentoMinimo(js);

        System.out.println("Media de faturamento: " + mediaFaturamento);

        System.out.println("Valor minimo de faturamento: " + minimoFaturamento);

        String maximoFaturamento = Maximo.FaturamentoDiaMaximo(js);
        System.out.println("Valor maximo de faturamento: " + maximoFaturamento);

    }




}
