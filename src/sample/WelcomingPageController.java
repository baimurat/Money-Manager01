package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javax.security.auth.callback.ConfirmationCallback;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.awt.SystemColor.window;

public class WelcomingPageController implements Initializable {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField balance;

    @FXML
    private RadioButton somRB;

    @FXML
    private RadioButton dollarRB;

    @FXML
    private RadioButton euroRB;

    @FXML
    private RadioButton yuanRB;

    @FXML
    private Button submitButton;

    @FXML
    private Button exitButton;

    private ToggleGroup currencyRBgroup;


    public String getFirstName(){
        return firstName.getText();
    }

    public String getLastName(){
        return lastName.getText();
    }

    public int getBalance(){
        return Integer.parseInt(balance.getText());
    }

    public String getCurrency(){
        String currency = "";

        if (this.currencyRBgroup.getSelectedToggle().equals(this.somRB)){
            currency = "Som";
        }
        if (this.currencyRBgroup.getSelectedToggle().equals(this.dollarRB)){
            currency = "Dollar";
        }
        if (this.currencyRBgroup.getSelectedToggle().equals(this.euroRB)){
            currency = "Euro";
        }
        if (this.currencyRBgroup.getSelectedToggle().equals(this.yuanRB)){
            currency = "Yuan";
        }

        return currency;
    }


    public void submitButtonPressed(ActionEvent event) throws IOException {

        Person currentUser = new Person(getFirstName(), getLastName(), getCurrency(), getBalance());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("infoPage.fxml"));
        Parent infoPage = loader.load();

        Scene tableViewScene = new Scene(infoPage);

        InfoPageController controller = loader.getController();
        controller.valueTakerFrom1stPage(currentUser);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void exitButtonPressed(ActionEvent event) throws  IOException {
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //configuring and setting up the currency radio buttons in one toggle
        currencyRBgroup = new ToggleGroup();
        this.somRB.setToggleGroup(currencyRBgroup);
        this.dollarRB.setToggleGroup(currencyRBgroup);
        this.euroRB.setToggleGroup(currencyRBgroup);
        this.yuanRB.setToggleGroup(currencyRBgroup);



    }

}
