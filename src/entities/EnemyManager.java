package entities;

import gamestates.Playing;
import levels.Level;
import utilz.LoadSave;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {

    private Playing playing;
    private BufferedImage[][] crabbyArr;
    private ArrayList<Crabby> crabbies = new ArrayList<>();

    public EnemyManager(Playing playing) {
        playing = this.playing;
        loadEnemyImgs();


    }

    public void loadEnemies(Level level) {
        crabbies = level.getCrabs();
    }

    public void update(int[][] lvlData, Player player) {
        // TODO: make a boolean named isAnyActive and assign false to it
        // TODO: for loop Crabby c : crabbies
        // for loop begin
        // TODO: check if c.isActive()
        // if begin
        // TODO: call c.update() passing in lvlData and player
        // TODO: assign true to isAnyActive
        // if end
        // for end
        // TODO: check if !isAnyActive
        // if begin
        // TODO: call playing.setLevelCompleted passing in true
        // if end
    }

    public void draw(Graphics g, int xLvlOffset) {
        drawCrabs(g, xLvlOffset);
    }

    private void drawCrabs(Graphics g, int xLvlOffset) {
        for (Crabby c : crabbies)
            if (c.isActive()) {

                g.drawImage(crabbyArr[c.getState()][c.getAniIndex()], (int) c.getHitbox().x - xLvlOffset - CRABBY_DRAWOFFSET_X + c.flipX(), (int) c.getHitbox().y - CRABBY_DRAWOFFSET_Y,
                        CRABBY_WIDTH * c.flipW(), CRABBY_HEIGHT, null);

				c.drawHitbox(g, xLvlOffset);
				c.drawAttackBox(g, xLvlOffset);
            }

    }

    public void checkEnemyHit(Rectangle2D.Float attackBox) {
        // TODO: for loop Crabby c : crabbies
        // for loop begin
        // TODO: check if c.isActive()
        // if begin
        // TODO: check if c.getCurrentHealth is greater than 0
        // if begin
        // TODO: check if attackBox.intersects(c.getHitbox())
        // if begin
        // TODO: call c.hurt() passing in 10
        // TODO: return
        // if end
        // if end
        // if end
        // for end
    }

    private void loadEnemyImgs() {
        // TODO: assign a new BufferedImage[5][9] to crabbyArr
        // TODO: create a BufferedImage called temp and assign LoadSave.GetSpriteAtlas() passing in LoadSave.CRABBY_SPRITE
        // TODO: for loop int j starting at 0, less than crabbyAr.length, add 1 each iteration
        // for loop begin
        // TODO: for loop int i starting at 0, less than crabby[j].length, add 1 each iteration
        // for loop begin
        // TODO: assign to crabbyArr[j][i] the value of temp.getSubimage(i * CRABBY_WIDTH_DEFAULT, j * CRABBY_HEIGHT_DEFAULT, CRABBY_WITH_DEFAULT, CRABBY_HEIGHT_DEFAULT)
        // for loop end
        // for loop end
    }

    public void resetAllEnemies() {
        for (Crabby c : crabbies) {
            c.resetEnemy();
        }

    }

}