package json.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import databases.ConnectToSqlDB;
import org.bson.json.JsonParseException;

import java.io.*;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.util.*;

public class CnnAPI {
    /*
      You can get API_KEY from this below link. Once you have the API_KEY, you can fetch the top-headlines news.
      https://newsapi.org/s/cnn-api

      Fetch This following CNN API, It will return some news in Json data. Parse this data and construct
      https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=YOUR_API_KEY

      MY_API_KEY=0d9e35dfa3c140aab8bf9cdd70df957f

      After getting Json Format of the news, You can go to json validator link: https://jsonlint.com/ to see
      how it can be parsed.

      "articles": [{
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": null,
		"title": "Who is affected by a shutdown? - CNN Video",
		"description": "CNN's Tom Foreman breaks down who is affected by a federal government partial shutdown.",
		"url": "http://us.cnn.com/videos/politics/2018/12/22/federal-partial-shutdown-by-the-numbers-foreman-ctn-vpx.cnn",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/181202171029-government-shutdown-capitol-file-super-tease.jpg",
		"publishedAt": "2018-12-23T01:09:50.8583193Z",
		"content": "Chat with us in Facebook Messenger. Find out what's happening in the world as it unfolds."
	   },{}]

	   Read the articles array and construct Headline news as source, author, title,description,url,urlToImage,publishedAt
	   and content. You need to design News Data Model and construct headline news.
	   You can store in Map and then into ArrayList as your choice of Data Structure.

	   You can follow How we implemented in Employee and JsonReaderUtil task.

	   Show output of all the headline news in to console.
	   Store into choice of your database and retrieve.

     */
    public static void main(String[] args) {
        String MY_API_KEY="0d9e35dfa3c140aab8bf9cdd70df957f";
        String url = "https://newsapi.org/v2/top-headlines?sources=cnn&apiKey="+MY_API_KEY;
        try {
            List news = ReadingAPI(url);
            storeDataTpMYSQL(news, "News");
            readFromMYSQL("news");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List ReadingAPI(String sURL) throws IOException {
        URL APIurl = new URL(sURL);
        URLConnection request = APIurl.openConnection();
        request.connect();
        JsonArray jsonArray = null, jsonOuterArray = null;
//        JsonObject rootObj = null;
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        if(root instanceof JsonObject){
            JsonObject rootObj = root.getAsJsonObject();
            jsonOuterArray = rootObj.getAsJsonArray("articles");
        }else{
            jsonArray = root.getAsJsonArray();
        }
        System.out.println(jsonOuterArray.size());
        List<Map> news = new ArrayList<Map>();
        for(int i = 0; i< jsonOuterArray.size(); i++){
            try{
                JsonObject jsonObject = jsonOuterArray.get(i).getAsJsonObject();
                String author = jsonObject.get("author").toString();
                String title = jsonObject.get("title").toString();
                String description = jsonObject.get("description").toString();
                String url = jsonObject.get("url").toString();
                String urlToImage = jsonObject.get("urlToImage").toString();
                String publishedAt = jsonObject.get("publishedAt").toString();
                String content = jsonObject.get("content").toString();

                Map article = new HashMap();
                article.put("author",author);
                article.put("title",title);
                article.put("description",description);
                article.put("url",url);
                article.put("urlToImage",urlToImage);
                article.put("publishedAt",publishedAt);
                article.put("content",content);
                news.add(article);
            }catch(Exception ex){
//                ex.printStackTrace();
            }
        }


        for(Map n: news){
            String  t = (String) n.entrySet().toString();
            Set keys = n.keySet();
//            System.out.println(t);
//            for(Object a: n.entrySet()){
//                Map.Entry e = (Map.Entry)a;
//                System.out.println(e.getKey());
//            }
        }
        return news;
    }

    public static void storeDataTpMYSQL(List data, String tableName ) throws SQLException, IOException, ClassNotFoundException {
        Connection connect = ConnectToSqlDB.connectToSqlDatabase();
        PreparedStatement ps = connect.prepareStatement("Drop table if exists `"+tableName+"`;");
        ps.executeUpdate();
        String sql = "create table `"+tableName+"`(ID int(10) not null auto_increment";
        Set keys = null;
        for(Object n : data){
            Map m = (Map)n;
            keys = m.keySet();
        }
        for(Object k : keys){
            String col = ",`"+(String)k+"` varchar(1000) ";
            sql = sql+col;
        }
        sql = sql+", Primary Key(ID));";

//        System.out.println(sql);
        ps = connect.prepareStatement(sql);
        ps.executeUpdate();

        List dbInserts = new ArrayList();
        String colName = "id";
        String colValue = "";
        int id = 1;
        for(Object n : data){
            Map news  = (Map)n;
            colValue = colValue+id;
            for(Object e : news.entrySet()){
                Map.Entry col = (Map.Entry)e;
                colName = colName+","+col.getKey();
                colValue = colValue+","+col.getValue();
            }
            id++;
            String insert = "insert into `"+tableName+"` "+"("+colName+") values ("+colValue+");" ;
            colName = "ID";
            colValue = "";
            dbInserts.add(insert);
//            System.out.println(insert);
        }

        for(Object ins: dbInserts){
            String insert = (String) ins;
            ps = connect.prepareStatement(insert);
            ps.executeUpdate();
        }

    }

    public static void readFromMYSQL(String tableName) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = ConnectToSqlDB.connectToSqlDatabase();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select ID, author, title, description, url, urlToImage, publishedAt, content from "+tableName+"; ");
        List<ArrayList> tableData = new ArrayList<ArrayList>();

        while(rs.next()){
            ArrayList rows = new ArrayList();
            rows.add(rs.getInt("ID"));
            rows.add(rs.getString("author"));
            rows.add(rs.getString("title"));
            rows.add(rs.getString("description"));
            rows.add(rs.getString("url"));
            rows.add(rs.getString("urlToImage"));
            rows.add(rs.getString("publishedAt"));
            rows.add(rs.getString("content"));
            tableData.add(rows);
        }
        System.out.println("--------------------------------------News Data--------------------------------------");
        for(List td: tableData ){
           String ID =  td.get(0).toString();
            System.out.println("--------------------------------------Row Data--------------------------------------");
            System.out.println(ID);
            for(int i = 1; i< td.size(); i++){
                String cell = (String)td.get(i);
                System.out.println(cell);
            }
        }
    }
}
