package epic.platformer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by laurynas on 2015.01.25.
 */
public class Sounds {
    private static Sound jump = Gdx.audio.newSound(Gdx.files.internal("jump.wav"));
    private static Sound hitTop = Gdx.audio.newSound(Gdx.files.internal("hit_top.wav"));
    private static Sound select = Gdx.audio.newSound(Gdx.files.internal("select.wav"));


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
}
