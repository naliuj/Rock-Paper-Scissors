package rock.paper.scissors.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

// import the player objects
import game.PersonPlayer;
import game.ComputerPlayer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.paint.Color;

public class RockPaperScissorsController implements Initializable {
    
    @FXML private Label playerScore;
    @FXML private Label compScore;
    
    private PersonPlayer p1 = new PersonPlayer();
    private ComputerPlayer cpu = new ComputerPlayer();
    
    @FXML
    private void rockClick(ActionEvent event) {
        compare(0);
    }
    
    @FXML
    private void paperClick(ActionEvent event) {
        compare(1);
    }

    @FXML
    private void scissorsClick(ActionEvent event) {
        compare(2);
    }
    
    @FXML
    private void saveClick(ActionEvent event) {
        
        try {
            FileOutputStream fileOut = new FileOutputStream("save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p1);
            out.writeObject(cpu);
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
            p1 = (PersonPlayer) in.readObject();
            cpu = (ComputerPlayer) in.readObject();
            in.close();
            fileIn.close();
            updateScore();
        }
        catch (IOException i) {
            i.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c) {
            System.out.println("Class not found.");
            return;
        }
        
    }
    
    public void compare(int pMove) {
        p1.generateMove(pMove);
        cpu.generateMove();
        
        if (p1.compareTo(cpu) == 1) {
            p1.incrementWins();
        } else if (p1.compareTo(cpu) == -1) {
            cpu.incrementWins();
        }
        updateScore();
    }
    
    public void updateScore() {
        playerScore.setText(Integer.toString(p1.getWins()));
        playerScore.setTextFill(Color.web(p1.getColor()));
        compScore.setText(Integer.toString(cpu.getWins()));
        compScore.setTextFill(Color.web(cpu.getColor()));
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
