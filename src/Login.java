import java.util.Scanner;

public class Login
{
    public static String dbUsername = null;
    public static String dbPassword = null;
    /*public static void main(String[] args)
    {

        loginCheck();
    }
    */
    public static void loginCheck()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        Employee E = null;
        Administrator A = null;
        /*if(isAdministrator(username))
        {
            //Set dbUsername and dbPassword to ones in DB
            if (username.equals(dbUsername) && password.equals(dbPassword))
            {
                //Create Administrator object with info from DB
                Schedule schedule = new Schedule();
                Administrator administrator = new Administrator(username, password, schedule);
                AdministratorLogin.Start(A);
            }
            else
            {
                System.out.println("Incorrect Password");
                loginCheck();
            }
        }*/
        //else if(isEmployee(username))
        //{
            //Set dbUsername and dbPassword to ones in DB
            if (username.equals(dbUsername) && password.equals(dbPassword))
            {
                //Create Employee object with info from DB
                EmployeeLogin.start(E);
            }
            else
            {
                System.out.println("Incorrect Password");
                loginCheck();
            }
        //}
        //else
        /*{
            System.out.println("Incorrect Username");
            loginCheck();
        }*/
    }
    public static boolean isAdministrator(String user)
    {
        if(user.equals("admin"))
        {
            dbUsername = "admin";
            dbPassword = "123";
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean isEmployee(String user)
    {
        if(user.equals("employee"))
        {
            dbUsername = "employee";
            dbPassword = "456";
            return true;
        }
        else
        {
            return false;
        }
    }
}
