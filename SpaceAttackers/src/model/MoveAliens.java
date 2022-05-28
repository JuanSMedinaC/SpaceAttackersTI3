package model;

import java.util.concurrent.CountDownLatch;

import Controller.FirstLevelController;

public class MoveAliens extends Thread{
	
	private FirstLevelController mainThread;
	private CountDownLatch latch;
	
	public MoveAliens(FirstLevelController mainThread, CountDownLatch latch) {
		this.mainThread=mainThread;
		this.latch=latch;
	}
	
	@Override
	public void run() {
		try 
        {
            latch.await();        
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		
	}
}
