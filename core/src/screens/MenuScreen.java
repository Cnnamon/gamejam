package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import epic.platformer.game.Platformer;

/**
 * Created by d.vilimas on 2015.01.24.
 */
public class MenuScreen implements Screen {

    Platformer game;

    Label playButton;

    public MenuScreen(Platformer game) {
        this.game = game;
    };

//test
    @Override
    public void show() {
        playButton = new Label("300", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    }

    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClearColor( 1, 1, 0, 1 );
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );


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
