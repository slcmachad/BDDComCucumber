package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;

public class PropondoLanceSteps {

	private Lance lance;
	private Lance lance10;
	private Lance lance15;
	private Leilao leilao;
	private ArrayList<Lance> lista;
	
	@Dado(" um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("fulano");
		new Lance(usuario, BigDecimal.TEN);
		Leilao leilao = new Leilao("Tablet0001");
	}
	
	@Quando(" propoe ao leilao")
	public void quando_propoe_o_lance() {
		leilao.propoe(lance);
	}
	
	@Entao(" o lance eh acheito")
	public void entao_o_lance_eh_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
		
	}
	
//	@Dado(" varios lances validos")
//	public void dado_varios_lances_validos() {
//		Usuario usuario1 = new Usuario("fulano");
//		lance10 = new Lance(usuario1, BigDecimal.TEN);
//		Usuario usuario2 = new Usuario("beltrano");
//		lance15 = new Lance(usuario2, new BigDecimal("15.0"));
//		leilao = new Leilao("Tablet0001");
//	}
	
	@Before
	public void setup() {
		this.lista = new ArrayList<Lance>();
	}
	
	@Dado("um lance de {double} reais do usuario {string}")
	public void dado_um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
		Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
		lista.add(lance);
		
	}
	
	@Quando(" propoe varios lances ao leilao")
	public void quando_propoe_varios_lances_ao_leilao() {
		leilao.propoe(lance10);
		leilao.propoe(lance15);
	}
	
	@Entao(" os lances sao aceitos")
	public void entao_os_lances_sao_aceitos() {
		Assert.assertEquals(2, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
		Assert.assertEquals(new BigDecimal("15.0"), leilao.getLances().get(1).getValor());
	}
	
}
