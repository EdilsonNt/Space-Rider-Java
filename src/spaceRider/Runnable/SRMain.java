package spaceRider.Runnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

import spaceRider.Enum.SRScreenPosition;
import spaceRider.GameEnvironment.SRPlayField;

@SuppressWarnings("serial")
public class SRMain extends JFrame {

	public SRMain() {
		//add(new SRPlayField());
		setTitle( "Space Rider");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		validate();
	}
	
	public static void main(String[] args) {
		new SRMain();
		
		List<SRScreenPosition> screenPositions = new ArrayList<>(Arrays.asList(SRScreenPosition.values()));
		for (int i = 0; i < screenPositions.size(); i++) {
			Collections.shuffle(screenPositions);
			System.out.println(i + "-----" + screenPositions.get(i));
		}
	}
}
