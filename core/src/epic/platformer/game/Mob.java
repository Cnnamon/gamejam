package epic.platformer.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by god on 15.1.23.
 */
public abstract class Mob extends Rectangle{
    protected Texture icon;
    protected boolean inAir;
    protected float yForce;

    public Mob(float width, float height, Texture icon){
        this.icon = icon;
        this.width = width;
        this.height = height;

        inAir = true;
        yForce = 0;
    }

    public Texture getIcon() {
        return icon;
    }

    public void update(float Delta){
        if(inAir){
            yForce -= 0.2;
            y += yForce * Delta;
        }
    }
}