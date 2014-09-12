package com.victorbraga.unyan;

import org.unbiquitous.uImpala.engine.asset.AssetManager;
import org.unbiquitous.uImpala.engine.asset.Audio;
import org.unbiquitous.uImpala.engine.core.GameComponents;
import org.unbiquitous.uImpala.engine.core.GameObject;
import org.unbiquitous.uImpala.engine.core.GameRenderers;
import org.unbiquitous.uImpala.engine.io.Speaker;

public class Music extends GameObject{

	Audio music;
	Speaker speaker;
	
	public Music(AssetManager assets) {
		speaker = GameComponents.get(Speaker.class);
		
		music = assets.newAudio("sfx/nyan.ogg");
		music.play(speaker, 100.0f, true);
	}
	
	@Override
	protected void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void render(GameRenderers arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void wakeup(Object... arg0) {
		// TODO Auto-generated method stub
		
	}

}
