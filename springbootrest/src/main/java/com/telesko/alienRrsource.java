package com.telesko;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class alienRrsource {
	@RequestMapping("alien")
public List<Alien> getAlien()
{
	List<Alien> aliens=new ArrayList<Alien>();
	Alien a1=new Alien();
	a1.setI(1);
a1.setName("Dh");
Alien a3=new Alien();
a3.setI(12);
a3.setName("sagar");

Alien a2=new Alien();
a2.setI(12);
a2.setName("walunj");


aliens.add(a1);
aliens.add(a2);
aliens.add(a3);
	return aliens;
}
}
