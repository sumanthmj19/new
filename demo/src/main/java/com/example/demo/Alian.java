package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Alian {
	private int aid;
	private String aname;
	private String tech;
	
	
	@Autowired
	@Qualifier("laptop")
	private laptop laptop;
	
	
	public Alian() {
//		super();
		System.out.println("object are created");
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	
	public laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(laptop laptop) {
		this.laptop = laptop;
	}
	public void show() {
		System.out.println("in show");
		laptop.compile();
	}

}
