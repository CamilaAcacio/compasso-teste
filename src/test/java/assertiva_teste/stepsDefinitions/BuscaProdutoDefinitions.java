package assertiva_teste.stepsDefinitions;


import static org.junit.Assert.assertTrue;

import assertiva_teste.core.DSL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class BuscaProdutoDefinitions {
	private DSL pagina = new DSL();
	String URL_LOGIN = "https://www.zattini.com.br/"; 
	String xpathCampoBusca = "//input[@id='search-input']";
	String xpathBotaoBusca = "//button[@title='Buscar']";
	String xpathBotaoComprar = "//button[@id='buy-button-now']";
	String xpathSacola = "//div//a[@qa-automation='home-cart-button']";
	
	@Given("acesso ao site da loja")
	public void acessarAoSite() {
		pagina.visitarPagina(URL_LOGIN);
	}
		
	@When("preencho o filtro de busca com o produto {string} específico com estoque")
	public void preencherFiltroBusca(String produto) {
		pagina.digitar(xpathCampoBusca, produto);
	}
	
	@And("clico no botão de realizar busca")
	public void acionarBotaoBusca() {
		pagina.clicar(xpathBotaoBusca);
	}
	
	@And("é me retornado um produto {string}")
	public void validarProdutoRetornado(String produto){
		String xpathGridProduto = String.format("//a[@title='%s']", produto);
		assertTrue(pagina.estaPresenteComEspera(xpathGridProduto));
	}

	@Then("seleciono o produto {string} desejado")
	public void selecionarProduto(String produto) {
		String xpathGridProduto = String.format("//a[@title='%s']", produto);
		pagina.clicar(xpathGridProduto);
	}
	
	@And("clico no botão de adicionar ao carrinho")
	public void acionarBotaoAdicionarCarrinho() {
		pagina.clicar(xpathBotaoComprar);	
	}
	
	@And("o produto {string} é adicionado")
	public void validarProdutoAdicionado(String produto){
		String xpathConferenciaSacola = String.format("//h3[contains(text(), '%s')]", produto);
		assertTrue(pagina.estaPresenteComEspera(xpathConferenciaSacola));

		
	}

}
