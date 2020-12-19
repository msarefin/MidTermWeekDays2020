package databases;

import com.mongodb.client.MongoDatabase;

public class UnitTestConnectDB {
    public static void main(String[] args) {
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        MongoDatabase mongoDatabase = new ConnectToMongoDB().connectToMongoDB();

    }
}
