package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import epic.platformer.game.Assets;
import epic.platformer.game.GameScreen;
import epic.platformer.game.Platformer;


/**
 * Created by d.vilimas on 2015.01.24.
 */
public class GameOverScreen implements Screen {

    Platformer game;
    Stage stage;

    public boolean doSomeRenderingToAnothaWindow = false;

    ClickListener playButtonClickListener;


    OrthographicCamera camera;

    Label playButton;
    float playButtonScale = 5;

    public GameOverScreen(Platformer game) {
        this.game = game;
    };

    //test
    @Override
    public void show() {
        playButton = new Label("Game Over", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        stage = new Stage();
        camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Assets.screenSizeWidth, Assets.screenSizeHeight);
        stage.getViewport().setCamera(camera);
        Gdx.input.setInputProcessor(stage);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                doSomeRenderingToAnothaWindow = true;
            }
        }, 2);
    }

    @Override
    public void render(float delta) {


        Gdx.graphics.getGL20().glClearColor( 0, 0, 0, 1 );
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );


        if((Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) || (Gdx.input.isButtonPressed(Input.Buttons.RIGHT) || Gdx.input.isButtonPressed(Input.Buttons.RIGHT))) && doSomeRenderingToAnothaWindow) {
            game.setScreen(new MenuScreen(game));
        }



        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
//        game.batch.draw(Assets.textureBack, 0, 0);
//            playButton.setFontScale(playButtonScale);
        playButton.setPosition((float) Assets.screenSizeWidth/2-(float)playButton.getWidth()/2, (float)Assets.screenSizeHeight/2-(float)playButton.getHeight()/2);
        playButton.draw(game.batch, 1f);

        game.batch.end();
        stage.draw();
        stage.act(delta);
        camera.update();
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
        stage.dispose();
    }
}
