package math.problems;

import databases.ConnectToSqlDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

	public static void main(String[] args) {
		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */

//		System.out.println(listPrime(1000000));

//		printPrime(1000000);
		nthPrime(100);
		StorePrimetoMYSQL(listPrime(1000000), "PrimeNumberList", "Prime_number");
	}

	public static void nthPrime(int nth){
		int n = 0;
		int c = 0;
		int p = 0;
		while(c<nth){
			if(isPrime(n)==true){
//				System.out.println((c+1)+" : "+n);
				c++;
				p = n;
			}
			n++;
		}
		System.out.println(c+"th prime number is "+p);
	}

	public static void printPrime(int range){
		int n = 0;

		while(n<=range){
			if(isPrime(n)== true){
				System.out.println(n);
			}
			n++;
		}
	}

	public static List listPrime(int range){
		int n = 0;
		List primeList = new ArrayList();
		while(n<=range){
			if(isPrime(n)== true){
				primeList.add(n);
			}
			n++;
		}
		return primeList;
	}

	public static boolean isPrime(int n){
		if(n<=1){
			return false;
		}
		for(int i = 2; i<=n/2; i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}

	public static void StorePrimetoMYSQL(List primeList, String tableName, String ColumnName){
		try {
			Connection connection = ConnectToSqlDB.connectToSqlDatabase();
			PreparedStatement ps = connection.prepareStatement("Drop table if exists "+tableName+";");
			ps.executeUpdate();
			ps = connection.prepareStatement("Create Table "+tableName+"(`ID` int(11) not null auto_increment, `"+ColumnName+"` int(10))");
			ps.executeUpdate();
			for(int i = 0; i < primeList.size(); i++){
				ps = connection.prepareStatement("Insert into "+tableName+"(ID,"+ColumnName+" values );");
			}


		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
