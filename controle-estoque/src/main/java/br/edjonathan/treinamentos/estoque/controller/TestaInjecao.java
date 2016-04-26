package br.edjonathan.treinamentos.estoque.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.edjonathan.treinamentos.estoque.model.Produto;

public class TestaInjecao {

	public static void main(String[] args) {
				
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		GerenciadorDeProdutos gerenciador = (GerenciadorDeProdutos)context.getBean("gerenciadorProduto");
		
		Produto produto = new Produto();
		produto.setDescricao("Livro Spring in Action");
		produto.setQuantidade(10L);
		
		gerenciador.novoProduto(produto);
		
		for (Produto p : gerenciador.getProdutos()) {
			System.out.println("Descricao: " + p.getDescricao());
			System.out.println("Quantidade: "+ p.getQuantidade());
		}
	}
}
