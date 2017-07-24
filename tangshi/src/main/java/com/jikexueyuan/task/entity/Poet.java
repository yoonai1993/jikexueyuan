package com.jikexueyuan.task.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * Created by Rachel on 2017年2月11日下午5:23:45 诗人
 */
public class Poet implements Serializable {
	private Integer id;
	private String name;
	
	private Timestamp created_at;
	private Timestamp updated_at;
	private List<Poetry> poetries;

	public Poet() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}


	public List<Poetry> getPoetries() {
		return poetries;
	}


	public void setPoetries(List<Poetry> poetries) {
		this.poetries = poetries;
	}

}
