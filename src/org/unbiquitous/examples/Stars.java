package org.unbiquitous.examples;

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
	float starCoordinatesX[], starCoordinatesY[];
	Random rand = new Random();
	Animation starAnimation;
	Sprite starSprite;
	int numberOfStars, limiter;
	float speedX, speedY;

	public Stars(AssetManager assets, int numberOfStars) {
		screen = GameComponents.get(Screen.class);
		
		speedX = 0;
		speedY = 0;
		
		this.numberOfStars = numberOfStars;
		
		starSprite = assets.newSprite("img/star_sprite.png");
		starAnimation = assets.newAnimation(starSprite, 6, 10);
		
		starCoordinatesX = new float[numberOfStars];
		starCoordinatesY = new float[numberOfStars];
		
		for(int i = 0; i < numberOfStars; i++){
			starCoordinatesX[i] = (float)rand.nextInt(1280);
			starCoordinatesY[i] = (float)rand.nextInt(800);
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
					starAnimation.render(screen, starCoordinatesX[i], starCoordinatesY[i], Corner.CENTER, 1.0f, 0.0f, 3.0f, 3.0f);
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
				starCoordinatesX[i] = (float)rand.nextInt(1280);
				starCoordinatesY[i] = (float)rand.nextInt(800);
			}
			limiter = 0;
		}
	}

	@Override
	protected void wakeup(Object... arg0) {
		// TODO Auto-generated method stub
		
	}

}
