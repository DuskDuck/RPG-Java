package main;

public class EventHandler {
	
	GamePanel gp;
	EventRectangle eventRect[][];
	
	int previousEventX,previousEventY;
	boolean canReTrigger = true;
	
	int FrameCounter = 0;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventRect = new EventRectangle[gp.maxWorldCol][gp.maxWorldRow];
		
		int col = 0;
		int row = 0;
		while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
			eventRect[col][row] = new EventRectangle();
			eventRect[col][row].x = 23;
			eventRect[col][row].y = 23;
			eventRect[col][row].width = 2;
			eventRect[col][row].height = 2;
			eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
			eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;
		
			col++;
			if(col == gp.maxWorldCol) {
				col = 0;
				row++;
			}
		}
	
	}
	int i;
	public void checkEvent() {
		FrameCounter++;
		if(FrameCounter == 40) {
			FrameCounter = 0;
		}
		if( hit(5,6) == true ) {
			damagePit(5,6);
		}
		if( hit(6,7) == true ) {healingWell(6,7);}
	}
	public boolean hit(int col,int row) {
		
		boolean hit = false;
		gp.player.collisionBox.x = gp.player.worldX + gp.player.collisionBox.x;
		gp.player.collisionBox.y = gp.player.worldY + gp.player.collisionBox.y;
		eventRect[col][row].x = col*gp.tileSize + eventRect[col][row].x;
		eventRect[col][row].y = row*gp.tileSize + eventRect[col][row].y;
		
		if(gp.player.collisionBox.intersects(eventRect[col][row]) ) {
			hit = true;
			//System.out.println("On");
		}else {
			//eventRect[col][row].Excuted = false;//for One Time Event
			//System.out.println("Off");
		}
		
		gp.player.collisionBox.x = gp.player.collisionDefaultX;
		gp.player.collisionBox.y = gp.player.collisionDefaultY;
		eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
		eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;
		
		return hit;
	}
	
    //OnTouch Event
	public void damagePit(int col,int row) {
		if(FrameCounter == 0) {
			if(gp.player.HP > 0 ) {
				gp.player.HP -= 1;
			}
		}
	}
	//OnTouch & PressKey Event
	public void healingWell(int col,int row) {
		System.out.println("Frame: "+FrameCounter);
		if(gp.key.interactKey == true) {
			if(gp.player.HP < gp.player.MaxHP) {
				gp.player.HP += 1;
			}
		}
		gp.key.interactKey = false;
	}
	//public void interactOnKey(int i) {
	//	System.out.printf("Pressed");
	//	if(gp.key.interactKey == true) {
	//		gp.obj[i].interact(i);
	//		System.out.println("Worked!");
	//	}
	//}
}
