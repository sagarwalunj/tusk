package com.model;

import org.springframework.stereotype.Component;

@Component
public class TenantDto {

	private String name;
	private String adress;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	private int age;
	private int room_no;
	private double rent;
}
