package com.example.demo.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.SampleDao;
import com.example.demo.entity.EntForm;

@Controller
public class ChatController {
	
	private final SampleDao sampledao;
	@Autowired
	public ChatController(SampleDao sampledao) {
		this.sampledao = sampledao;
	}

	@RequestMapping("/index")
	public String index(Model model, Form form) {
		model.addAttribute("title", "ようこそ");
		return "index";
	}
	
	
	@RequestMapping("/chat")
	public String chat(Model model, Form form) {
		model.addAttribute("title", "チャット画面");
//		view
		List<EntForm> list = sampledao.searchDb();
		model.addAttribute("dbList", list);
		
		return "form/chat";
	}
	
	@RequestMapping("/confirm")
	public String confirm(Model model, @Validated Form form, BindingResult result) {
//	public String confirm(Model model, Form form) {
		
		
		if(result.hasErrors()) {
			
			return "form/chat";
		}
		
		model.addAttribute("title", "確認画面");
		
		EntForm entform = new EntForm();
		entform.setName(form.getName());
		entform.setComment(form.getComment());
		
		
		sampledao.insertDb(entform);
		
//		complete
	

		
		return "form/confirm";
	}
	
}
