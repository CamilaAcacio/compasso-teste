
@tag
Feature: Busca Produto

  @tag1
  Scenario: Validar adicionar produto no carrinho
    Given acesso ao site da loja
    When preencho o filtro de busca com o produto 'Kindle 10ª Geração Tela 6" 8GB Wi-Fi Luz Embutida - Preto' específico com estoque
    And clico no botão de realizar busca 
    And é me retornado um produto 'Kindle 10ª Geração Tela 6" 8GB Wi-Fi Luz Embutida - Preto' e seleciono o produto desejado
    Then o produto 'Kindle 10ª Geração Tela 6" 8GB Wi-Fi Luz Embutida - Preto' é adicionado

