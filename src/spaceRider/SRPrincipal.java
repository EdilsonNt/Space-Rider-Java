package spaceRider;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SRPrincipal extends JFrame {

	public SRPrincipal() {

		add(new SRFase());

		setTitle( "Space Rider");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		
		validate();

	}
	
	public static void main(String[] args) {
		new SRPrincipal();
		
	}
}
