package arjungame;

import object.OBJ_Strawberry;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_RStrawberry;

public class AssetSetter {
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
	}
	public void setObject() {
		// cooridnates of where the object is placed ( WE WILL HAVE TO CHANGE THIS TO WHERE WE WANT THE KEY TO GO)
		gp.obj[00] = new OBJ_Key();
		gp.obj[00].worldX = 24  * gp.tileSize;// these values SPECFICALLY NEED TO BE CHANGED 
		gp.obj[00].worldY = 35 * gp.tileSize;
		
		gp.obj[01] = new OBJ_Key();
		gp.obj[01].worldX = 34  * gp.tileSize;// these values SPECFICALLY NEED TO BE CHANGED 
		gp.obj[01].worldY = 6 * gp.tileSize;
		

		
		gp.obj[02] = new OBJ_Door();
		gp.obj[02].worldX = 8 * gp.tileSize;
		gp.obj[02].worldY = 6 * gp.tileSize;
		
		gp.obj[03] = new OBJ_Chest();
		gp.obj[03].worldX = 14 * gp.tileSize;
		gp.obj[03].worldY = 42 * gp.tileSize;
		// this is for powerups 
		gp.obj[04] = new OBJ_Strawberry();
		gp.obj[04].worldX = 11 * gp.tileSize;
		gp.obj[04].worldY = 44 * gp.tileSize;
		
		gp.obj[05] = new OBJ_Door();
		gp.obj[05].worldX = 34  * gp.tileSize;// these values SPECFICALLY NEED TO BE CHANGED 
		gp.obj[05].worldY = 15 * gp.tileSize;
	
		gp.obj[06] = new OBJ_Door();
		gp.obj[06].worldX =	38  * gp.tileSize;// these values SPECFICALLY NEED TO BE CHANGED 
		gp.obj[06].worldY = 24 * gp.tileSize;
	
		gp.obj[07] = new OBJ_Key();
		gp.obj[07].worldX = 43  * gp.tileSize;// these values SPECFICALLY NEED TO BE CHANGED 
		gp.obj[07].worldY = 48 * gp.tileSize;
	

		gp.obj[8] = new OBJ_Key();
		gp.obj[8].worldX = 24  * gp.tileSize;// these values SPECFICALLY NEED TO BE CHANGED 
		gp.obj[8].worldY = 10 * gp.tileSize;
		
		gp.obj[9] = new OBJ_RStrawberry();
		gp.obj[9].worldX = 24 * gp.tileSize;
		gp.obj[9].worldY = 15 * gp.tileSize;
		
		gp.obj[10] = new OBJ_Door();
		gp.obj[10].worldX = 17 * gp.tileSize;// these values SPECFICALLY NEED TO BE CHANGED 
		gp.obj[10].worldY = 44 * gp.tileSize;
		
		gp.obj[11] = new OBJ_Key();
		gp.obj[11].worldX = 1  * gp.tileSize;// these values SPECFICALLY NEED TO BE CHANGED 
		gp.obj[11].worldY = 1 * gp.tileSize;
		
		gp.obj[12] = new OBJ_Door();
		gp.obj[12].worldX = 14 * gp.tileSize;// these values SPECFICALLY NEED TO BE CHANGED 
		gp.obj[12].worldY = 37 * gp.tileSize;
		
		gp.obj[13] = new OBJ_Strawberry();
		gp.obj[13].worldX = 47  * gp.tileSize;// these values SPECFICALLY NEED TO BE CHANGED 
		gp.obj[13].worldY = 5 * gp.tileSize;

		
	}
	
	
}
