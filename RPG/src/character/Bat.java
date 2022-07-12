package character;

import main.GamePanel;

public class Bat extends Monster{

	public Bat(GamePanel gp) {
		super(gp);
		MaxHP = 20;
		HP = 20; 
		direction = "down";
		name = "Bat";
		lv = 2;
		speed = 1;
		
		graphic.getImageMonster("Bat");
	}
}
