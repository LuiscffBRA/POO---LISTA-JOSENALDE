import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    private static int contador = 1; // Para gerar código sequencial
    private int codigo;
    private LocalDateTime horaCompra;
    private LocalDateTime horaEntrega;
    private String enderecoEntrega;
    private int quantidadeBotijoes;
    private double totalCompra;
    private String numeroCartao;
    private String status; // "pendente", "confirmado", "entregue"

    public Pedido(String enderecoEntrega) {
        this.codigo = contador++;
        this.horaCompra = LocalDateTime.now();
        this.enderecoEntrega = enderecoEntrega;
        this.status = "pendente";
    }

    public int getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public void confirmarPedido(int quantidadeBotijoes, double precoUnitario, String numeroCartao) {
        this.quantidadeBotijoes = quantidadeBotijoes;
        this.totalCompra = quantidadeBotijoes * precoUnitario;
        this.horaEntrega = this.horaCompra.plusHours(6);
        this.numeroCartao = numeroCartao;
        this.status = "confirmado";
    }

    public void entregarPedido() {
        this.status = "entregue";
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder sb = new StringBuilder();
        sb.append("Código: ").append(codigo)
          .append("\nHora da Compra: ").append(horaCompra.format(formatter))
          .append("\nEndereço de Entrega: ").append(enderecoEntrega)
          .append("\nQuantidade de Botijões: ").append(quantidadeBotijoes)
          .append("\nTotal da Compra: R$ ").append(String.format("%.2f", totalCompra))
          .append("\nHora da Entrega: ").append(horaEntrega != null ? horaEntrega.format(formatter) : "Não definido")
          .append("\nStatus: ").append(status);
        return sb.toString();
    }
}
