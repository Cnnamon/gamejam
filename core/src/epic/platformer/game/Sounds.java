package epic.platformer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by laurynas on 2015.01.25.
 */
public class Sounds {
    private static Sound jump = Gdx.audio.newSound(Gdx.files.internal("jump.wav"));
    private static Sound hitTop = Gdx.audio.newSound(Gdx.files.internal("hit_top.wav"));
    private static Sound select = Gdx.audio.newSound(Gdx.files.internal("select.wav"));
    private static Sound menuMusic = Gdx.audio.newSound(Gdx.files.internal("01.wav"));
    private static Sound gameMusic = Gdx.audio.newSound(Gdx.files.internal("02.wav"));
    private static Sound hurt = Gdx.audio.newSound(Gdx.files.internal("hurt.wav"));


    public static void playJump()
    {
        jump.play();
    }
    public static void playHitTop()
    {
        hitTop.play();
    }
    public static void playSelect()
    {
        select.play();
    }
    public static void playHurt() { hurt.play(); }
    public static void playGameMusic() {
        gameMusic.stop();
        gameMusic.loop();
        gameMusic.play();
        menuMusic.stop();

    }
    public static void playMenuMusic() {
        menuMusic.stop();
        menuMusic.loop();
        menuMusic.play();
        gameMusic.stop();
    }
}
