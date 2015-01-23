package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** Concept
 * Basic principals of the game:
 * Similar to classic War3 TD mods, where players both defend AND send enemy troops to attack their enemies
 * To generate troops/build defences, a special mineral will be required (gold maybe?)
 * The player will be receiving income, which will grow with either the upgrades of his base(research), sending troops or killing enemy troops
 * Mineral X can also be gained by harvesting mines, that will generate in the map
 * Though the idea is multiplayer based, there will be a single player mode, where the player will be either defending or attacking an AI opponent
 * The attacking player will not see the enemy players territory, but will have a map, that gets generated as his troops go deeper in
 * A normal unit will not see much beyond the road
 * A full scan can be made if the player invests in special technology
 *
 *
 *
 * Idea: building troops, making research, and so on, requires special building, that can be built close to roads
 *
 *
 * todo: decide if this will be a classic or a more original version
 *
 * Classic: both attacking and defending at once
 * 	Pros:
 * 		Strategic, simple unit control
 * 	Cons:
 * 		May take a while to finish
 *
 * Original (mobile) version
 * 	Pros:
 * 		Quicker (time limit)
 * 	Cons:
 *
 * todo: make a single player version (for now) that has: basic TD, later - offensive gameplay
 *
 */

public class MyGdxGame extends Game{

	GameScreen gameScreen;
	public SpriteBatch batch;
	@Override
	public void create() {
		Assets.load();
		gameScreen = new GameScreen(this);

		setScreen(gameScreen);

	}

}

/*public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
}*/
