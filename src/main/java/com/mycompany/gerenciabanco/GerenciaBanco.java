/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

import java.util.Scanner;

// b) Classe para dados pessoais e operações bancárias
class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;
    private ContaBancaria conta;

    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.conta = new ContaBancaria();
    }

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public ContaBancaria getConta() {
        return conta;
    }
}

// b) Classe para dados pessoais e operações bancárias
class ContaBancaria {
    private double saldo;

    public ContaBancaria() {
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
        } else if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$" + String.format("%.2f", saldo));
    }
}

// a) Classe principal
public class GerenciaBanco {

    // c) Método para exibição do menu
    public static int exibirMenu(Scanner scanner) {
        System.out.println("Escolha uma operação:");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Realizar Depósito");
        System.out.println("3 - Realizar Saque");
        System.out.println("0 - Encerrar");
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Banco!");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, sobrenome, cpf);
        ContaBancaria conta = cliente.getConta();

        int opcao;

        do {
            opcao = exibirMenu(scanner); // Exibe o menu e obtém a opção do usuário

            // 5 - Estrutura de decisão para as opções do menu
            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor para depósito: R$");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para saque: R$");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar nossos serviços!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}