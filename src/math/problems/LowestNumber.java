package math.problems;

import algorithm.Sort;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import databases.ConnectToSqlDB;
import databases.ConnectToMongoDB;
import org.apache.poi.hssf.record.DConRefRecord;
import org.bson.Document;


import javax.print.Doc;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LowestNumber {

	public static void main(String[] args) {
		/*
		 * Write java solution to find the lowest number from this array.
		 * Use one of the databases from mysql or mongodb to store and to retrieve.
		 */
		int  array[] = new int[]{211,110,99,34,67,89,67,456,321,456,78,90,45,32,56,78,90,54,32,123,67,5,679,54,32,65};

		//find lowest number from the array

		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		List<String> lowestValue = new ArrayList<String>();
		lowestValue.add(Integer.toString(getLowestNumber(array)));
		int [] lo = new int[lowestValue.size()];
		for(int i =0; i< lowestValue.size(); i++){
			lo[i] = Integer.parseInt(lowestValue.get(i));
		}
		try {
			connectToSqlDB.insertDataFromArrayToSqlTable(lo, "tbl_lowestNumber", "column_lowestNumber");
			lowestValue = connectToSqlDB.readDataBase("tbl_lowestNumber", "column_lowestNumber");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Data is reading from the Table (tbl_lowestNumber) and displaying to the console");
		for(String st:lowestValue){
			System.out.println(st);
		}

//		MongoDB Data Input
		Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
		String mongoDBname = "pnt";
		String mongoCollectionName = "tbl_lowestNumber";

		try{
			MongoClient mongo = new MongoClient();
			MongoDatabase mongoDatabase = mongo.getDatabase(mongoDBname);
			MongoCollection mongoCollection = mongoDatabase.getCollection(mongoCollectionName);
			Document document = new Document();
			mongoCollection.deleteMany(document);
			for(int i = 0; i< lo.length; i++){
				document.append("ID", i).append("LowestNumber",lo[i]);
				mongoCollection.insertOne(document);
			}

			FindIterable<Document> doc = mongoCollection.find(new BasicDBObject());
			for(Document dc :doc){
				int str = (Integer) dc.get("LowestNumber");
				System.out.println("Retreived from MongoDB-->"+str);
			}


		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static int getLowestNumber(int [] arr) {
		new Sort().insertionSort(arr);
		int lo = arr[0];
		return  lo;
	}






}
