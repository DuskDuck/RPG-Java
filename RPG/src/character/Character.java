package character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import main.GamePanel;
import object.Item_Coin;
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
	public PlayerGraphic graphic = new PlayerGraphic();
	public ItemPicker itemPicker;
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
		itemPicker = new ItemPicker(gp);
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
	public void TookDMG(int i) {
		
	}
	public void CostMP(int i) {
		MP -= i; 
		if(MP < 0) {
			MP = 0;
		}
	}
	public void DropItem(MasterObject item) {
		for(int i = 0; i <gp.obj.length;i++) {
			if(gp.obj[i] == null) {
				gp.obj[i] = item;
				gp.obj[i].worldX = worldX; 
			    gp.obj[i].worldY = worldY;
			    break;
			}
		}
		
	}
	public void CheckDrop() {
        int i = new Random().nextInt(100)+1;
		
		if(i < 40) {
			DropItem(itemPicker.picker("common"));
		}
		if(i >= 40 && i < 65) {
			DropItem(itemPicker.picker("standard"));
		}
		if(i >= 65 && i < 80 ) {
			DropItem(itemPicker.picker("rare"));
		}
		if(i >= 80 && i < 90 ) {
			DropItem(itemPicker.picker("superior"));
		}
		if(i >= 90 && i < 97 ) {
			DropItem(itemPicker.picker("high-end"));
		}
		if(i >= 97 && i <= 100 ) {
			DropItem(itemPicker.picker("exotic"));
		}
	}
}
