package turtlemint.qa.utility;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class connectmongodb {
	public static MongoClient mongo;
	public static String Flashotp;
	static String serverip;
	protected static DB db;
	protected static MongoDatabase db1;
	protected static DBCollection collection;
	protected static MongoCollection collection1;
	public static String pedreqid;
	protected static DBObject req1;
	
	public static String leadB2C (String pedreqid) throws IOException
	{
		CommanFuntion.loadingconfig();
		mongo = new MongoClient(CommanFuntion.prop.getProperty("RonanB2Cserver"), 27017);
		db = mongo.getDB("hdfcbank");
		collection = db.getCollection("Lead");
		BasicDBObject req = new BasicDBObject("requestIds",pedreqid);
		DBCursor curreq = collection.find(req);
		
		try 
		{
			req1 = curreq.next();
		}
		catch (Exception NoSuchElementException)
		{
			System.out.println("Element was not found. Hence unable to perform any action.");
			
		}
		String leadstage= req1.get("leadStage").toString();
		if (leadstage.isEmpty())
		{
			System.out.println("Lead entry probably was not created");
		}

		return leadstage;
		
	}
	
	
	public static String HealthOrderB2C (String pedreqid) throws IOException
	{
	
		CommanFuntion.loadingconfig();
		DB db = mongo.getDB("hdfcbank");
		DBCollection collection = db.getCollection("HealthOrder");
		BasicDBObject req = new BasicDBObject("requestId",pedreqid);
		DBCursor curreq = collection.find(req);
		DBObject req1 = curreq.next();
		BasicDBObject leadstage= (BasicDBObject) req1.get("healthCheckoutInfo");
		String req2 = leadstage.get("productId").toString();
		System.out.println(leadstage);
		System.out.println("Current info received is : " +req2);
		return req2;
	}
	
	public static String getotp(String loginpageurl) throws IOException
	{
		CommanFuntion.loadingconfig();
		String domain[]=loginpageurl.split("/");
		String server = domain[2].split("[.]")[1];
		connectsanyserver.connectingB2B(server);
		db = connectsanyserver.mongo.getDB("authService");
		collection = db.getCollection("otp");
		BasicDBObject where = new BasicDBObject();
		
	    where.put("mobile", CommanFuntion.prop.getProperty("Mobilenumber"));
	    BasicDBObject orderBy = new BasicDBObject();
	    orderBy.put("createdAt", -1);
	    DBCursor cursor = collection.find(where).sort(orderBy);
		DBObject recievedData = cursor.next();
	    System.out.println("Fetching Otp for: " + where.toString());
		
		if(recievedData.containsField("otp")) 
		{
			System.out.println(recievedData.get("otp"));
			Flashotp = recievedData.get("otp").toString();
		}
		else 
		{
			System.out.println("No otp found in collection. Here is the received data :"+ recievedData);
		}
		return Flashotp;
	}
	
	public static String getB2Cleaddetails (String B2Clead) throws IOException 
	{
		CommanFuntion.loadingconfig();
		mongo = new MongoClient(CommanFuntion.prop.getProperty(""));
		
		return B2Clead;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
//		CommanFuntion.loadingconfig();
//		mongo = new MongoClient(CommanFuntion.prop.getProperty("B2Bserver"), 27017);
//		System.out.println("Connecting to server...");
//			db1 = mongo.getDatabase("authService");
//			collection1 = db1.getCollection("otp");
//		    
//			BasicDBObject where = new BasicDBObject();
//		    where.put("mobile", CommanFuntion.prop.getProperty("Mobilenumber"));
//		    
//		    BasicDBObject orderBy = new BasicDBObject();
//		    orderBy.put("createdAt", -1);
//		    
//		    FindIterable cursor = collection1.find(where).sort(orderBy);
//			
//		    DBObject recievedData = ((DBCursor) cursor).next();
//		    System.out.println("Fetching Otp for: " + where.toString());
//			System.out.println("received value is: " + recievedData.get("otp").toString());
//			if(recievedData.containsField("otp")) 
//			{
//				System.out.println(recievedData.get("otp"));
//				Flashotp = recievedData.get("otp").toString();
//			}
//			else 
//			{
//				System.out.println("no otp found in collection "+ recievedData);
//			}
		    
		
	}

	
}
