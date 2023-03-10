package br.com.luisa.resource;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.luisa.model.CadastrarProdutoDto;
import br.com.luisa.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	@GET
	public List<Produto> buscarTodosProdutos() {
		return Produto.listAll();
	}

	@POST
	@Transactional
	public void cadastrarProduto(CadastrarProdutoDto dto) {
		Produto p = new Produto();
		p.nome = dto.nome;
		p.valor = dto.valor;
		p.persist();
	}

	@PUT
	@Path("{id}")
	@Transactional
	public void atualizarProduto(@PathParam("id") Long id, CadastrarProdutoDto dto) {
		Optional<PanacheEntityBase> optional = Produto.findByIdOptional(id);
		if (optional.isEmpty())
			throw new NotFoundException();

		Produto p = (Produto) optional.get();
		p.nome = dto.nome;
		p.valor = dto.valor;
		p.persist();
	}

	@DELETE
	@Path("{id}")
	@Transactional
	public void removerProduto(@PathParam("id") Long id) {
		Optional<Produto> optional = Produto.findByIdOptional(id);

		optional.ifPresentOrElse(Produto::delete, () -> {
			throw new NotFoundException();
		});
	}

}
