package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Strawberry extends SuperObject{
	public OBJ_Strawberry() {
		name = "Strawberry";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/SB.png"));// replace once you have the key image
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
