package org.gorani.chap2.item1;

public class Gorani {

	private String name;
	private int age;
	private static volatile Gorani defaultGorani;

	private Gorani(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public static Gorani getOldGorani(String name) {
		return new Gorani(name, 100);
	}

	public static Gorani getYoungGorani(String name) {
		return new Gorani(name, 0);
	}

	public static Gorani getDefaultGorani() {
		/*
		Double-Checked Locking
		 */
		if(defaultGorani == null) {
			/**
			 * 멀티스레드 환경에서 임계 영역에 대한 상호 배제
			 * synchronized는 너무 느리기 때문에 if문으로 한번 더 검사하는 구조
			 */
			synchronized (Gorani.class) {
				if(defaultGorani == null) {
					defaultGorani = new Gorani("default gorani", 0);
				}
			}
		}

		return defaultGorani;
	}
}
