package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
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
import com.badlogic.gdx.utils.Timer;
import epic.platformer.game.Assets;
import epic.platformer.game.GameScreen;
import epic.platformer.game.Platformer;

import java.text.DecimalFormat;


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

    Label scoreText;

    TextButton playTextButton;
    TextButton.TextButtonStyle playTextButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;


    public GameOverScreen(Platformer game, float score) {
        this.game = game;
        this.scoreText = new Label("Score: " + (new DecimalFormat("#").format(score)), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        game.prefs.putInteger("highscore", (int)Math.round(score));
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

        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("mainButtons.pack"));
        skin.addRegions(buttonAtlas);
        playTextButtonStyle = new TextButton.TextButtonStyle();
        playTextButtonStyle.font = new BitmapFont();
        playTextButtonStyle.up = skin.getDrawable("Back");
        playTextButtonStyle.down = skin.getDrawable("BakcP");
        playTextButtonStyle.checked = skin.getDrawable("BakcP");
        playTextButton = new TextButton(null, playTextButtonStyle);
        stage.addActor(playTextButton);

        playTextButton.addListener(playButtonClickListener = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
                playTextButton.removeListener(playButtonClickListener);
                super.clicked(event, x, y);
            }
        });

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                doSomeRenderingToAnothaWindow = true;
            }
        }, 1);
    }

    @Override
    public void render(float delta) {


        Gdx.graphics.getGL20().glClearColor( 0, 0, 0, 1 );
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );


//        if((Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) || (Gdx.input.isButtonPressed(Input.Buttons.LEFT) || Gdx.input.isButtonPressed(Input.Buttons.RIGHT))) && doSomeRenderingToAnothaWindow) {
//            game.setScreen(new MenuScreen(game));
//        }



        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        scoreText.setFontScale(5);
        scoreText.setPosition(Assets.screenSizeWidth/2 - scoreText.getWidth()/2*5, Assets.screenSizeHeight*2/10 - playButton.getHeight()*2/10*5);
        scoreText.draw(game.batch, 0.5f);

//        game.batch.draw(Assets.textureBack, 0, 0);
        playButton.setFontScale(5);
        playButton.setPosition(Assets.screenSizeWidth/2 - playButton.getWidth()/2*5, Assets.screenSizeHeight*8/10 - playButton.getHeight()*8/10*5);
        playButton.draw(game.batch, 1f);

//        game.font.setColor(1.0f, 0f, 1.0f, 1.0f);
//        game.font.draw(game.batch, "my-string", 0, 0);

        playTextButton.setPosition(Assets.screenSizeWidth/2-playTextButton.getWidth()/2, Assets.screenSizeHeight/2-playTextButton.getHeight()/2);

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
