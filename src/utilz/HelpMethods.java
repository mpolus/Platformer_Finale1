package utilz;

import static utilz.Constants.ObjectConstants.*;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.Crabby;
import main.Game;
import objects.GameContainer;
import objects.Potion;
import objects.Projectile;
import objects.Spike;

public class HelpMethods {

    public static boolean IsTileSolid(int xTile, int yTile, int[][] lvlData) {
        int value = lvlData[yTile][xTile];
        if (value >= 48 || value < 0 || value != 11){
            return true;
        }else{
            return false;
        }
    }

    private static boolean IsSolid(float x, float y, int[][] lvlData) {
        int maxWidth = lvlData[0].length * Game.TILES_SIZE;
        // TODO check if x is less than 0 or x is greater than or equal to maxWidth.
        // TODO: (cont.) if the condition is true return true
        // TODO: check if y is less than 0 or y is greater than or equal to Game.GAME_HEIGHT
        // TODO: (cont.) if the condition is true return true

        float xIndex = x / Game.TILES_SIZE;
        float yIndex = y / Game.TILES_SIZE;

        int xTile = (int) xIndex;
        int yTile = (int) yIndex;

        return IsTileSolid(xTile, yTile, lvlData);
    }

    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
        // TODO: This checks if the four corners of something is able to move.
        // TODO: we will need 4 booleans first.  Initialize them all to false.
        boolean bottomLeftGood = false;
        boolean topRightGood = false;
        boolean bottomRightGood = false;
        boolean topLeftGood = false;

        topLeftGood = !IsSolid(x, y, lvlData);
        topRightGood = !IsSolid(x + width, y, lvlData);
        bottomRightGood = !IsSolid(x + width, y + height, lvlData);
        bottomLeftGood = !IsSolid(x, y + height, lvlData);

