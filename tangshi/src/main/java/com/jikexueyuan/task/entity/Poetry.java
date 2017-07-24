package com.jikexueyuan.task.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Poetry implements Serializable {
	private Integer id;
	private String title;
	private String content;
	private Timestamp updated_at;
	private Integer poet_id;
	private Timestamp created_at;
	private Poet poet;

	public Poetry() {
	}

	public Poetry(Poet poet) {
		this.poet = poet;
	}
	
	public Poetry(String title, String content, Timestamp updated_at, Integer poet_id, Timestamp created_at,
			Poet poet) {
		this.title = title;
		this.content = content;
		this.updated_at = updated_at;
		this.poet_id = poet_id;
		this.created_at = created_at;
		this.poet = poet;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public Integer getPoet_id() {
		return poet_id;
	}

	public void setPoet_id(Integer poet_id) {
		this.poet_id = poet_id;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Poet getPoet() {
		return poet;
	}

	public void setPoet(Poet poet) {
		this.poet = poet;
	}


}
