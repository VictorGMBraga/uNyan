package com.victorbraga.unyan;

import java.util.Random;

import org.unbiquitous.uImpala.engine.asset.Animation;
import org.unbiquitous.uImpala.engine.asset.AssetManager;
import org.unbiquitous.uImpala.engine.asset.Sprite;
import org.unbiquitous.uImpala.engine.core.GameComponents;
import org.unbiquitous.uImpala.engine.core.GameObject;
import org.unbiquitous.uImpala.engine.core.GameRenderers;
import org.unbiquitous.uImpala.engine.io.Screen;
import org.unbiquitous.uImpala.util.Corner;

public class Stars extends GameObject {

	Screen screen;
	float starCoordinatesX[], starCoordinatesY[], scale;
	Random rand = new Random();
	Animation starAnimation;
	Sprite starSprite;
	int numberOfStars, limiter;

	public Stars(AssetManager assets, int numberOfStars) {
		screen = GameComponents.get(Screen.class);
		
		this.numberOfStars = numberOfStars;
		
		scale = 5.0f;
		
		starSprite = assets.newSprite("img/star_sprite.png");
		starAnimation = assets.newAnimation(starSprite, 6, 10);
		
		starCoordinatesX = new float[numberOfStars];
		starCoordinatesY = new float[numberOfStars];
		
		for(int i = 0; i < numberOfStars; i++){
			starCoordinatesX[i] = (float)rand.nextInt(screen.getWidth());
			starCoordinatesY[i] = (float)rand.nextInt(screen.getHeight());
		}
	}
	
	@Override
	protected void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void render(GameRenderers arg0) {
		arg0.put(0, new Runnable(){
			public void run() {
				for(int i = 0; i < numberOfStars; i++){
					starAnimation.render(screen, starCoordinatesX[i], starCoordinatesY[i], Corner.CENTER, 1.0f, 0.0f, scale, scale);
				}
			}
		});
	}

	@Override
	protected void update() {
		limiter++;
		
		if(limiter == 15){
			int loopStart = rand.nextInt(numberOfStars);
			int loopEnd = rand.nextInt(numberOfStars);
			
			if(loopStart > loopEnd){
				int temp = loopStart;
				loopStart = loopEnd;
				loopEnd = temp;
			}
			
			for(int i = loopStart; i < loopEnd; i++){
				starCoordinatesX[i] = (float)rand.nextInt(screen.getWidth());
				starCoordinatesY[i] = (float)rand.nextInt(screen.getHeight());
			}
			limiter = 0;
		}
	}

	@Override
	protected void wakeup(Object... arg0) {
		// TODO Auto-generated method stub
		
	}

}
