import java.util.Scanner;

public class Employee
{
    String username;
    String password;
    Schedule schedule;
    boolean Access = false;
    Scanner scanner = new Scanner(System.in);

    public Employee(String u, String p, Schedule s)
    {
        username = u;
        password = p;
        schedule = s;
    }

    public Employee()
    {
        username = null;
        password = null;
        schedule = null;
    }

    public void logout()
    {
        Access = false;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public Schedule getSchedule()
    {
        return schedule;
    }
    
    public void changeUsername(String newUsername)
    {
        username = newUsername;
    }

    public void changePassword(String newPassword)
    {
        password = newPassword;
    }
    
    public void changeSchedule(Schedule newSchedule)
    {
        schedule = newSchedule;
    }
    
    public void changeSchedule()
    {
        schedule = new Schedule();
    }

    public void updateSchedule(Meeting meetingToAdd)
    {
        this.schedule.addMeeting(meetingToAdd);
    }

    public Meeting createMeeting()
    {
        System.out.println("Select a room");
        System.out.println("2");//Display available rooms from DB
        int roomNumber = scanner.nextInt();
        int dbRoomNumber = 2;
        Room meetingRoom = null;
        float start = 0;
        float end = 23;
        if(roomNumber == dbRoomNumber)
        {
            meetingRoom = new Room(roomNumber);
            System.out.println("Choose Start Time");
            start = scanner.nextFloat();
            System.out.println("Choose End Time");
            end = scanner.nextFloat();
        }
        Meeting newMeeting = new Meeting();
        newMeeting.changeOwner(this);
        newMeeting.changeRoom(meetingRoom);
        newMeeting.changeStartTime(start);
        newMeeting.changeEndTime(end);
        
        return newMeeting;

    }

    public  void cancelMeeting()
    {
        //Display meetings from DB
        System.out.println("Choose meeting to cancel");
        int meeting = scanner.nextInt();
        Meeting meetingToCancel = new Meeting();
        meetingToCancel.cancelMeeting(this);

    }

    public void displaySchedule()
    {
        schedule.Display();
    }
}
