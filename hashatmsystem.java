import java.util.*;
public class hashatmsystem {
    static double atmcash=20000;
    static HashMap<Integer,hashatm>users=new HashMap<>();
    static{
        users.put(1000,new hashatm(1000,1111,5000));
        users.put(1001,new hashatm(1001,2222,3000));
        users.put(1002,new hashatm(1002,3333,4000));
    }
        static Scanner sc=new Scanner(System.in);
        public static void main(String args[]){
            while(true){
            System.out.println("---------MENU----------\n1.AdminAccess\n2.UserAccess\n3.Create Account\n4.Exit");
            
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    admin();
                    break;
                case 2:
                    user();
                    break;
                case 3:
                    create();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
    static hashatm FindAccount(int accno){
              return users.get(accno);
            }
    static void create(){
        System.out.println("Enter the account number:");
        int acno=sc.nextInt();
        if(users.containsKey(acno)){
            System.out.println("Account already exist");
            return;
        }
        System.out.println("Enter the PIN:");
        int pin=sc.nextInt();
        System.out.println("Enter the initial deposit amount:");
        double deposit=sc.nextDouble();
        hashatm ac=new hashatm(acno,pin,deposit);
        users.put(acno,ac);
        System.out.println("Account created successfully");

        }
    static void admin(){
        System.out.println("Enter Admin Password");
        int pass=sc.nextInt();
        if(pass!=9999){
            System.out.println("Wrong Password");
            return;
        }
        System.out.println("-------MENU-------");
        System.out.println("1.load cash in the atm");
        System.out.println("2.check atm balance");
        System.out.println("3.No.of transactions");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter the amount");
                double amt=sc.nextDouble();
                atmcash+=amt;
                System.out.println("Amount loaded successfully");
                break;
            case 2:
                System.out.println("Available ATM Balance : "+atmcash);
                break;
            case 3:
                int total=0;
                for(hashatm acc:users.values()){
                    total+=acc.getTransactions();
                }
                System.out.println("Total Transactions: "+total);
                break;
        }

    }
    static void user(){
        
        System.out.println("Enter account Number");
        int accno=sc.nextInt();
        hashatm acc=FindAccount(accno);
        if(acc==null){
            System.out.println("Cannot find the account number");
            return;
        }
        System.out.println("Enter the pin number");
        int pin=sc.nextInt();
        if(pin!=acc.getPin()){
            System.out.println("Wrong Pin");
            return;
        }
        while(true){
             System.out.println("-------MENU-------\n1.deposit\n2.Withdraw\n3.Change PIN\n4.Account Receipt\n5.Check Balance\n6.Account Transfer\n7.Exit");
             int ch=sc.nextInt();
        switch(ch){
            case 1:
                System.out.println("Enter the amount");
                double amt=sc.nextDouble();
                acc.deposit(amt);
                System.out.println("Deposit Successfull");
                break;
            case 2:
                System.out.println("Enter the amount to be withdrawn:");
                double wamt=sc.nextDouble();
                if(wamt>atmcash){
                    System.out.println("ATM has insufficient balance");

                }
                else if(acc.withdraw(wamt)){
                      atmcash-=wamt;
                      System.out.println("Withdrawal Successfull");
                }
                else{
                    System.out.println("Insufficient Account balance");
                }
                break;
            case 3:
                System.out.println("Enter New PIN:");
                acc.setPin(sc.nextInt());
                System.out.println("PIN changed successfully");
                break;
            case 4:
                System.out.println("----Account Receipt----");
                System.out.println("Account Number: "+acc.getAccountNumber());
                System.out.println("Balance: "+acc.getBalance());
                System.out.println("Total Transactions: "+acc.getTransactions());
                System.out.println("-----------------------");
                break;
            case 5:
                System.out.println("The available balance is: "+acc.getBalance());
                break;
            case 6:
                System.out.println("Enter receiver Account");
                int r=sc.nextInt();
                hashatm receiver=FindAccount(r);
                if(receiver==null){
                    System.out.println("Receiver account not found");
                    return;
                }
                System.out.println("Enter the amount ");
                double tamt=sc.nextDouble();
                if(acc.withdraw(tamt)){
                    receiver.deposit(tamt);
                    System.out.println("Transfer Successfull");

                }
                else{
                    System.out.println("Insufficient balance");
                }
                break;
            case 7:
                return;
            }
        }
    }
}
