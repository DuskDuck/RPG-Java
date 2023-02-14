package character;

import java.util.Random;

import main.GamePanel;

public class NPC_1 extends Character{
	
	public NPC_1(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getImage();
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
	public void getImage() {
		
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
	public void setDialog() {
		dialog[0] = "Hello, traveller";
		dialog[1] = "Fuckoff mate!";
		dialog[2] = "You are a piece of shit";
		dialog[3] = "Dumbass!";
		dialog[4] = "Out of here!";
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
}
