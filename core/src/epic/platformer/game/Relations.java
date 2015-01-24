package epic.platformer.game;

/**
 * Created by laurynas on 2015.01.24.
 */

import java.util.HashMap;
import java.util.Map;

public class Relations {
    private static Map<Integer, Integer> collisionRelations = new HashMap<Integer, Integer>();

    public static boolean shouldCollide(int arg1, int arg2)
    {
        return collisionRelations.get(arg1) == arg2;
    }
    public static void addCollision(int arg1, int arg2)
    {
        collisionRelations.put(arg1, arg2);
    }
}
