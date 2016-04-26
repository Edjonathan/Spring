package br.edjonathan.treinamentos.estoque.dao;

import java.util.List;

import br.edjonathan.treinamentos.estoque.model.Produto;

public interface ProdutoDAO {

	void salvar(Produto produto);
	void alterar(Produto produto);
	List<Produto>listar();
	Produto buscaPorId(Long id);
}
