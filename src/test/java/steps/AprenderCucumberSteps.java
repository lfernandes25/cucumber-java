package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class AprenderCucumberSteps {

    private int contador = 0;

    @Dado("que criei o arquivo corretamente")
    public void queCrieiOArquivoCorretamente() {
        System.out.println("Passei pelo Dado");
    }

    @Quando("executa-lo")
    public void executaLo() {
        System.out.println("Passei pelo Quando");
    }

    @Entao("a especificacao deve finalizar com sucesso")
    public void aEspecificacaoDeveFinalizarComSucesso() {System.out.println("Passei pelo Entao");
    }

    @Dado("que o valor do contador e {int}")
    public void queOValorDoContadorE(Integer valor) {
        contador = valor;
    }
    @Quando("eu incrementar em {int}")
    public void euIncrementarEm(Integer valor) {
        contador += valor;
    }
    @Entao("o valor do contador sera {int}")
    public void oValorDoContadorSera(int valor) {
        Assert.assertEquals(contador,valor);
    }
}
