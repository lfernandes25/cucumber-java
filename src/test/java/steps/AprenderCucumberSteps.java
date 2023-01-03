package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

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

    @Dado("que o valor do contador e (\\d+)$")
    public void queOValorDoContadorE(Integer valor) {
        contador = valor;
    }
    @Quando("eu incrementar em (\\d+)$")
    public void euIncrementarEm(Integer valor) {
        contador += valor;
    }
    @Entao("o valor do contador sera (\\d+)$")
    public void oValorDoContadorSera(int valor) {
        assertEquals(contador,valor);
    }

    Date entrega = new Date();

    @Dado("que a entrega e dia (\\d+)/(\\d+)/(\\d+)$")
    public void queAEntregaEDia(Integer dia, Integer mes, Integer ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes - 1); // Para o java o mes começa no 0
        cal.set(Calendar.YEAR, ano);

        entrega = cal.getTime();
    }
    @Quando("a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
    public void aEntregaAtrasarEmDias(Integer qtde, String tempo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        if(tempo.equals("dias")) {
            cal.add(Calendar.DAY_OF_MONTH, qtde);
        } else if (tempo.equals("meses")) {
            cal.add(Calendar.MONTH, qtde);
        }
        entrega = cal.getTime();
    }
    @Entao("a entrega sera efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeraEfetuadoEm(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        assertEquals(data,dataFormatada);
    }
}
