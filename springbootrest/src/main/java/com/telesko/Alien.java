package com.telesko;

import org.springframework.stereotype.Component;

@Component
public class Alien {
private int i;
private String name ;
public int getI() {
	return i;
}
public void setI(int i) {
	this.i = i;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
