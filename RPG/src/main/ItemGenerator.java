package main;


import character.GreenSlime;
import character.NPC_1;
import object.Item_Blood_Katana;
import object.Item_Blood_Katana_Left;
import object.Item_Coin;
import object.Item_Crusader_Shield;
import object.Item_HP_Potion_B;
import object.Item_HP_Potion_S;
import object.Item_Key;
import object.Item_LightSaber;
import object.Item_Speed_Potion;

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

		gp.obj[4] = new Item_HP_Potion_B(gp);
		gp.obj[4].worldX = 7 * gp.tileSize;
		gp.obj[4].worldY = 7 * gp.tileSize;
		
		gp.obj[5] = new Item_Blood_Katana(gp);
		gp.obj[5].worldX = 7 * gp.tileSize;
		gp.obj[5].worldY = 8 * gp.tileSize;
		
		gp.obj[6] = new Item_LightSaber(gp);
		gp.obj[6].worldX = 17 * gp.tileSize;
		gp.obj[6].worldY = 8 * gp.tileSize;
		
		gp.obj[7] = new Item_Coin(gp);
		gp.obj[7].worldX = 19 * gp.tileSize;
		gp.obj[7].worldY = 8 * gp.tileSize;
		
		gp.obj[8] = new Item_Crusader_Shield(gp);
		gp.obj[8].worldX = 19 * gp.tileSize;
		gp.obj[8].worldY = 10 * gp.tileSize;
		
		gp.obj[8] = new Item_Blood_Katana_Left(gp);
		gp.obj[8].worldX = 21 * gp.tileSize;
		gp.obj[8].worldY = 5 * gp.tileSize;
	}
	public void setNPC() {
		int i = 0;
		gp.npc[i] = new NPC_1(gp, "Markus");
		gp.npc[i].worldX = gp.tileSize*18;
		gp.npc[i].worldY = gp.tileSize*18;
		i++;
		gp.npc[i] = new GreenSlime(gp);
		gp.npc[i].worldX = gp.tileSize*17;
		gp.npc[i].worldY = gp.tileSize*18;
		i++;
		gp.npc[i] = new GreenSlime(gp);
		gp.npc[i].worldX = gp.tileSize*16;
		gp.npc[i].worldY = gp.tileSize*18;
		i++;
		gp.npc[i] = new GreenSlime(gp);
		gp.npc[i].worldX = gp.tileSize*5;
		gp.npc[i].worldY = gp.tileSize*9;
		i++;
		gp.npc[i] = new GreenSlime(gp);
		gp.npc[i].worldX = gp.tileSize*18;
		gp.npc[i].worldY = gp.tileSize*18;
		i++;
		gp.npc[i] = new GreenSlime(gp);
		gp.npc[i].worldX = gp.tileSize*7;
		gp.npc[i].worldY = gp.tileSize*7;
		i++;
		gp.npc[i] = new GreenSlime(gp);
		gp.npc[i].worldX = gp.tileSize*7;
		gp.npc[i].worldY = gp.tileSize*17;
		i++;
    }
}

	
