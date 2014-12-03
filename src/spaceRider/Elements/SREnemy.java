package spaceRider.Elements;

public class SREnemy extends SRSpaceShip {

	private static final String ENEMY_1 = "res/SREnemy1.gif";
	
	public SREnemy(String local, int x, int y, boolean isThread) {
		super(local, x, y, isThread);
	}
	
	@Override
	public void run() {
		while(isVisible()){
			
		}
	}
}
