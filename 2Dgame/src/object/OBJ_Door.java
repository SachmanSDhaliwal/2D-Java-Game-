package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject {
	public OBJ_Door() {
		name = "Door";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));// replace once you have the key image
		}
		catch(IOException e){
			e.printStackTrace();
		}
		collision=true;
	}
}
