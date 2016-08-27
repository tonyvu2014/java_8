package stream;

import java.util.*;

public class Member {
	private String name;
	private String identification;
	private int age;
	private boolean premium;
	
	
	public Member(String name, String identification, int age, boolean premium) {
		this.name = name;
		this.identification = identification;
		this.age = age;
		this.premium = premium;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getIdentification() {
		return this.identification;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public boolean isPremium() {
		return premium;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public void setPremium(boolean premium) {
		this.premium=premium;
	}
	
	public String toString() {
		return "Member: " + this.identification + ", Name: " + this.name;	
	}
	
}