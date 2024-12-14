package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject {
	public OBJ_Chest() {
		name = "Chest";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));// replace once you have the key image
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
