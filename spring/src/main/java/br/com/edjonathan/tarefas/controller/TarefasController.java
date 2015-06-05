package br.com.edjonathan.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.edjonathan.tarefas.bean.Tarefa;

@Controller
public class TarefasController {
	
	@RequestMapping("novaTarefa")
	public String form()
	{
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(Tarefa tarefa)
	{
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/tarefa-adicionada";
	}
}
