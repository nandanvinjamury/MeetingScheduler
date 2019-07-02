import java.util.Arrays;

public class Meeting
{
	private long meetingID;
    private Employee[] Employees;
    private Room meetingRoom;
    private Employee Owner;
    private float StartTime; //Note: numbers accepted are between 00.00 to 24.00 
    private float EndTime; //Note: same as above and must be larger then above

    public Meeting()
    {
        Employees = null;
        meetingRoom = null;
        Owner = null;
        StartTime = 0;
        EndTime = 0;
    }

    public Meeting(Employee[] e, Room r, Employee o, float sT, float eT)
    {
        Employees = e;
        meetingRoom = r;
        Owner = o;
        StartTime = sT;
        EndTime = eT;
    }


    
    
    public void Meeting() {
    	meetingID = 0;
    	Employees = new Employee[1];
    	meetingRoom = new Room(0);
    	Owner = Employees[0];
    	StartTime = 1;
    	EndTime = 23;
    }
    

    //If the one who called this method is the owner then every position in the
    //Employees array is made to be null using the decline meeting method
    public void cancelMeeting(Employee potentialOwner)
    {
        if(potentialOwner.equals(Owner))
        {
            for(int z = 0; z < Employees.length; z++)
            {
                declineMeeting(Employees[z]);
            }
            
            meetingRoom.setAvailability(true);
            meetingRoom = null;
        }
        else
        {
            System.out.println("You are not the owner of the meeting, so it"
                                + " has not been cancelled, no changes made.");
        }
    }
    
    //Either handle the checking process for whether the Employee is availible
    //or not here or do it in the Employee class
    public void inviteEmployee(Employee invitedEmployee)
    {
       if(invitedEmployee.getSchedule().TimeSlotAvailible(this))
       {
            Employees = Arrays.copyOf(Employees, Employees.length + 1);
            Employees[Employees.length - 1] = invitedEmployee;
            invitedEmployee.updateSchedule(this);
       }
       else
       {
           System.out.println("That employee cannot be invited.");
       }
      
        
    }
    
    public void forceEmployee(Employee invitedEmployee)
    {
       Employees = Arrays.copyOf(Employees, Employees.length + 1);
       Employees[Employees.length - 1] = invitedEmployee;
       invitedEmployee.updateSchedule(this);
      
        
    }
    
    //make sure to add code to get rid of the meeting on the Decliners schedule
    public void declineMeeting(Employee Decliner)
    {
        for(int y = 0; y < Employees.length; y++)
        {
            if(Employees[y].getUsername().equals(Decliner.getUsername()))
            {
                Employees[y] = null;
            }
        }
    }
    
    public void setID(long meetingID) {
    	this.meetingID = meetingID;
    }
    
    //checks if the new room is availible then opens up the current room before
    //changing to the new room
    public void changeRoom(Room newRoom)
    {
        if(newRoom.getAvailability())
        {
            
            
            meetingRoom = newRoom;
            
            meetingRoom.setAvailability(false);
        }
        else
        {
            System.out.println("That room is not availible, no changes made");
        }
    }
    
    public void changeOwner(Employee newOwner)
    {
        Owner = newOwner;
    }
    
    public void changeStartTime(float newStartTime)
    {
        if(newStartTime >= 0.0f && newStartTime <= 24.00)
        {
            StartTime = newStartTime;
        }
        else
        {
            System.out.println("The Time you entered is not between 00.00 and "
                                +  "24.00, no changes were made.");
        }
    }
    
    public void changeEndTime(float newEndTime)
    {
     if(newEndTime >= 0.0f && newEndTime <= 24.00)
        {
            if(newEndTime > StartTime)
            {
                EndTime = newEndTime;
            }
            else
            {
                System.out.println("The end time entered is not after the start"
                                     + " time, no changes were made.");
            }
        }
        else
        {
            System.out.println("The Time you entered is not between 00.00 and "
                                +  "24.00, no changes were made.");
        }   
    }
    
    public Employee[] getEmployeeList()
    {
        return Employees;
    }
    
    public Room getRoom()
    {
        return meetingRoom;
    }
    public Employee getOwner()
    {
        return Owner;
    }
    public float getStartTime()
    {
        return StartTime;
    }
    public float getEndTime()
    {
        return EndTime;
    }
    public long getID() {
    	return meetingID;
    }

}
