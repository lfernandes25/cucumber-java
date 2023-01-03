package steps;

import entidade.Filme;
import entidade.NotaAluguel;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.AluguelServices;

import java.util.Calendar;
import java.util.Date;

public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelServices aluguel = new AluguelServices();

    private NotaAluguel nota;
    private String erro;

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
            nota = aluguel.alugar(filme);
        } catch (RuntimeException e){
            erro = e.getMessage();
        }

    }
    @Entao("o preco do aluguel sera de R$ {int}")
    public void oPrecoDoAluguelSeraDeR$(int valor) {
        Assert.assertEquals(valor,nota.getPreco());
    }
    @Entao("a data de entrega sera no dia seguinte")
    public void aDataDeEntregaSeraNoDiaSeguinte() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,1);

        Date dataRetorno = nota.getDataEntrega();
        Calendar calRetorno = Calendar.getInstance();
        calRetorno.setTime(dataRetorno);

        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH),calRetorno.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(cal.get(Calendar.MONTH),calRetorno.get(Calendar.MONTH));
        Assert.assertEquals(cal.get(Calendar.YEAR),calRetorno.get(Calendar.YEAR));
    }
    @Entao("o estoque do filme sera de {int} unidade")
    public void oEstoqueDoFilmeSeraDeUnidade(int qtde) {
        Assert.assertEquals(qtde,filme.getEstoque());
    }

    @Entao("nao sera possivel por falta de estoque")
    public void naoSeraPossivelPorFaltaDeEstoque() {
        Assert.assertEquals(erro,"Filme sem estoque");
    }
}
