package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PropondoLanceSteps {

	private Lance lance;
	private Leilao leilao;
	
	@Given("Dado um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("fulano");
		new Lance(usuario, BigDecimal.TEN);
	}
	
	@When("Quando propoe o lance")
	public void quando_propoe_o_lance() {
		Leilao leilao = new Leilao("Tablet0001");
		leilao.propoe(lance);
	}
	
	@Then("Entao o lance eh acheito")
	public void entao_o_lance_eh_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
		
	}
	
}
