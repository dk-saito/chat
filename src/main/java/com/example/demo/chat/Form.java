package com.example.demo.chat;

import javax.validation.constraints.Size;

public class Form {
	@Size(min=1, max=10, message="名前が短すぎるか長すぎます。")
	private String name;
	
	@Size(min=1, max=30, message="コメントが短すぎるか長すぎます。")
	private String comment;
	
	public Form() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
