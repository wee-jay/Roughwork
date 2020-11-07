package turtlemint.qa.utility;

import java.io.IOException;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.WriteResult;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class connectsanyserver {
	public static MongoClient mongo;
	
	public static void connectingB2B(String server) throws IOException
	{
		CommanFuntion.loadingconfig();
		switch (server)
		{
			case "ronan":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("RonanB2Bserver"), 27017);
				break;
			}
			
			case "got":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("GotB2Bserver"), 27017);
				break;
			}
			
			case "ironman":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("IronmanB2Bserver"), 27017);
				break;
			}
			
			case "aquaman":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("AquamanB2Bserver"), 27017);
				break;
			}
			
			case "hdfc":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("HDFCB2Bserver"), 27017);
				break;
			}
			
			case "flash":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("FlashB2Bserver"), 27017);
				break;
			}
			
			case "hawkeye":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("HAWKEYEB2Bserver"), 27017);
				break;
			}
			
			case "ghost":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("GHOSTB2Bserver"), 27017);
				break;
			}
			
			case "neon":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("NEONB2Bserver"), 27017);
				break;
			}
		}	
	}
	
	
	public static void connectingB2C(String server) throws IOException
	{
		CommanFuntion.loadingconfig();
		switch (server)
		{
			case "ronan":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("RonanB2Cserver"), 27017);
				break;
			}
			
			case "got":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("GotB2Cserver"), 27017);
				break;
			}
			
			case "ironman":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("IronmanB2Cserver"), 27017);
				break;
			}
			
			case "aquaman":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("AquamanB2Cserver"), 27017);
				break;
			}
			
			case "hdfc":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("HDFCB2Cserver"), 27017);
				break;
			}
			
			case "flash":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("FlashB2Cserver"), 27017);
				break;
			}
			

			case "hawkeye":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("HAWKEYEB2Cserver"), 27017);
				break;
			}
			
			case "ghost":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("GHOSTB2Cserver"), 27017);
				break;
			}
			
			case "neon":
			{
				mongo = new MongoClient(CommanFuntion.prop.getProperty("NEONB2Cserver"), 27017);
				break;
			}
		}	
	}
	
	public static void closerlowestnumber()
	{
		int lowestclosest[]= {4, 8, 5, 2, 4, 3, 1};
		int j;
		System.out.println(lowestclosest.length-1);
		int a=0;
		while (a < lowestclosest.length-1)
		{
			a++;
			}
		
	}
	
	
	
	
	public static void main (String args[]) throws IOException
	
	{
//		connectsanyserver.connectingB2C("hawkeye");
//		connectsanyserver.prodotp();
//		closerlowestnumber();
	}
	

	
	public static void prodotp ()
	{
		//mongo = new MongoClient("13.126.78.94", 27017);
		mongo = new MongoClient(new MongoClientURI("mongodb://mintAuthRead:bWludEF1dGhSZWFk@13.126.78.94/authService"));
		System.out.println("MOngo" + mongo);
		//String s = "bWludEF1dGg=";
		//MongoCredential credential = MongoCredential.createCredential("mintAuth", "authService", s.toCharArray());
		//credential.getAuthenticationMechanism();
		DB js = mongo.getDB("authService");
		ReadPreference.primary();
		
		BasicDBObject req = new BasicDBObject("mobile", "8767510435");
		BasicDBObject orderBy = new BasicDBObject("createdAt", -1);
		DBCollection collection = js.getCollection("otp");
		
		DBCursor cursor = collection.find(req).sort(orderBy);
		System.out.println(cursor.toString());
		//System.out.println("Credentials are as follows: "+ "\n" +credential);
		DBObject otpc = cursor.next();
		System.out.println("collection:  " + otpc);
	}
}
