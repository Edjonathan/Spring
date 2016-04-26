package br.edjonathan.treinamentos.estoque.dao;

import java.util.ArrayList;
import java.util.List;

import br.edjonathan.treinamentos.estoque.model.Produto;

public class ProdutoMemoriaDAO implements ProdutoDAO {

	private List<Produto> produtos = new ArrayList<Produto>();
	
	
	public ProdutoMemoriaDAO() {
		Produto produto = new Produto();
		produto.setDescricao("Mac Book");
		produto.setQuantidade((long) 40);
		produtos.add(produto);
	}

	public void salvar(Produto produto) {
		produtos.add(produto);
	}

	public void alterar(Produto produto) {
	}

	public List<Produto> listar() {
		return produtos;
	}

	public Produto buscaPorId(Long id) {
		return null;
	}

}
