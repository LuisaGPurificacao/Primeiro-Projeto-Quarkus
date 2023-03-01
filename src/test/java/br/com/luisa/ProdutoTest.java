package br.com.luisa;

import static org.junit.Assert.assertEquals;

import com.github.database.rider.core.api.configuration.DBRider;

import org.junit.Test;

import br.com.luisa.model.Produto;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@DBRider
@QuarkusTest
@QuarkusTestResource(DatabaseLifecycle.class)
class ProdutoTest {

	@Test
	public void testUm() {
		assertEquals(1, Produto.count());
	}

}
