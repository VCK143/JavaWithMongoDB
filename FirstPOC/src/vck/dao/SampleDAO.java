package vck.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import vck.pojo.MyDetails;

public class SampleDAO {
	public static void main(String[] args) {
		// SampleDAO.retriveDataMongo();
	}

	@SuppressWarnings("deprecation")
	public static DB getConnection() {
		DB db = null;
		try {
			@SuppressWarnings("resource")
			MongoClient mongo = new MongoClient("localhost", 27017);
			db = mongo.getDB("MyDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db;
	}

	public static int insertDataMongo(MyDetails info) {
		int status = 0;
		try {
			DB db = SampleDAO.getConnection();
			DBCollection table = db.getCollection("Java Collection");
			BasicDBObject document = new BasicDBObject();
			document.put("Name", info.getName());
			document.put("Age", info.getAge());
			document.put("Qualification", info.getQual());
			table.insert(document);
			status = document.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<MyDetails> retriveDataMongo() {
		List<MyDetails> list = new ArrayList<MyDetails>();
		try {
			DB db = SampleDAO.getConnection();
			DBCollection table = db.getCollection("Java Collection");
			DBCursor cursor = table.find();
			DBObject obj = null;
			while (cursor.hasNext()) {
				MyDetails details = new MyDetails();
				obj = cursor.next();
				details.setName(obj.get("Name").toString());
				details.setAge(Integer.parseInt(obj.get("Age").toString()));
				details.setQual(obj.get("Qualification").toString());
				list.add(details);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static MyDetails getMyDetailsByName(String Name) {
		MyDetails details = new MyDetails();
		try {
			DB db = SampleDAO.getConnection();
			DBCollection table = db.getCollection("Java Collection");
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("Name", Name);
			DBCursor cursor = table.find(whereQuery);
			DBObject obj = null;
			while (cursor.hasNext()) {
				obj = cursor.next();
				details.setName(obj.get("Name").toString().trim());
				details.setAge(Integer.parseInt(obj.get("Age").toString()));
				details.setQual(obj.get("Qualification").toString().trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}

	public static int updateDataMongo(MyDetails info) {
		int status = 0;
		try {
			DB db = SampleDAO.getConnection();
			DBCollection table = db.getCollection("Java Collection");
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("Name", info.getName());
			newDocument.put("Age", info.getAge());
			newDocument.put("Qualification", info.getQual());
			table.update(new BasicDBObject().append("Name", info.getName()), newDocument);

			status = newDocument.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static void deleteDataMongo(MyDetails info) {
		try {
			DB db = SampleDAO.getConnection();
			DBCollection table = db.getCollection("Java Collection");
			BasicDBObject document = new BasicDBObject();
			document.put("Name", info.getName());
			table.remove(document);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
