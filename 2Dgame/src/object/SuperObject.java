package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import arjungame.GamePanel;

public class SuperObject {// parent class of all object classes that will be created
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0,0,48,48);// used the default value of the tiles 
	// can also select diffrent solid areas for different objects like key 
	
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	public void draw(Graphics2D g2, GamePanel gp) {
		int screenX = worldX - gp.player.worldX + gp.player.screenX;// kinda of confused as to why we need this
		int screenY = worldY - gp.player.worldY + gp.player.screenY;// kinda of confused too
		// only prints the tiles as long as its in the given boundary
		if(worldX  + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX -gp.tileSize < gp.player.worldX + gp.player.screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY + gp.tileSize < gp.player.worldY + gp.player.screenY) {
			g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);		
		}
	}
}
