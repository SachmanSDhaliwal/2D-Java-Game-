package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_RStrawberry extends SuperObject {
	public OBJ_RStrawberry() {
		name = "RStrawberry";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/bad.png"));// inputs the rotten strawberry
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
