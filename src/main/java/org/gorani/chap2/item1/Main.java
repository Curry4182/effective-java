package org.gorani.chap2.item1;

import java.util.Optional;
import java.util.ServiceLoader;

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
		AnimalTexture goraniTexture = AnimalTextureFactory.getInstance("gorani");
		Gorani youngGorani = Gorani.getYoungGorani("young gorani", goraniTexture);
		Gorani oldGorani = Gorani.getOldGorani("old gorani", goraniTexture);


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

		/*
		3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
		3-1. 반환할 객체의 클래스를 자유롭게 선택할 수 있다.
			- 구현 클래스를 공개하지 않고도 극 객체를 반환할 수 있어 API를 작게 유지할 수 있다.
			- 프레임워크를 구현하기 위한 핵심 기술
		3-2. 자바 8 전에는 인터페이스에 정적 메서드를 선언할 수 없었다.
			- "Type" 인터페이스를 반환하는 정적 메서드가 필요하면, "Types"라는 동반 클래스(companion class)를 만드는게 관례
			- 예로 들어, 자바 컬렉션 프레임워크는 핵심 인터페이스들에 수정 불가나 동기화 등의 기능을 덧붙인 45개의 유틸리티 구현체를 제공
			- java.util.Collections에서 정적 팩터리 메서드를 통해 얻도록 한다.
		 */
		Animal gorani = AnimalFactory.getAnimalByName("gorani");

		/*
		3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
		4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
		5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
		 */
		ServiceLoader<GoraniService> serviceLoader = ServiceLoader.load(GoraniService.class);
		Optional<GoraniService> goraniServiceOptional = serviceLoader.findFirst();
		goraniServiceOptional.ifPresent( service -> {
			System.out.println(service.feedGorani(defaultGorani));
		});



	}
}

/*

 */
