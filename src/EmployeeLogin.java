import java.util.Scanner;

public class EmployeeLogin
{
    public static void start(Employee E)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println("1. Create Meeting");
        System.out.println("2. Cancel Meeting");
        System.out.println("3. Update Schedule");
        System.out.println("4. Display Schedule");
        System.out.println("5. Change Password");
        System.out.println("6. Log out");
        int choice = scanner.nextInt();
        switch(choice)
        {
            case 1:
                E.createMeeting();
                break;
            case 2:
                E.cancelMeeting();
                break;
            case 3:
                E.changeSchedule();
                break;
            case 4:
                E.displaySchedule();
                break;
            case 5:
                E.changePassword();
                break;
            case 6:
                Login.loginCheck();
                break;
            default:
                System.out.println("Not a valid option");
                start(E);
        }

    }
}
