package Project;

import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
 
public class blowAndHit extends JFrame{
	
	public static void main(String[] args) {
	EventQueue.invokeLater(()->{
		JFrame frame = new MainFrame();
		frame.setTitle("Hit & Blow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	});
	}
}