package util;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DB;
import org.w3c.dom.Document;

public class MongoUtil {

    public static MongoClient mongo;
    private static MongoDatabase db;

    private static MongoCollection collection;
    public static String otpfound;
    public static DBCursor cursor;



    public static void mongoConnnection(){

      MongoUtil.selectionOfConnection("panther");
        //to be fetched from Data driven file or from a method
    }

    public static String getOTP(){
        MongoUtil.mongoConnnection();
        db=mongo.getDatabase("authService");
        collection=  db.getCollection("otp");

        BasicDBObject where = new BasicDBObject();
        where.put("mobile","6999912345");  //to be fetched from Data driven file

        BasicDBObject orderBy = new BasicDBObject();
        orderBy.put("createdAt", -1);

        cursor = (DBCursor) collection.find(where).limit(1);

        FindIterable cur=collection.find().sort(orderBy);

        DBObject recievedData =cursor.next();
        System.out.println("Fetching Otp for: " + where.toString());

        System.out.println(recievedData.get("otp"));
        otpfound = recievedData.get("otp").toString();

        return otpfound;

    }

    public static  void selectionOfConnection(String servername){


        if ("panther".equals(servername)) {
            mongo = new MongoClient("service.panther.stage.mintpro.in", 27017);
        }
        else if ("vision".equals(servername)){
            mongo = new MongoClient("service.vision.stage.mintpro.in",27017);
        }

        MongoUtil.getOTP();

    }



}
