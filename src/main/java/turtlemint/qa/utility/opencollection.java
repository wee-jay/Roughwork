package turtlemint.qa.utility;

import java.io.IOException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class opencollection 
{
	public static String B2Cleadcollection (String server, String loginpageurl)
	{
		try {
			connectsanyserver.connectingB2C(server);
		} catch (IOException e) {
			e.printStackTrace();
		}
		connectsanydb.B2Cbajajcapital(loginpageurl);
		DBCollection db = null;
		DBCollection collection = db.getCollection("Lead");
		Object pedreqid = null;
		BasicDBObject req = new BasicDBObject("requestIds",pedreqid);
		DBCursor curreq = collection.find(req);
		
		DBObject req1 = null;
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

}
