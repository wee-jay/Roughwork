package turtlemint.qa.utility;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public class switchdb {
	
	public static DB db;
		
	public static void switchb2cdatabses(String b2cdb)
	{
		switch (b2cdb)
		{
			
			case "hdfcbank":
			{
				db = connectsanyserver.mongo.getDB("hdfcbank");
				break;
			}
			
			case "hdfcbankinsurance":
			{
				db = connectsanyserver.mongo.getDB("hdfcbank");
				break;
			}
			
			case "app":
			{
				db = connectsanyserver.mongo.getDB("turtlemint");
				break;
			}
			
			case "getquote":
			{
				db = connectsanyserver.mongo.getDB("bajajcapital");
				break;
			}
			
			case "planturtle":
			{
				db = connectsanyserver.mongo.getDB("turtlemint");
				break;
			}
		}
	}

}
