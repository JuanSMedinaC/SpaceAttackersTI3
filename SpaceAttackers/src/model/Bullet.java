package model;

public class Bullet {
	private int posY;
	private int posX;
	private int deltaY;
	private boolean active;
	
	public Bullet(int posX,int posY) {
		this.posY=posY;
		this.posX=posX;
		this.deltaY=2;
		active=true;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getDeltaY() {
		return deltaY;
	}

	public void setDeltaY(int deltaY) {
		this.deltaY = deltaY;
	}
	
	public void increaseHeight() {
		posY-=deltaY;
	}
	
	public void deactive() {
		active=false;
	}
	
	public boolean isActive() {
		return active;
	}
	
}
