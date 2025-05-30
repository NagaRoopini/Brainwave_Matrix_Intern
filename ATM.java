import java.util.Scanner;
public class ATM{
    private static double balance=1000.00; // Initial balance
    private static final int PIN=1234;     // Sample PIN
    private static final int MAX_ATTEMPTS=3;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int userPIN;
        int attempts=0;
        System.out.println("Welcome to ATM");
        // PIN verification loop
        while (attempts<MAX_ATTEMPTS){
            System.out.print("Enter your 4-digit PIN: ");
            userPIN=scanner.nextInt();
            attempts++;
            if(userPIN==PIN){
                mainMenu(scanner);
                break;
            }else{
                System.out.println("Incorrect PIN. " +(MAX_ATTEMPTS-attempts)+" attempts remaining.");
                if(attempts==MAX_ATTEMPTS){
                    System.out.println("Too many incorrect attempts. Access denied.");
                }
            }
        }
        scanner.close();
    }
    public static void mainMenu(Scanner scanner){
        int choice;
        do{
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice=scanner.nextInt();
            switch(choice){
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please enter correct value.");
            }
        } while (choice!=4);
    }
    public static void checkBalance(){
        System.out.printf("Your current balance is: $%.2f\n",balance);
    }
    public static void withdraw(Scanner scanner){
        System.out.print("Enter amount to withdraw: $");
        double amount=scanner.nextDouble();
        if(amount>balance){
            System.out.println("Insufficient balance!");
        }else if(amount<=0){
            System.out.println("Invalid amount!");
        }else{
            balance-=amount;
            System.out.printf("Please collect your cash: $%.2f\n",amount);
            System.out.printf("Remaining balance: $%.2f\n",balance);
        }
    }
    public static void deposit(Scanner scanner){
        System.out.print("Enter amount to deposit: $");
        double amount=scanner.nextDouble();
        if(amount<=0){
            System.out.println("Invalid amount!");
        }else{
            balance+=amount;
            System.out.printf("$%.2f deposited successfully.\n", amount);
            System.out.printf("Updated balance: $%.2f\n", balance);
        }
    }
}