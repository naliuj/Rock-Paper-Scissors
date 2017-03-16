package rock.paper.scissors.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

// import the player objects
import game.Game;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.paint.Color;

public class RockPaperScissorsController implements Initializable {
    
    @FXML private Label playerScore;
    @FXML private Label compScore;
    
    private Game game = new Game();
    
    @FXML
    private void rockClick(ActionEvent event) {
        game.compare(0);
        updateScore();
    }
    
    @FXML
    private void paperClick(ActionEvent event) {
        game.compare(1);
        updateScore();
    }

    @FXML
    private void scissorsClick(ActionEvent event) {
        game.compare(2);
        updateScore();
    }
    
    @FXML
    private void saveClick(ActionEvent event) {
        
        try {
            FileOutputStream fileOut = new FileOutputStream("save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game);
            out.close();
            fileOut.close();
            System.out.println("Data serialized.");
        }
        catch (IOException i) {
            i.printStackTrace();
        }
        
    }
    
    @FXML
    private void loadClick(ActionEvent event) {
        
        try {
            FileInputStream fileIn = new FileInputStream("save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            game = (Game) in.readObject();
            in.close();
            fileIn.close();
            updateScore();
        }
        catch (IOException i) {
            System.err.println("Error: " + i.getMessage());
        }
        catch (ClassNotFoundException c) {
            System.err.println("Class not found.");
        }
        
    }
    
    @FXML
    public void newClick(ActionEvent event) {
        
        // create a brand new game
        game = new Game();
        
        updateScore();
        
    }
        
    public void updateScore() {
        playerScore.setText(Integer.toString(game.p1.getWins()));
        playerScore.setTextFill(Color.web(game.p1.getColor()));
        compScore.setText(Integer.toString(game.cpu.getWins()));
        compScore.setTextFill(Color.web(game.cpu.getColor()));
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
