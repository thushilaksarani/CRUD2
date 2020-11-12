package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import cli.GetInput;
import cli.PrintOutput;

public class Calculation extends GetInput {
	
	public static double loanAmt, interestRate,instalmentVal, rate;
	static	int repayPeriod;
	
	
		public Calculation(){
			
		}
		
		public Calculation(double loanAmt, double interestRate, int repayPeriod) {
			Calculation.loanAmt = loanAmt;
			Calculation.interestRate = interestRate;
			Calculation.repayPeriod = repayPeriod;
		}

		public static double calInstalmentVal(double loanAmt, double interestRate, int repayPeriod) {
			instalmentVal= (loanAmt*(interestRate/12))/(1-(Math.pow((1+interestRate/12), (-repayPeriod))));
			instalmentVal=bigDecimal(instalmentVal);
			return instalmentVal;
		}
		
		public static void calRepaySch(double loanAmt, double interestRate, int repayPeriod) {

			double interestAmt,capitalAmt;
			double capitalBalnce=loanAmt;
		
			PrintOutput.printRepaySched1(loanAmt);
			
			for(int i=1; i<=repayPeriod; i++) {
				interestAmt=capitalBalnce*interestRate/12;
				capitalAmt=instalmentVal-interestAmt;
				capitalBalnce=capitalBalnce-capitalAmt;
				
				interestAmt=bigDecimal(interestAmt);
				capitalAmt=bigDecimal(capitalAmt);
				capitalBalnce=bigDecimal(capitalBalnce);
				
				PrintOutput.printRepaySched2(i, instalmentVal, interestAmt, capitalAmt, capitalBalnce);
				
			}
		}
		

		public static void calInterestRate(double rentalVal, int Period, double lonAmt) {
			 rate = ((12*((rentalVal*Period)-lonAmt)*((95*Period)+9))/(12*Period*(Period+1)*(4*lonAmt+((rentalVal*Period)-lonAmt))));
			 rate = bigDecimal(rate);
			 PrintOutput.printInterestRate(rate);
		}
		
		public static void calRepayPeriod(double rVal, double rate, double lonAmt) {
			double per=Math.log10(rVal/(rVal-(lonAmt*rate/12)))/Math.log10(1+rate/12);
			per = bigDecimal(per);
			PrintOutput.printRepayPeriod(per);
		}
		
		public static void calLoanAmt(double rVal, double rate, int period) {
			double LoanAmt=rVal*(1-(1/Math.pow((1+rate/12),(period))))/(rate/12);
			LoanAmt=bigDecimal(LoanAmt);
			PrintOutput.printLoanAmt(LoanAmt);
		}
		
		public static double bigDecimal(double val) {
			BigDecimal bd = new BigDecimal(val).setScale(2, RoundingMode.HALF_UP);
			return bd.doubleValue();
		}

	
}
