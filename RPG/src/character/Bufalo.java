package character;

import java.awt.Color;
import java.awt.Graphics2D;
import main.GamePanel;

public class Bufalo extends Monster{

	public Bufalo(GamePanel gp) {
		super(gp);
		MaxHP = 40;
		HP = 40;
		name = "Buffalo"; 
		lv = 2;
		direction = "down";
		speed = 1;
		
		graphic.getImageMonster("Bufalo");
	}
}
