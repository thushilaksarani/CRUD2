package cli;

import java.sql.SQLException;
import java.util.Scanner;

import dao.impl.AccountDaoImpl;
import dao.impl.PersonDaoImpl;
import domain.Account;
import domain.Person;
import service.Calculation;

public class GetInput {
	static Scanner scan = new Scanner(System.in);
	static double rentalVal, lonAmt, interestRate;
	static int Period;
	String id, fname, lname, email, contNo,accNo;
	 String action, a;
	 double at;
	
	public void inputCal() {
		System.out.println("\nWhat do you need to cal : \n Instalment Value --> 1			"
				+ "Interest Rate --> 2 \n Repayment Period --> 3			Loan Amount --> 4			View Repayment Schedule --> 5");
		int act=scan.nextInt();
		if(act==1){
			inputInstalmentVal();
		}else if(act==2){
			inputInterestRate();
		}else if(act==3){
			inputRepayPeriod();
		}else if(act==4){
			inputLoanAmt();
		}else if(act==5){
			inputRepaySched();
		}else {
			System.out.println("Try Again with Correct Number");
		}
	}
	
	public void inputInterestRate() {
		System.out.print("Enter Instalment / Rental Value : ");
		rentalVal=scan.nextDouble();
		System.out.print("Enter Loan Amount : ");
		lonAmt=scan.nextDouble();
		System.out.print("Enter Repayment Period : ");
		Period=scan.nextInt();
		Calculation.calInterestRate(rentalVal, Period, lonAmt);
	}
	
	public void inputRepayPeriod() {
		System.out.print("Enter Instalment / Rental Value : ");
		rentalVal=scan.nextDouble();
		System.out.print("Enter Loan Amount : ");
		lonAmt=scan.nextDouble();
		System.out.print("Enter Interest Rate in Decimal form : ");
		interestRate=scan.nextDouble();
		Calculation.calRepayPeriod(rentalVal, interestRate, lonAmt);
	}
	
	public void inputLoanAmt() {
		System.out.print("Enter Instalment / Rental Value : ");
		rentalVal=scan.nextDouble();
		System.out.print("Enter Interest Rate in Decimal form : ");
		interestRate=scan.nextDouble();
		System.out.print("Enter Repayment Period : ");
		Period=scan.nextInt();
		Calculation.calLoanAmt(rentalVal, interestRate, Period);
	}
	
	public void inputInstalmentVal() {
		System.out.print("Enter Interest Rate in Decimal form : ");
		interestRate=scan.nextDouble();
		System.out.print("Enter Loan Amount : ");
		lonAmt=scan.nextDouble();
		System.out.print("Enter Repayment Period : ");
		Period=scan.nextInt();
		rentalVal=Calculation.calInstalmentVal(lonAmt, interestRate, Period);
		PrintOutput.printInstalmentVal(rentalVal);
		permission(rentalVal);
	}
	
	public void inputRepaySched() {
		System.out.print("Enter Interest Rate in Decimal form : ");
		interestRate=scan.nextDouble();
		System.out.print("Enter Loan Amount : ");
		lonAmt=scan.nextDouble();
		System.out.print("Enter Repayment Period : ");
		Period=scan.nextInt();
		Calculation.calInstalmentVal(lonAmt, interestRate, Period);
		Calculation.calRepaySch(lonAmt, interestRate, Period);
	}
	
	@SuppressWarnings("resource")
	public void  permission(double instAmt) {
		Scanner scan = new Scanner(System.in);
		System.out.print(" Do you need to view Repayment shedule ? yes / no : ");
		if((scan.nextLine()).equals("yes")) {
			Calculation.calRepaySch(lonAmt, interestRate, Period);
		}
		System.out.print("\n Do you need to save ? yes / no : ");
		a=scan.nextLine();
		if(a.equals("yes")) {
			inputInsertAccount(instAmt);	
		}else {
			System.out.println("Ok, Thank you");
		}
	}
	
