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


		/*
		2. 호출 될 때 마다 인스턴스를 새로 생성하지는 않아도 된다.
		2-1. 새로 생성한 인스턴스를 캐싱하여 재활용하는 식으로 불필요한 객체 생성을 피할 수 있다.
			- Boolean.valueOf(boolean)
			- Flyweight pattern
		2-2. 반복되는 요청에 같은 객체를 반환하는 식으로 정적 팩터리 방식의 클래스는 언제 어느 인스턴스를 살아 있게 할지를 철저히 통제할 수 있다.
			- 이유1. 싱글턴
			- 이유2. 인스턴스화 불가
			- 이유3. 동치 보장(a==b, a.equals(b))
		 */
		Gorani defaultGorani = Gorani.getDefaultGorani();
	}
}
