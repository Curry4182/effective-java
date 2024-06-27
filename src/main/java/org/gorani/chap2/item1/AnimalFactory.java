package org.gorani.chap2.item1;

/**
 * 동물이름을 받으면 해당하는 동물을 반환 합니다.
 */
public class AnimalFactory {

	public static Animal getAnimalByName(String name) {
		switch (name) {
			case "gorani":
				return Gorani.getDefaultGorani();
			default:
				return null;
		}
	}
}
