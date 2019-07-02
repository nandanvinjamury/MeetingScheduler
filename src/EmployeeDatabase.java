import org.bson.Document;
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
        
        long[] meetingIDs = new long[entryInfo.getSchedule().getMeetings().length];
        
        for(int i=0; i<meetingIDs.length;i++) {
        	meetingIDs[i] = entryInfo.getSchedule().getMeetings()[i].getID();
        }
        
        Document meetings = new Document("id", meetingIDs);
        
        
        Document schedule = new Document("meetings", meetings);
        employee.append("schedule", schedule);
        
        
        employeeCollection.insertOne(employee);
        
	}
	
	public boolean FindEntry(String username) {
		
		//if()
		
		
		
		return false;
	}
	
	
	public void DeleteEntry(String username) {
		if(FindEntry(username)) {
			//delete
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
		Room room = new Room();
		
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
		
		
		EmployeeDatabase db = new EmployeeDatabase();
		db.AddEntry(man);
		db.Close();
		
		
	}
	
	
	
}
