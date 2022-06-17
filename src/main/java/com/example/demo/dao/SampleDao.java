package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntForm;

@Repository
public class SampleDao {
private final JdbcTemplate db;
	
	@Autowired
	public SampleDao(JdbcTemplate db) {
		this.db = db;
	}
	
	public void insertDb(EntForm entform) {
		db.update("INSERT INTO sample (name, comment) VALUES(?, ?)", entform.getName(), entform.getComment());
	}
	
	public List<EntForm> searchDb(){
		String sql = "SELECT * FROM sample";
		
		List<Map<String, Object>> resultDb1 = db.queryForList(sql);
		
		List<EntForm> resultDb2 = new ArrayList<EntForm>();
		
		for(Map<String, Object> result1:resultDb1) {
			EntForm entformdb = new EntForm();
			entformdb.setId((int)result1.get("id"));
			entformdb.setName((String)result1.get("name"));
			entformdb.setComment((String)result1.get("comment"));
			resultDb2.add(entformdb);
		}
		
		return resultDb2;
	}
	
//	public String img() {
////		画像処理
//		String imgPath = "";
//		switch(form.getName()) {
//			case "taro":
//			imgPath = "/img/boy.jpg";
//			
//			case "jiro":
//			imgPath = "/img/boy2.jpg";
//			
//			case "saburo":
//			imgPath = "/img/boy3.jpg";
//			
//			case "hanako":
//			imgPath = "/img/girl2.jpg";
//		}
//		
//		return imgPath;
//		
//	}
	
	
}
