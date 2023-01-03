package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AprenderCucumberSteps {

    @Dado("que criei o arquivo corretamente")
    public void que_criei_o_arquivo_corretamente() {
        System.out.println("Passei pelo Dado");
    }

    @Quando("executa-lo")
    public void executa_lo() {
        System.out.println("Passei pelo Quando");
    }

    @Entao("a especificacao deve finalizar com sucesso")
    public void a_especificacao_deve_finalizar_com_sucesso() {
        System.out.println("Passei pelo Entao");
    }
}
