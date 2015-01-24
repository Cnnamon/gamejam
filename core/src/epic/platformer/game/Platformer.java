package epic.platformer.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Platformer extends Game {

	/*
	*	Todo: make a transition to another world;
	*	Todo: add different properties to the worlds;
	*	Todo: add more objects (enemies, traps, health, coins and so on)
	*	Todo: add random properties to those items
	*	Todo: extend on the current ceiling grappling move
	*
	*
	 */

	GameScreen gameScreen;
//	GameOverScreen gameOverScreen;
//	MenuScreen menuScreen;
	public SpriteBatch batch;

	@Override
	public void create() {
		Assets.load();
		gameScreen = new GameScreen(this);
		setScreen(gameScreen);
		batch = new SpriteBatch();

//		gameOverScreen = new GameOverScreen(this); // Dominykas FTW
//		setScreen(gameOverScreen);
//aaa
//		menuScreen = new MenuScreen(this); // Dominykas FTW 2
//		setScreen(menuScreen);
	}
}
