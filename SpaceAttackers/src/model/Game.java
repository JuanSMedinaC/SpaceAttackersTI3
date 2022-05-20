package model;

import java.util.ArrayList;

public class Game {
	private Ship ship;
	private ArrayList<Alien> aliens;
	private ArrayList<Bullet> bullets;
	
	public Game() {
		aliens=new ArrayList<>();
		ship=new Ship();
	}
	
	public void moveShipRight() {
		ship.moveRight();
	}
	
	public void moveShipLeft() {
		ship.moveLeft();
	}
	
	public void createObjects(int alienNum) {
		if (alienNum>10) {
			
		}else {
			
		}
		int diff=800/alienNum;
		
		int last=70;
		for (int i=0; i<alienNum;i++) {
			aliens.add(new Alien(last, 50));
			last+=diff;
		}
	}

	public Ship getShip() {
		return ship;
	}
	
	public ArrayList<Alien> getaliens(){
		return aliens;
	}
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

}
