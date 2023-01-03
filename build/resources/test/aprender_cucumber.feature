#language: pt

@Teste
Funcionalidade: Aprendendo cucumber

  Cenario: Deve executar especificacao
    Dado que criei o arquivo corretamente
    Quando executa-lo
    Entao a especificacao deve finalizar com sucesso

  Cenario: Deve incrementar contador
    Dado que o valor do contador e 15
    Quando eu incrementar em 3
    Entao o valor do contador sera 18

  Cenario: Deve incrementar contador
    Dado que o valor do contador e 123
    Quando eu incrementar em 35
    Entao o valor do contador sera 158

  Cenario: Deve calcular atraso na entrega
    Dado que a entrega e dia 05/04/2018
    Quando a entrega atrasar em 2 dias
    Entao a entrega sera efetuada em 07/04/2018

  Cenario: Deve calcular atraso no prazo de entrega da China
    Dado que a entrega e dia 05/04/2018
    Quando a entrega atrasar em 2 meses
    Entao a entrega sera efetuada em 05/06/2018

  Cenario: Deve criar steps genericos para estes passos
    Dado que o ticket e AF345
    E que o valor da passagem e R$230,45
    E que o nome do passageiro e "Fulano da Silva"
    E que o telefone do passageiro e 9999-9999
    Quando criar os steps
    Entao o teste vai funcionar

  Cenario: Deve reaproveitar os steps "Dado" do cenario anterior
    Dado que o ticket e AB167
    E que o ticket especial e AB167
    E que o valor da passagem e R$1120,23
    E que o nome do passageiro e "Cicrano de Oliveira"
    E que o telefone do passageiro e 9888-8888

  @ignore
  Cenario: Deve reaproveitar os steps "Dado" do cenario anterior
    Dado que o ticket e CD123
    E que o ticket e AG1234
    E que o valor da passagem e R$1.1345,56
    E que o nome do passageiro e "Beltrano Souza Matos de Alcantra Azevedo"
    E que o telefone do passageiro e 1234-5678
    E que o telefone do passageiro e 999-2223
