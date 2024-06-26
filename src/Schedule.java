import java.util.Arrays;

public class Schedule
{
    private Meeting[] meetings;

    
    public Schedule()
    {
    	meetings = new Meeting[1];
    }
    //checks if either the start time or end time of a meeting is during one of
    //the Schedules current meetings. 
    public boolean TimeSlotAvailible(Meeting newMeeting)
    {
    	if(meetings.length > 1)
    	{
        for(int x = 1; x < meetings.length ; x++)
        {
            if(newMeeting.getStartTime() >= meetings[x].getStartTime()
                && newMeeting.getStartTime() <= meetings[x].getEndTime())
            {
                return false;
            }
            
            if(newMeeting.getEndTime() >= meetings[x].getStartTime()
                && newMeeting.getEndTime() <= meetings[x].getEndTime())
            {
                return false;
            }
            
        }
        
        
        return true;
    	}
    	else
    	{
    	return true;
    	}
    }
    
    public void addMeeting(Meeting newMeeting)
    {
        if(TimeSlotAvailible(newMeeting))
        {
            meetings = Arrays.copyOf(meetings, meetings.length + 1);
            meetings[meetings.length - 1] = newMeeting;
        }
        else
        {
            System.out.println("The Employee is busy during a portion of the "
                                + "meeting, no changes have been made.");
        }
    }

    public void deleteMeeting(Meeting meetingToDelete)
    {
        for(int y = 0; y < meetings.length; y++)
        {
            if(meetings[y].equals(meetingToDelete))
            {
                meetings[y] = null;
            }
        }
    }
    
    public Meeting[] getMeetings()
    {
        return meetings;
    }
    
    public void Display()
    {
        System.out.println("These are the meetings for today:");
        for(int z = 0; z < meetings.length; z++)
        {
            if(meetings[z] != null)
            {
                System.out.println( meetings[z].getOwner().getUsername() + "'s"
                        + " meeting from " + meetings[z].getStartTime()
                        + " to " + meetings[z].getEndTime());
            }
        }
    }
    
 
}
