package objects;

import java.awt.geom.Rectangle2D;

public class Projectile extends GameObject {
    private Rectangle2D.Float hitbox;
    private int dir;
    private boolean active = true;


    public Projectile(int x, int y, int dir) {
        xOffset = (int) (-3 * Game.SCALE);
        yOffset = (int) (5 * Game.SCALE);

        if(dir == 0){
            xOffset = (int)  (29 * Game.SCALE);
        }

        // TODO: set hitbox to new Rectangle2D.Float() passing in
        // x + xOffset, y + yOffset, CANNON_BALL_WIDTH, CANNON_BALL_HEIGHT
        // TODO: set this.dir to dir
    }

    public void updatePos(){
        // TODO: add dir * SPEED to hitbox.x
    }

    public void setPos(int x, int y){
        // TODO: do what this setter method should do
    }

    public Rectangle2D.Float getHitbox() {
        // TODO: return the hitbox
    }

    public void setActive(boolean active){
        // TODO: do what you think this should do
    }

    public boolean isActive(){
        // TODO: isActive
    }
}