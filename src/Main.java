import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner escanear = new Scanner(System.in);
        double saldo = 100.000;
        int conversao = 0;
        double valorConversao = 0;

        List<String> opcoes = new ArrayList<>();

        opcoes.add(0,"USD/CLP");
        opcoes.add(1,"CLP/USD");
        opcoes.add(2,"USD/BRL");
        opcoes.add(3,"BRL/USD");
        opcoes.add(4,"AUD/JPY");
        opcoes.add(5,"JPY/AUD");

        String moedas = """
                1) dolar americano -> peso chileno
                2) peso chileno -> dolar americano
                3) dolar americano -> real brasileiro
                4) real brasileiro -> dolar americano
                5) dolar australiano -> iene
                6) iene -> dolar australiano
                """;

        System.out.println("*******");
        System.out.println("#####Seja bem vindo######");
        System.out.print("Digite seu nome: ");
        String nome = escanear.nextLine();
        System.out.println("\n*******");

        while (true) {
            String menu = """
                    ** digite sua opção **
                    1- digite o valor
                    2- moedas que temos
                    3- resultado e taxa de cambio
                    4- sair
                    """;

            System.out.println("\n" + menu);

            double opcao = escanear.nextDouble();
            if (opcao == 1) {
                System.out.println("digite o valor que deseja converter ");
                valorConversao = escanear.nextDouble();
            } else if (opcao == 2) {
                System.out.println("moedas que temos \n" + moedas);
                conversao = escanear.nextInt();
            } else if (opcao == 3) {
                String opcaoSelecionada = opcoes.get(conversao-1);
                String resultado = ConsultaMoeda.Consultar(opcaoSelecionada, valorConversao);
                System.out.println("resultado e taxa de cambio " + resultado + "[ " + opcaoSelecionada.replace("/", " -> ") + " ]");
            } else if (opcao == 4) {
                System.exit(0);
            }
        }
    }
}