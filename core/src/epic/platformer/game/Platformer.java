package epic.platformer.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Platformer extends Game {
	GameScreen gameScreen;
//	GameOverScreen gameOverScreen;
//	MenuScreen menuScreen;
	public SpriteBatch batch;

	@Override
	public void create() {
		Assets.load();
		gameScreen = new GameScreen(this);
		setScreen(gameScreen);

//		gameOverScreen = new GameOverScreen(this); // Dominykas FTW
//		setScreen(gameOverScreen);
//aaa
//		menuScreen = new MenuScreen(this); // Dominykas FTW 2
//		setScreen(menuScreen);
	}
}
