package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AprenderCucumberSteps {

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
}
