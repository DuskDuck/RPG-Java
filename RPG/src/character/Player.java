package character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import main.GamePanel;
import main.KeyInput;

public class Player extends Character{

	KeyInput key;
	
	public int screenX;
	public int screenY;
	
	boolean right = true;
	int FrameCounter = 0;
	
	public Player(GamePanel gp, KeyInput key) {
		super(gp);
		
		this.gp = gp;
		this.key = key;
		
		lv = 1;
		
		//Middle of the screen
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		collisionBox = new Rectangle();
		collisionBox.x = 12;
		collisionBox.y = 16;
		collisionDefaultX = collisionBox.x;
		collisionDefaultY = collisionBox.y;
		collisionBox.width = 24;
		collisionBox.height = 32;
		
		
		setDefaultValues();
		graphic.getImage("/player","humanoid");
		graphic.getAtkImage("/player");
	}
	//Spawn default information
	public void setDefaultValues() {
		//Starting Spawn Location
		worldX = gp.tileSize*5;
		worldY = gp.tileSize*5;
		speed = 6;	//move 4 pixel each frame
		direction = "down"; //default spawn direction
		
		//Stat
		MaxHP = 10;
		HP = 10;
		MaxMP = 200;
		MP = 120;	
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
        if(attacking == true) {
			
		}
		if(key.up == true ||key.down == true ||key.right == true||key.left == true ||key.interactKey == true) {
			if(key.up == true) {
			direction = "up";
		}
		else if(key.down == true) {
			direction = "down";
		}
		else if(key.left == true) {
			direction = "left";	
		}
		else if(key.right == true) {
			direction = "right";
		}
			/*
		if(key.up == true && key.right == true) {
			direction = "upright";
		}
		if(key.up == true && key.left == true) {
			direction = "upleft";
		}
		if(key.down == true && key.right == true) {
			direction = "downright";
		}
		if(key.down == true && key.left == true) {
			direction = "downleft";
		}
		*/
		//Collision checking	
		collisionOn = false;
		gp.Colchecker.checkTile(this);
		
		//check entity collision
		int objIndex = gp.Colchecker.CheckObject(this, true);
		pickupObject(objIndex);
		//Check NPC/Mob Collision
		int npcIndex = gp.Colchecker.checkCharacter(this, gp.npc);
		interactNPC(npcIndex);
		//int mobIndex = gp.Colchecker.checkCharacter(this, gp.mob);
		//interactNPC(mobIndex);
		
		graphic.updateDirection(this, 10, 2);	
		
		//System.out.println(direction);
		//Test
		}
	}
	
	//Effect when pick up Items 
	private void pickupObject(int i) {
		// TODO Auto-generated method stub
		if(i != 999) {
			//i not 999 mean character just touch an object -> pick it up and it disappear on ground
			//String objectName = gp.obj[i].name;
			gp.obj[i].interact(i);
		}	
	}
	private void interactNPC(int i) {
		if(i != 999) {
			if(gp.key.interactKey == true) {
				//gp.Event.interactOnKey(i);
				gp.npc[i].interact();
			}else {
				gp.npc[i].contact(this);
			}
			gp.key.interactKey = false;
		}
	}
	//Update player image/animation
	public void draw(Graphics2D g2) {
		//System.out.println(graphic.spriteNum);
		graphic.drawPlayer(this, g2);
		graphic.drawCollision(g2, screenX+collisionBox.x, screenY+collisionBox.y, collisionBox.width,collisionBox.height);
		graphic.drawName(this, g2, "Lv."+ lv, gp, 15, Color.WHITE);
	}
}
