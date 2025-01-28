package com.example.springkadaitodo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {
	private final ToDoService todoService;
	
	public ToDoController(ToDoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping("/todo")
	public String Todo(Model model) {
		//データベースの内容を取得
		List<ToDo> todos = todoService.getAllTodo();
		
		//ビューに返す
		model.addAttribute("todos", todos);
		
		return "todoView";
	}
}
