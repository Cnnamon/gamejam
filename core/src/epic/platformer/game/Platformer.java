package epic.platformer.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Platformer extends Game {
	GameScreen gameScreen;
	public SpriteBatch batch;

	@Override
	public void create() {
		Assets.load();
		gameScreen = new GameScreen(this);

		setScreen(gameScreen);

	}
}