        return bottomLeftGood && topRightGood && bottomRightGood && topLeftGood;
    }


    public static boolean IsProjectileHittingLevel(Projectile p, int[][] lvlData) {
        float hitboxCenterX = (p.getHitbox().x + p.getHitbox().width) / 2;
        float hitboxCenterY = (p.getHitbox().y + p.getHitbox().height) / 2;
        return IsSolid(
                hitboxCenterX,
                hitboxCenterY,
                lvlData);
    }


    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) {
        int currentTile = (int) (hitbox.x / Game.TILES_SIZE);
        // TODO: check if xSpeed is positive.  (This is the Right)
        // TODO: (cont.) if the condition is true do the following
        // TODO: (cont.) create an int named tileXPos and set to currentTile * Game.TILES_SIZE
        // TODO: (cont.) create an int named xOffset and set to (int)(Game.TILES_SIZE - hitbox.width
        // TODO: (cont.) return tileXPos + xOffset - 1
        // TODO: else return currentTile * GAME.TILES_SIZE  (This is the Left)
    }

    public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
        // TODO: create an int named currentTile and set to (int) (hitbox.y / Game.TILES_SIZE)
        // TODO: check if airSpeed is positive.  (This is the Falling - touching floor)
        // TODO: (cont.) if the condition is true do the following
        // TODO: (cont.) create an int named tileYPos and set to currentTile * Game.TILES_SIZE
        // TODO: (cont.) create an int named yOffset and set to (int)(Game.TILES_SIZE - hitbox.height
        // TODO: (cont.) return tileXPos + yOffset - 1
        // TODO: else return currentTile * GAME.TILES_SIZE  (This is Jumping)
    }

    public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {
        // TODO: if !IsSolid(hitbox.x, hitbox.y + hitbox.height +1, lvlData then
        // TODO: if !IsSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData then
        // TODO: return false
        return true;
    }

    public static boolean IsFloor(Rectangle2D.Float hitbox, float xSpeed, int[][] lvlData) {
        // TODO: if xSpeed is greater than 0 then
        // TODO: return IsSolid(hitbox.x + hitbox.width + xSpeed, hitbox.y + hitbox.height + 1, lvlData);
        // TODO: else
        // TODO: return IsSolid(hitbox.x + xSpeed, hitbox.y + hitbox.height + 1, lvlData);
    }

    public static boolean CanCannonSeePlayer(int[][] lvlData, Rectangle2D.Float firstHitbox, Rectangle2D.Float secondHitbox, int yTile) {
        // TODO: create an int named firstXTile and set to (int) (firstHitbox.x / Game.TILES_SIZE)
        // TODO: repeat for secondXTile in appropriate fashion using the secondHitbox

        // TODO: if firstXTile is greater than secondXTile then
        // TODO: return IsAllTilesClear(secondXTile, firstXTile, yTile, lvlData)
        // TODO: else
        // TODO: return IsAllTilesClear(firstXTile, secondXTile, yTile, lvlData)
    }

    public static boolean IsAllTilesClear(int xStart, int xEnd, int y, int[][] lvlData) {
        // TODO: for int i starting at 0 and ending before xEnd - xStart, adding 1 to i each iteration
        // TODO: check if IsTileSolid with xStart +i, y, and lvlData then
        // TODO: return false
        return true;
    }

    public static boolean IsAllTilesWalkable(int xStart, int xEnd, int y, int[][] lvlData) {
        if(IsAllTilesClear(xStart, xEnd, y, lvlData)){
            // TODO: for int i starting at 0 ending before xEnd - xStart, incrementing by 1 each time then
            // TODO: return false
        }
        return true;
    }

    public static boolean IsSightClear(int[][] lvlData, Rectangle2D.Float firstHitbox, Rectangle2D.Float secondHitbox, int yTile) {
        // TODO: create an int named firstXTile and set to (int) (firstHitbox.x / Game.TILES_SIZE)
        // TODO: repeat for secondXTile in appropriate fashion using the secondHitbox

        // TODO: if firstXTile is greater than secondXTile then
        // TODO: return IsAllTilesWalkable(secondXTile, firstXTile, yTile, lvlData)
        // TODO: else
        // TODO: return IsAllTilesWalkable(firstXTile, secondXTile, yTile, lvlData)
    }

    public static int[][] GetLevelData(BufferedImage img) {
        int[][] lvlData = new int[img.getHeight()][img.getWidth()];
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getRed();
                if (value >= 48)
                    value = 0;
                lvlData[j][i] = value;
            }
        return lvlData;
    }

    public static ArrayList<Crabby> GetCrabs(BufferedImage img) {
        // TODO: create an ArrayList of Crabby named list and instantiate to a new ArrayList<>()
        // TODO: for int j starting at 0 ending before img.getHeight() adding 1 each time then
        // TODO: for int i starting at 0 ending before img.getWidth() adding 1 each time then
        // TODO: create a Color named color and get from new Color(img.getRGB(i, j));
        // TODO: create an int named value and get from color.getGreen();
        // TODO: if (value == CRABBY) then
        // TODO: call list.add passing in a new Crabby(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
        // TODO: end of both for loops
        return list;
    }

    public static Point GetPlayerSpawn(BufferedImage img) {
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == 100)
                    return new Point(i * Game.TILES_SIZE, j * Game.TILES_SIZE);
            }
        return new Point(1 * Game.TILES_SIZE, 1 * Game.TILES_SIZE);
    }

    public static ArrayList<Potion> GetPotions(BufferedImage img) {
        ArrayList<Potion> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getBlue();
                if (value == RED_POTION || value == BLUE_POTION)
                    list.add(new Potion(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
            }

        return list;
    }

    public static ArrayList<GameContainer> GetContainers(BufferedImage img) {
        ArrayList<GameContainer> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getBlue();
                if (value == BOX || value == BARREL)
                    list.add(new GameContainer(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
            }

        return list;
    }

    public static ArrayList<Spike> GetSpikes(BufferedImage img) {
        // TODO: create an ArrayList of Spike named list and instantiate to a new ArrayList<>()
        // TODO: for int j starting at 0 ending before img.getHeight() adding 1 each time then
        // TODO: for int i starting at 0 ending before img.getWidth() adding 1 each time then
        // TODO: create a Color named color and get from new Color(img.getRGB(i, j));
        // TODO: create an int named value and get from color.getBlue();
        // TODO: if (value == SPIKE) then
        // TODO: call list.add passing in a new Spike(i * Game.TILES_SIZE, j * Game.TILES_SIZE, SPIKE));
        // TODO: end of both for loops
    }

    public static ArrayList<Cannon> GetCannons(BufferedImage img) {
        // TODO: create an ArrayList of Cannon named list and instantiate to a new ArrayList<>()
        // TODO: for int j starting at 0 ending before img.getHeight() adding 1 each time then
        // TODO: for int i starting at 0 ending before img.getWidth() adding 1 each time then
        // TODO: create a Color named color and get from new Color(img.getRGB(i, j));
        // TODO: create an int named value and get from color.getBlue();
        // TODO: if (value == CANNON_LEFT || value == CANNON_RIGHT) then
        // TODO: call list.add passing in a new Cannon(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
        // TODO: end of both for loops
    }

}