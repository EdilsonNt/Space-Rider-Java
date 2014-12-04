package spaceRider.Enum;

public enum SREnemiesFile {
	ENEMY_1("res/SREnemy1.gif"),
	ENEMY_2("res/SREnemy2.gif"),
	ENEMY_3("res/SREnemy3.gif"),
	ENEMY_4("res/SREnemy4.gif"),
	ENEMY_5("res/SREnemy5.gif"),
	ENEMY_6("res/SREnemy6.gif"),
	ENEMY_7("res/SREnemy7.gif"),
	ENEMY_8("res/SREnemy8.gif"),
	ENEMY_9("res/SREnemy9.gif"),
	ENEMY_10("res/SREnemy10.gif"),
	ENEMY_11("res/SREnemy11.gif"),
	ENEMY_12("res/SREnemy12.gif");
	
	private final String src;
	
	private SREnemiesFile(final String text) {
		this.src = text;
	}
	public String getSrc() {
		return src;
	}
}
