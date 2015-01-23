package epic.platformer.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by god on 15.1.23.
 */
public class Mob extends Rectangle{
    private Texture icon;

    public Mob(float width, float height, Texture icon){
        this.icon = icon;
        this.width = width;
        this.height = height;
    }

    public Texture getIcon() {
        return icon;
    }
}