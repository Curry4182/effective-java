package org.gorani.chap2.item1;

public class Main {

	public static void main(String[] args) {

		/*
		정적 팩토리 메서드에는 다섯 가지 장점이 있다.
		 */

		/*
		1. 첫 번째 장점, 이름을 가질 수 있다.
		1-1. 생성자 자체만으로 반환될 객체의 특성을 제대로 설명하지 못한다. 반면 정적 팩터리는 이름만 잘 지으면 반환될 객체의
		특성을 쉽게 묘사할 수 있다.
		1-2. 하나의 시그니처로는 생성자를 하나만 만들 수 있다.
		 */
		Gorani youngGorani = Gorani.getYoungGorani("young gorani");
		Gorani oldGorani = Gorani.getOldGorani("old gorani");



	}
}
