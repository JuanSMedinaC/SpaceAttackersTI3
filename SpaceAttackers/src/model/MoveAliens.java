package model;

import java.util.concurrent.CountDownLatch;

import Controller.FirstLevelController;
import javafx.application.Platform;

public class MoveAliens extends Thread{
	
	private FirstLevelController mainThread;
	private CountDownLatch latch;
	private int alienNum;
	private int counter;
	
	public MoveAliens(FirstLevelController firstLevelController, CountDownLatch latch, int alienNum) {
		this.mainThread=firstLevelController;
		this.latch=latch;
		this.alienNum=alienNum;
		counter=0;
	}
	
	@Override
	public void run() {
		try 
        {
            latch.await();  
            System.out.println(System.currentTimeMillis());
            boolean stop=false;
            while (!stop) {
            	Platform.runLater(() -> {
            		
	            	mainThread.getMain().getGame().getaliens().get(alienNum).move();
	            	mainThread.load(); 
	            	counter++;
            		if (counter==7) {
            			mainThread.getMain().getGame().getaliens().get(alienNum).switchSide();
            			counter=0;
            			mainThread.getMain().getGame().getaliens().get(alienNum).goDown();
            		}
            		
            		
            	});
            	
            	if(!mainThread.getMain().getGame().getaliens().get(alienNum).isAlive()) {
            		stop=true;
            	}
            	
            	Alien alien=mainThread.getMain().getGame().getaliens().get(alienNum);
            	
            	if(alien.getPosY()+alien.getHeight()>=mainThread.getMain().getGame().getShip().getPosY()) {
            		for (int i=0; i<mainThread.getMain().getGame().getaliens().size();i++ ) {
            			mainThread.getMain().getGame().getaliens().get(i).goLeft();
            			mainThread.getMain().getGame().getaliens().get(i).resetPos();
            			mainThread.getMain().getGame().getShip().reduceLife();
            		}
            		counter=0;
            	}
            	
            	Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		
	}
}
