package epic.platformer.game;

/**
 * Created by laurynas on 2015.01.24.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Relations {
    private static Map<Integer, ArrayList<Integer>> collisionRelations = new HashMap<Integer, ArrayList<Integer>>();

    public static boolean shouldCollide(int arg1, int arg2)
    {
        return collisionRelations.get(arg1).contains(arg2);
    }
    public static void addCollision(int arg1, int arg2)
    {
        if(!collisionRelations.containsKey(arg1))
        {
            collisionRelations.put(arg1, new ArrayList<Integer>());
        }
        collisionRelations.get(arg1).add(arg2);
    }
}
