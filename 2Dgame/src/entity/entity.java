package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class entity {
public int worldX,worldY;// two kinds of x and y are needed so that the character is always at the center of the screen
public int speed;

public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
public String direction;
// These two varaibles are needed in order to make the character look like hes walking
public int spriteCounter = 0;
public int spriteNum = 1;
; // we can create an abstract rectangle and store its area
public Rectangle solidArea; 
public int solidAreaDefaultX, solidAreaDefaultY;
public boolean collisionOn = false;



}
