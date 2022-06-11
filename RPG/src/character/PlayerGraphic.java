package character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.Utility;

public class PlayerGraphic {
	
	public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2,idle1,idle2;
	public BufferedImage atkup1,atkup2,atkdown1,atkdown2,atkleft1,atkleft2,atkright1,atkright2;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public PlayerGraphic() {
	}
	
	public BufferedImage setup(String imagename) {
    	Utility utility = new Utility();
		BufferedImage Image = null;
		
		try {
			Image = ImageIO.read(getClass().getResourceAsStream(imagename + ".png"));
			Image = utility.scaleImage(Image,48,48);
			
		}catch(IOException e) {
			e.printStackTrace();
		}   	   	
    	return Image;   	
		
	}
	public BufferedImage setup(String imagename,int width,int height) {
    	Utility utility = new Utility();
		BufferedImage Image = null;
		
		try {
			Image = ImageIO.read(getClass().getResourceAsStream(imagename + ".png"));
			Image = utility.scaleImage(Image,width,height);
			
		}catch(IOException e) {
			e.printStackTrace();
		}   	   	
    	return Image;   	
		
	}
	public void getImage(String filename, String type) {
		switch(type) {
		case "humanoid":
			up1 = setup(filename + "/back_1");
			up2 = setup(filename + "/back_2");
			down1 = setup(filename + "/idle_2");
			down2 = setup(filename + "/idle_3");
			left1 = setup(filename + "/idle_L");
			left2 = setup(filename + "/idle_L_2");
			right1 = setup(filename + "/idle_R");
			right2 = setup(filename + "/idle_R_2");
			idle1 = setup(filename + "/idle1");
			idle2 = setup(filename + "/idle_2");
			break;
		case "slime":
			up1 = setup(filename + "/slime1");
			up2 = setup(filename + "/slime2");
			down1 = setup(filename + "/slime1");
			down2 = setup(filename + "/slime2");
			left1 = setup(filename + "/slime1");
			left2 = setup(filename + "/slime2");
			right1 = setup(filename + "/slime1");
			right2 = setup(filename + "/slime2");
			idle1 = setup(filename + "/slime1");
			idle2 = setup(filename + "/slime2");
			break;
		case "MC":
			up1 = setup(filename + "/idle1");
			up2 = setup(filename + "/idle2");
			down1 = setup(filename + "/idle1");
			down2 = setup(filename + "/idle2");
			left1 = setup(filename + "/idle1");
			left2 = setup(filename + "/idle2");
			right1 = setup(filename + "/idle1");
			right2 = setup(filename + "/idle2");
			idle1 = setup(filename + "/idle1");
			idle2 = setup(filename + "/idle2");
		}
	}
	public void getAtkImage(String filename) {
		atkup1 = setup(filename + "/back_1",96,96);
		atkup2 = setup(filename + "/back_2",96,96);
		atkdown1 = setup(filename + "/idle_2",96,96);
		atkdown2 = setup(filename + "/idle_3",96,96);
		atkleft1 = setup(filename + "/idle_L",96,96);
		atkleft2 = setup(filename + "/idle_L_2",96,96);
		atkright1 = setup(filename + "/idle_R",96,96);
		atkright2 = setup(filename + "/idle_R_2",96,96);
	}
	