	@SuppressWarnings("resource")
	public void inputCrudOperationForAccount()  {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nDo you need to do Advanced operations in Account Table ? yes / no : ");
		action=scan.nextLine();
		if(action.equals("yes")){
			System.out.print("Select the operation (update /select /selectAll /delete) : ");
			action=scan.nextLine();
			if(action.equals("update")){
				inputUpdateAccount();
			}else if(action.equals("select")){
				inputSelectAccount();
			}else if(action.equals("selectAll")){
				inputSelectAllAccount();
			}else if(action.equals("delete")){
				inputDeletAccount();
			}else {
				System.out.println("Enter correct operation ! ");
			}
		}else {
			System.out.println("Thank you !");
		}
		System.out.println("");
	}
	
	
	@SuppressWarnings("resource")
	private static void inputInsertAccount(double instAmt) {
		Scanner scan = new Scanner(System.in);
		Account a1=new Account();
		System.out.print("Enter Account Number : ");
		a1.setAccnum(scan.nextLine());
		System.out.print("Enter ID Number : ");
		a1.setPid(scan.nextLine());
		a1.setInstAmt(instAmt);
		a1.setTotAmt(lonAmt);
		a1.setPeriod(Period);
		a1.setRate(interestRate);
		AccountDaoImpl ad1=new AccountDaoImpl();
		try {
			ad1.insertAccount(a1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	private void inputDeletAccount() {
		Account a1=new Account();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Account Number : ");
		a1.setAccnum(scan.nextLine());
		AccountDaoImpl ad1=new AccountDaoImpl();
		try {
			ad1.deleteAccount(a1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private void inputSelectAllAccount() {
		Account a1=new Account();
		a1.setAccnum(accNo);
		AccountDaoImpl ad1=new AccountDaoImpl();
		try {
			ad1.selectAllAccount(a1);
		}catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@SuppressWarnings("resource")
	private  void inputSelectAccount() {
		Account a1=new Account();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Account Number : ");	
		a1.setAccnum(scan.nextLine());
		AccountDaoImpl ad1=new AccountDaoImpl();
		try {
			ad1.selectAccount(a1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("resource")
	private void inputUpdateAccount() {
		Scanner scan = new Scanner(System.in);
		Account a1=new Account();
		System.out.print("Enter Account Number : ");
		a1.setAccnum(scan.nextLine());
		System.out.print("Enter Interest Rate in Decimal form : ");
		interestRate=scan.nextDouble();
		a1.setRate(interestRate);
		System.out.print("Enter Loan Amount : ");
		lonAmt=scan.nextDouble();
		a1.setTotAmt(lonAmt);
		System.out.print("Enter Repayment Period : ");
		Period=scan.nextInt();
		a1.setPeriod(Period);
		rentalVal=Calculation.calInstalmentVal(lonAmt, interestRate, Period);
		PrintOutput.printInstalmentVal(rentalVal);
		a1.setInstAmt(rentalVal);
		AccountDaoImpl ad1=new AccountDaoImpl();
		try {
			ad1.updateAccount(a1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inputActionForPerson() {
		System.out.print("What do you need to do in person table (insert /update /select /selectAll /delete/ deleteAll) : ");
		action=scan.nextLine();
		
		if(action.equals("insert")){
			inputInsertPerson();
			
		}else if(action.equals("update")){
			inputUpdatePerson();
			
		}else if(action.equals("select")){
			inputSelectPerson();
			
		}else if(action.equals("selectAll")){
			inputSelectAllPerson();
		
		}else if(action.equals("delete")){
			inputDeletePerson();
			
		}else if(action.equals("deleteAll")){
			inputDeleteAllPerson();
			
		}else {
			System.out.println("Enter Again");	
		}
	}
	
	public void inputInsertPerson() {
		System.out.print("Enter Id : ");
		id=scan.nextLine();
		System.out.print("Enter First name : ");
		fname=scan.nextLine();
		System.out.print("Enter Last name : ");
		lname=scan.nextLine();
		System.out.print("Enter Email : ");
		email=scan.nextLine();
		System.out.print("Enter Contact number : ");
		contNo=scan.nextLine();
		
		Person p1=new Person(id, fname, lname, email, contNo);
		PersonDaoImpl pd1=new PersonDaoImpl();
		try {
			pd1.insertPerson(p1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inputUpdatePerson() {
		System.out.print("Enter Id : ");
		id=scan.nextLine();
		System.out.print("Enter Email : ");
		email=scan.nextLine();
		System.out.print("Enter Contact number : ");
		contNo=scan.nextLine();
		
		Person p1=new Person();
		p1.setId(id);
		p1.setEmail(email);
		p1.setContactNo(contNo);
		PersonDaoImpl pd1=new PersonDaoImpl();
		try {
			pd1.updatePerson(p1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inputSelectPerson() {
		System.out.print("Enter Id : ");
		id=scan.nextLine();
			
		Person p1=new Person();
		p1.setId(id);
		PersonDaoImpl pd1=new PersonDaoImpl();
		try {
			pd1.selectPerson(p1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inputSelectAllPerson() {	
		Person p1=new Person();
		PersonDaoImpl pd1=new PersonDaoImpl();
		try {
			pd1.selectAllPerson(p1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inputDeletePerson() {
		System.out.print("Enter Id : ");
		id=scan.nextLine();
			
		Person p1=new Person();
		p1.setId(id);
		PersonDaoImpl pd1=new PersonDaoImpl();
		try {
			pd1.deletePerson(p1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inputDeleteAllPerson() {
		Person p1=new Person();
		PersonDaoImpl pd1=new PersonDaoImpl();
		try {
			pd1.deleteAllPerson(p1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}



