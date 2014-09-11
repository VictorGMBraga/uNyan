package org.unbiquitous.examples;

import org.unbiquitous.uImpala.engine.core.Game;
import org.unbiquitous.uImpala.engine.core.GameComponents;
import org.unbiquitous.uImpala.engine.core.GameScene;
import org.unbiquitous.uImpala.engine.io.Screen;
import org.unbiquitous.uImpala.engine.io.ScreenManager;

public class Menu extends GameScene{

	Screen screen;
	
	public Menu() {
		screen = GameComponents.get(ScreenManager.class).create();
		
		screen.open("ITAE", 1280, 800, true, null);
		GameComponents.put(Screen.class, screen);
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
