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

//	@Override
//	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
//	}
}
