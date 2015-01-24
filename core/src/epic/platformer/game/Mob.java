package epic.platformer.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by god on 15.1.23.
 */
public abstract class Mob extends Rectangle{
    protected Sprite icon;
    protected boolean inAir;
    protected float yForce;

    public Mob(int x, int y, float width, float height, Sprite icon){
        this.icon = icon;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        inAir = true;
        yForce = 0;
    }

    public Sprite getIcon() {
        return icon;
    }

    public void update(float Delta){
        if(inAir){
            yForce -= 0.6;
            y += yForce * Delta;
        }
        if(Assets.world[(int)x][(int)y] == 1){
            inAir = false;
            y -= yForce*Delta;
            yForce = 0;
        }
    }
}