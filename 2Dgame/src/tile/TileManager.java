package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;


import arjungame.GamePanel;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];// will store all the numbers from the 
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[30];//limit number of tiles used in game
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];// this stores the numbers from the text file
		getTileImage(); // calls method
		loadMap("/maps/text.txt");
	}
	public void getTileImage() {
		try {

			tile[00] = new Tile();
			tile[00].image = ImageIO.read(getClass().getResourceAsStream("/tiles/TREE (2).png"));
			tile[00].collision = true;
			
			tile[01] = new Tile();
			tile[01].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Path.png"));
			
			tile[02] = new Tile();
			tile[02].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water.png"));
			tile[02].collision = true; // makes it so the player dosent go into the tile
			
			tile[03] = new Tile();
			tile[03].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Rocks.png"));
			tile[03].collision = true;
			
			tile[04] = new Tile();
			tile[04].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tree (1).png"));
			tile[04].collision = true;
			
			tile[05] = new Tile();
			tile[05].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Mushrooms (1).png"));
			tile[05].collision = true;

			// Tiles for town hall
			tile[06] = new Tile();
			tile[06].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Window.png"));
			tile[06].collision = true;
			
			tile[07] = new Tile();
			tile[07].image = ImageIO.read(getClass().getResourceAsStream("/tiles/TopRight.png"));
			tile[07].collision = true;
			
			tile[18] = new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/BottomRight.png"));
			tile[18].collision = true;
			
			tile[19] = new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/MidBottom (1).png"));
			tile[19].collision = true;
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Mid (1).png"));
			tile[10].collision = true;
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/BottomLeft (1).png"));
			tile[11].collision = true;
			
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/TopLeft (1) (1).png"));
			tile[12].collision = true;
			
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/SideMid.png"));
			tile[13].collision = true;
			
			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/BrickL (1).png"));
			tile[14].collision = true;
			
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/BrickD (3).png"));
			tile[15].collision = true;
			


			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[16].collision = true;
			

			tile[17] = new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
		
			
		
	
			
			
		}
		catch(IOException e){
			e.printStackTrace();
			getTileImage();
		}
	}
	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);// used this to import the text file
			BufferedReader br = new BufferedReader(new InputStreamReader(is));// buffered reader reads the contents of text file 
			
			int col = 0;
			int row =0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();// read a single line within the text file 
				while(col <gp.maxWorldCol) {
					String numbers[] = line.split(" ");// splits the string at the space
					;
					int num = Integer.parseInt(numbers[col]);// changes value from string to integer
					
					mapTileNum[col][row] = num;// stores the extrated number in the 2d array
					col++;
					
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
				
			}
			br.close();
			
		}
		catch(Exception e) {
			
		}
	}
	
	// method needed in order to draw tiles
	public void draw(Graphics2D g2) {
		// local variables 
		int worldCol = 0;
		int worldRow = 0;
	
		while(worldCol < gp.maxWorldCol && worldRow< gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			// only prints the tiles as long as its in the given boundary
			if(worldX  + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX -gp.tileSize < gp.player.worldX + gp.player.screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY + gp.tileSize < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);		
			}
			g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);	
				
			worldCol++;	
			
			
			if(worldCol == gp.maxWorldCol) {// if the colum reaches the max size for the amount of collums, it restes so that it dosent draw over
				worldCol = 0;
				
				worldRow++;
				
				
			}
			
		}
		
	}
}
