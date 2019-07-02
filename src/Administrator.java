import java.util.Scanner;

public class Administrator extends Employee
{
    public Administrator(String u, String p, Schedule s)
    {
        username = u;
        password = p;
        schedule = s;
    }

    public Employee createUser()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");
        String name = scanner.nextLine();
        System.out.println("Enter password");
        String pass = scanner.nextLine();
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

    public Room createRoom()
    {
        System.out.println("Choose room number");
        int roomNum = scanner.nextInt();
        Room newRoom = new Room(roomNum);
        newRoom.setAvailability(true);

        return  newRoom;
    }

    //Will have to do this part when the database is up
    public void deleteRoom()
    {

    }
}
