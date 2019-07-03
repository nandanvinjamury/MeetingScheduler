import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class EmployeeDatabase{

	
	
	public static MongoClientURI mongoClientURI;
	public static MongoClient mongoClient;
	public static MongoDatabase database;
	public static MongoCollection employeeCollection;
	public static MongoCollection scheduleCollection;
	public static MongoCollection meetingCollection;
	public static MongoCollection roomCollection;
	
	public EmployeeDatabase() {
		String uri = "mongodb+srv://Admin:admin@meetingscheduler-rok4p.mongodb.net/test";
		mongoClientURI = new MongoClientURI(uri);
		mongoClient = new MongoClient(mongoClientURI);
		database = mongoClient.getDatabase("EmployeeDatabase");	//if it doesn't exist, mongodb creates it
		employeeCollection = database.getCollection("Employee");	//if it doesn't exist, mongodb creates it
		scheduleCollection = database.getCollection("Schedules");
	}
	
	
	public void AddEntry(Employee entryInfo) {
		
		Document employee = new Document("username", entryInfo.getUsername());
        employee.append("password", entryInfo.getPassword());
       

        /*long[] meetingIDs = new long[entryInfo.getSchedule().getMeetings().length > 0 ? entryInfo.getSchedule().getMeetings().length : 1];
        
        if(meetingIDs != null) {
	        for(int i=0; i<meetingIDs.length;i++) {
	        	if(entryInfo.getSchedule().getMeetings()[i] != null)
	        		meetingIDs[i] = entryInfo.getSchedule().getMeetings()[i].getID();
	        }
        }
        
        Document meetings = new Document("id", meetingIDs);
        
        
        Document schedule = new Document("meetings", meetings);
        
        //if(schedule != null)
        int[] array = {0,1,2,3,4};
        schedule.append("schedule",array);
        */
        
        employeeCollection.insertOne(employee);
        //employeeCollection.insertOne(schedule);
	}
	
	public boolean FindEntry(String username) {
		
		Document found = (Document) employeeCollection.find(new Document("username", username)).first();
		if(found != null) {
			return true;
		}		
		
		return false;
	}
	
	
	public void UpdatePassword(String username, String password) {
		
		Document found = (Document) employeeCollection.find(new Document("username", username)).first();
		if(found != null) {
			Bson updatedValue = new Document("password", password);
			Bson updatedOperation = new Document("$set", updatedValue);
			employeeCollection.updateOne(found, updatedOperation);
		}
		
	}
	
	
	
	public void DeleteEntry(String username) {
		Document found = (Document) employeeCollection.find(new Document("username", username)).first();
		if(found != null) {
			employeeCollection.deleteOne(found);
		} else {
			System.out.println("Employee not found in system!");
		}
	}
	
	//close the connection after accessing the database
	public void Close() {
		mongoClient.close();
	}
	
	
	public static void main(String[] args) {
		Employee man = new Employee();
		Schedule schedule = new Schedule();
		Meeting meeting = new Meeting();
		Room room = new Room(0);
		
		room.setRoomNumber(5);
		room.setAvailability(true);
		
		
		
		man.changeUsername("JohnSmith");
		man.changePassword("password");
		
		//meeting.forceEmployee(man);
		//meeting.changeRoom(room);
		//meeting.changeStartTime(12);
		//meeting.changeEndTime(14);
		//meeting.changeOwner(man);
		
		//schedule.addMeeting(meeting);
		
		
		man.changeSchedule(schedule);
		
		Employee man2 = new Employee();
		Schedule schedule2 = new Schedule();
		Meeting meeting2 = new Meeting();
		Room room2 = new Room(0);
		
		room.setRoomNumber(6);
		room.setAvailability(true);
		
		
		
		man.changeUsername("JaredDunn");
		man.changePassword("password2");
		
		EmployeeDatabase db = new EmployeeDatabase();
		db.AddEntry(man);
		db.AddEntry(man2);
		Login.loginCheck();
		
		db.Close();
		
		
	}
	
	
	
}
