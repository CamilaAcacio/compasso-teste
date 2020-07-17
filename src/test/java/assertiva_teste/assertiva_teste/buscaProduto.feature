
@tag
Feature: Busca Produto

  @tag1
  Scenario: Validar adicionar produto no carrinho
    Given acesso ao site da loja
    When preencho o filtro de busca com o produto 'Bolsa Santa Lolla Flap Croco Alto Brilho Alça Corrente Feminina - Preto' específico com estoque
    And clico no botão de realizar busca 
    And é me retornado um produto 'Bolsa Santa Lolla Flap Croco Alto Brilho Alça Corrente Feminina'
    Then seleciono o produto 'Bolsa Santa Lolla Flap Croco Alto Brilho Alça Corrente Feminina' desejado
    And clico no botão de adicionar ao carrinho
    And o produto 'Bolsa Santa Lolla Flap Croco Alto Brilho Alça Corrente Feminina' é adicionado

