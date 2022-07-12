package character;

import java.awt.Color;
import java.awt.Graphics2D;
import main.GamePanel;

public class spider extends Monster{

	public spider(GamePanel gp) {
		super(gp);
		MaxHP = 25;
		HP = 25;
		name = "spider";
		lv = 2;
		direction = "down";
		speed = 1;
		
		graphic.getImageMonster("spider");
	}
} 
