package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Item_HP_Potion_S extends MasterObject{
	
	GamePanel gp;
	
	public Item_HP_Potion_S(GamePanel gp) {
		
		this.gp = gp;
		name = "Speed_Potion";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/object/HP_Potion_S.png"));
			utility.scaleImage(image,gp.tileSize,gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	public void interact(int i) {
		gp.player.HP += 35;
		if(gp.player.HP < gp.player.MaxHP) {
			gp.ui.showMessage("HP +35");
		}else {
			gp.ui.showMessage("HP Full");
			gp.player.HP = gp.player.MaxHP;
		}
		gp.obj[i] = null;
		gp.playSound(1);
	}

}
