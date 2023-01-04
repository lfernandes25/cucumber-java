package steps;

import entidade.Filme;
import entidade.NotaAluguel;
import entidade.TipoAluguel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.AluguelServices;
import utils.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelServices aluguel = new AluguelServices();

    private NotaAluguel nota;
    private String erro;
    private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

    @Dado("um filme com estoque de {int} unidade")
    public void umFilmeComEstoqueDeUnidade(int qtde) {
        filme = new Filme();
        filme.setEstoque(qtde);
    }
    @Dado("que o preco do aluguel seja R$ {int}")
    public void queOPreODoAluguelSejaR$(int valor) {
        filme.setAluguel(valor);
    }
    @Quando("alugar")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme , tipoAluguel);
        } catch (RuntimeException e){
            erro = e.getMessage();
        }

    }

    @Dado("que o tipo de aluguel seja (.*)$")
    public void queOTipoDeAluguelSejaExtendido(String tipo) {
        tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL:
                tipo.equals("extendido")? TipoAluguel.EXTENDIDO:
                        TipoAluguel.COMUM;
    }

    @Dado("um filme")
    public void umFilme(DataTable dataTable) {
        Map<String , String> map = dataTable.asMap(String.class, String.class);
        filme = new Filme();
        filme.setEstoque(Integer.parseInt(map.get("estoque")));
        filme.setAluguel(Integer.parseInt(map.get("preco")));
        String tipo = map.get("tipo");
        tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL:
                tipo.equals("extendido")? TipoAluguel.EXTENDIDO:
                        TipoAluguel.COMUM;
    }
    @Entao("o preco do aluguel sera de R$ {int}")
    public void oPrecoDoAluguelSeraDeR$(int valor) {
        Assert.assertEquals(valor,nota.getPreco());
    }

    @Entao("o estoque do filme sera de {int} unidade")
    public void oEstoqueDoFilmeSeraDeUnidade(int qtde) {
        Assert.assertEquals(qtde,filme.getEstoque());
    }

    @Entao("nao sera possivel por falta de estoque")
    public void naoSeraPossivelPorFaltaDeEstoque() {
        Assert.assertEquals(erro,"Filme sem estoque");
    }

    @Entao("a data de entrega sera em (\\d+) dias?$")
    public void aDataDeEntregaSeraEmDias(int dias) {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(dias);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada),format.format(dataReal));

    }

    @Entao("a pontuacao sera de {int} pontos")
    public void aPontuacaoSeraDePontos(int pontuacao) {
        Assert.assertEquals(pontuacao,nota.getPontuacao());
    }
}
