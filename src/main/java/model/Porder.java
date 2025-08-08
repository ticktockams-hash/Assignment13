package model;

import java.io.Serializable;

public class Porder implements Serializable{
	private int id;
	private String name;
	private int lcd;
	private int ram;
	private int mouse;
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Porder(String name, int lcd, int ram, int mouse) {
		super();
		this.name = name;
		this.lcd = lcd;
		this.ram = ram;
		this.mouse = mouse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLcd() {
		return lcd;
	}
	public void setLcd(int lcd) {
		this.lcd = lcd;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getMouse() {
		return mouse;
	}
	public void setMouse(int mouse) {
		this.mouse = mouse;
	}


}
