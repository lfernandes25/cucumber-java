#language: pt
@Filme
Funcionalidade: Alugar Filme
  Como um usuario
  Eu quero cadastrar alugueis de filmes
  para controlar precos e datas de entrega


  Cenario: Deve alugar um filme com sucesso
    Dado um filme com estoque de 2 unidade
    E que o preco do aluguel seja R$ 3
    Quando alugar
    Entao o preco do aluguel sera de R$ 3
    E a data de entrega sera no dia seguinte
    E o estoque do filme sera de 1 unidade

    Cenario: Nao deve alugar fime sem estoque
      Dado um filme com estoque de 0 unidade
      Quando alugar
      Entao nao sera possivel por falta de estoque
      E o estoque do filme sera de 0 unidade