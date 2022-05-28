package model;

public class Ship {
	private int width;
	private int height;
	private int posX;
	private int posY;
	private int deltaX;
	
	public Ship() {
		this.width = 48;
		this.height = 48;
		this.posX = 350-width/2;
		this.posY = 450-height;
		this.deltaX=10;
		
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
	
	public void moveRight() {
		if(this.posX+width<700) {
			this.posX+=deltaX;	
		}
		
	}
	public void moveLeft() {
		if (this.posX>0) {
			this.posX-=deltaX;	
		}
		
	}
	
	
}