	//Draw 2 pic set using singular pic each
	public void updateDirection(Character c, int interval, int NumIndex) {
		if(c.collisionOn == false && c.gp.key.interactKey == false) {
			switch(c.direction) {
			case "up":
				c.worldY -= c.speed;
				break;
			case "down":
				c.worldY += c.speed;
				break;
			case "left":
				c.worldX -= c.speed;
				break;
			case "right":
				c.worldX += c.speed;
				break;
			case "upright":
				c.worldY -= c.speed -2;
				c.worldX += c.speed -2;
				break;
			case "upleft":
				c.worldY -= c.speed -2;
				c.worldX -= c.speed -2;
				break;
			case "downright":
				c.worldY += c.speed -2;
				c.worldX += c.speed -2;
				break;
			case "downleft":
				c.worldY += c.speed -2;
				c.worldX -= c.speed -2;
				break;
			}
		}	
		//each frame + 1, every 10 frame change animation once
		spriteCounter++;
		if(spriteCounter > interval) {
			spriteNum++;
			if(spriteNum > NumIndex) {
				spriteNum = 1; 
			}
			/*
			if(spriteNum == 1) {
				spriteNum = 2;
			}else if(spriteNum == 2) {
				spriteNum = 1;
			}
			*/
			spriteCounter = 0;
		}
		c.collisionOn = false;
		
	}
	public void drawName(Character c,Graphics2D g2,String name,GamePanel gp, int offsety,Color color) {
		int screenX = c.worldX - gp.player.worldX + gp.player.screenX;
		int screenY = c.worldY - gp.player.worldY + gp.player.screenY;
		int length = (int)g2.getFontMetrics().getStringBounds(name, g2).getWidth();
		int centeredX = screenX + gp.tileSize/2 - length/2;
		g2.setColor(color);
		g2.drawString(name,centeredX,screenY-offsety);
	}
	public void drawLv(Character c,Graphics2D g2,int lv,GamePanel gp) {
		if(lv - gp.player.lv <= 0) {
			drawName(c, g2, "lv."+c.lv, gp, 5, Color.WHITE);
		}else if(lv - gp.player.lv > 0 && lv - gp.player.lv < 5) {
			drawName(c, g2, "lv."+c.lv, gp, 5, Color.GREEN);
		}else if(lv - gp.player.lv >= 5 && lv -gp.player.lv < 10) {
			drawName(c, g2, "lv."+c.lv, gp, 5, Color.ORANGE);
		}else if(lv -gp.player.lv >= 10) {
			drawName(c, g2, "lv."+c.lv, gp, 5, Color.RED);
		}
	}
	public void drawPlayer(Player c ,Graphics2D g2) {
		BufferedImage image = null;
		switch(c.direction) {
		case "up":
			if(spriteNum == 1) {image = up1;}
			if(spriteNum == 2) {image = up2;}
			break;
		case "down":
			if(spriteNum == 1) {image = down1;}
			if(spriteNum == 2) {image = down2;}
			break;
		case "left":
			if(spriteNum == 1) {image = left1;}
			if(spriteNum == 2) {image = left2;}
			break;
		case "right":
			if(spriteNum == 1) {image = right1;}
			if(spriteNum == 2) {image = right2;}
			break;
		case "upright":
			if(spriteNum == 1) {image = right1;}
			if(spriteNum == 2) {image = right2;}
			break;
		case "upleft":
			if(spriteNum == 1) {image = left1;}
			if(spriteNum == 2) {image = left2;}
			break;
		case "downright":
			if(spriteNum == 1) {image = right1;}
			if(spriteNum == 2) {image = right2;}
			break;
		case "downleft":
			if(spriteNum == 1) {image = left1;}
			if(spriteNum == 2) {image = left2;}
			break;
		}
		g2.drawImage(image, c.screenX, c.screenY,null);
	}
	
	//for debug
	public void drawCollision(Graphics2D g2,int x,int y,int width,int height) {
		g2.setColor(new Color(242,0,6,100));
		g2.fillRect(x, y, width, height);
	}

	public void drawCharacter(Character c ,Graphics2D g2, GamePanel gp) {
		BufferedImage image = null;
		int screenX = c.worldX - gp.player.worldX + gp.player.screenX;
		int screenY = c.worldY - gp.player.worldY + gp.player.screenY;
		
		//Only create object that visible on screen
		if(c.worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
		   c.worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
		   c.worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
		   c.worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			
			switch(c.direction) {
			case "up":
				if(spriteNum == 1) {image = up1;}
				if(spriteNum == 2) {image = up2;}
				break;
			case "down":
				if(spriteNum == 1) {image = down1;}
				if(spriteNum == 2) {image = down2;}
				break;
			case "left":
				if(spriteNum == 1) {image = left1;}
				if(spriteNum == 2) {image = left2;}
				break;
			case "right":
				if(spriteNum == 1) {image = right1;}
				if(spriteNum == 2) {image = right2;}
				break;
			}
			g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
	
		}
	}
	public void atkAnim(Character c) {
		spriteCounter++;
		if(spriteCounter <= 5) {
			spriteNum = 1;
		}
		if(spriteCounter > 5 && spriteCounter <= 25) {
			spriteNum = 2;
		}
		if(spriteCounter > 25) {
			spriteNum = 1;
			spriteCounter = 0;
			c.attacking = false;
			
		}
	}
	
}
