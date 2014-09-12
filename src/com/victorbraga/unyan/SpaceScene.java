package com.victorbraga.unyan;

import org.unbiquitous.uImpala.engine.core.GameObjectTreeScene;

public class SpaceScene extends GameObjectTreeScene {
	public SpaceScene(){
		add(new Background(assets));
		add(new Stars(assets, 30));
		add(new NyanCat(assets));
		add(new Music(assets));
	}
}
