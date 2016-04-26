package br.edjonathan.treinamentos.estoque.controller;

import java.util.List;

import br.edjonathan.treinamentos.estoque.dao.ProdutoDAO;
import br.edjonathan.treinamentos.estoque.model.Produto;

public class GerenciadorDeProdutos {

	private ProdutoDAO produtoDao;
	
	public GerenciadorDeProdutos(ProdutoDAO produtoDao){
		this.produtoDao = produtoDao;
	}
	
	public void novoProduto(Produto produto){
		System.out.println("Salvando Projeto");
		this.produtoDao.salvar(produto);
	}
	
	public List<Produto>getProdutos(){
		return produtoDao.listar();
	}
}
