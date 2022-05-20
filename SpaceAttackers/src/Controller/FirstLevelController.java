package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import model.Alien;
import model.Ship;

public class FirstLevelController implements Initializable{
	
	private Main main;
	
	private GraphicsContext gc;
	
	private Image shipImage;
	
	private Image alienImage;
	
    @FXML
    private Canvas canvas1;

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
	}
	
	public void load() {
		Ship ship=main.getGame().getShip();
		ArrayList<Alien> aliens=main.getGame().getaliens();
		shipImage= new Image(getClass().getResourceAsStream("../ui/ship.png"));
		alienImage= new Image(getClass().getResourceAsStream("../ui/alien.png"));
		gc.clearRect(0,0, 800, 600);

		for (int i=0; i<aliens.size();i++) {
			gc.drawImage(alienImage, aliens.get(i).getPosX(), aliens.get(i).getPosY());
		}
		
		gc.drawImage(shipImage, ship.getPosX(), ship.getPosY());
	}
	
	public void setMain(Main main) {
		this.main=main;
	}

}