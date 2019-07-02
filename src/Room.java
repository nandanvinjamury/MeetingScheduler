public class Room
{
    private int roomNumber;
    private boolean available;

    public Room(int r)
    {
        roomNumber = r;
        available = true;
    }

    public void setRoomNumber(int rn)
    {
        roomNumber = rn;
    }

    public int getRoomnumber()
    {
        return roomNumber;
    }

    public void setAvailability(boolean a)
    {
        available = a;
    }

    public boolean getAvailability()
    {
        return available;
    }
}
