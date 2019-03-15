import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class gui extends Application {
ATM atm;
int i=-1;
int x=-1;
String[]type=new String[5];

String[]history=new String[5];


Stage stage;
	public ATM getAtm() {

	return atm;
}

public void setAtm(ATM atm) {
	this.atm = atm;
}



	public static void main(String[]args) {
		launch(args);
		
	}
  
	@Override
	public void start(Stage primaryStage) throws Exception {
		for(int G=0;G<=4;G++)
		{history[G]="";
		type[G]="No History Available";
		}
		
atm=new ATM();
//start..........................................................................
	primaryStage.setTitle("ATM");	
	Label idnumLabel=new Label("IdNum");
	Label passwordLabel=new Label("Password");
Label validationLabel =new Label();
	TextField idField=new TextField();
PasswordField passwordField =new PasswordField();
Button sumbit =new Button("Sumbit");
GridPane gridLogin =new GridPane();
gridLogin.add(idnumLabel, 0, 0);
gridLogin.add(passwordLabel, 0, 1);
gridLogin.add(idField, 1, 0);
gridLogin.add(passwordField, 1, 1);
gridLogin.add(sumbit, 2, 3);
gridLogin.add(validationLabel,1,2);
gridLogin.setAlignment(Pos.CENTER);

Scene sceneLogin =new Scene(gridLogin,400,300);
//end...............................................................................


primaryStage.setTitle("ATM");
Button deposit =new Button("Deposit");
Button withdraw =new Button("Withdraw");
Button next =new Button("Next");
Button previous =new Button("Previous");
Button balanceInquiry =new Button("BalanceInquiry");
Label validationhistory =new Label();
Label validationhistor =new Label();
Label history1 =new Label();



GridPane OperationScreengrid=new GridPane();
OperationScreengrid.setAlignment(Pos.CENTER);
OperationScreengrid.add(deposit,3, 1); 
OperationScreengrid.add(withdraw, 6, 1); 
OperationScreengrid.add(next,6, 5); 
OperationScreengrid.add(previous, 3, 5); 
OperationScreengrid.add(balanceInquiry, 4, 3); 
OperationScreengrid.add(validationhistory,1,2);
OperationScreengrid.add(validationhistor,1,4);
OperationScreengrid.add(history1,4, 6);


Scene OperationScreenScene =new Scene(OperationScreengrid,400,300);
//end.....................................................................................
primaryStage.setTitle("ATM");	
Label amount=new Label(" Amount:");
TextField amountField=new TextField();
Button confirm =new Button("Sumbit");
Button back=new Button("Back");

Label validationLabel1 =new Label();
Label balance =new Label();
Label amountDeposit =new Label();


GridPane DepositScreengrid=new GridPane();
DepositScreengrid.setAlignment(Pos.CENTER);
DepositScreengrid.add(confirm, 2, 3);
DepositScreengrid.add(back, 1, 5);

DepositScreengrid.add(validationLabel1,1,4);
DepositScreengrid.add(balance,3,4);
DepositScreengrid.add(amountDeposit,3,3);


DepositScreengrid.add(amount, 0, 0);
DepositScreengrid.add(amountField, 0, 1);
Scene DepositScreenScene =new Scene(DepositScreengrid,600,300);
//end...........................................................................................
primaryStage.setTitle("ATM");	
Label amount1=new Label(" Amount:");
TextField amountField1=new TextField();
Button confirm1 =new Button("Sumbit");
Button back1=new Button("Back");

Label validationLabel2 =new Label();
Label balance1 =new Label();
Label amountWithdraw =new Label();


GridPane WithdrawScreengrid=new GridPane();
WithdrawScreengrid.setAlignment(Pos.CENTER);
WithdrawScreengrid.add(confirm1, 2, 3);
WithdrawScreengrid.add(back1, 1, 5);

WithdrawScreengrid.add(validationLabel2,1,4);
WithdrawScreengrid.add(balance1,3,4);
WithdrawScreengrid.add(amountWithdraw,3,3);


WithdrawScreengrid.add(amount1, 0, 0);
WithdrawScreengrid.add(amountField1, 0, 1);
Scene WithdrawScreenScene =new Scene(WithdrawScreengrid,600,300);
//end.........................................................................................
primaryStage.setTitle("ATM");	
Label Balance=new Label();

Button back2=new Button("Back");

GridPane BalanceScreengrid=new GridPane();
BalanceScreengrid.setAlignment(Pos.CENTER);

BalanceScreengrid.add(Balance,1 ,1 );
BalanceScreengrid.add(back2, 2, 5);


Scene BalanceScreenScene =new Scene(BalanceScreengrid,400,300);

//end.........................................................................................
primaryStage.setScene(sceneLogin);
	primaryStage.show();
sumbit.setOnAction(new EventHandler<ActionEvent>() { 
	public void handle(ActionEvent event) {
	
	String IdNum=idField.getText();	
	String password=passwordField.getText();	
	boolean valid=atm.validate(IdNum,password);
	if(valid) 
	{primaryStage.setScene(OperationScreenScene);//end of operation scene
	deposit.setOnAction(new EventHandler<ActionEvent>()
	{ 
		public void handle(ActionEvent event) 
		{primaryStage.setScene(DepositScreenScene);
		balance.setText("");
		amountDeposit.setText("");
		validationLabel1.setText("");
		back.setOnAction(new EventHandler<ActionEvent>() 
		{ public void handle(ActionEvent event) {
			primaryStage.setScene(OperationScreenScene);
			history1.setText("");
		
		}});
		confirm.setOnAction(new EventHandler<ActionEvent>() 
		{ public void handle(ActionEvent event) {
			String a=amountField.getText();//amount string
			amountField.clear();
			balance.setText("");
amountDeposit.setText("");
validationLabel1.setText("");

			boolean valid1=atm.isNumericArray(a);
			validationLabel1.setText("");
			if(a.isEmpty()) 
			{validationLabel1.setText("Error,Enter a valid amount");}
			else if(valid1) {int am=Integer.parseInt(a);//amount int
			if(am==0) {validationLabel1.setText("Error,Enter a valid amount");}
			else
			if (am < 50 && (am % 10 > 0))
			{validationLabel1.setText("Error,Enter a valid amount");
			
		} else {validationLabel1.setText("");
			float sa;//balance float
			sa=atm.Deposit(am);
			String s;//balance string
			s= String.valueOf(sa);
   ++i; 
   if(i==5) {for(i=4;i>1;i--){history[i-1]=history[i];type[i-1]=type[i];}i=4;}

type[i]="Deposit";
history[i]=a;


balance.setText("balance:"+s);
			amountDeposit.setText("Amount deposited:"+a);

			}}
			else 
			{validationLabel1.setText("Error,Enter a valid amount");
				
			}
			

			}});
		
	
		
			
		}});//end of deposit
	withdraw.setOnAction(new EventHandler<ActionEvent>()
	{ 
		public void handle(ActionEvent event) 
		{primaryStage.setScene(WithdrawScreenScene);
		 balance1.setText("");
			amountWithdraw.setText("");
			validationLabel2.setText("");
		back1.setOnAction(new EventHandler<ActionEvent>() 
		{ public void handle(ActionEvent event) {
			primaryStage.setScene(OperationScreenScene);
			history1.setText("");
		}});
		confirm1.setOnAction(new EventHandler<ActionEvent>() 
		{ public void handle(ActionEvent event) {		
			String a1=amountField1.getText();
			amountField1.clear();
			 balance1.setText("");
				amountWithdraw.setText("");
			boolean valid1=atm.isNumericArray(a1);
			validationLabel2.setText("");
			if(a1.isEmpty()) 
			{validationLabel2.setText("Error,Enter a valid amount");}
			else if(valid1) {int am=Integer.parseInt(a1);
			if(am==0) {validationLabel2.setText("Error,Enter a valid amount");}
			else
			if ((am>atm.getCurrentBalance())||(am < 50 && (am % 10 > 0))) 
			{validationLabel2.setText("Error,Enter a valid amount");
			
		} else {
			float sa;
			sa=atm.Withdraw(am);
			String s;
			s= String.valueOf(sa);
			 ++i; 
			   if(i==5) {for(i=4;i>1;i--){history[i-1]=history[i];type[i-1]=type[i];}i=4;}
			
			type[i]="Withdraw";
			history[i]=a1;
			balance1.setText("balance:"+s);
			amountWithdraw.setText("Amount withdrew:"+a1);
					

			}}
			else 
			{validationLabel2.setText("Error,Enter a valid amount");
				
			}
			
			

		
		

		
			}});
		}});//end of Withdraw
	balanceInquiry.setOnAction(new EventHandler<ActionEvent>()
	{ 
		public void handle(ActionEvent event) 
		{primaryStage.setScene(BalanceScreenScene);			
		Balance.setText(" CurrentBalance: "+(String.valueOf((atm.getCurrentBalance()))));
		 ++i; 
		   if(i==5) {for(i=4;i>1;i--){history[i-1]=history[i];type[i-1]=type[i];}i=4;}

		type[i]="BalanceInquiry";
		history[i]=String.valueOf((atm.getCurrentBalance()));

		back2.setOnAction(new EventHandler<ActionEvent>() 
		{ public void handle(ActionEvent event) {
			primaryStage.setScene(OperationScreenScene);
			history1.setText("");
	
			
		}});
		}});
	next.setOnAction(new EventHandler<ActionEvent>()
	{ 
		public void handle(ActionEvent event) 
		{primaryStage.setScene(OperationScreenScene);
		
		history1.setText("");
		
		if (x>=4) {history1.setText("error");x=4;}
		else
{x++;history1.setText(x+1+":"+type[x]+":"+history[x]);}
		
		}});
	previous.setOnAction(new EventHandler<ActionEvent>()
	{ 
		public void handle(ActionEvent event) 
		{primaryStage.setScene(OperationScreenScene);
		history1.setText("");

		
		if (x<=0) {history1.setText("error");x=-1;}
		else		if (x==1)  {x--;history1.setText(x+1+":"+type[x]+":"+history[x]);x=-1;}
		else
{x--;history1.setText(x+1+":"+type[x]+":"+history[x]);}
		
		}});
		}else {validationLabel.setText("Wrong IdNumber Or Password");};
	
	}
	});

	
	
	}

	
	}



