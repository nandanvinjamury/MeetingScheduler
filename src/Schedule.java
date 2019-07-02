import java.util.Arrays;

public class Schedule
{
    private boolean visible;
    private Meeting[] meetings;


    //checks if either the start time or end time of a meeting is during one of
    //the Schedules current meetings.
    public boolean TimeSlotAvailible(Meeting newMeeting)
    {
        for(int x = 0; x < meetings.length ; x++)
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

    public boolean getVisibility()
    {
        return visible;
    }

    public void setVisibility(boolean bool)
    {
        visible = bool;
    }
}
