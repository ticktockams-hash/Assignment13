package model;

import java.io.Serializable;

public class Porder implements Serializable{

		private int id;
		private String name;
		private int waffle;
		private int salad;
		private int sandwich;
		
		
		public Porder() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Porder(String name, int waffle, int salad, int sandwich) {
			super();
			this.name = name;
			this.waffle = waffle;
			this.salad = salad;
			this.sandwich = sandwich;
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
		public int getWaffle() {
			return waffle;
		}
		public void setWaffle(int waffle) {
			this.waffle = waffle;
		}
		public int getSalad() {
			return salad;
		}
		public void setSalad(int salad) {
			this.salad = salad;
		}
		public int getSandwich() {
			return sandwich;
		}
		public void setSandwich(int sandwich) {
			this.sandwich = sandwich;
		}


}
