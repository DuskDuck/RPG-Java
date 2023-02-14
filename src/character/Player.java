package character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyInput;
import main.Utility;

public class Player extends Character{

	KeyInput key;
	
	public final int screenX;
	public final int screenY;
	
	boolean right = true;
	int FrameCounter = 0;
	
	public Player(GamePanel gp, KeyInput key) {
		super(gp);
		
		this.gp = gp;
		this.key = key;
		
		//Middle of the screen
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		collisionBox = new Rectangle();
		collisionBox.x = 0;
		collisionBox.y = 16;
		collisionDefaultX = collisionBox.x;
		collisionDefaultY = collisionBox.y;
		collisionBox.width = 32;
		collisionBox.height = 32;
		
		
		setDefaultValues();
		getPlayerImage();
	}
	//Spawn default information
	public void setDefaultValues() {
		//Starting Spawn Location
		worldX = gp.tileSize*5;
		worldY = gp.tileSize*5;
		speed = 4;	//move 4 pixel each frame
		direction = "down"; //default spawn direction
		
		//Stat
		MaxHP = 10;
		HP = 10;
		MaxMP = 200;
		MP = 120;	
		}
	
	
	//images for each state
	public void getPlayerImage() {
	
		up1 = setup("/player/back_1");
		up2 = setup("/player/back_2");
		down1 = setup("/player/idle_2");
		down2 = setup("/player/idle_3");
		left1 = setup("/player/idle_L");
		left2 = setup("/player/idle_L_2");
		right1 = setup("/player/idle_R");
		right2 = setup("/player/idle_R_2");
		idle1 = setup("/player/idle1");
		idle2 = setup("/player/idle_2");
	}
	
	//update player location
	public void update() {
		//Mana generation
		if(MP < 0) {
			MP = 0;
		}
		if(MP < 200) {
			FrameCounter++;
			if(FrameCounter == 20) {
				MP++;
				FrameCounter = 0;
			}
		}
		if(key.up == true ||key.down == true ||key.right == true||key.left == true) {
			if(key.up == true) {
			direction = "up";
		}
		else if(key.down == true) {
			direction = "down";
		}
		else if(key.left == true) {
			direction = "left";
			right = false;
		}
		else if(key.right == true) {
			direction = "right";
			right = true;
		}
		
		//Collision checking	
		collisionOn = false;
		gp.Colchecker.checkTile(this);
		int objIndex = gp.Colchecker.CheckObject(this, true);
		pickupObject(objIndex);
		//Check NPC/Mob Collision
		int npcIndex = gp.Colchecker.checkCharacter(this, gp.npc);
		interactNPC(npcIndex);
		
		int mobIndex = gp.Colchecker.checkCharacter(this, gp.mob);
		interactNPC(mobIndex);
		//interactNPC(npcIndex);
		
		if(collisionOn == false) {
			switch(direction) {
			case "up":
				worldY -= speed;
				break;
			case "down":
				worldY += speed;
				break;
			case "left":
				worldX -= speed;
				break;
			case "right":
				worldX += speed;
				break;
			}
		}
				
		//each frame + 1, every 10 frame change animation once
		spriteCounter++;
		if(spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
			}
		}	
	}
	
	//Effect when pick up Items 
	private void pickupObject(int i) {
		// TODO Auto-generated method stub
		if(i != 999) {
			//i not 999 mean character just touch an object -> pick it up and it disappear on ground
			String objectName = gp.obj[i].name;
			gp.obj[i].interact(i);
		}	
	}
	private void interactNPC(int i) {
		if(i != 999) {
			if(gp.key.interactKey == true) {
				//gp.Event.interactOnKey(i);
				gp.npc[i].interact();
			}
			gp.key.interactKey = false;
		}
	}
	//Update player image/animation
	public void draw(Graphics2D g2) {

		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNum == 1) {			
				image = up1;
				}
			if(spriteNum == 2) {
				image = up2;
				}
			break;
		case "down":
			if(spriteNum == 1) {			
				image = down1;
				}
			if(spriteNum == 2) {
				image = down2;
				}
			break;
		case "left":
			if(spriteNum == 1) {			
				image = left1;
				}
			if(spriteNum == 2) {
				image = left2;
				}
			break;
		case "right":
			if(spriteNum == 1) {			
				image = right1;
				}
			if(spriteNum == 2) {
				image = right2;
				}
			break;
		}
		g2.drawImage(image, screenX, screenY,null);
	}
	
	//Got call in UI class
	public void HUD(Graphics2D g2) {
		//Health bar
		double hpscale = (double)gp.tileSize*6/MaxHP;
		double hpbarValue = hpscale*HP;
		g2.setColor(new Color(130,0,0,200));
		g2.fillRect(90, 20, gp.tileSize*6, 20);
		g2.setColor(new Color(215,0,0));
		g2.fillRect(90, 20, (int)hpbarValue, 20);
		//Mana bar
		double mpscale = (double)gp.tileSize*6/MaxMP;
		double mpbarValue = mpscale*MP;
		g2.setColor(new Color(0,24,83,200));
		g2.fillRect(90, 45, gp.tileSize*6, 20);
		g2.setColor(new Color(14,86,254));
		g2.fillRect(90, 45, (int)mpbarValue, 20);
		g2.setColor(Color.white);
	}
}
