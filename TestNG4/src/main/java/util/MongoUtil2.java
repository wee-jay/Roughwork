package util;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;

public class MongoUtil2 {

    public static int getOTP(){

        MongoClient mongo = new MongoClient( "service.panther.stage.mintpro.in" , 27017 );

        //***Accessing database
        MongoDatabase database=mongo.getDatabase("authService");

        //***Retreiving collection
        MongoCollection<Document> collection=database.getCollection("otp");
       // System.out.println(collection.count());

        //***To create query parameters
        BasicDBObject www = new BasicDBObject();
        www.put("mobile", "6999912345");

        FindIterable<Document> doc =  collection.find(www);
        Integer otpValue = doc.first().getInteger("otp");

        //Integer value  = collection.find().projection(Projections.include("otp")).first().getInteger("otp");

        return otpValue;

    }

}
