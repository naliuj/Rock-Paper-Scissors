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
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class RockPaperScissorsController implements Initializable {
    
    // labels
    @FXML private Label playerScore;
    @FXML private Label compScore;
    @FXML private Label winMessageLabel;
    
    // buttons
    @FXML private Button compRock;
    @FXML private Button compPaper;
    @FXML private Button compScissors;
    
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
        
        Stage stage = RockPaperScissorsGUI.getPrimaryStage();
        
        FileChooser fc = new FileChooser();
        fc.setTitle("Save Game File");
        fc.getExtensionFilters().addAll(
                new ExtensionFilter("RPS Files", "*.rps"),
                new ExtensionFilter("All Files", "*.*"));

        
        try {
            FileOutputStream fileOut = new FileOutputStream(
                    fc.showSaveDialog(stage));
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
        
        Stage stage = RockPaperScissorsGUI.getPrimaryStage();
        
        FileChooser fc = new FileChooser();
        fc.setTitle("Load Game File");
        fc.getExtensionFilters().addAll(
                new ExtensionFilter("RPS Files", "*.rps"),
                new ExtensionFilter("All Files", "*.*"));
        
        try {
            FileInputStream fileIn = new FileInputStream(
                    fc.showOpenDialog(stage));
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
        
        // visually reset the computer's previous move
        compRock.getStyleClass().remove("cpu-choice");
        compPaper.getStyleClass().remove("cpu-choice");
        compScissors.getStyleClass().remove("cpu-choice");
        
        // update the scoreboard
        playerScore.setText(Integer.toString(game.p1.getWins()));
        compScore.setText(Integer.toString(game.cpu.getWins()));
        
        // change the color of the winner on the scoreboard
        playerScore.setTextFill(Color.web(game.p1.getColor()));
        compScore.setTextFill(Color.web(game.cpu.getColor()));

        // update the win message label with the victor
        winMessageLabel.setText(game.getWinMessage());
        
        // style the cpu's choice in move
        switch (game.cpu.getMove().value) {
            case 0:
                compRock.getStyleClass().add("cpu-choice");
                break;
            case 1:
                compPaper.getStyleClass().add("cpu-choice");
                break;
            case 2:
                compScissors.getStyleClass().add("cpu-choice");
                break;
        }
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
