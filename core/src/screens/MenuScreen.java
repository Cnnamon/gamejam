package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import epic.platformer.game.Assets;
import epic.platformer.game.GameScreen;
import epic.platformer.game.Platformer;

/**
 * Created by d.vilimas on 2015.01.24.
 */
public class MenuScreen implements Screen {

    Platformer game;

    OrthographicCamera camera;

    Label playButton;
    float playButtonScale = 5;


    public MenuScreen(Platformer game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Assets.screenSizeWidth, Assets.screenSizeHeight);
    };

//test
    @Override
    public void show() {
        playButton = new Label("Press any key to play", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    }

    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClearColor( 0, 1, 0, 1 );
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new GameScreen(game));
        }

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
            playButton.setFontScale(playButtonScale);
            playButton.setPosition((float) Assets.screenSizeHeight/2-(float)playButton.getHeight()*playButtonScale/2, (float)Assets.screenSizeHeight/2-(float)playButton.getHeight()*playButtonScale/2);
            playButton.draw(game.batch, 1f);
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
