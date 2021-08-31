/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bärehöhlispil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Math.random;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.concurrent.ThreadLocalRandom;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author rwuer
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private Button buttonPlay;
    @FXML
    private ImageView one;
    @FXML
    private ImageView two;
    @FXML
    private ImageView four;
    @FXML
    private ImageView five;
    @FXML
    private ImageView three;
    @FXML
    private Button check;
    @FXML
    private ImageView CavePic;
    @FXML
    private ImageView bearImage;
    @FXML
    private AnchorPane getCaveNumber;
    @FXML
    private TextField getCavesNumber;
    @FXML
    private TextField getBearsNumber;
    @FXML
    private Label outputText;
    @FXML
    private Button Help;

    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private Integer oneN;
    private Integer twoN;
    private Integer threeN;
    private Integer fourN;
    private Integer fiveN;

    @FXML
    private void buttonRollDice(ActionEvent event) throws FileNotFoundException {
        
        buttonPlay.setText("Roll Dices");
        check.setVisible(true);
        getCavesNumber.setVisible(true);
        getBearsNumber.setVisible(true);
        getCavesNumber.clear();
        getBearsNumber.clear();
        outputText.setText(" ");
        Help.setVisible(true);
        

        oneN = getRandomNumber();
        twoN = getRandomNumber();
        threeN = getRandomNumber();
        fourN = getRandomNumber();
        fiveN = getRandomNumber();

        //Show pictures
        one.setImage(new Image("pics/" + oneN + ".png"));
        two.setImage(new Image("pics/" + twoN + ".png"));
        three.setImage(new Image("pics/" + threeN + ".png"));
        four.setImage(new Image("pics/" + fourN + ".png"));
        five.setImage(new Image("pics/" + fiveN + ".png"));
        CavePic.setImage(new Image("pics/cave.png"));
        bearImage.setImage(new Image("pics/bear.png"));

    }

    private int getRandomNumber() {
        int number = ThreadLocalRandom.current().nextInt(1, 7);
        return number;
    }

    @FXML
    private void checkButton(ActionEvent event) {
        //int caves = Integer.parseInt(getCavesNumber.getText());
        //int bears = Integer.parseInt(getBearsNumber.getText());

        String bearsS = getBearsNumber.getText();
        String cavesS = getCavesNumber.getText();
        
        int bears;
        int caves;
        
        caves = Integer.parseInt(cavesS);
        bears = Integer.parseInt(bearsS);
        
        

        boolean oneC;
        boolean twoC;
        boolean threeC;
        boolean fourC;
        boolean fiveC;

        int resultBear = 0;
        int resultCave = 0;

        //grad isch egal
        //Summe vo zahle vo de Rücksite vo de ungrade Zahle sind Bäre
        //Azahl ungradi Würfel sind Höhlene
        if (oneN % 2 != 0) {
            resultBear = resultBear + (7 - oneN);
            resultCave++;
        }

        if (twoN % 2 != 0) {
            resultBear = resultBear + (7 - twoN);
            resultCave++;
        }

        if (threeN % 2 != 0) {
            resultBear = resultBear + (7 - threeN);
            resultCave++;
        }

        if (fourN % 2 != 0) {
            resultBear = resultBear + (7 - fourN);
            resultCave++;
        }

        if (fiveN % 2 != 0) {
            resultBear = resultBear + (7 - fiveN);
            resultCave++;
        }

        System.out.println("Bären: " + resultBear);
        System.out.println("Höhlen: " + resultCave);
        
        if (caves == resultCave && bears == resultBear) {
            outputText.setText("Gratuliere!");
        }
        
        else {
            outputText.setText("falsch");
        }
                

    }

    @FXML
    private void helpClick(ActionEvent event) throws IOException {
        Parent root;
            root = FXMLLoader.load(getClass().getResource("Help.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

}
