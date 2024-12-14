package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import arjungame.GamePanel;
import arjungame.KeyHandler;

public class Player extends entity{
	GamePanel gp;
	KeyHandler keyH;
	// indicates where we draw player on screen
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;// indicates how many keys the player has
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		// returns halfway point of screen
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		solidArea = new Rectangle();
		// can find what we like controlls the players hitbox
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		setDefaultValues();// calls method below 
		getPlayerImage(); // calls method mentioned in name
	}
	// method sets the default values for the postion and speed of the player
	public void setDefaultValues() {
		worldX = gp.tileSize *24;
		worldY= gp.tileSize *21;
		speed = 4;
		direction = "down"; // any direction is fine(used as a place holder basically);
	}
	// This method gets the player image from the player folder in the res package
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/up 1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/up 2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down 1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down 2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left 1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left 2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right 1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/right 2.png"));
			
	}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	// these methods are copied from game panel class
	public void update() {
		// numbers work as a grid so that right and up is posative and opposite for down and left 
		// this if statement makes sure that the sprite counter only increases unless a key is pressed
				if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed) {
					if(keyH.upPressed == true) {
						direction = "up";// direction is change based on what key the user enters 
						
					}
					else if(keyH.downPressed == true) {
						direction = "down";
						
					}
					else if(keyH.leftPressed == true) {
						direction = "left";
						
					}
					else if(keyH.rightPressed == true) {
						direction = "right";
						
					}
					// Checks the tiles collision
					collisionOn = false;
					gp.cChecker.checkTile(this);
					
					//check object collision 
					int objIndex = gp.cChecker.checkObject(this,true);
					pickUpObject(objIndex);
					
					// if collision is false then the player can move 
					if(collisionOn == false) {
						switch(direction) {
						case "up" :
							worldY -= speed;
							break;
						case "down":
							worldY += speed;
							break;
						case "left" :
							worldX -= speed;
							break;
							
						case "right" :
							worldX += speed;
							break;
							 
							
						}
					}
					
					
					spriteCounter++;
					// player image changes every 10 frames as its updating at 60 frames per second
					if(spriteCounter >12) {
						if(spriteNum == 1) {
							spriteNum =2;
						}
						else if(spriteNum ==2) {
							spriteNum =1;
						}
						spriteCounter = 0;
					}	
				}
				
	}
	public void pickUpObject(int i) {
		if(i != 999) {// any number is fine tbh 
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key" :
				gp.playSE(1);
				hasKey++;
				gp.obj[i] = null;
				gp.ui.showMessage("YOU GOT A KEY!");
				break;
			case "Door":
				gp.playSE(3);
				if(hasKey > 0) {
					gp.obj[i] = null;
					hasKey --;
					gp.ui.showMessage("YOU OPENED THE DOOR!");
				}
				else {
					gp.ui.showMessage("YOU NEED A KEY TO OPEN THE DOOR!");
				}
				
				break;
			case "Chest":
				gp.ui.gameFinished = true;
				gp.stopMusic();
				gp.playSE(4);	
				break;
			case "Strawberry" :
				gp.playSE(2);
				speed += 2;// gives the player a speed boost can make faster by changing value 
				gp.obj[i] = null;// removes the object from the screen once picked up
				gp.ui.showMessage("SPEED POWER UP");
				break;
			case "RStrawberry" :
				gp.playSE(2);
				speed -= 2;
				gp.obj[i] = null;
				gp.ui.showMessage("SPEED DECREASED X2");
			}
			
			
			
			
		}
	}
	
	public void draw(Graphics2D g2) {
		//g2.setColor(Color.white);
		//g2.fillRect(x,y,gp.tileSize,gp.tileSize);// asks for x,y, width and height measurment
		// Switch is alot like if, its checking what the case is and updating the image to the images we made for the character
		BufferedImage image = null;
		switch(direction) {
			case "up":
				// the if statement within swtich statement allows for user to move based on the sprite int
				if(spriteNum ==1) {
					image = up1;
				}
				if(spriteNum ==2) {
					image = up2;
				}
				
				break;
			case "down":
				if(spriteNum == 1) {
				image = down1;
				}
				if(spriteNum == 2) {
				image = down2;
				}
				break;
			case "left" :
				if(spriteNum == 1) {
				image = left1;
				}
				if(spriteNum == 2) {
				image = left2;
				}
				break;
			case "right" :
				if(spriteNum == 1) {
				image = right1;
				}
				if(spriteNum == 2) {
				image = right2;
				}
				break;
		}
		// draw image draws the imaage based on the switch statement 
		g2.drawImage(image, screenX,screenY,gp.tileSize,gp.tileSize, null);
}
}
