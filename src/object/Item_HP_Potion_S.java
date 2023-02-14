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
			image = ImageIO.read(getClass().getResourceAsStream("/object/Speed_Potion.png"));
			utility.scaleImage(image,gp.tileSize,gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	public void interact(int i) {
		gp.player.speed += 2;
		gp.obj[i] = null;
		gp.playSound(1);
		gp.ui.showMessage("speed +2");
	}

}
