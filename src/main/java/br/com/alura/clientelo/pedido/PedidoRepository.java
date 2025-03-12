package br.com.alura.clientelo.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("SELECT p FROM Pedido p JOIN FETCH p.itens")
    List<Pedido> findAllWithItens();
}
