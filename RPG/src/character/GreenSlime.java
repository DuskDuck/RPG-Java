package character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import main.GamePanel;

public class GreenSlime extends Character{
	public int ActionCounter;
	int AnimCounter;
	int cooldown;
	boolean activated = false;
	boolean hpbarOn;
	int hpbartimer;
	int OnmapIndex;
	boolean death = false;
	public GreenSlime(GamePanel gp) {
		super(gp);
		this.name = "Green Slime";
		direction = "down";
		speed = 1;
		lv = 15;
		MaxHP = 40;
		HP = MaxHP;
		ATK = 10;
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
			c.HP -= ATK - c.DEF ;
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

		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		if(HP > 0) {
			graphic.drawCharacter(this, g2,gp);
			graphic.drawName(this, g2, name, gp, 22,Color.WHITE);
			graphic.drawLv(this, g2, lv, gp);
		}else {
			//Death Anim
			AnimCounter++;
			if(AnimCounter <= 5 ) {
				graphic.AnimFX(g2,1,screenX,screenY);			
			}
			if(AnimCounter > 5 && AnimCounter < 15) {
				graphic.AnimFX(g2,2,screenX,screenY);
				
			}
			if(AnimCounter >= 15 && AnimCounter < 20) {
				graphic.AnimFX(g2,3,screenX,screenY);
			}
			if(AnimCounter >= 20) {
				AnimCounter = 0;
				gp.npc[OnmapIndex] = null;
			}
		}
		if(hpbarOn == true) {
			hpbartimer ++;
			graphic.drawHP(g2, gp, this);
			if(hpbartimer > 600) {
				hpbartimer = 0;
				hpbarOn = false;
			}
		}
		//graphic.drawCollision(g2, screenX+collisionBox.x, screenY+collisionBox.y, collisionBox.width,collisionBox.height);
	}
	public void hitted(int dmg,int i) {
		HP -= dmg; 
		OnmapIndex = i;
		hpbarOn = true;
		direction = gp.player.direction;
		gp.ui.addMessage("-" + dmg);
		hpbartimer = 0;
		if(HP <= 0) {
			death = true;
			speed = 0;
		}
	}

}
