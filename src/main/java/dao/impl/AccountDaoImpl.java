package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cli.PrintOutput;
import connections.JDBCconnection;
import domain.Account;

public class AccountDaoImpl {
  
	private final String insertSql = "INSERT INTO account(accnum, pid, totamt, repayperiod, rate, instamt) VALUES(?,?,?,?,?,?)";
	private final String updateSql = "UPDATE account SET totamt=?, repayperiod=?, rate=?, instamt=? WHERE accnum=?" ;
	private final String selectSql = "SELECT accnum, pid, totamt, repayperiod, rate, instamt FROM account WHERE accnum=? ";
	private final String selectAllSql = "SELECT * FROM account";
	private final String deleteSql = "DELETE FROM account WHERE accnum=?";
	private final String deleteAllSql = "DELETE FROM account";
	Connection con;
	PreparedStatement ps;
	
	public void insertAccount(Account a) throws SQLException {
		 
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
			ps=con.prepareStatement(insertSql);
			ps.setString(1,a.getAccnum());
			ps.setString(2,a.getPid());
			ps.setDouble(3,a.getTotAmt());
			ps.setInt(4,a.getPeriod());
			ps.setDouble(5,a.getRate());
			ps.setDouble(6,a.getInstAmt());
			ps.execute();
		 	
			PrintOutput.printSuccess("Inserted");
			con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
		}	 
	
	 public void updateAccount(Account a) throws SQLException {
		
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
		ps=con.prepareStatement(updateSql);	
		ps.setDouble(1,a.getTotAmt());
		ps.setInt(2,a.getPeriod());
		ps.setDouble(3,a.getRate());
		ps.setDouble(4,a.getInstAmt());
		ps.setString(5,a.getAccnum());
		ps.execute();
		
		PrintOutput.printSuccess("Updated");
		con.commit();
	 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
}

	 public void selectAccount(Account a) throws SQLException {
			
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
			ps=con.prepareStatement(selectSql);
			ps.setString(1,a.getAccnum());
			ResultSet r = ps.executeQuery();
			PrintOutput.printSeletAccountDetails(r);
			
			con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
		}

	 public void selectAllAccount(Account a) throws SQLException {
			
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
			ps=con.prepareStatement(selectAllSql);
			//ps.setString(1,a.getAccnum());
			ResultSet r = ps.executeQuery();
			PrintOutput.printSeletAccountDetails(r);
			
			
			con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
			
		}

	 public void deleteAccount(Account a) throws SQLException {
			
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
		 ps=con.prepareStatement(deleteSql);
		 ps.setString(1,a.getAccnum());
			ps.execute();
			
			PrintOutput.printSuccess("Deleted");
			con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
		}

	 public void deleteAllAccount(Account a) throws SQLException {
			
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
		 ps=con.prepareStatement(deleteAllSql);
			ps.execute();
			
			PrintOutput.printSuccess("Deleted All Records");
			con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
		}
	
}
