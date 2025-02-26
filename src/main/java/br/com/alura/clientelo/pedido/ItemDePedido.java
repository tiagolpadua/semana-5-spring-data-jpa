package br.com.alura.clientelo.pedido;

import br.com.alura.clientelo.produto.Produto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
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
