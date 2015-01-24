package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import epic.platformer.game.Assets;
import epic.platformer.game.Platformer;

import java.text.DecimalFormat;

/**
 * Created by d.vilimas on 2015.01.24.
 */
public class HighScoreScreen implements Screen {


    Platformer game;

    OrthographicCamera camera;

    float score;
    float scoreScale = 5f;

    Label scoreText;

    public HighScoreScreen(Platformer game, float score) {
        this.game = game;
        this.score = score;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Assets.screenSizeWidth, Assets.screenSizeHeight);
    }

    @Override
    public void show() {
        scoreText = new Label("Score: \n" + new DecimalFormat("#").format(score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreText.setAlignment(Align.center);
    }

    @Override
    public void render(float delta) {

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
            scoreText.setFontScale(scoreScale, scoreScale);

            scoreText.setX((Assets.screenSizeWidth/2)-(scoreText.getWidth()*scoreScale/2));
            scoreText.setY((Assets.screenSizeHeight/2)-(scoreText.getHeight()*scoreScale/2));
            scoreText.draw(game.batch, 1f);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
