package br.com.alura.clientelo.pedido;

import br.com.alura.clientelo.cliente.Cliente;
import br.com.alura.clientelo.produto.Categoria;
import br.com.alura.clientelo.produto.Produto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@ToString
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private LocalDateTime data;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemDePedido> itens = new ArrayList<>();

    public int getQuantidadeDeProdudosVendidos() {
        return itens.stream()
                .mapToInt(ItemDePedido::getQuantidade)
                .sum();
    }


    public BigDecimal getValorTotal() {
        return itens.stream()
                .map(ItemDePedido::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }


    public boolean isMaisBaratoQue(Pedido outroPedido) {
        return getValorTotal().compareTo(outroPedido.getValorTotal()) < 0;
    }

    public boolean isMaisCaroQue(Pedido outroPedido) {
        return getValorTotal().compareTo(outroPedido.getValorTotal()) > 0;
    }

    public Collection<String> getCategorias() {
        return itens.stream()
                .map(ItemDePedido::getProduto)
                .map(Produto::getCategoria)
                .map(Categoria::getNome)
                .collect(Collectors.toSet());
    }
}
