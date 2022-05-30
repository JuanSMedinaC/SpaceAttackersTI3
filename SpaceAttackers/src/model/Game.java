package model;

import java.util.ArrayList;

public class Game {
	private Ship ship;
	private ArrayList<Alien> aliens;
	private ArrayList<Bullet> bullets;
	private final int N=21;
	
	public Game() {
		aliens=new ArrayList<>();
		ship=new Ship();
		bullets= new ArrayList<>();
	}
	
	public void moveShipRight() {
		ship.moveRight();
	}
	
	public void moveShipLeft() {
		ship.moveLeft();
	}
	
	public void createObjects() {
		int diff1= N/3;
		int posY=50;
		int diff=(700/(N/3))-5;
		
		int last=70;
		for (int i=0; i<3;i++) {
			for (int j=0; j<diff1;j++) {
				aliens.add(new Alien(last, posY));
				last+=diff;
			}
			last=70;
			posY+=56;
			
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
	
	public void addBullet() {
		bullets.add(new Bullet(ship.getPosX()+(ship.getWidth()/2)-15, ship.getPosY()-20));
	}

}
