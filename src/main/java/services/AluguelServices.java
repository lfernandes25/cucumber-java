package services;

import entidade.Filme;
import entidade.NotaAluguel;
import utils.DateUtils;

import java.util.Calendar;

public class AluguelServices {

    public NotaAluguel alugar(Filme filme){
        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");

        NotaAluguel nota = new NotaAluguel();
        nota.setPreco(filme.getAluguel());

        nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));

        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
