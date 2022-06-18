package character;

import java.awt.Graphics2D;
import java.awt.Rectangle;



import main.GamePanel;
import object.MasterObject;

public class Character {
	
	public int worldX,worldY;
	//public int screenX;
	//public int screenY;
	
	public String direction;
	String name;
	public Rectangle collisionBox = new Rectangle(0,0,48,48);
	public Rectangle attackBox = new Rectangle(0,0,0,0);
	public int collisionDefaultX ,collisionDefaultY;
	public boolean collisionOn = false;
	public boolean attacking = false;
	
	//public boolean PlayerIn = false;
	GamePanel gp;
	
	//Graphic
	PlayerGraphic graphic = new PlayerGraphic();
	//Stat	
	public int speed;
	public int MaxHP;
	public int HP;
	public int MaxMP;
	public int MP;
	public int ATK;
	public int DEF;
	public int Stamina;
	public int lv;
	public int exp;
	public int NextLvexp;
	public MasterObject OnhandWP;
	public MasterObject Shield;
	
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
		
	}
	public void draw(Graphics2D g2) {
		
	}
	public void contact(Character c) {
		
	}
	public void hitted(int dmg,int i) {
		
	}
}
