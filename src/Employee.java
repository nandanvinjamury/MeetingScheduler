public class Employee
{
    private String username;
    private String password;
    private Schedule schedule;
    private boolean Access = false;

    public void login(String u, String p)
    {
        if(username.equals(u) && password.equals(p))
        {
            Access = true;
        }
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

    public Meeting createMeeting(Room meetingRoom,
                                            float start, float end)
    {
        Meeting newMeeting = new Meeting();
        newMeeting.changeOwner(this);
        newMeeting.changeRoom(meetingRoom);
        newMeeting.changeStartTime(start);
        newMeeting.changeEndTime(end);
        
        return newMeeting;

    }

    public  void cancelMeeting(Meeting meetingToCancel)
    {
        meetingToCancel.cancelMeeting(this);
    }

    public void displaySchedule()
    {
        schedule.Display();
    }
}
