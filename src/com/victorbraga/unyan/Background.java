package com.victorbraga.unyan;

import org.unbiquitous.uImpala.engine.asset.AssetManager;
import org.unbiquitous.uImpala.engine.asset.Sprite;
import org.unbiquitous.uImpala.engine.core.Game;
import org.unbiquitous.uImpala.engine.core.GameComponents;
import org.unbiquitous.uImpala.engine.core.GameObject;
import org.unbiquitous.uImpala.engine.core.GameRenderers;
import org.unbiquitous.uImpala.engine.io.KeyboardEvent;
import org.unbiquitous.uImpala.engine.io.KeyboardSource;
import org.unbiquitous.uImpala.engine.io.Screen;
import org.unbiquitous.uImpala.util.Corner;
import org.unbiquitous.uImpala.util.observer.Event;
import org.unbiquitous.uImpala.util.observer.Observation;
import org.unbiquitous.uImpala.util.observer.Subject;

public class Background extends GameObject {

	Screen screen;
	Sprite bg;
	KeyboardSource keyboard;
	
	public Background(AssetManager assets) {
		screen = GameComponents.get(Screen.class);
		bg = assets.newSprite("img/nyan_bg.png");
		
		keyboard = screen.getKeyboard();
        keyboard.connect(KeyboardSource.EVENT_KEY_DOWN, new Observation(this, "OnKeyDown"));
	}
	
	@Override
	protected void destroy() {
		keyboard.disconnect(KeyboardSource.EVENT_KEY_DOWN, new Observation(this, "OnKeyDown"));	
	}

	@Override
	protected void render(GameRenderers arg0) {
		arg0.put(0, new Runnable(){
			public void run() {
				bg.render(screen, 0.0f, 0.0f, Corner.TOP_LEFT);
			}
		});
	}

	@Override
	protected void update() {
		if(screen.isCloseRequested())
			GameComponents.get(Game.class).quit();
	}

	@Override
	protected void wakeup(Object... arg0) {
		// TODO Auto-generated method stub
		
	}

	protected void OnKeyDown(Event event, Subject subj) {
		KeyboardEvent e = (KeyboardEvent) event;
        if (e.getKey() == 1) {
            GameComponents.get(Game.class).quit();
        }
	}
	
}
