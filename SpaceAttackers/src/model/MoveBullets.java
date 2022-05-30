package model;

import Controller.FirstLevelController;
import javafx.application.Platform;

public class MoveBullets extends Thread {
	private int bulletNum;
	private FirstLevelController mainThread;
	private boolean stop;
	public MoveBullets(FirstLevelController mainThread, int bulletNum) {
		this.bulletNum=bulletNum;
		this.mainThread=mainThread;
		stop=false;
	}
	
	@Override
	public void run() {
		while(!stop) {
			try {
				Platform.runLater(() -> {

					mainThread.getMain().getGame().getBullets().get(bulletNum).increaseHeight();
					Bullet bullet=mainThread.getMain().getGame().getBullets().get(bulletNum);
					for(int i=0; i<mainThread.getMain().getGame().getaliens().size(); i++) {
						Alien alien=mainThread.getMain().getGame().getaliens().get(i);
						if(alien.isAlive()&&bullet.isActive()&&bullet.getPosX()>=alien.getPosX()&&bullet.getPosX()<=alien.getPosX()+alien.getWidth()-20&&bullet.getPosY()>=alien.getPosY()&&bullet.getPosY()<alien.getPosY()+alien.getHeight()) {
							bullet.deactive();
							alien.kill();
							stop=true;
							break;
						}
					}
				});
        			Thread.sleep(50);
        	} catch (InterruptedException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
			
			if(mainThread.getMain().getGame().getBullets().get(bulletNum).getPosY()<0) {
				mainThread.getMain().getGame().getBullets().get(bulletNum).deactive();
				stop=true;
				break;
			}
        	mainThread.load();
		}
	}
}