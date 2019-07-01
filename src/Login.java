import java.util.Scanner;

public class Login
{
    public static void main(String[] args)
    {
        loginCheck();
    }
    public static void loginCheck()
    {
        String dbUsername = null;
        String dbPassword = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        Employee E = null;
        Administrator A = null;
        if(administrator)
        {
            //Set dbUsername and dbPassword to ones in DB
            if (username == dbUsername && password == dbPassword)
            {
                //Create Administrator object with info from DB
                AdministratorLogin.Start(A);
            }
            else
            {
                System.out.println("Incorrect Password");
                loginCheck();
            }
        }
        if(employee)
        {
            //Set dbUsername and dbPassword to ones in DB
            if (username == dbUsername && password == dbPassword)
            {
                //Create Employee object with info from DB
                EmployeeLogin.start(E);
            }
            else
            {
                System.out.println("Incorrect Password");
                loginCheck();
            }
        }
        else
        {
            System.out.println("Incorrect Username");
            loginCheck();
        }

    }
}
