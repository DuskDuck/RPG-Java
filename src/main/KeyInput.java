package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
	public boolean up,down,left,right,idle,interactKey;
	GamePanel gp;
	
	public KeyInput(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// Action when key pressed
		int code = e.getKeyCode();//get code of pressed key
		//Play State
		if(gp.GameState == gp.playState) {
			if(code == KeyEvent.VK_W) {
				up = true;
				idle = false;
			}
			if(code == KeyEvent.VK_S) {
				down = true;
				idle = false;
			}
			if(code == KeyEvent.VK_A) {
				left = true;
				idle = false;
			}
			if(code == KeyEvent.VK_D) {
				right = true;
				idle = false;
			}
			if(code == KeyEvent.VK_ESCAPE) {
				gp.GameState = gp.pauseState;
			}
			if(code == KeyEvent.VK_F) {
				interactKey = true;
			}
		}
		//Pause State
		else if(gp.GameState == gp.pauseState) {
			if(code == KeyEvent.VK_ESCAPE) {
				gp.GameState = gp.playState;
			}
		}
		//In dialog State
		if(gp.GameState == gp.dialogState) {
			if(code == KeyEvent.VK_SPACE) {
				gp.GameState = gp.playState;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//Action when key released
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			up = false;
			idle = true;
		}
		if(code == KeyEvent.VK_S) {
			down = false;
			idle = true;
		}
		if(code == KeyEvent.VK_A) {
			left = false;
			idle = true;
		}
		if(code == KeyEvent.VK_D) {
			right = false;
			idle = true;
		}
		if(code == KeyEvent.VK_F) {
			interactKey = false;
		}
		
		
		
	}

}
