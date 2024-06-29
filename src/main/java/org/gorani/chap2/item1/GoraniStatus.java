package org.gorani.chap2.item1;

/**
 * 9p
 * 두 번째 장점, 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
 * - 열거 타입은 인스턴스가 단 하나뿐 임을 보장할 수 있다.
 */

public enum GoraniStatus {
	RUNNING("달리는중"), SLEEPING("자는중"), EATING("먹는중"), DEAD("죽음"), DEFAULT("기본");
	private final String status;
	private GoraniStatus(String status) {
		this.status = status;
	}
}
