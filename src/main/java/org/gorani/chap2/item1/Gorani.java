package org.gorani.chap2.item1;

public class Gorani {

	private String name;
	private int age;

	public Gorani(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public static Gorani getOldGorani(String name) {
		return new Gorani(name, 100);
	}

	public static Gorani getYoungGorani(String name) {
		return new Gorani(name, 0);
	}
}
