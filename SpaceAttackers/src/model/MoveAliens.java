package model;

import java.util.concurrent.CountDownLatch;

import Controller.FirstLevelController;
import javafx.application.Platform;

public class MoveAliens extends Thread{
	
	private FirstLevelController mainThread;
	private CountDownLatch latch;
	private int alienNum;
	private int counter;
	
	public MoveAliens(FirstLevelController mainThread, CountDownLatch latch, int alienNum) {
		this.mainThread=mainThread;
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
            while (true) {
            	Platform.runLater(() -> {
            		
	            	mainThread.getMain().getGame().getaliens().get(alienNum).move();
	            	mainThread.load(); 
	            	counter++;
            		if (counter==7) {
            			mainThread.getMain().getGame().getaliens().get(alienNum).switchSide();
            			counter=0;
            			mainThread.getMain().getGame().getaliens().get(alienNum).goDown();
            		}
            		System.out.println(counter);
            	});
            	Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		
	}
}
