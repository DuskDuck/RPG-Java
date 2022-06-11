package character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import main.GamePanel;

public class NPC_1 extends Character{
	
	public int ActionCounter;
	String dialog[] = new String[20];
	int dialogIndex = 0;
	
	public NPC_1(GamePanel gp,String name) {
		super(gp);
		this.name = name;
		direction = "down";
		speed = 1;
		
		graphic.getImage("/player","humanoid");
		setDialog();
	}
	public void setAction() {
		ActionCounter++;
		if(ActionCounter == 120) {
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
	public void setDialog() {
		dialog[0] = "Hello, traveller";
		dialog[1] = "Welcome mate!";
		dialog[2] = "My name is " + name;
		dialog[3] = "Bye!";
		dialog[4] = "Stop bugging me!";
	}
	public void speak() {
		switch(gp.player.direction) {
		case "up":
			direction = "down";
			break;
		case "down":
			direction = "up";
			break;
		case "left":
			direction = "right";
			break;
		case "right":
			direction = "left";
			break;
		}
		if(dialog[dialogIndex] == null) {
			dialogIndex = 0;
		}
		gp.ui.currentDialog = dialog[dialogIndex];
		dialogIndex++;//next call will load next dialog

	}
	public void interact() {
		gp.GameState = gp.dialogState;
		speak();
	}
	public void update() {
		setAction();
		gp.Colchecker.checkTile(this);
		gp.Colchecker.checkPlayer(this);
		graphic.updateDirection(this,10,2);
	}
	public void draw(Graphics2D g2) {
		graphic.drawCharacter(this, g2,gp);
		graphic.drawName(this, g2, name, gp, 15,Color.WHITE);
	}
}
