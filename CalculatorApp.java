package calculator;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
	VBox root = new VBox();	
	StackPane stackPane = new StackPane();

	HBox hboxOne = new HBox();
	HBox hboxTwo = new HBox();
	HBox hboxThree = new HBox();
	HBox hboxFour = new HBox();
	HBox hboxFive = new HBox();
	HBox hboxDisplay = new HBox();

	TextField tfDisplay = new TextField();

	Button btZero = new Button("0");
	Button btOne = new Button("1");
	Button btTwo = new Button("2");		
	Button btThree = new Button("3");
	Button btFour = new Button("4");
	Button btFive = new Button("5");	
	Button btSix = new Button("6");
	Button btSeven = new Button("7");
	Button btEight = new Button("8");	
	Button btNine = new Button("9");
	Button btCalculate = new Button("=");
	Button btAdd = new Button("+");		
	Button btSubtract = new Button("-");
	Button btMultiply = new Button("*");
	Button btDivide = new Button("/");
	Button btClear = new Button("C");
	Button btExponent = new Button("^");
	
	ArrayList<Button> buttonList = new ArrayList<>();
	ArrayList<HBox> hboxList = new ArrayList<>();
	ArrayList<Button> numpadList = new ArrayList<>();
	
	private Text output;
	private long number2 = 0;
	private long number1 = 0;
	private String operator = "";
	private boolean start = true;

	private Parent createContent() {
		stackPane.setPrefSize(250,300);		
		root.setPrefSize(250,300);
		
		root.setStyle("-fx-background-color: rgba(0,0,0,0.3)");
		root.getChildren().addAll(stackPane,hboxDisplay,hboxFive,hboxFour,hboxThree,hboxTwo,hboxOne);

		hboxOne.getChildren().addAll(btZero,btCalculate,btAdd);
		hboxTwo.getChildren().addAll(btOne,btTwo,btThree,btSubtract);
		hboxThree.getChildren().addAll(btFour,btFive,btSix,btMultiply);
		hboxFour.getChildren().addAll(btSeven,btEight,btNine,btDivide);
		hboxFive.getChildren().addAll(btClear,btExponent);
		hboxDisplay.getChildren().add(tfDisplay);

		setProperties();

				btOne.setOnAction(e ->{
					processDisplay(e);		
				});
				btTwo.setOnAction(e ->{
					processDisplay(e);
				});
				btThree.setOnAction(e ->{
					processDisplay(e);
				});
				btFour.setOnAction(e ->{
					processDisplay(e);
				});
				btFive.setOnAction(e ->{
					processDisplay(e);
				});
				btSix.setOnAction(e ->{
					processDisplay(e);
				});
				btSeven.setOnAction(e ->{
					processDisplay(e);
				});
				btEight.setOnAction(e ->{
					processDisplay(e);
				});
				btNine.setOnAction(e ->{
					processDisplay(e);
				});
				btAdd.setOnAction(e ->{
					processOperators(e);
				});
				btSubtract.setOnAction(e ->{
					processOperators(e);
				});
				btMultiply.setOnAction(e ->{
					processOperators(e);
				});
				btDivide.setOnAction(e ->{
					processOperators(e);
				});
				btExponent.setOnAction(e ->{
					processOperators(e);
				});
				btCalculate.setOnAction(e ->{
					processOperators(e);
				});
				btZero.setOnAction(e ->{
					processDisplay(e);			
				});
				btClear.setOnAction(e ->{
					tfDisplay.setText("");
				});

		return root;
	}

	private void processDisplay(ActionEvent event) {
		if(start) {
			tfDisplay.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		tfDisplay.setText(tfDisplay.getText() + value);
	}

	private void processOperators(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();

		if(!value.equals("=")) {
			if(!operator.isEmpty()) 
				return;	

			operator = value;
			number1 = Long.parseLong(tfDisplay.getText());
			tfDisplay.setText("");

		} else {
			if(operator.isEmpty())

				return;

			number2 = Long.parseLong(tfDisplay.getText());
			float output = calculate(number1,number2,operator);
			tfDisplay.setText(String.valueOf(output));
			operator = "";
			start = true;
		}
	}

	//Set Properties for Nodes
	private void setProperties() {

		buttonList.add(btOne);
		buttonList.add(btTwo);
		buttonList.add(btThree);
		buttonList.add(btFour);
		buttonList.add(btFive);
		buttonList.add(btSix);
		buttonList.add(btSeven);
		buttonList.add(btEight);
		buttonList.add(btNine);
		buttonList.add(btCalculate);
		buttonList.add(btAdd);
		buttonList.add(btSubtract);
		buttonList.add(btMultiply);
		buttonList.add(btDivide);
		buttonList.add(btClear);
		buttonList.add(btExponent);
		for(Button button : buttonList) {
			button.setPrefWidth(50);
			button.setPrefHeight(200);
		}

		hboxList.add(hboxOne);
		hboxList.add(hboxTwo);
		hboxList.add(hboxThree);
		hboxList.add(hboxFour);
		hboxList.add(hboxFive);

		for(HBox hbox : hboxList) {
			hbox.setPrefHeight(300);
			hbox.setPrefWidth(400);
			hbox.setPadding(new Insets(5,5,5,5));
			hbox.setSpacing(10);
			hbox.setAlignment(Pos.CENTER);
		}
		
		btZero.setPrefWidth(110);
		btZero.setPrefHeight(200);	
		hboxDisplay.setAlignment(Pos.CENTER);
		hboxDisplay.setPadding(new Insets(5,5,5,5));
		hboxDisplay.setPrefHeight(350);
		hboxDisplay.setPrefWidth(230);
		tfDisplay.setPrefWidth(230);
		tfDisplay.setPrefHeight(350);
		tfDisplay.setEditable(false);
		tfDisplay.setFont(Font.font(24));
	}

	//Calculate method
	public float calculate(long number1, long number2, String operator) {
		switch(operator) {
		case "+":
			return number1 + number2;
		case "-":
			return number1 - number2;
		case "*":
			return number1 * number2;
		case "/":
			if(number2 == 0)
				return 0;
			return number1 / number2;
		case "^":
			for(int counter = 0; counter < number2; counter++) {
				return number1 * number1;
			}
		default:
			break;
		}
		return 0;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


}
