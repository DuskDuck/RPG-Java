package main;

import character.Monster;
import character.NPC_1;

import object.Item_HP_Potion_S;
import object.Item_Key;
import object.Item_Speed_Potion;
import object.Item_Tree;

public class ItemGenerator {
	//Item and NPC generate
	GamePanel gp;
	
	public ItemGenerator(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[0] = new Item_Key(gp);
		gp.obj[0].worldX = 5 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;
		
		gp.obj[1] = new Item_Key(gp);
		gp.obj[1].worldX = 18 * gp.tileSize;
		gp.obj[1].worldY = 20 * gp.tileSize;
		
		gp.obj[2] = new Item_Speed_Potion(gp);
		gp.obj[2].worldX = 8 * gp.tileSize;
		gp.obj[2].worldY = 16 * gp.tileSize;
		
		gp.obj[3] = new Item_HP_Potion_S(gp);
		gp.obj[3].worldX = 8 * gp.tileSize;
		gp.obj[3].worldY = 8 * gp.tileSize;
	}
	public void setNPC() {
		
		gp.npc[0] = new NPC_1(gp);
		gp.npc[0].worldX = gp.tileSize*18;
		gp.npc[0].worldY = gp.tileSize*18;
		
		gp.npc[1] = new NPC_1(gp);
		gp.npc[1].worldX = gp.tileSize*17;
		gp.npc[1].worldY = gp.tileSize*18;
		
		gp.npc[2] = new NPC_1(gp);
		gp.npc[2].worldX = gp.tileSize*16;
		gp.npc[2].worldY = gp.tileSize*18;
		
		gp.npc[3] = new NPC_1(gp);
		gp.npc[3].worldX = gp.tileSize*5;
		gp.npc[3].worldY = gp.tileSize*9;
		
		gp.mob[0] = new Monster(gp,"spider");
		gp.mob[0].worldX = gp.tileSize*18;
		gp.mob[0].worldY = gp.tileSize*18;
	
		gp.mob[1] = new Monster(gp,"slame");
		gp.mob[1].worldX = gp.tileSize*7;
		gp.mob[1].worldY = gp.tileSize*7;
		
		gp.mob[2] = new Monster(gp,"bird");
		gp.mob[2].worldX = gp.tileSize*7;
		gp.mob[2].worldY = gp.tileSize*17;
    }
}

	
