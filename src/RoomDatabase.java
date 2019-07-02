import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RoomDatabase{

	
	
	public static MongoClientURI mongoClientURI;
	public static MongoClient mongoClient;
	public static MongoDatabase database;
	public static MongoCollection employeeCollection;
	public static MongoCollection scheduleCollection;
	public static MongoCollection meetingCollection;
	public static MongoCollection roomCollection;
	
	public RoomDatabase() {
		String uri = "mongodb+srv://Admin:admin@meetingscheduler-rok4p.mongodb.net/test";
		mongoClientURI = new MongoClientURI(uri);
		mongoClient = new MongoClient(mongoClientURI);
		database = mongoClient.getDatabase("EmployeeDatabase");	//if it doesn't exist, mongodb creates it
		employeeCollection = database.getCollection("Employee");	//if it doesn't exist, mongodb creates it
		scheduleCollection = database.getCollection("Schedules");
		roomCollection = database.getCollection("Room");
	}
	
	
	public void AddEntry(Room entryInfo) {
		
		Document room = new Document("roomNumber", entryInfo.getRoomnumber());
        room.append("availability", entryInfo.getAvailability());

                
        roomCollection.insertOne(room);
        
	}
	
	public boolean FindEntry(int roomNumber) {
		
		Document found = (Document) roomCollection.find(new Document("roomNumber", roomNumber)).first();
		if(found != null) {
			return true;
		}		
		
		return false;
	}
	
	public void UpdateAvailability(int roomNumber, boolean available) {
		
		Document found = (Document) roomCollection.find(new Document("roomNumber", roomNumber)).first();
		if(found != null) {
			Bson updatedValue = new Document("availability", available);
			Bson updatedOperation = new Document("$set", updatedValue);
			roomCollection.updateOne(found, updatedOperation);
		}
		
	}
	
	public void UpdateRoomNumber(int roomNumber) {
		
		Document found = (Document) roomCollection.find(new Document("roomNumber", roomNumber)).first();
		if(found != null) {
			Bson updatedValue = new Document("roomNumber", roomNumber);
			Bson updatedOperation = new Document("$set", updatedValue);
			roomCollection.updateOne(found, updatedOperation);
		}
		
	}
	
	public void DeleteEntry(int roomNumber) {
		Document found = (Document) roomCollection.find(new Document("roomNumber", roomNumber)).first();
		if(found != null) {
			roomCollection.deleteOne(found);
		} else {
			System.out.println("Room does not exist!");
		}
	}
	
	//close the connection after accessing the database
	public void Close() {
		mongoClient.close();
	}
	
	
	
}
