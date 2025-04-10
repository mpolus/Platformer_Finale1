package entities;

import static utilz.Constants.EnemyConstants.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import static utilz.Constants.Directions.*;

import main.Game;

public class Crabby extends Enemy {

    private int attackBoxOffsetX;

    public Crabby(float x, float y) {
        super(x, y, CRABBY_WIDTH, CRABBY_HEIGHT, CRABBY);
        initHitbox(22, 19);
        initAttackBox();

    }

    private void initAttackBox() {
        // TODO: assign a new Rectangle2D.Float() with arguments x, y, (int)(82 * Game.SCALE), (int)(19 * Game.SCALE) to attackBox
        // TODO: assign (int) (Game.SCALE * 30) to attackBoxOffsetX
    }

    public void update(int[][] lvlData, Player player) {
        updateBehavior(lvlData, player);
        updateAnimationTick();
        updateAttackBox();
        
    }

    private void updateAttackBox() {
        // TODO: assign hitbox.x - attackBoxOffsetX to attackBox.x
        // TODO: assign hitbox.y to attackBox.y
    }

    private void updateBehavior(int[][] lvlData, Player player) {
        // TODO: check if firstUpdate
        // if block begin
        // TODO: call firstUpdateCheck() passing in lvlData
        // end of if block
        // TODO: check if inAir
        // if block begin
        // TODO: call updateInAir() passing in lvlData
        // end of if block
        // else block begin
        switch (state) {
            case IDLE:
                newState(RUNNING);
                break;
            case RUNNING:
                if (canSeePlayer(lvlData, player)) {
                    turnTowardsPlayer(player);
                    if (isPlayerCloseForAttack(player))
                        newState(ATTACK);
                }

                move(lvlData);
                break;
            case ATTACK:
                if (aniIndex == 0)
                    attackChecked = false;
                if (aniIndex == 3 && !attackChecked)
                    checkPlayerHit(attackBox, player);
                break;
            case HIT:
                break;
        }
        // else block end
    }

    public int flipX() {
        // TODO: check if walkDir is equal to RIGHT
        // if block begin
        // TODO: return width;
        // end of if block
        // else block begin
        // TODO: return 0
        // else block end
        return 0; // TODO: temp value, remove when done.

    }

    public int flipW() {
        // TODO: check if walkDir is equal to RIGHT
        // if block begin
        // TODO: return -1;
        // end of if block
        // else block begin
        // TODO: return 1
        // else block end
        return 0; // TODO: temp value, remove when done.
    }
}