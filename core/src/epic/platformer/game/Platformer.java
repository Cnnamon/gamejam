package epic.platformer.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.GameOverScreen;
import screens.MenuScreen;


public class Platformer extends Game {

	/*
	*	Todo: make a transition to another world (transition effects?)
	*	Todo: add more objects (enemies, traps, health, coins and so on)
	*	Todo: add random properties to those items(it may be beneficial or detrimental
	*	Todo: return the ceiling grappling move
	*	Todo: add a status system for the different worlds (do they affect all mobs?)
	*	Todo: player doesn't always land normally (keeps bouncing)
	*	Todo: while on moving platforms, the screen keeps shaking
	*	Todo: high score keeps resetting (smaller value overrides bigger one)
	*	Todo: a lot of memory gets allocated = the longer the game goes on, the more lag comes up (maybe we should dispose stuff properly?)
	*
	*
	*
	 */

	//	GameScreen gameScreen;
//	GameOverScreen gameOverScreen;
	MenuScreen menuScreen;
	//	HighScoreScreen highScoreScreen;
	public SpriteBatch batch;

	public Preferences prefs;

//	public BitmapFont font;

	@Override
	public void create() {

		prefs = Gdx.app.getPreferences("Platformer");

//		font = new BitmapFont(Gdx.files.internal("mainFont.fnt"), Gdx.files.internal("mainFont.png"), false);

		Assets.load();
//		gameScreen = new GameScreen(this);
//		setScreen(gameScreen);
		batch = new SpriteBatch();

//		gameOverScreen = new GameOverScreen(this, 5270); // Dominykas FTW
//		setScreen(gameOverScreen);
//aaa
		menuScreen = new MenuScreen(this); // Dominykas FTW 2
		setScreen(menuScreen);
//aaa
//		highScoreScreen = new HighScoreScreen(this, 502f); // Dominykas FTW 3
//		setScreen(highScoreScreen);
	}

	@Override
	public void dispose() {
		prefs.flush();
		super.dispose();

	}
}