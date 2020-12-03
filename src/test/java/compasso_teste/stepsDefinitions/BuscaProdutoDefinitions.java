package compasso_teste.stepsDefinitions;


import static org.junit.Assert.assertTrue;

import compasso_teste.core.DSL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class BuscaProdutoDefinitions {
	private DSL pagina = new DSL();
	String URL_Inicial = "https://www.livelo.com.br/"; 
	String xpathCampoBusca = "//input[@id='input-search']";
	String xpathBotaoBusca = "//button[@id='span-searchIcon']";
	String xpathBotaoComprar = "//div[@id=\"CC-prodDetails-addToCart\"]//button";
	String xpathSacola = "//div//a[@qa-automation='home-cart-button']";
	
	@Given("acesso ao site da loja")
	public void acessarAoSite() {
		pagina.visitarPagina(URL_Inicial);
	}
		
	@When("preencho o filtro de busca com o produto {string} específico com estoque")
	public void preencherFiltroBusca(String produto) {
		pagina.digitar(xpathCampoBusca, produto);
	}
	
	@And("clico no botão de realizar busca")
	public void acionarBotaoBusca() {
		pagina.clicar(xpathBotaoBusca);
	}
	
	@And("é me retornado um produto {string} e seleciono o produto desejado")
	public void validarProdutoRetornado(String produto){
		String xpathGridProduto = String.format("//div[@class='card-name']//div[contains(text(), '%s')]", produto);
		assertTrue(pagina.estaPresenteComEspera(xpathGridProduto));
		pagina.clicar("//div[@class='box-card']");
		pagina.clicar(xpathBotaoComprar);
	}
	
	@Then("o produto {string} é adicionado")
	public void validarProdutoAdicionado(String produto){
		String xpathConferenciaSacola = String.format("//a[contains(text(), '%s')]", produto);
		assertTrue(pagina.estaPresenteComEspera(xpathConferenciaSacola));
		
	}

}
