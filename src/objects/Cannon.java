package objects;

public class Cannon extends GameObject {

    public Cannon(int x, int y, int objType) {
        super(x, y, objType);
        tileY = y / Game.TILES_SIZE;
        initHitbox(40, 26);
        hitbox.x -= (int)(4 * Game.SCALE);
        hitbox.y += (int)(6 * Game.SCALE);
    }

    public void update(){
        // TODO: check if doAnimation is true and if so updateAnimationTick()
    }

    public int getTileY() {
        return tileY;
        // TODO: return tileY
    }
}