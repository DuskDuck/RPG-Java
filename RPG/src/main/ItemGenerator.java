package main;


import character.BossSlime;
import character.GreenSlime;
import character.NPC_1;
import character.NPC_Trader;
import object.Item_Blood_Katana;
import object.Item_Blood_Katana_Left;
import object.Item_Coin;
import object.Item_Crusader_Shield;
import object.Item_HP_Potion_B;
import object.Item_HP_Potion_M;
import object.Item_HP_Potion_S;
import object.Item_I_Crate;
import object.Item_Key;
import object.Item_LightSaber;
import object.Item_Speed_Potion;
import overlay_object.Hut;

public class ItemGenerator {
	//Item and NPC generate
	GamePanel gp;
	
	public ItemGenerator(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		int i = 0;
		gp.obj[0][i] = new Item_Key(gp);
		gp.obj[0][i].worldX = 5 * gp.tileSize;
		gp.obj[0][i].worldY = 7 * gp.tileSize;
		i++;
		gp.obj[0][i] = new Item_Key(gp);
		gp.obj[0][i].worldX = 18 * gp.tileSize;
		gp.obj[0][i].worldY = 20 * gp.tileSize;
		i++;
		gp.obj[0][i] = new Item_Speed_Potion(gp);
		gp.obj[0][i].worldX = 8 * gp.tileSize;
		gp.obj[0][i].worldY = 16 * gp.tileSize;
		i++;
		gp.obj[0][i] = new Item_HP_Potion_S(gp);
		gp.obj[0][i].worldX = 8 * gp.tileSize;
		gp.obj[0][i].worldY = 8 * gp.tileSize;
		i++;
		gp.obj[0][i] = new Item_HP_Potion_M(gp);
		gp.obj[0][i].worldX = 4 * gp.tileSize;
		gp.obj[0][i].worldY = 3 * gp.tileSize;
		i++;
		gp.obj[0][i] = new Item_Blood_Katana(gp);
		gp.obj[0][i].worldX = 7 * gp.tileSize;
		gp.obj[0][i].worldY = 8 * gp.tileSize;
		i++;
		gp.obj[0][i] = new Item_LightSaber(gp);
		gp.obj[0][i].worldX = 17 * gp.tileSize;
		gp.obj[0][i].worldY = 8 * gp.tileSize;
		i++;
		gp.obj[0][i] = new Item_Coin(gp);
		gp.obj[0][i].worldX = 19 * gp.tileSize;
		gp.obj[0][i].worldY = 8 * gp.tileSize;
		i++;
		gp.obj[0][i] = new Item_Crusader_Shield(gp);
		gp.obj[0][i].worldX = 19 * gp.tileSize;
		gp.obj[0][i].worldY = 10 * gp.tileSize;
		i++;
		gp.obj[0][i] = new Item_Blood_Katana_Left(gp);
		gp.obj[0][i].worldX = 21 * gp.tileSize;
		gp.obj[0][i].worldY = 5 * gp.tileSize;
		i++;
	}
	public void setOverlay() {
		int i = 0;
		gp.ovl[0][i] = new Hut();
		gp.ovl[0][i].worldX = 80;
		gp.ovl[0][i].worldY = gp.tileSize*0;
	}
	public void setNPC() {
		int i = 0;
		gp.npc[1][i] = new NPC_Trader(gp);
		gp.npc[1][i].worldX = gp.tileSize*25;
		gp.npc[1][i].worldY = gp.tileSize*18;
		i++;
		gp.npc[0][i] = new NPC_1(gp, "Markus");
		gp.npc[0][i].worldX = gp.tileSize*18;
		gp.npc[0][i].worldY = gp.tileSize*18;
		i++;
		gp.npc[0][i] = new GreenSlime(gp);
		gp.npc[0][i].worldX = gp.tileSize*17;
		gp.npc[0][i].worldY = gp.tileSize*18;
		i++;
		gp.npc[0][i] = new GreenSlime(gp);
		gp.npc[0][i].worldX = gp.tileSize*16;
		gp.npc[0][i].worldY = gp.tileSize*18;
		i++;
		gp.npc[0][i] = new GreenSlime(gp);
		gp.npc[0][i].worldX = gp.tileSize*5;
		gp.npc[0][i].worldY = gp.tileSize*9;
		i++;
		gp.npc[0][i] = new GreenSlime(gp);
		gp.npc[0][i].worldX = gp.tileSize*18;
		gp.npc[0][i].worldY = gp.tileSize*18;
		i++;
		gp.npc[0][i] = new GreenSlime(gp);
		gp.npc[0][i].worldX = gp.tileSize*7;
		gp.npc[0][i].worldY = gp.tileSize*7;
		i++;
		gp.npc[0][i] = new GreenSlime(gp);
		gp.npc[0][i].worldX = gp.tileSize*7;
		gp.npc[0][i].worldY = gp.tileSize*17;
		i++;
		gp.npc[0][i] = new BossSlime(gp);
		gp.npc[0][i].worldX = gp.tileSize*19;
		gp.npc[0][i].worldY = gp.tileSize*8;
		i++;
    }
}

	
