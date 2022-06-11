package character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import main.GamePanel;

public class GreenSlime extends Character{
	public int ActionCounter;
	int cooldown;
	boolean activated = false;
	public GreenSlime(GamePanel gp) {
		super(gp);
		this.name = "Green Slime";
		direction = "down";
		speed = 1;
		lv = 15;
		MaxHP = 5;
		HP = MaxHP;
		/*
		collisionBox = new Rectangle();
		collisionBox.x = 3;
		collisionBox.y = 16;
		collisionDefaultX = collisionBox.x;
		collisionDefaultY = collisionBox.y;
		collisionBox.width = 42;
		collisionBox.height = 24;
		*/
		graphic.getImage("/monster","slime");	

	}
	public void setAction() {
		ActionCounter++;
		if(ActionCounter == 60) {
			ActionCounter = 0;
			Random random = new Random();
			int i = random.nextInt(100)+1;// get a number from 1 to 100
			if(i <= 25) {
				direction = "down";
			}
			if(i > 25 && i <= 50) {
				direction = "up";
			}
			if(i > 50 && i <= 75) {
				direction = "left";
			}
			if(i > 75 && i <= 100) {
				direction = "right";
			}
		}	
	}
	public void contact(character.Character c) {
		if(activated == false) {
			c.HP --;
			activated = true;
		}
	}
	public void update() {
		if(activated == true) {
			cooldown++;
			if(cooldown == 60) {
				activated = false;
				cooldown = 0;
			}
		}
		setAction();
		gp.Colchecker.checkTile(this);
		gp.Colchecker.checkPlayer(this);
		graphic.updateDirection(this, 20,2);
	}
	public void draw(Graphics2D g2) {
		//int screenX = worldX - gp.player.worldX + gp.player.screenX;
		//int screenY = worldY - gp.player.worldY + gp.player.screenY;
		graphic.drawCharacter(this, g2,gp);
		graphic.drawName(this, g2, name, gp, 18,Color.WHITE);
		graphic.drawLv(this, g2, lv, gp);
		//graphic.drawCollision(g2, screenX+collisionBox.x, screenY+collisionBox.y, collisionBox.width,collisionBox.height);
	}

}
