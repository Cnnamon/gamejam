package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
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
import epic.platformer.game.Assets;
import epic.platformer.game.GameScreen;
import epic.platformer.game.Platformer;
import epic.platformer.game.Sounds;


/**
 * Created by d.vilimas on 2015.01.24.
 */
public class MenuScreen implements Screen {

    Platformer game;
    Stage stage;

    ClickListener playButtonClickListener;


    OrthographicCamera camera;

    Label playButton;
    float playButtonScale = 5;

    public MenuScreen(Platformer game) {
        this.game = game;
    };

//test
    @Override
    public void show() {
        playButton = new Label("Play", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        stage = new Stage();
        camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Assets.screenSizeWidth, Assets.screenSizeHeight);
        stage.getViewport().setCamera(camera);
        Gdx.input.setInputProcessor(stage);
        playButton.addListener(playButtonClickListener = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
                playButton.removeListener(playButtonClickListener);
                super.clicked(event, x, y);
            }
        });

        stage.addActor(playButton);

        Sounds.playMenuMusic();

    }

    @Override
    public void render(float delta) {


//        Gdx.graphics.getGL20().glClearColor( 1, 0, 0, 1 );
//        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

//        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
//            game.setScreen(new GameScreen(game));
//        }



        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
            game.batch.draw(Assets.textureBack, 0, 0);
//            playButton.setFontScale(playButtonScale);
            playButton.setPosition((float) Assets.screenSizeWidth/2-(float)playButton.getWidth()*playButtonScale/2, (float)Assets.screenSizeHeight/2-(float)playButton.getHeight()*playButtonScale/2);
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
