package character;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;

public class flame extends Monster{
	
	public flame(GamePanel gp) {
		super(gp);
		MaxHP = 12;
		HP = 12;
		name = "flame";
		lv = 2; 
		direction = "down";
		speed = 1;
		
		graphic.getImageMonster("flame");
	}
}