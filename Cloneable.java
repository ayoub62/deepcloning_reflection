package com.ayoub.me;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Cloneable {

	private ArrayList<String> setters = new ArrayList<>();
	private Long id = null;
	
	public Cloneable() {
		Method[] m = this.getClass().getDeclaredMethods();
		for (Method meth : m) {
			if (meth.getName().startsWith("set")) {
				if(!meth.getName().contains("Setters") && !meth.getName().contains("setId"))
				setters.add(meth.getName());
			}
		}
	}
	
	public ArrayList<String> getSetters() {
		return setters;
	}
	
	public void setSetters(ArrayList<String> setters) {
		this.setters = setters;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
