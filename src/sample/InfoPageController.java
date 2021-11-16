package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InfoPageController implements Initializable{

    @FXML
    private Label firstNameLastName;

    @FXML
    private Label currencyType;

    @FXML
    private Label income;

    @FXML
    private Label expense;

    @FXML
    private Label balance;

    @FXML
    private Button incomeAddButton;

    @FXML
    private Button expenseAddButton;

    @FXML
    private TextArea historyTA ;

    private static Person currentUser;

    private static int initialIncome = 0;

    private static int staticBalance = 0;

    private static int staticExpense = 0;

    private static String result = "";


    @FXML
    public void expenseAddButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("expenseRecordingPage.fxml"));
        Parent infoPage = loader.load();

        Scene tableViewScene = new Scene(infoPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    public void incomeAddButtonPressed(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("incomeRecordingPage.fxml"));
        Parent infoPage = loader.load();

        Scene tableViewScene = new Scene(infoPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        income.setText("0");
        expense.setText("0");
    }

    //Method for values that are taken from Welcoming page
    public void valueTakerFrom1stPage(Person user){
        currentUser = user;
        initialIncome += currentUser.getBalance();
        currentUser.setBalance(0);
        this.firstNameLastName.setText(currentUser.getFistName() +" "+currentUser.getLastName());
        this.balance.setText("0");
        this.income.setText(Integer.toString(initialIncome));
        this.currencyType.setText(currentUser.getCurrencyType());
        this.expense.setText("-" + staticExpense);
    }

    //Method for values that are taken from Income page
    public void valueTakerFromIncomePage(int newIncome){
        initialIncome += newIncome;
        staticBalance = initialIncome - staticExpense;
        currentUser.setIncome(initialIncome);
        this.firstNameLastName.setText(currentUser.getFistName() + " " + currentUser.getLastName());
        this.balance.setText(Integer.toString(staticBalance));
        this.currencyType.setText(currentUser.getCurrencyType());
        this.income.setText(Integer.toString((initialIncome)));
        this.expense.setText("-" + staticExpense);

        if (result.length() == 0){
            this.historyTA.setText("");}
        else{
            this.historyTA.setText(result);}
    }

    //Method for values that are taken from Expense page
    public void valueTakerFromExpensePage(int newExpense, String description){
            if (newExpense != 0){
            result += String.format("%s %s%n", description,  " ---> " + newExpense);

            currentUser.setExpense(newExpense);
            currentUser.setIncome(initialIncome);
            staticExpense += newExpense;
            currentUser.setExpense(staticExpense);
            staticBalance = initialIncome - staticExpense;
            currentUser.setBalance(staticBalance);

            this.firstNameLastName.setText(currentUser.getFistName() + " " + currentUser.getLastName());
            this.currencyType.setText(currentUser.getCurrencyType());
            this.income.setText(Integer.toString(initialIncome));
            this.expense.setText("-" + currentUser.getExpense());
            this.balance.setText(Integer.toString(currentUser.getBalance()));
            this.historyTA.setText(result);
            }
            else{
                this.firstNameLastName.setText(currentUser.getFistName() + " " + currentUser.getLastName());
                this.currencyType.setText(currentUser.getCurrencyType());
                this.income.setText(Integer.toString(initialIncome));
                this.expense.setText("-" + currentUser.getExpense());
                this.balance.setText(Integer.toString(currentUser.getBalance()));
                this.historyTA.setText(result);

            }




    }

}

