package spaceRider.Runnable;

import javax.swing.JFrame;

import spaceRider.GameEnvironment.SRPlayField;

@SuppressWarnings("serial")
public class SRMain extends JFrame {

	public SRMain() {
		add(new SRPlayField());
		setTitle( "Space Rider");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		//validate();
	}
	
	public static void main(String[] args) {
		new SRMain();
	}
}
