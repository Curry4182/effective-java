package org.gorani.chap2.item1;

import java.util.HashMap;
import java.util.Map;

public final class AnimalTextureFactory {

	private static final Map<String, AnimalTexture> textureMap = new HashMap<>();

	private AnimalTextureFactory(){
	}

	/**
	 * flyweight 패턴 적용
	 */
	public static AnimalTexture getInstance(String  key) {

		if(!textureMap.containsKey(key)) {
			AnimalTexture newTexture = new AnimalTexture("gorani texture");
			textureMap.put(key, newTexture);
		}

		return textureMap.get(key);
	}
}
