#language: pt

  Funcionalidade: Aprendendo cucumber

    Cenario: Deve executar especificacao
      Dado que criei o arquivo corretamente
      Quando executa-lo
      Entao a especificacao deve finalizar com sucesso

    Cenario: Deve incrementar contador
      Dado que o valor do contador e 15
      Quando eu incrementar em 3
      Entao o valor do contador sera 18
