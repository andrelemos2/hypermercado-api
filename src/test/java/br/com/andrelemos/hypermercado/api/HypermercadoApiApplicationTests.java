package br.com.andrelemos.hypermercado.api;

import br.com.andrelemos.hypermercado.api.model.Produto;
import br.com.andrelemos.hypermercado.api.resource.ProdutoResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProdutoResource.class)
public class HypermercadoApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProdutoResource service;

	@Test
	public void deveRetornarStatusOk() throws Exception {
		when(service.buscarPeloCodigo(1L)).thenReturn(ResponseEntity.ok(new Produto()));
		this.mockMvc.perform(get("/produtos"))
				.andDo(print())
				.andExpect(status()
						.isOk());
	}

}
