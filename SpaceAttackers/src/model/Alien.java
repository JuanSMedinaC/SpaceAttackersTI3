package model;

public class Alien {

	private int width;
	private int height;
	private int posX;
	private int posY;
	private int deltaX;
	private int deltaY;
	private boolean left;
	private boolean alive;
	private int firstPosX;
	private int firstPosY;
	
	public Alien(int posX,int posY) {
		this.width = 56;
		this.height = 56;
		this.posX = posX;
		this.posY = posY;
		this.firstPosX = posX;
		this.firstPosY = posY;
		this.deltaX=10;
		this.deltaY=20;
		left=true;
		alive=true;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	public void move() {
		if (left==true) {
			posX-=deltaX;
		}
		else if(left==false) {	
			posX+=deltaX;
		}
	}
	
	public boolean getLeft() {
		return left;
	}
	
	public void goLeft() {
		left=true;
	}
	
	public void switchSide() {
		if (left==true) {
			left=false;
		}
		else if (left==false) {
			left=true;
		}
		
	}
	
	public void goDown() {
		posY+=deltaY;
	}
	
	public void kill() {
		alive=false;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void resetPos() {
		posY=firstPosY;
		posX=firstPosX;
	}
	
	
	
}
