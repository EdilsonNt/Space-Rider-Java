package spaceRider.Elements;

public class SREnemy extends SRSpaceShip {

	private static final String ENEMY_1 = "res/SREnemy1.gif";
	
	public SREnemy() {
		super(ENEMY_1, 37, 0);
	}
	
	@Override
	public void run() {
		while(isVisible()){
			
		}
	}
}
