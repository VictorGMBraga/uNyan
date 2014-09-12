package com.victorbraga.unyan;

import org.unbiquitous.uImpala.engine.core.Game;
import org.unbiquitous.uImpala.engine.core.GameComponents;
import org.unbiquitous.uImpala.engine.core.GameScene;
import org.unbiquitous.uImpala.engine.io.Screen;
import org.unbiquitous.uImpala.engine.io.ScreenManager;
import org.unbiquitous.uImpala.engine.io.Speaker;
import org.unbiquitous.uImpala.engine.io.SpeakerManager;

public class Menu extends GameScene{

	Screen screen;
	Speaker speaker;
	
	public Menu() {
		screen = GameComponents.get(ScreenManager.class).create();
		speaker = (Speaker) GameComponents.get(SpeakerManager.class).alloc();
				
		screen.open("uNyan", 1152, 720, false, null);
		GameComponents.put(Screen.class, screen);
		GameComponents.put(Speaker.class, speaker);
		GameComponents.get(Game.class).change(new SpaceScene());
	}
	
	@Override
	protected void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
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
