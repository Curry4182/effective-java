package org.gorani.chap2.item1;

/**
 * 동물 가져야 하는 행동들
 */
public interface Animal {

	/**
	 * 동물이 달린다.
	 */
	String run();

	/**
	 * 동물이 잠을 잔다.
	 */
	String sleep();

	/**
	 * 동물이 밥을 먹는다.
	 */
	String eat();

	/**
	 * 동물이 죽는다.
	 */
	String die();
}
