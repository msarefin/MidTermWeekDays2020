package datastructure;

import databases.ConnectToSqlDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 * 
		 */

		ArrayList arl = new ArrayList();

		arl.add("Sherlock Holmes");
		arl.add(321);
		arl.add("Baker Street");
		arl.add("London");
		arl.add("UK");


		System.out.println(arl.toString());

		//arl.remove("London");
		try {
			Connection connection = ConnectToSqlDB.connectToSqlDatabase();
			PreparedStatement ps = connection.prepareStatement("drop table if exists arraylist;");
			ps.executeUpdate();
			ps=connection.prepareStatement("create table arraylist(ID int(10) auto_increment primary key,data varchar (100));");
			ps.executeUpdate();
			ps=connection.prepareStatement("insert into arraylist(data) values(?)");

			Iterator it = arl.iterator();

			while(it.hasNext()){
				String data = it.next().toString();
				System.out.println(data);
				ps.setString(1,data);
				ps.executeUpdate();
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
