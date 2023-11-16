import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao banco!");
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);
        int opcao;
        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para depositar na conta corrente: ");
                    double valorDepositoCC = scanner.nextDouble();
                    cc.depositar(valorDepositoCC);
                    break;
                case 2:
                    System.out.print("Digite o valor para depositar na conta poupança: ");
                    double valorDepositoPoupanca = scanner.nextDouble();
                    poupanca.depositar(valorDepositoPoupanca);
                    break;
                case 3:
                    System.out.print("Digite o valor para sacar da conta corrente: ");
                    double valorSaqueCC = scanner.nextDouble();
                    cc.sacar(valorSaqueCC);
                    break;
                case 4:
                    System.out.print("Digite o valor para sacar da conta poupança: ");
                    double valorSaquePoupanca = scanner.nextDouble();
                    poupanca.sacar(valorSaquePoupanca);
                    break;
                case 5:
                    System.out.println("Extrato da Conta Corrente:");
                    cc.imprimirExtrato();
                    System.out.println("Saldo da Conta Corrente: " + cc.getSaldo());
                    break;
                case 6:
                    System.out.println("Extrato da Conta Poupança:");
                    poupanca.imprimirExtrato();
                    System.out.println("Saldo da Conta Poupança: " + poupanca.getSaldo());
                    break;
                case 7:
                    System.out.print("Digite o valor para transferir: ");
                    double valorTransferencia = scanner.nextDouble();
                    System.out.print("Digite o tipo de conta para transferir (1 - Corrente, 2 - Poupança): ");
                    int tipoConta = scanner.nextInt();

                    Conta contaDestino = (tipoConta == 1) ? cc : poupanca;
                    cc.transferir(valorTransferencia, contaDestino);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Depositar na Conta Corrente");
        System.out.println("2. Depositar na Conta Poupança");
        System.out.println("3. Sacar da Conta Corrente");
        System.out.println("4. Sacar da Conta Poupança");
        System.out.println("5. Ver Extrato da Conta Corrente");
        System.out.println("6. Ver Extrato da Conta Poupança");
        System.out.println("7. Transferir entre Contas");
        System.out.println("0. Sair");
    }
}
