package model;

public class Alien {

	private int width;
	private int height;
	private int posX;
	private int posY;
	private int deltaX;
	private int deltaY;
	
	public Alien(int posX,int posY) {
		this.width = 64;
		this.height = 64;
		this.posX = posX;
		this.posY = posY;
		this.deltaX=10;
		this.deltaY=10;
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
	
	
}
