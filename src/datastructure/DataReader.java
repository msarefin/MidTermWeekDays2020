package datastructure;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import databases.ConnectToSqlDB;
import org.bson.Document;


import javax.print.Doc;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReader {

	public static void main(String[] args) {
		/*
		 * Use API to read the below textFile and print to console.
		 * Use BufferedReader class.
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */

		String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car";

		List lines =  readingFile(textFile);

		Iterator it = lines.iterator();
		while(it.hasNext()){
			String msg = it.next().toString();
			System.out.println(msg.length()+" :: "+msg);
		}

		System.out.println("----------------------------Writing and Reading from MYSQL Database!!------------------------------");

		writeToMYSQL(lines, "Self_Driving_Car","sentence");
		readFromMYSQL("select * from Self_Driving_Car;");

		System.out.println("----------------------------Writing and Reading from MongoBD Database!!------------------------------");
		writeToMongoDB(lines,"self_driving_car","sentence");
		readingMongoDbDocument("pnt","self_driving_car","sentence");

	}



	public static List readingFile(String fileLocation) {
		System.out.println(fileLocation);
		File file = new File(fileLocation);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			List lines = new ArrayList();
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
			fr.close();
			return lines;
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			System.gc();
		}
		return null;
	}

	public static void writeToMYSQL(List sentences, String tblName, String colname){
		try {
			Connection mysqlConnect = ConnectToSqlDB.connectToSqlDatabase();
			PreparedStatement ps = mysqlConnect.prepareStatement("Drop table if exists "+tblName);
			ps.executeUpdate();
			ps = mysqlConnect.prepareStatement("create table "+tblName+" (ID int(11) not null auto_increment, "+colname+" varchar(300) default null ,primary key(ID) );");
			ps.executeUpdate();
			for(int i = 0; i< sentences.size(); i++) {
				ps = mysqlConnect.prepareStatement("Insert into "+tblName+" ("+colname+") values (?)");
				ps.setString(1,sentences.get(i).toString());
				ps.executeUpdate();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			System.gc();
		}

	}

	public static void readFromMYSQL(String sql){
		try {
			Connection connection = ConnectToSqlDB.connectToSqlDatabase();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			List<ArrayList> table = new ArrayList<ArrayList>();
			while(resultSet.next()){
				ArrayList rows = new ArrayList();
//				rows.add(resultSet.getInt("ID"));
				rows.add(resultSet.getString("sentence"));
				table.add(rows);
			}
			resultSet.close();
			statement.close();
			connection.close();

			Iterator it = table.iterator();
			while(it.hasNext()){
				ArrayList r = (ArrayList) it.next();
				for(int i = 0; i< r.size(); i++){
					System.out.println(r.get(i));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			System.gc();
		}
	}

	public static void writeToMongoDB(List sentences, String collectionName, String DocumentName){
		Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("pnt");
		MongoCollection<Document> collection = database.getCollection(collectionName);

		Document document = new Document();
		collection.deleteMany(document);

		Document sent = new Document();
		for(int i = 0; i< sentences.size(); i++) {
//			document.append("line"+i,sentences.get(i).toString());
			document.put(DocumentName, sent.append("line"+i,sentences.get(i).toString()));
		}
		collection.insertOne(document);

		document.clear();
		client.close();

		System.gc();
	}

	public static void readingMongoDbDocument(String mongoDB, String collectionName, String documentName ){
		Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase(mongoDB);
		MongoCollection<Document> collection = database.getCollection(collectionName);
		BasicDBObject basicDBObject = new BasicDBObject();
		FindIterable<Document> iterable = collection.find(basicDBObject);
		for(Document doc: iterable){
			Document line = (Document) doc.get(documentName);
			for(int i = 0; i< line.size(); i++) {
				String l = (String)line.get("line"+i);
				System.out.println(l);
			}
		}
	}

	public static void toStack(){

	}
}
