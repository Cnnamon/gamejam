package epic.platformer.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by laurynas on 2015.01.25.
 */
public class Bat extends Mob {

    protected float speed = 2;

    public Bat(int x, int y, float width, float height, Texture icon) {
        super(x, y, width, height, icon);
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
