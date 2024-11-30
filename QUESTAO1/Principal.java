import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static final double PRECO_BOTIJAO = 100.00; // Valor médio
    private static ArrayList<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Fazer pedido");
            System.out.println("2. Confirmar entrega");
            System.out.println("3. Ver pedidos confirmados");
            System.out.println("4. Ver pedidos entregues");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    fazerPedido(scanner);
                    break;
                case 2:
                    confirmarEntrega(scanner);
                    break;
                case 3:
                    listarPedidos("confirmado");
                    break;
                case 4:
                    listarPedidos("entregue");
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void fazerPedido(Scanner scanner) {
        System.out.print("Digite o endereço de entrega: ");
        String endereco = scanner.nextLine();

        Pedido pedido = new Pedido(endereco);
        System.out.println("\nPedido criado:\n" + pedido);

        System.out.println("\nDeseja alterar o endereço? (s/n): ");
        String alterar = scanner.nextLine();
        if (alterar.equalsIgnoreCase("s")) {
            System.out.print("Digite o novo endereço: ");
            endereco = scanner.nextLine();
            pedido.setEnderecoEntrega(endereco);
            System.out.println("\nEndereço alterado:\n" + pedido);
        }

        System.out.print("Digite a quantidade de botijões: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Digite o número do cartão de crédito: ");
        String numeroCartao = scanner.nextLine();

        pedido.confirmarPedido(quantidade, PRECO_BOTIJAO, numeroCartao);
        pedidos.add(pedido);

        System.out.println("\nPedido confirmado:\n" + pedido);
    }

    private static void confirmarEntrega(Scanner scanner) {
        System.out.print("Digite o código do pedido: ");
        int codigo = scanner.nextInt();

        Pedido pedido = buscarPedido(codigo);
        if (pedido != null && pedido.getStatus().equals("confirmado")) {
            pedido.entregarPedido();
            System.out.println("\nEntrega confirmada para o pedido:\n" + pedido);
        } else {
            System.out.println("\nPedido não localizado ou não está confirmado!");
        }
    }

    private static void listarPedidos(String status) {
        System.out.println("\nPedidos com status: " + status);
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus().equals(status)) {
                System.out.println("\n" + pedido);
            }
        }
    }

    private static Pedido buscarPedido(int codigo) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigo() == codigo) {
                return pedido;
            }
        }
        return null;
    }
}
