package gamestates;

import main.Game;
import ui.MenuButton;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu extends State implements Statemethods {

    private MenuButton[] buttons = new MenuButton[3];
    private BufferedImage backgroundImg, backgroundImgPink;
    private int menuX, menuY, menuWidth, menuHeight;

    public Menu(Game game) {
        super(game);
        // TODO: call loadButtons()
        // TODO: call loadBackground()
        // TODO: setbackgroundImgPink to LoadSave.GetSpriteAtlas() passing in LoadSave.MENU_BACKGROUND_IMG
    }

    private void loadBackground() {
        // TODO: set backgroundImg to LoadSave.GetSpriteAtlas() passing in LoadSave.MENU_BACKGROUND
        // TODO: set menuWidth to (int) (backgroundImg.getWidth() * Game.SCALE
        // TODO: same for menuHeight setting it to (int)(backgroundImg.getHeight() * Game.SCALE
        // TODO: set menuX to Game.GAME_WIDTH / 2 - menuWidth / 2
        // TODO: set menuY to (int) (45 * Game.SCALE)
    }

    private void loadButtons() {
        // TODO: set buttons[0] to new MenuButton() passing in Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0, GameState.PLAYING
        // TODO: set buttons[1] to new MenuButton() passing in Game.GAME_WIDTH / 2, (int) (220 * Game.SCALE), 1, Gamestate.OPTIONS
        // TODO: set buttons[2] to new MenuButton() passing in Game.GAME_WIDTH / 2, (int) (290 * Game.SCALE), 2, Gamestate.QUIT
    }

    @Override
    public void update() {
        // TODO: for MenuButton mb in buttons
        // for block start
        // TODO: call mb.update()
    }

    @Override
    public void draw(Graphics g) {
        // TODO: call g.drawImage() passing in backgroundImgPin, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null
        // TODO: call g.drawImage() passing in backgroundImg, menuX, menuY, menuWidth, menuHeight, null
        // TODO: for MenuButton mb in buttons
        // for block start
        // TODO: call mb.draw() passing in g
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO: nothing here.  Method must exist
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO: for MenuButton mb in buttons
        // for block start
        // TODO: check if isIn() passing in e, mb
        // if statement block start
        // TODO: call mb.setMousePressed() passing in true
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO: for MenuButton mb in buttons
        // for block start
        // TODO: check if isIn() passing in e, mb
        // if statement start
        // TODO: check if mb.isMousePressed()
        // if statement start
        // TODO: call mb.applyGameState()
        // end of if
        // TODO: check if mb.getState() is equal to Gamestate.PLAYING
        // if statement start
        // TODO: call game.getAudioPlayer().setLevelSong() passing in game.getPlaying().getLevelManager.getLevelIndex()
        // end of if
        // TODO: break
        // end of if
        // end of for
        // TODO: call resetButtons()
    }

    private void resetButtons() {
        // TODO: for MenuButton mb in buttons
        // for block start
        // TODO: call mb.resetBools()

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO: for MenuButton mb in buttons
        // for block start
        // TODO: call mb.setMouseOver() passing in false
        // for block end
        // TODO: for Menubutton mb in buttons
        // for block start
        // TODO: check if isIn() passing in e, mb
        // if statement block start
        // TODO: call mb.setMouseOver() passing in true
        // TODO: break;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO: nothing here.  Method must exist
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO: nothing here.  Method must exist
    }

}