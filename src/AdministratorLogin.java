import java.util.Scanner;

public class AdministratorLogin
{
    public static void Start(Administrator A)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println("1. Create Meeting");
        System.out.println("2. Cancel Meeting");
        System.out.println("3. Update Schedule");
        System.out.println("4. Display Schedule");
        System.out.println("5. Create User");
        System.out.println("6. Delete User");
        System.out.println("7. Create Room");
        System.out.println("8. Delete Room");
        System.out.println("9. Change Password");
        System.out.println("10. Log out");
        int choice = scanner.nextInt();
        switch(choice)
        {
            case 1:
                A.createMeeting();
                break;
            case 2:
                A.cancelMeeting();
                break;
            case 3:
                A.updateSchedule();
                break;
            case 4:
                A.displaySchedule();
                break;
            case 5:
                A.createUser();
                break;
            case 6:
                A.deleteUser(A);
                break;
            case 7:
                A.createRoom();
                break;
            case 8:
                A.deleteRoom();
                break;
            case 9:
                Employee DBE = null;
                Employee E = null;
                System.out.println("1. Change Your Password ");
                System.out.println("2. Change Employee Password");
                int passChoice = scanner.nextInt();
                do {
                    if(passChoice == 1)
                    {
                        A.resetPassword();
                    }
                    else if(passChoice == 2)
                    {
                        do{
                            System.out.println("Enter Employee Username");
                            if(E == DBE)
                            {
                                A.resetPassword(E);
                            }
                            else
                            {
                                System.out.println("Not a valid username");
                            }
                        } while (E != DBE);
                    }
                    else
                    {
                        System.out.println("Not a valid choice");
                    }
                } while(passChoice != 1 && passChoice != 2);
                break;
            case 10:
                Login.loginCheck();
                break;
            default:
                System.out.println("Not a valid option");
                Start(A);
                break;
        }
    }
}
