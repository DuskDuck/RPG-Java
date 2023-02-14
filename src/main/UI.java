package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import object.Item_Key;

public class UI {
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_30;
	Font warning;
	public Boolean messageOn = false;
	public String message = "";
	int messageDuration = 0;//frame counter
	public String currentDialog = "";
	BufferedImage StatBox = null;
	
	
	public UI (GamePanel gp) {
		this.gp = gp;
		arial_30 = new Font("Airal",Font.PLAIN, 30);
		warning = new Font("Airal",Font.BOLD,15);
		Item_Key key = new Item_Key(gp);
		//KeyImage = key.image;
		try {
			StatBox = ImageIO.read(getClass().getResource("/UI/StatBox.png"));
		} 
		catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(arial_30);
		g2.setColor(Color.white);
		//g2.drawImage(KeyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
		//g2.drawString("x " +gp.player.Key,80,60);
		if(gp.GameState == gp.playState) {
			drawHUD();
		}
		if(gp.GameState == gp.pauseState) {
			drawPauseScreen();
			drawHUD();
		}
		if(gp.GameState == gp.dialogState) {
			drawDialogScreen();
			drawHUD();
		}
		if(messageOn == true) {
			g2.setFont(g2.getFont().deriveFont(15F));
			g2.drawString(message, gp.tileSize*10, gp.tileSize*8);
			
			messageDuration++;
			
			if(messageDuration > 120) {
				messageDuration = 0;
				messageOn = false;
			}
		}
	}
	//HUD(mp and hp)
	public void drawHUD() {
		g2.drawImage(StatBox,10, 5, null);
		gp.player.HUD(g2);
	}
	public void drawPauseScreen() {
		String text = "PAUSED";
		int x = getXforCenteredText(text);
		int y = gp.screenHeight/2;
		g2.drawString(text,x,y);
	}
	public void drawDialogScreen() {
		
		//Dialog window size
		int x = gp.tileSize;
		int y = gp.tileSize*12;
		int width = gp.screenWidth - (gp.tileSize*2);
		int height = gp.tileSize*5;
		drawSubWindow(x,y,width,height);
		//Dialog text
		x += gp.tileSize;
		y += gp.tileSize;
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN));
		//split line whenever the text have "\n"
		for(String line : currentDialog.split("\n")) {
			g2.drawString(currentDialog, x, y);
			y += 40;
		}
	}
	public void drawSubWindow(int x,int y,int width,int height) {
		//Using Paint to define correct RGB,A is for opacity
		Color c = new Color(30,30,30,200);
		g2.setColor(c);
		g2.fillRect(x, y, width, height);
		
		g2.setColor(c);
		g2.fillRect(gp.tileSize, gp.tileSize*11, gp.tileSize*4, gp.tileSize);
		
		c = new Color(255,255,255);
		
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(5));
		g2.drawRect(x+5, y+5, width-10, height-10);
	}
	public int getXforCenteredText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenHeight/2 - length/2;
		return x;

	}

}
