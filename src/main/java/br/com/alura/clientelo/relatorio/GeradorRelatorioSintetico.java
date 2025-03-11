package br.com.alura.clientelo.relatorio;

import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class GeradorRelatorioSintetico {
    @Autowired
    private PedidoRepository pedidoRepository;

    public RelatorioSintetico geraRelatorio() {
        int totalDeProdutosVendidos = 0;
        BigDecimal montanteDeVendas = BigDecimal.ZERO;

        Pedido pedidoMaisBarato = null;
        Pedido pedidoMaisCaro = null;

        Set<String> categoriasProcessadas = new HashSet<>();

        var pedidos = pedidoRepository.findAll();

        for (Pedido pedidoAtual : pedidos) {
            if (pedidoMaisBarato == null || pedidoAtual.isMaisBaratoQue(pedidoMaisBarato)) {
                pedidoMaisBarato = pedidoAtual;
            } else if (pedidoMaisCaro == null || pedidoAtual.isMaisCaroQue(pedidoMaisCaro)) {
                pedidoMaisCaro = pedidoAtual;
            }

            montanteDeVendas = montanteDeVendas.add(pedidoAtual.getValorTotal());
            totalDeProdutosVendidos += pedidoAtual.getQuantidadeDeProdudosVendidos();

            categoriasProcessadas.addAll(pedidoAtual.getCategorias());
        }

        return new RelatorioSintetico(
                pedidos.size(),
                totalDeProdutosVendidos,
                montanteDeVendas,
                pedidoMaisBarato,
                pedidoMaisCaro,
                categoriasProcessadas.size()
        );
    }
}
