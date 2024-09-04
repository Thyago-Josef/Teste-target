package org.example.ex5;

public class Main {

    public static void main(String[] args) {
        // Defina a string a ser invertida
        String original = "Exemplo de string";

        // Inverter a string
        String invertida = inverter(original);

        // Exibir a string invertida
        System.out.println("String original: " + original);
        System.out.println("String invertida: " + invertida);
    }

    public static String inverter(String s) {
        // Criar um array de caracteres com o mesmo tamanho da string original
        char[] caracteres = new char[s.length()];

        // Loop para preencher o array de caracteres com a string invertida
        for (int i = 0; i < s.length(); i++) {
            caracteres[i] = s.charAt(s.length() - 1 - i);
        }

        // Converter o array de caracteres de volta para uma string
        return new String(caracteres);
    }
    }

