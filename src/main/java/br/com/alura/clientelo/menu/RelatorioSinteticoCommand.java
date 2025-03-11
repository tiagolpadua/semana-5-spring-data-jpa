package br.com.alura.clientelo.menu;

import br.com.alura.clientelo.pedido.PedidoRepository;
import br.com.alura.clientelo.relatorio.GeradorRelatorioSintetico;
import br.com.alura.clientelo.relatorio.RelatorioSintetico;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RelatorioSinteticoCommand implements FuncionalidadeCommand {
    @Autowired
    private PedidoRepository pedidoRepository;

//    @Autowired
//    private GeradorRelatorioSintetico geradorRelatorioSintetico;

    @Override
    public void executa() {
        RelatorioSintetico relatorioSintetico = RelatorioSintetico.geraRelatorio(pedidoRepository.findAllWithItens());
//        RelatorioSintetico relatorioSintetico = geradorRelatorioSintetico.geraRelatorio();
        relatorioSintetico.exibir();
    }

    @Override
    public String getDescricao() {
        return "Relatório sintético";
    }
}
