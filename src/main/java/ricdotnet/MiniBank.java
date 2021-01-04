package ricdotnet;

/**
 * MiniBank Java Program
 * The excess of spaces is for better human readability
 * 
 * @author Ricardo Rocha - rrocha.uk
 * 
 */

import java.util.*;

public class MiniBank extends BankGUI {
    
    Random rand = new Random();

    Calendar date = Calendar.getInstance(); //create a calendar/date object

    String print_date = getDate();
    
    double deposit_amount; //sets deposit amount
    double withdraw_amount; //sets wthdrawal amount

    //HashMap<Integer, Clients> client = new HashMap<Integer, Clients>();
    //ArrayList<Transaction> transactions; //call transaction class

    /**
     * Using an HashMap for the transactions will help keep many transactions linked to 1 account
     * Same result could be achieved with ArrayList with 3 values setting:
     *  - Account Number
     *  - Amount.
     *  - Deposit / Withdraw
     */

    //generate account number
    public int generateAccountNumber() {
        account_number = rand.nextInt(99999);
        return account_number + 100000;
    }

    //create and register client
    public String registerClient() {

        //asks for the clients name. first and last name with a space. then registers both. each with a seperated input
        askClientName();

        //asks for the clients age and registers it to @age
        askClientAge();

        //asks for the clients city and registers it to @city
        askClientAddress();

        //asks for the clients account number and registers it to @account_number
        //obsolete on version 2.0
        //System.out.print("Enter an account number: ");
            //account_number = input.nextInt();
        //new version uses the bellow getter/generator
        account_number = generateAccountNumber();

        //asks the teller for the first registered deposit and regsiters it to @account_balance
        askClientStartingBalance();

        //if the user does not deposit the acocunt will remain inactive until a first deposit is made
        if(account_balance == 0){
            account_status = "Inactive";
        }else{
            account_status = "Active";
        }

        //reset the form
        input.nextLine();

        //prints all the info after registering
        System.out.println("\nAccount created succesfully.\nThe details are as follows:");
        System.out.println(account_number + " :: " + client_name + " :: " + client_age + " :: " + client_address + " :: " + print_date + " :: £" + account_balance + " :: " + account_status);

        //if deposit is null or 0 show inactive warning
        if(account_status.equals("Inactive")) {
            System.out.println("This account is inactive. Please deposit at least £1 to activate.");
        }
        System.out.println();

        return account_number + client_name + client_age + client_address + print_date + account_balance + account_status;

    } //end register client method
    //client name getter
    public String askClientName() {

        //String client_first_name;
        //String client_last_name;

        System.out.print("Enter your name (first and last): ");
        //client_first_name = input.next();
        //client_last_name = input.next();
        //input.nextLine();
        client_name = input.nextLine();

        //client_name_initials = client_first_name.charAt(0) + "" + client_last_name.charAt(0);

        //client_name = client_first_name + " " + client_last_name;

        return client_name;
    }
    //client age getter
    public int askClientAge() {

        boolean ageSet = false;

        while(!ageSet) {

            //while(client_age < 18) {
                System.out.print("Enter your age: ");

                //try and catch to check if user inputs a valid number
                try {
                    client_age = input.nextInt();

                    if(client_age < 18) {
                        System.out.println("Age has to be higher than 17.");
                    } else {
                        ageSet = true;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("The age has to be a number.");
                    input.next();
                }

            //} //end while loop client_age < 18
        } //end while loop ageSet
        
            return client_age;
    }
    //client city getter
    public String askClientAddress() {
        
        System.out.print("Enter your Address: ");
            input.nextLine();
            client_address = input.nextLine();
            

        return client_address;
    }
    //client starting balance getter
    public double askClientStartingBalance() {
        
        System.out.print("Enter a starting balance: £");
            account_balance = input.nextDouble();

        //System.out.println("Your starting balance will be £0. Please note that the account will be Inactive on creation.");

        return account_balance;
    }
    //method to set a first deposit
    public void setFirstDeposit(int selected_account, double deposit_amount) {
        Clients current_client = client.get(selected_account);
        current_client.setDeposit(deposit_amount, print_date);
    }
    //method to make a deposit
    public void setDeposit(int selected_account, double deposit_amount) {
        Clients current_client = client.get(selected_account);
        current_client.setDeposit(deposit_amount, print_date);
    }
    //method to make withdrawal
    public void setWithdrawal(int selected_account, double deposit_amount) {
        Clients current_client = client.get(selected_account);
        current_client.setWithdrawal(deposit_amount, print_date);
    }
    
    //account open date getter
    public String getDate() {

        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH) + 1; //+ 1 because months go from 0-11
        int year = date.get(Calendar.YEAR);

        String current_date = day + "/" + month + "/" + year;

        return current_date;
    }

    //select and print user selected account
    //Integer inherits from object so its valid to return null. can use together with minibankcustom
    public String selectAccount(int selected_account) {
        
        if(client.containsKey(selected_account)) {
            return "Account number: " + selected_account + "\n" + client.get(selected_account);
        } else {
            return null;
        }

    }

