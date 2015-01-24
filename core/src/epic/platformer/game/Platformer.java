package epic.platformer.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.HighScoreScreen;


public class Platformer extends Game {

	/*
	*	Todo: make a transition to another world (transition effects?)
	*	Todo: add different properties to the worlds;
	*	Todo: add more objects (enemies, traps, health, coins and so on)
	*	Todo: add random properties to those items(it may be beneficial or detrimental
	*	Todo: extend on the current ceiling grappling move
	*	Todo: add a status system for the different worlds (do they affect all mobs?)
	*	Todo: implement a die method
	*	Todo: determine if we keep pixel graphics, or morbid 2D
	*
	*
	 */

	GameScreen gameScreen;
//	GameOverScreen gameOverScreen;
//	MenuScreen menuScreen;
	HighScoreScreen highScoreScreen;
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
//aaa
//		highScoreScreen = new HighScoreScreen(this, 502f); // Dominykas FTW 3
//		setScreen(highScoreScreen);
	}
}
