package epic.platformer.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.Animation;

/**
 * Created by laurynas on 2015.01.25.
 */
public class Bat extends Mob {

    protected float speed = 2;


    public com.badlogic.gdx.graphics.g2d.Animation anim;
    private TextureAtlas atlas;
    public float elapsedTime = 0;

    public Bat(int x, int y, float width, float height, Texture icon) {
        super(x, y, width, height, icon);
        inAir = false;
        this.icon = Assets.batSprite;
        group = 3;

        atlas = new TextureAtlas();
        TextureRegion tempRegion = new TextureRegion(Assets.batSprite, 0, 0, 64, 43);
        atlas.addRegion("bat1", tempRegion);
        tempRegion = new TextureRegion(Assets.batSprite, 0, 44, 64, 43);
        atlas.addRegion("bat2", tempRegion);
        tempRegion = new TextureRegion(Assets.batSprite, 65, 0, 64, 43);
        atlas.addRegion("bat3", tempRegion);
        anim = new Animation(0.05f, atlas.getRegions(), Animation.PlayMode.LOOP_PINGPONG);

    }

    @Override
    public void update(float Delta) {
        super.update(Delta);
        Vector2 playerPos = new Vector2(Engine.player.getX()+Engine.player.getWidth()/2, Engine.player.getY()+Engine.player.getHeight()/2);
        Vector2 moveDirection = playerPos.sub(getX()+getWidth()/2, getY()+getHeight()/2);
        moveDirection.limit(speed);

        x += moveDirection.x;
        y += moveDirection.y;
    }
}
