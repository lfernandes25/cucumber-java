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
    E a data de entrega sera em 1 dia
    E o estoque do filme sera de 1 unidade

  Cenario: Deve alugar um filme com sucesso
    Dado um filme
      | estoque | 2     |
      | preco   | 3     |
      | tipo    | comum |
    Quando alugar
    Entao o preco do aluguel sera de R$ 3
    E a data de entrega sera em 1 dia
    E o estoque do filme sera de 1 unidade

  Cenario: Nao deve alugar fime sem estoque
    Dado um filme com estoque de 0 unidade
    Quando alugar
    Entao nao sera possivel por falta de estoque
    E o estoque do filme sera de 0 unidade

  Cenario: Deve dar condicoes especiais para categoria extendida
    Dado um filme com estoque de 2 unidade
    E que o preco do aluguel seja R$ 4
    E que o tipo de aluguel seja extendido
    Quando alugar
    Entao o preco do aluguel sera de R$ 8
    E a data de entrega sera em 3 dias
    E a pontuacao sera de 2 pontos

  Cenario: Deve alugar para categoria comum
    Dado um filme com estoque de 2 unidade
    E que o preco do aluguel seja R$ 4
    E que o tipo de aluguel seja comum
    Quando alugar
    Entao o preco do aluguel sera de R$ 4
    E a data de entrega sera em 1 dia
    E a pontuacao sera de 1 pontos

  Esquema do Cenario: Deve dar condicoes conforme tipo de aluguel
    Dado um filme com estoque de 2 unidade
    E que o preco do aluguel seja R$ <preco>
    E que o tipo de aluguel seja <tipo>
    Quando alugar
    Entao o preco do aluguel sera de R$ <valor>
    E a data de entrega sera em <qtdeDias> dias
    E a pontuacao sera de <pontuacao> pontos

    Exemplos:
      | preco | tipo      | valor | qtdeDias | pontuacao |
      | 4     | extendido | 8     | 3        | 2         |
      | 4     | comum     | 4     | 1        | 1         |
      | 10    | extendido | 20    | 3        | 2         |
      | 5     | semanal   | 15    | 7        | 3         |
