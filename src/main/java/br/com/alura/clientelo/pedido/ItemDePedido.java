package br.com.alura.clientelo.pedido;

import br.com.alura.clientelo.produto.Produto;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "item_pedido")
public class ItemDePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;

    @Column(name = "preco_compra")
    private BigDecimal preco;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;
}
