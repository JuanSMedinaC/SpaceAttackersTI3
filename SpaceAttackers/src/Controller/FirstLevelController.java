package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import model.Alien;
import model.Bullet;
import model.MoveAliens;
import model.MoveBullets;
import model.Ship;

public class FirstLevelController implements Initializable{
	
	private Main main;
	
	private CountDownLatch latch;
	
	private ArrayList<MoveAliens> alienTh;
	
	private ArrayList<MoveBullets> bulletTh;
	
	private GraphicsContext gc;
	
	private Image shipImage;
	
	private Image alienImage;
	
	private Image bulletImage;
    @FXML
    private Canvas canvas1;
    @FXML
    private Label livesLabel;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		canvas1.setFocusTraversable(true);
		gc = canvas1.getGraphicsContext2D();	
		
	}
	
	@FXML
	public void movement(KeyEvent e) {
		if (e.getCode() == KeyCode.LEFT) {
			main.getGame().moveShipLeft();
			load();
		} else if (e.getCode() == KeyCode.RIGHT) {
			main.getGame().moveShipRight();
			load();
		}
		else if(e.getCode()==KeyCode.SPACE) {
			main.getGame().addBullet();
			bulletTh.add(new MoveBullets(this, main.getGame().getBullets().size()-1));
			bulletTh.get(bulletTh.size()-1).start();
			load();
		}
	}
	
	public void load() {
		
		int alienAliveCounter=0;
		Ship ship=main.getGame().getShip();
		ArrayList<Alien> aliens=main.getGame().getaliens();
		ArrayList<Bullet> bullets=main.getGame().getBullets();
		shipImage= new Image(getClass().getResourceAsStream("../ui/ship.png"));
		alienImage= new Image(getClass().getResourceAsStream("../ui/alien.png"));
		bulletImage=new Image(getClass().getResourceAsStream("../ui/bullet.png"));
		gc.clearRect(0,0, 700, 500);
		if (ship.getLifes()==0) {
			main.gameOverScreen();
			for(int i=0; i<alienTh.size();i++) {
				alienTh.get(i).stop();
			}
		}
		livesLabel.setText("Lives: "+ship.getLifes());
		for (int i=0; i<aliens.size();i++) {
			if( aliens.get(i).isAlive()) {
				gc.drawImage(alienImage, aliens.get(i).getPosX(), aliens.get(i).getPosY(), aliens.get(i).getWidth(),aliens.get(i).getHeight());
				alienAliveCounter++;
			}
		}
		
		if (alienAliveCounter==0) {
			main.GameWonScreen();
		}
		
		for (int i=0; i<bullets.size();i++) {
			if( bullets.get(i).isActive()) {
				
				gc.drawImage(bulletImage, bullets.get(i).getPosX(), bullets.get(i).getPosY()-20, 30,40);
			}
		}
		
		gc.drawImage(shipImage, ship.getPosX(), ship.getPosY(),ship.getWidth(),ship.getHeight());
	}
	
	
	public void start() {
		alienTh=new ArrayList<>();
		bulletTh=new ArrayList<>();
		Ship ship=main.getGame().getShip();
		ArrayList<Alien> aliens=main.getGame().getaliens();
		
        CountDownLatch latch = new CountDownLatch(1);
        
		for (int i = 0 ; i<aliens.size(); i++) {
			alienTh.add(new MoveAliens(this, latch,i));
			alienTh.get(i).start();
		}
		latch.countDown();

	}
	
	public void setMain(Main main) {
		this.main=main;
	}
	
	public Main getMain() {
		return main;
	}

}
