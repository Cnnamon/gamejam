package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
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
    TextButton playTextButton;
    TextButton.TextButtonStyle playTextButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;

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

        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("mainButtons.pack"));
        skin.addRegions(buttonAtlas);
        playTextButtonStyle = new TextButton.TextButtonStyle();
        playTextButtonStyle.font = new BitmapFont();
        playTextButtonStyle.up = skin.getDrawable("Play");
        playTextButtonStyle.down = skin.getDrawable("PLayP");
        playTextButtonStyle.checked = skin.getDrawable("PLayP");
        playTextButton = new TextButton(null, playTextButtonStyle);
        stage.addActor(playTextButton);
//        stage.addActor(playButton);

        playTextButton.addListener(playButtonClickListener = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
                playTextButton.removeListener(playButtonClickListener);
                super.clicked(event, x, y);
            }
        });



        Sounds.playMenuMusic();

    }

    @Override
    public void render(float delta) {


        Gdx.graphics.getGL20().glClearColor( 1, 1, 1, 1 );
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

//        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
//            game.setScreen(new GameScreen(game));
//        }



        game.batch.setProjectionMatrix(camera.combined);

        stage.draw();
        game.batch.begin();
            game.batch.setColor(Color.WHITE);
//            game.batch.draw(Assets.textureBack, 0, 0);
//          playButton.setFontScale(playButtonScale);
            playTextButton.setPosition(Assets.screenSizeWidth/2-playTextButton.getWidth()/2, Assets.screenSizeHeight/2-playTextButton.getHeight()/2);
//            playButton.draw(game.batch, 1f);


//        font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
//        font.draw(game.batch, "my-string", 500, 500);
        game.batch.end();

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
