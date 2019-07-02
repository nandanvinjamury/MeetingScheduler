public class Administrator extends Employee
{
    public Employee createUser(String name, String pass)
    {
        Employee newEmployee = new Employee();
        newEmployee.changeUsername(name);
        newEmployee.changePassword(pass);
        newEmployee.changeSchedule();
        
        return newEmployee;
    }

    //Will have to do this part when the database is up
    public void deleteUser(Employee employee)
    {
        
    }

    public void resetPassword(Employee employee, String newPass)
    {
        employee.changePassword(newPass);
    }

    public Room createRoom(int roomNum)
    {
        Room newRoom = new Room();
        newRoom.setRoomNumber(roomNum);
        newRoom.setAvailability(true);

        return  newRoom;
    }

    //Will have to do this part when the database is up
    public void deleteRoom()
    {

    }
}
