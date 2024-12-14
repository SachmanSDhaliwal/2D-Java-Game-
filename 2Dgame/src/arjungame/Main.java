package arjungame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.color.*;


public class Main {
	public static String text;
	public static String records;

	public static void main(String[] args) {
	//System.out.println("Hello");	
		
	JFrame window = new JFrame();
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// allows user to exit the game
	window.setResizable(false);
	window.setTitle("AZUL'S VILLAGE TREASURE HUNT");// name of the game
	
	GamePanel gamePanel = new GamePanel();// adds gamepanel to window
	window.add(gamePanel);
	window.pack();// window is sized to fit the size of its subcompoents
	
	window.setLocationRelativeTo(null);// makes it so you cant change postioning of frame
	window.setVisible(true);
	gamePanel.setupGame();
	gamePanel.startGameThread();
	
	JFrame window2 = new JFrame();
    window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window2.setResizable(false);
    window2.setTitle("Records");
    window2.setSize(200, 200);
    window2.setVisible(true);

    JLabel text = new JLabel();

//    text.setText(records());
    text.setVisible(true);

    window2.add(text, BorderLayout.PAGE_START);
    
   
    
   // window2.getContentPane().setBackground(new Color(128, 170, 44));




}

  //  public static String records(int time, String r) {
    //    if(end game condition) {

      //  }

//}
}