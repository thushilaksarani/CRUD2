package domain;

public class Account {

	 String accnum, pid;
	 double totAmt, rate, instAmt;
	 int period;
	
	public Account() {
		
	}
	 
	public Account(String accnum, String pid, double totAmt, double rate, int period, double instAmt) {
		this.accnum = accnum;
		this.pid = pid;
		this.totAmt = totAmt;
		this.rate = rate;
		this.period = period;
		this.instAmt = instAmt;
	}

	public String getAccnum() {
		return accnum;
	}

	public  void setAccnum(String accnum) {
		this.accnum = accnum;
	}

	public String getPid() {
		return pid;
	}

	public  void setPid(String pid) {
		this.pid = pid;
	}

	public double getTotAmt() {
		return totAmt;
	}

	public  void setTotAmt(double totAmt) {
		this.totAmt = totAmt;
	}

	public double getRate() {
		return rate;
	}

	public  void setRate(double rate) {
		this.rate = rate;
	}

	public int getPeriod() {
		return period;
	}

	public  void setPeriod(int period) {
		this.period = period;
	}

	public double getInstAmt() {
		return instAmt;
	}

	public  void setInstAmt(double instAmt) {
		this.instAmt = instAmt;
	}

	
	 
}
