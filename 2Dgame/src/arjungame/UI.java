package arjungame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {// This class handles all the on the screen messages 
	GamePanel gp;
	Font arial_40,arial_80B, MonoSpaced_35B;
	BufferedImage keyImage;
	
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;// varaible needed to set time on message 
	public boolean gameFinished = false;
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Monospaced",Font.BOLD,40);
		arial_80B = new Font("Monospaced",Font.BOLD,70);
		MonoSpaced_35B = new Font("Monospaced",Font.BOLD,35);
		OBJ_Key key = new OBJ_Key();
		keyImage = key.image;
		
		
	}
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	public void draw(Graphics2D g2) {
		if(gameFinished == true) { 
			 g2.setFont(arial_40);// sets the parameters of the font 
			 g2.setColor(Color.black);// sets the colour of the font to white
			String text;
			int textLength;
			int x;
			int y;
			text= "YOU FOUND THE TREASURE";
			textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();// returns length of string in a int value 
			 x = gp.screenWidth/2- textLength/2;
			 y = gp.screenHeight/2- (gp.tileSize*3);
			 g2.drawString(text, x, y);
			 
			 text= "YOUR TIME IS:" + dFormat.format(playTime) + "!";
				textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();// returns length of string in a int value 
				 x = gp.screenWidth/2- textLength/2;
				 y = gp.screenHeight/2+ (gp.tileSize*4);
				 g2.drawString(text, x, y);
			 
			 
			 
			 g2.setFont(arial_80B);// sets the parameters of the font 
			 g2.setColor(Color.white);// sets the colour of the font to white
			 text= "CONGRATS YOU WON!";
				textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();// returns length of string in a int value 
				 x = gp.screenWidth/2- textLength/2;
				 y = gp.screenHeight/2+ (gp.tileSize*2);
				 g2.drawString(text, x, y);
				 
				gp.gameThread =null;// stops the thread 
			
		}
		else { 
		g2.setFont(MonoSpaced_35B);// sets the parameters of the font 
		g2.setColor(Color.white);// sets the colour of the font to white
		g2.drawImage(keyImage,gp.tileSize/2, gp.tileSize/2, gp.tileSize/2, gp.tileSize/2,null);
		g2.drawString("x"+gp.player.hasKey,74,65);
		
		//TIME 
		playTime+=(double)1/60;// 
		g2.drawString("Time :"+dFormat.format(playTime),gp.tileSize*11,65);
		
		
		
	// message display
		if(messageOn == true) {
			g2.setFont(MonoSpaced_35B);
			g2.setColor(Color.white);
			g2.drawString(message,gp.tileSize/5,gp.tileSize*5 );// can choose varaibles later
			
			messageCounter++;
			if(messageCounter > 120) {// message dissapears after two seconds 
				messageCounter = 0;
				messageOn = false;
			}
			
		}
		
	
	}
	}
	
	
}
