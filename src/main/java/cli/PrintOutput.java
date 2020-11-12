package cli;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintOutput {

	public void firstSection() {
		
	}
	
	public static void printInstalmentVal(double instalVal) {
		//System.out.println("Instalment Value : "+ new DecimalFormat("#.##").format(instalVal));
		System.out.println("Instalment Value : "+ instalVal);
		System.out.println("==================================\n");		
	}
	
	public static void printInterestRate(double rate) {
		System.out.println("Interest Rate : "+ rate);
		System.out.println("==================================\n");
	}
	
	public static void printRepayPeriod(double period){
		System.out.println("Repayment Period : "+ period);
		System.out.println("==================================\n");
	}
	
	public static void printLoanAmt(double loanAmt) {
		System.out.println("Loan Amount : "+ loanAmt);
		System.out.println("==================================\n");
	}
	
	public static void printRepaySched1(double loanAmt) {
		System.out.println("\n \t\t\t\t Repayment Schedule ");
		System.out.println(" \t\t\t----------------------------------\n");
		System.out.println("Rental No\tRental Value\tInterest Amount\t	Capital Amount\t   Capital Balance");
		System.out.println("0 \t\t 0 \t\t\t 0 \t\t 0 \t\t\t " + loanAmt);
	}
	
	public static void printRepaySched2(int i, double instalmentVal, double interestAmt, double capitalAmt, double capitalBalnce) {
		System.out.println(i +"\t\t" + instalmentVal + "\t\t" + interestAmt + "\t\t" + capitalAmt + "\t\t" + capitalBalnce);
	}
	
	public static void printSeletPersonDetails(ResultSet r) {
		try {
			while (r.next()) {
				System.out.println("ID : "+r.getString(1)+"\n"+"Full Name : "+r.getString(2)+" "+r.getString(3)+"\n"+"Email : "+r.getString(4)+"\n"+"Contac No : "+r.getString(5));
				System.out.println(" ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void printSuccess(String act) {
		System.out.println("Successfully "+act);
	}
	
	public static void printSeletAccountDetails(ResultSet r) {
		try {
			while (r.next()) {
				System.out.println("Account Number : "+r.getString(1)+"\n"+"Owner's ID : "+r.getString(2)+"\n"+"Loan Amount : "+r.getDouble(3)+"\n"+"Repayment Period : "+r.getInt(4)+"\n"+"Interest Rate : "+r.getDouble(5)+"\n"+"Instalment Amount : "+r.getDouble(6));
				System.out.println(" ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

