package org.example.ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o número do usuário
        System.out.print("Informe um número para verificar se pertence à sequência de Fibonacci: ");
        int numero = scanner.nextInt();

        // Verifica se o número pertence à sequência de Fibonacci
        if (isFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }


    // Método para verificar se um número pertence à sequência de Fibonacci
    public static boolean isFibonacci(int numero) {
        if (numero == 0 || numero == 1) {
            return true;
        }

        int num1 = 0;
        int num2 = 1;
        int soma = num1 + num2;

        while (soma <= numero) {
            if (soma == numero) {
                return true;
            }

            num1 = num2;
            num2 = soma;
            soma = num1 + num2;
        }

        return false;
    }
}