    //method to deposit money into an account for terminal use
    public void makeDeposit(int selected_account) {

        boolean value_ok = false; //value_ok variable is set to true if the value entered is accepted. accepted values are > 0;
        while(value_ok == false) {
            System.out.print("Please enter the amount to deposit: ");

            try {
                deposit_amount = input.nextDouble();
            } catch(InputMismatchException e) {
                System.out.println("The amount to deposit has to be Integer or Double.");
                input.next();
            }

            if(deposit_amount <= 0) {
                System.out.println("The amount to deposit cannot be 0 or negative.");
            } else {
                value_ok = true;
            }

        }

        Clients current_client = client.get(selected_account);

        current_client.setDeposit(deposit_amount, print_date);

        //check if the account is inactive, activate and confirm its activated
        if(current_client.getStatus().equals("Inactive")){
            System.out.println("Thanks for the first deposit.\n"
            + "This account will now be active.");
            current_client.activateAccount();
        }

        System.out.println("Your new balance is: £" + current_client.getBalance());
        System.out.println();

    }

    //make withdrawal for terminal use
    public void makeWithdrawal(int selected_account) {

        boolean value_ok = false;
        String value = " ";

        while(value_ok == false || value == " ") {
            System.out.print("Please enter the ammount to withdraw: ");
            withdraw_amount = input.nextDouble();

            if(withdraw_amount <= 0) {
                System.out.println("The amount has to be a positive value.");
            } else {
                value_ok = true;
                value = "";
            }

        }

        Clients current_client = client.get(selected_account);

        //calculate if withdrawal is valid or not
        if(current_client.getBalance() <= withdraw_amount) {
            System.out.println("You do not have enough money to withdraw.\n");
            
            return; //stop the method
        }

        current_client.setWithdrawal(withdraw_amount, print_date);

        if(current_client.getBalance() == 0) {
            System.out.println("It is not safe to leave an account with £0 balance.\n"
            + "It will be marked as Inactive and may get deleted.\n"
            + "Please make a deposit of at least £1 to keep it Active.");
            current_client.deactivateAccount();
        }

        System.out.println("Your new balance is: £" + current_client.getBalance());
        System.out.println();
        
    }

    //method to delete account
    public int deleteAccount(int selected_account) {

        Clients current_client = client.get(selected_account);

        //if the account is active returns 0 or else return 1
        if(current_client.getStatus() == "Active") {
            return 0;
        } else {
            return 1;
        }
    }
    //do the delete bit
    public void doDelete(int selected_account) {

        client.remove(selected_account);
        System.out.println("");
    }

    //retrieve account details
    public String accountDetails(int selected_account) {

        Clients current_client = client.get(selected_account);

        return "\nAccount number: " + selected_account + " - " + client_name
                + "\nAccount status: " + current_client.getStatus()
                + "\nAccount balance: £" + current_client.getBalance() + "\n";
    }

    //get account status
    public String accountStatus(int selected_account) {
        Clients current_client = client.get(selected_account);

        return current_client.getStatus();
    }
    //get account name
    public String accountName(int selected_account) {
        Clients current_client = client.get(selected_account);

        return current_client.getName();
    }
    //get account balance
    public double accountBalance(int selected_account) {
        Clients current_client = client.get(selected_account);
        
        return current_client.getBalance();
    }
    //set account active
    public void setActive(int selected_account) {
        Clients current_client = client.get(selected_account);
        
        current_client.activateAccount();
    }
    //set account inactive
    public void setInactive(int selected_account) {
        Clients current_client = client.get(selected_account);
        
        current_client.deactivateAccount();
    }

    //retrieve sorted transactions
    public String getSortedTransactions(int selected_account) {

        Clients current_client = client.get(selected_account);

        if(current_client.getSortedTransactions() == "") {
            return "No transactions to show.";
        } else  {

            return "" + current_client.getSortedTransactions();
        }

    }

    //retrieve unsorted transactions
    public String getUnsortedTransactions(int selected_account) {

        Clients current_client = client.get(selected_account);

        if(current_client.getUnsortedTransactions() == "") {
            return "No transactions to show.";
        } else {

            return "" + current_client.getUnsortedTransactions();
        }
    }

    //get sorted transactions using custom algorithm
    public String getCustomSortedTransactions(int selected_account) {

        Clients current_client = client.get(selected_account);

        if (current_client.getCustomSortedTransactions() == "") {
            return "No transactions to show.";
        } else {

            return "" + current_client.getCustomSortedTransactions();
        }
    }

    //String method to return invalid account
    public String invalidAccount() {
        return "\nThe account you entered does not exist.\n";
    }

    
    //print existing accounts
    public String existingAccounts() {

        String result = "";
        if(client.isEmpty()){
            //System.out.println("You have no bank accounts.");
            return "There are no bank accounts.";
        }else{
            for(Integer i:client.keySet()){
                //System.out.print(i + " :: " + client.get(i));
                result = result + "Account number: " + i + "\n" + client.get(i);
            }
        } 
        
        return result;

    }
    //print existing accounts
    public String printAccountNumbers() {

        String result = "";
        if(client.isEmpty()){
            //System.out.println("You have no bank accounts.");
            return "There are no bank accounts.";
        }else{
            for(Integer i:client.keySet()){
                
                Clients current_client = client.get(i);
                
                //System.out.print(i + " :: " + client.get(i));
                result = result + "# " + i + " - " + current_client.getName() + " - " + current_client.getStatus() + "\n";
            }
        } 
        
        return result;

    }

} //end main class