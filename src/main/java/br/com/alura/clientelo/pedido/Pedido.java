package br.com.alura.clientelo.pedido;

import br.com.alura.clientelo.cliente.Cliente;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private LocalDateTime data;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDePedido> itens = new ArrayList<>();

//    private String categoria;
//    private String produto;
//    private String cliente;

//    private BigDecimal preco;
//    private int quantidade;

//    private LocalDate data;

//    public Pedido(String categoria, String produto, String cliente, BigDecimal preco, int quantidade, LocalDate data) {
//        this.categoria = categoria;
//        this.produto = produto;
//        this.cliente = cliente;
//        this.preco = preco;
//        this.quantidade = quantidade;
//        this.data = data;
//    }

//    public String getCategoria() {
//        return categoria;
//    }
//
//    public String getProduto() {
//        return produto;
//    }
//
//    public String getCliente() {
//        return cliente;
//    }
//
//    public BigDecimal getPreco() {
//        return preco;
//    }
//
//    public int getQuantidade() {
//        return quantidade;
//    }
//
//    public LocalDate getData() {
//        return data;
//    }
//
//    public BigDecimal getValorTotal() {
//        return preco.multiply(BigDecimal.valueOf(quantidade))
//                .setScale(2, RoundingMode.HALF_UP);
//    }
//
//    @Override
//    public String toString() {
//        return "Pedido{" +
//                "categoria='" + categoria + '\'' +
//                ", produto='" + produto + '\'' +
//                ", cliente='" + cliente + '\'' +
//                ", preco=" + preco +
//                ", quantidade=" + quantidade +
//                ", data=" + data +
//                '}';
//    }
//
//    public boolean isMaisBaratoQue(Pedido outroPedido) {
//        return false;
//    }
//
//    public boolean isMaisCaroQue(Pedido outroPedido) {
//        return false;
//    }
}
