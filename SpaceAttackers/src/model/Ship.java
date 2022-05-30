package model;

public class Ship {
	private int width;
	private int height;
	private int posX;
	private int posY;
	private int deltaX;
	private int lives;
	private boolean reduced;
	public Ship() {
		this.width = 48;
		this.height = 48;
		this.posX = 350-width/2;
		this.posY = 450-height;
		this.deltaX=10;
		lives=3;
		reduced=false;
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
		if(this.posX+width+deltaX<700) {
			this.posX+=deltaX;	
		}
		
	}
	public void moveLeft() {
		if (this.posX>0) {
			this.posX-=deltaX;	
		}
		
	}
	
	public void reduceLife() {
		if (reduced==false) {
			reduced=true;
			lives--;
			System.out.println("Redujo");
			new Thread(() -> {
	            try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            reduced=false;
	        }).start();
		}
	}
	
	public int getLifes() {
		return lives;
	}
	
	
}
