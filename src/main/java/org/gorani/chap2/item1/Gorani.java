package org.gorani.chap2.item1;

/**
 * 초원에 사는 야생 고라니
 */
public class Gorani implements Animal {

	private String name;
	private int age;
	private static volatile Gorani defaultGorani;
	private GoraniStatus goraniStatus;
	private AnimalTexture texture;

	private Gorani(String name, int age, AnimalTexture animalTexture) {
		this.name = name;
		this.age = age;
		this.texture = animalTexture;
		this.goraniStatus = GoraniStatus.DEFAULT;
	}

	public static Gorani getOldGorani(String name, AnimalTexture animalTexture) {
		return new Gorani(name, 100, animalTexture);
	}

	public static Gorani getYoungGorani(String name, AnimalTexture animalTexture) {
		return new Gorani(name, 0, animalTexture);
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
				AnimalTexture animalTexture = AnimalTextureFactory.getInstance("gorani");
				if(defaultGorani == null) {
					defaultGorani = new Gorani("default gorani", 0, animalTexture);
				}
			}
		}

		return defaultGorani;
	}

	@Override
	public String run() {
		this.goraniStatus = GoraniStatus.RUNNING;
		return "이름: " + name + "나이: " + age + " 초원에서 달리다.";
	}

	public String sleep() {
		this.goraniStatus = GoraniStatus.SLEEPING;
		return "이름: " + name + "나이: " + age + " 잠을 자다.";
	}

	public String eat() {
		this.goraniStatus = GoraniStatus.EATING;
		return "이름: " + name + "나이: " + age + " 밥을 먹다.";
	}

	public String die() {
		this.goraniStatus = GoraniStatus.DEAD;
		return "이름: " + name + "나이: " + age + " 죽다.";
	}

	public String getStatus() {
		return "이름: " + name + "나이: " + age + " 상태: " + goraniStatus;
	}
}
