package arjungame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
 // SCREEN SETTINGS
	final int originalTileSize = 16; // 16X16 tile that will be used for characters and other aspects of the game
	final int scale = 3;// variable is needed to scale up the tile size 
	
	public final int tileSize = originalTileSize * scale;// confirms the now scaled tile scale makes it 48X48 ALSO varaible needs to be public in order to interact with other classes
	// sets the size of the game screen for 16 by 12
	public int maxScreenCol = 16;// 16 tiles vertically
	public int maxScreenRow = 12;// 12 tiles horizontally
	public int screenWidth = tileSize * maxScreenCol;// 768 pixels
	public int screenHeight = tileSize * maxScreenRow;// 576 pixels
	
	//World settings
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	
	
	
	
	
	int FPS = 60;// Sets the frame per seconds to 60(game will run at this pace)
	
	TileManager tileM = new TileManager(this);
	
	KeyHandler keyH = new KeyHandler();
	Sound music = new Sound();
	Sound se = new Sound();
	
	
	
	// Initalizes player class from entity package onto the game panel
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	
	public Player player = new Player(this, keyH);
	public SuperObject obj[] = new SuperObject[40]; // can display upto 10 objects at the same time

	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));// sets the size of the game panel
		this.setBackground(new Color(128, 170, 44)); //
		this.setDoubleBuffered(true); // helps better render the game
		this.addKeyListener(keyH);// game panel recognizers key input
		this.setFocusable(true);//game apnel is focused to recive the key imput meaning is will actively look for key input
	}
	public void setupGame() {
		aSetter.setObject();
		playMusic(0);
	}
	//public void resetGame() {
	//	aSetter.setObject();
	//	playMusic(0);
	//}

	public void startGameThread() {
		gameThread = new Thread(this);// passing gamepanel class to this constrouctor
		gameThread.start();// calls run method
	}
	@Override
	public void run() {// game loop which is the core of the game
		double drawInterval = 1000000000/FPS;// draws the screen every 0.016 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;// current time plus the draw interval
		
		
		while(gameThread != null) {// as long is game thread exists it repeats process
			
			long currentTime = System.nanoTime(); //this part is needed to check the time since the computer updates so quick 
			
			
			
			//System.out.println("The game loop is Running");
			
			// Two main things done within this class
			// Update information about character postion and 2
			update();
			//: draw the screen with the updated information
			repaint();
			

			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;// accpets the remaining time as milliseconds
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long)remainingTime);// pauses the game loop and wont do anything till the sleep time is over
				nextDrawTime += drawInterval;// next drawtime will be 0.16 seconds 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	public void update() {
		player.update(); // calls on the player method to update whats happenging
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		// can draw stuff using graphic 2d
		Graphics2D g2 = (Graphics2D)g; 
		tileM.draw(g2);
		
		
		//object 
		for(int i =0; i<obj.length;i++) {// scans the super object one by one from the array
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		player.draw(g2);
		
		// UI 
		ui.draw(g2);
	// first draws tiles then the player (works like a layer, if the tiles are behind player you wont be able to see the player 	
		// calls on the same way as in update
		g2.dispose(); // gets rid of graphics context to save memory
		
	}
	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	public void stopMusic(){
		music.stop();
	}
	public void playSE(int i ) {
		se.setFile(i);
		se.play();// we dont need to loop
	}
}
