package character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.Utility;

public class Character {
	
	public int worldX,worldY;
	public int speed;
	GamePanel gp;
	
	public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2,idle1,idle2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle collisionBox = new Rectangle(0,0,48,48);
	//public Rectangle interactBox = new Rectangle(0,0,160,160);
	public int collisionDefaultX ,collisionDefaultY;
	public boolean collisionOn = false;
	public int ActionCounter;
	public boolean PlayerIn = false;
	String dialog[] = new String[20];
	int dialogIndex = 0;
	
	//Bonus
	protected BufferedImage[][] sprite1;
	public int UP = 3;
	public int DOWN = 0;
	int LEFT = 1;
	public int RIGHT = 2;
	private int xoffset ;
	private int yoffset ;
	
	//Stat
	public int MaxHP;
	public int HP;
	public int MaxMP;
	public int MP;
	
	public Character(GamePanel gp) {
		this.gp = gp;
	}
	public void setAction() {
		
	}
	public void speak() {
		
	}
	public void interact() {
		
	}
	public void update() {
		setAction();
		gp.Colchecker.checkTile(this);
		//gp.Colchecker.CheckObject(this, false);
		gp.Colchecker.checkPlayer(this);
		//gp.Colchecker.checkPlayerforInteraction(this);
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
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		xoffset = screenX - gp.tileSize/2;
		yoffset = screenY - gp.tileSize/2;				
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
		collisionOn = false;
		//gp.Colchecker.checkTile(this);
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		//Only create object that visible on screen
		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
		   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
		   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
		   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			
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
			g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
		}
		
	}
	public void draw3(Graphics2D g2, GamePanel gp) {
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		BufferedImage image = null;
		//Only create object that visible on screen
		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
		   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
		   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
		   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			switch(direction) {
			case "up":
				if(spriteNum == 1) {
					image = sprite1[UP][0];
				}
				if(spriteNum == 2) {
					image = sprite1[UP][1];
				}
				if(spriteNum == 3) {
					image = sprite1[UP][2];
				}
				break;
			case "down":
				if(spriteNum == 1) {
					image = sprite1[DOWN][0];
				}
				if(spriteNum == 2) {
					image = sprite1[DOWN][1];
				}
				if(spriteNum == 3) {
					image = sprite1[DOWN][2];
				}
				break;
			case "left":
				if(spriteNum == 1) {
					image = sprite1[LEFT][0];
				}
				if(spriteNum == 2) {
					image = sprite1[LEFT][1];
				}
				if(spriteNum == 3) {
					image = sprite1[LEFT][2];
				}
				break;
			case "right":
				if(spriteNum == 1) {
					image = sprite1[RIGHT][0];
				}
				if(spriteNum == 2) {
					image = sprite1[RIGHT][1];
				}
				if(spriteNum == 3) {
					image = sprite1[RIGHT][2];
				}
				break;
			}
			g2.drawImage(image, screenX, screenY,gp.tileSize,gp.tileSize,null);
			g2.setColor(new Color(0, 0, 255));
			g2.fillRect(xoffset + 20, yoffset + 15, 60, 4);
		}
	}
	public BufferedImage setup(String imagename) {
    	Utility utility = new Utility();
		BufferedImage Image = null;
		
		try {
			Image = ImageIO.read(getClass().getResourceAsStream(imagename + ".png"));
			Image = utility.scaleImage(Image,gp.tileSize,gp.tileSize);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
    	   	
    	return Image;
    	
		
	}
}
