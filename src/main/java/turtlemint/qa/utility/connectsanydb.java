package turtlemint.qa.utility;

import java.io.IOException;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class connectsanydb {

	protected static DB db;
	public static DBCollection collection;
	static String obj; 
	protected static DBObject lc;
	static String pageurl = "https://pro.hawkeye.planturtle.com/health-insurance/checkout/AFU4KL7F8JK/self_spouse/insurer-details";
	
	public static String B2Chealthorder (String pageurl) throws IOException
	{
		connectsanydb.decider(pageurl);
		collection = switchdb.db.getCollection("HealthOrder");
		String reqid = pageurl.split("/")[5];
		System.out.println("Received requestId as: "+reqid);
		BasicDBObject req = new BasicDBObject("requestId",reqid);
		DBCursor cursor = collection.find(req);
		
		try
			{
				lc = cursor.next();
			}
		
		catch (Exception e)
			{
				System.out.println("Error occured while fetching health order collection.");
			}
		
		System.out.println("Health order for the following is : " +lc.toString());
		return lc.toString();
	}
	
	
	public static String B2CLead (String pageurl) throws IOException
	{
		connectsanydb.decider(pageurl);
		collection = switchdb.db.getCollection("Lead");
		String reqid = pageurl.split("/")[5];
		
		System.out.println("Received requestId as: "+reqid);
		BasicDBObject req = new BasicDBObject("requestIds",reqid);
		DBCursor cursor = collection.find(req);
		
		try
			{
				lc = cursor.next();
			}
		
		catch (Exception e)
			{
				System.out.println("Error occured while fetching Lead collection.");
			}
		
		System.out.println("Lead for the following is : " +lc.toString());
		return lc.toString();
	}
	
	
	public static void policyissuanceB2C (String loginpageurl) throws IOException
	{
		String domain[]= loginpageurl.split("/");
		connectsanydb.decider(loginpageurl);
		collection= switchdb.db.getCollection("PolicyIssuance");
		String reqid = domain[5];
		System.out.println(reqid);
		DBObject dbo = new BasicDBObject("requestId", reqid);
		DBCursor cursor = collection.find(dbo);
		
		try
		{
			lc = cursor.next();
		}
		
		catch(Exception e)
		{
			System.out.println("Error occured while fetching Lead collection.");
		}
		
		System.out.println("Policy Issuance collection :" +lc.toString());
	}
	
	
	
	public static void B2Clogs (String loginpageurl) throws IOException
	{
		
	}
	
	
	// To complete verification of non verified partner
	public static void partnerverification (String dealerid, String url) throws IOException
	{
		String domain[]=url.split("/");
		String str = domain[2];
		String server = str.split("[.]")[1];
		connectsanyserver.connectingB2B(server);
		db = connectsanyserver.mongo.getDB("turtlemint");
		collection = db.getCollection("Partner");
		DBObject obj = new BasicDBObject("_id", new ObjectId(dealerid));
		DBCursor cursor = collection.find(obj);
		System.out.println("Query:  " + obj.toString());
		BasicDBObject update = new BasicDBObject();
		update.append("$set", new BasicDBObject().append("status","verified"));
		collection.update(obj, update);
		System.out.println(cursor.next());
		
		
	}
	
	public static void parnterposp (String dealerid, String url) throws IOException
	{
		String domain[]=url.split("/");
		String str = domain[2];
		String server = str.split("[.]")[1];
		connectsanyserver.connectingB2B(server);
		db = connectsanyserver.mongo.getDB("turtlemint");
		collection = db.getCollection("Partner");
		BasicDBObject update = new BasicDBObject();
		update.append("$set", new BasicDBObject().append("certificateDetails", "a" ));
		
	}
	

	
	public static void decider(String pageurl) throws IOException
	{
		String domain[]=pageurl.split("/");
		String url= domain [2];
		System.out.println("This is url: " +url);
		System.out.println("Url contains HDFC is : " +url.contains("hdfcbank"));
		obj = domain[2].split("[.]")[1];
		System.out.println("Deciding on the basis of:  " +obj);
		String b2cdb = domain[2].split("[.]")[2];
		
		
		if (obj.equals("planturtle"))
			{
				String b2cs = domain[2].split("[.]")[1];
				System.out.println("first "+b2cs);
				connectsanyserver.connectingB2C(b2cs);
				switchdb.switchb2cdatabses(obj);
			}
		else
		{
			if(obj.equals("com"))
				{
					String b2clink = domain[2].split("[.]")[1];
					String b2cdb1 = domain[2].split("[.]")[0];
					System.out.println("second loop "+ b2clink);
					connectsanyserver.connectingB2C(b2cdb1);
					switchdb.switchb2cdatabses(b2clink);
				}
			else
			{
				if (obj.equals("bajajcapitalinsurance"))
					{
						String b2clink = domain[2].split("[.]")[1];
						String b2cdb1 = domain[2].split("[.]")[0];
						System.out.println("third loop " + b2clink);
						connectsanyserver.connectingB2C(b2cdb1);
						switchdb.switchb2cdatabses(b2clink);
					}
				else
				{
					if (obj.equals("hdfcbankinsurance"))
					{
						String b2clink = domain[2].split("[.]")[2];
						System.out.println(b2clink);
						String b2cdb1 = domain[2].split("[.]")[1];
						System.out.println(b2cdb1);
						System.out.println("fourth loop " + b2clink);
						connectsanyserver.connectingB2C(b2cdb1);
						switchdb.switchb2cdatabses(b2clink);
					}
					else
					{
						if (url.contains("hdfcbank"))
						{
							String p []= pageurl.split("/");
							String broker = p[2].split("[.]")[1];
							System.out.println(broker);
							String server = p[2].split("[.]")[2];
							System.out.println(server);
							connectsanyserver.connectingB2C(server);
							switchdb.switchb2cdatabses(broker);
						}
					}
					
				}
			}
			connectsanyserver.connectingB2C(obj);
			switchdb.switchb2cdatabses(b2cdb);
		}
		
	}
	
	
	public static void main (String args[]) throws IOException
	{
		String dealerid = "5da46ce7ae40c49668036c6e";
		String url = "https://pro.hawkeye.planturtle.com/health-insurance/health-profile/profile-hospitals-self/AFU4KL7F8JK";
		connectsanydb.partnerverification(dealerid, url);
		
	}


	public static void B2Cbajajcapital(String loginpageurl) {
		// TODO Auto-generated method stub
		
	}
}
