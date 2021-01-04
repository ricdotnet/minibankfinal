package ricdotnet;

/**
 * MiniBank Java Program
 * The excess of spaces is for better human readability
 * 
 * @author Ricardo Rocha - rrocha.uk
 * 
 */

import java.util.*;

//class MiniBankCustom <Key, Value> extends DefaultMainClass {
class MiniBankCustom <Key, Value> extends BankGUI {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // Scanner input = new Scanner(System.in);
    Random rand = new Random();

    Calendar date = Calendar.getInstance(); //create a calendar/date object

    String print_date = getDate();
    
    double deposit_amount; //sets deposit amount
    double withdraw_amount; //sets wthdrawal amount
     
    private final Client<Key, Value>[] table;   //Array of Entry.
    private final int capacity = 16;  //Initial capacity of HashMap/array.
        //can be more but never less due to the size of my account numbers.
        //hash can be up to 15 if the account number generated is 199999.
    
    //define Client class/constructor for a custom hashmap
    static class Client<Key, Value> {
        Key accountnumber; //define key as account number
        Value accountdetails; //define value as the account details
        Client<Key, Value> nextNode; //each entry will have a 3rd cell 
    
        //define a constructor for the custom hashmap
        public Client(Key accountnumber, Value accountdetails, Client<Key, Value> nextNode){
            this.accountnumber = accountnumber;
            this.accountdetails = accountdetails;
            this.nextNode = nextNode;
        }
    }
    
    //define the capacidy for the array
    @SuppressWarnings("unchecked")
    public MiniBankCustom(){
        table = new Client[capacity];
    }

    
    /**
     * This is the .put() method from java libraries
     * here is defined as put() but anything else would work.
     * Duplicate and null keys will not be allowed.
     * If a key is a duplicate, the old entry will be replaced.
     * If a key is null the entry will not be accepted however Value can be null.
     * 
     * @param newaccountnumber
     * @param newaccountdetails 
     */
    public void put(Key newaccountnumber, Value newaccountdetails){

        //if the accountnumber is empty then the method will stop here and not insert anything
        if(newaccountnumber == null)
            return;
     
        //calculate hash of key.
        int hash = hash(newaccountnumber);
        //create new entry.
        Client<Key, Value> newClient = new Client<>(newaccountnumber, newaccountdetails, null);
     
        //if there are no entries or clients yet the first will be stored here
        if(table[hash] == null){

            table[hash] = newClient;

        } else {

            Client<Key, Value> previous = null; //set the previous node as null
            Client<Key, Value> current = table[hash]; //set the current node as the new entry
          
            while(current != null){ //we have reached last entry of bucket.

                //this logic is to check if there is already an account with the same number as the new account number
                if(current.accountnumber.equals(newaccountnumber)){   
                        
                    newClient.nextNode = current.nextNode;
                    table[hash] = newClient;
                    return;
                    
                }     

                //adds the new account on the next node
                previous = current;
                current = current.nextNode;
            }

            previous.nextNode = newClient;
        }
    }

   /**
    * This method would be .get() from java libraries.
    * I use selectedAccount() for compatibility purposes
    * It loops through the Array and prints the account with the key.
    * 
    * @param selected_account
    */
    public Value selectAccount(Key selected_account) {

        int hash = hash(selected_account); //hash the accountnumber to match the accounts on the list

        if (table[hash] == null) {

            return null;

        } else {

            Client<Key, Value> this_account = table[hash];

            while (this_account != null) {

                if (this_account.accountnumber.equals(selected_account)) {
                    return this_account.accountdetails;
                }

                this_account = this_account.nextNode; //return value corresponding to key.
            }

            return null;   //returns null if key is not found.
        }
    }


   /**
    * This is the .remove() method from java libraries.
    * Removes the selected Key-Value pair.
    * 
    * @param selected_account
    */
    public boolean removeAccount(Key selected_account){
      
        int hash = hash(selected_account);
             
        if(table[hash] == null){
            return false;

        } else {
        
            @SuppressWarnings("unused")
            Client<Key, Value> previous = null;
            Client<Key, Value> current = table[hash];
       
            while(current != null){ //we have reached last entry node of bucket.

//                if(current.accountnumber.equals(selected_account)){    
//
//                    if(previous == null){  //delete first entry node.
//                        table[hash] = table[hash].nextNode;
//                        return true;
//
//                    } else {
//                        previous.nextNode = current.nextNode;
//                        return true;
//                    }
//
//                }

                //code to remove account
                table[hash] = table[hash].nextNode;
                previous = current;
                current = current.nextNode;
            }
            return false;
    
        }
    }
  

   /**
    * Method to display / print all entries previously added.
    * 
    */
    public String existingAccounts(){

        /**
         * the program checks for accounts 16 times because there are 16 nodes.
         * if the user/back end wants to add more nodes they can do so by changing capacity variable
         */
        if(checkForAccounts() == 16) {
            //System.out.println("There are no accounts in the system.\n");
            return "There are no accounts in the system.\n";
        }
      
        String result = ""; //empty string to append all accounts. 1 by 1
        for(int i = 0; i < capacity; i++){

            if(table[i]!=null){

                Client<Key, Value> client = table[i];

                while(client != null){

                    //the next 4 lines is for use of terminal
                    // String StringNumber = "" + client.accountnumber; //set object account number as string
                    // int IntNumber = Integer.parseInt(StringNumber); //set string account number as int
                    // Clients current_client = bank.selectAccount(IntNumber); //get account details from account number
                    // System.out.print(client.accountnumber + current_client.accounts());
                    
                    result = result + "Account number: " + client.accountnumber + "\n" + client.accountdetails; //print account details on gui
                    client = client.nextNode;
                    //return client.accountnumber + " :: " + client.accountdetails + client.nextNode;
                }
            }
        }
        
        return result;
    }
    
    //print account number and name for account selection
    public String printAccountNumbers() {
        
        if(checkForAccounts() == 16) {
            //System.out.println("There are no accounts in the system.\n");
            return "There are no accounts in the system.\n";
        }
        String result = "";
        for(int i = 0; i < capacity; i++){

            if(table[i]!=null){

                Client<Key, Value> client = table[i];

                while(client != null){
                    
                    /**
                     * each loop an account number will be selected
                     * the below logic will get the account name for each loop
                     */
                    String StringNumber = "" + client.accountnumber; //set object account number as string
                    int IntNumber = Integer.parseInt(StringNumber); //set string account number as int
                    Clients current_client = bank.selectAccount(IntNumber); //get account details from account number

                    //System.out.print("" + client.accountnumber + " :: " + client.accountdetails);
                    result = result + "# " + client.accountnumber + " - " + current_client.getName() + " - " + current_client.getStatus() + "\n";
                    client = client.nextNode;
                    //return client.accountnumber + " :: " + client.accountdetails + client.nextNode;
                }
            }
        }
        
        return result;
        
    }

    //this method checks if there are any accounts
    public int checkForAccounts() {

        int nulls = 0;

        //this for loop will run counting how manu nodes are null
        //if any of them is not detected as null then there are accounts
        for(int i = 0; i < capacity; i++) {

            //if all nodes are null then there are no accounts
            if(table[i] == null) {
                nulls++;
            }

        }

        return nulls;

    }

   /**
    * The hash method hashes the account number to find the correct bucket for the account added.
    * my account numbers go from 100000 to 199999. the buckets for these accounts after hashing go from 0 to 15.
    * this is a very important method because the implementation of hash maps rely a lot on the hashing to find the correct location or node.
    * 
    * @param accountnumber
    */
    private int hash(Key accountnumber){
        int hash = Math.abs(accountnumber.hashCode()) % capacity;
        //JOptionPane.showMessageDialog(null, hash);
        
        return hash;
    }



    /**
     * From here down I will define the methods for good program functionality
     * 
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
        Clients current_client = bank.selectAccount(selected_account);
        current_client.setDeposit(deposit_amount, print_date);
    }
    //method to make a deposit
    public void setDeposit(int selected_account, double deposit_amount) {
        Clients current_client = bank.selectAccount(selected_account);
        current_client.setDeposit(deposit_amount, print_date);
    }
    //method to make withdrawal
    public void setWithdrawal(int selected_account, double deposit_amount) {
        Clients current_client = bank.selectAccount(selected_account);
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

    //method to deposit money into an account
    public void makeDeposit(Key selected_account) {

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

        Clients current_client = bank.selectAccount((Integer) selected_account);

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


    //make withdrawal
    public void makeWithdrawal(int selected_account) {

        boolean value_ok = false;
        String value = " ";

        while(value_ok == false || " ".equals(value)) {
            System.out.print("Please enter the ammount to withdraw: ");
            withdraw_amount = input.nextDouble();

            if(withdraw_amount <= 0) {
                System.out.println("The amount has to be a positive value.");
            } else {
                value_ok = true;
                value = "";
            }

        }

        Clients current_client = bank.selectAccount(selected_account);
        
        //calculate if withdrawal is valid or not
        if(current_client.getBalance() < withdraw_amount) {
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


    //retrieve sorted transactions
    public String getSortedTransactions(int selected_account) {

        Clients current_client = bank.selectAccount(selected_account);
        
        //if(current_client.getSortedTransactions() == "") {
        if(current_client.getSortedTransactions().isEmpty()) {
            //System.out.println("No transactions to show.");
            return "No transactions to show.";
        } else  {

            //System.out.println(current_client.getSortedTransactions());
            return "" + current_client.getSortedTransactions();
        }

    }

    //retrieve unsorted transactions
    public String getUnsortedTransactions(Key selected_account) {

        Clients current_client = bank.selectAccount((Integer) selected_account);
        
        //if(current_client.getUnsortedTransactions() == "") {
        if(current_client.getUnsortedTransactions().isEmpty()) {
            //System.out.println("No transactions to show.");
            return "No transactions to show.";
        } else {

            //System.out.println(current_client.getUnsortedTransactions());
            return "" + current_client.getUnsortedTransactions();
        }

    }

    //get sorted transactions using custom algorithm
    public String getCustomSortedTransactions(Key selected_account) {

        Clients current_client = bank.selectAccount((Integer) selected_account);
        
        //if (current_client.getCustomSortedTransactions() == "") {
        if(current_client.getCustomSortedTransactions().isEmpty()) {
            //System.out.println("No transactions to show.");
            return "No transactions to show.";
        } else {

            //System.out.println(current_client.getCustomSortedTransactions());
            return "" + current_client.getCustomSortedTransactions();
        }
    }

    //get account details
    public String accountDetails(int selected_account) {

        Clients current_client = bank.selectAccount(selected_account);

        return "Account number: " + selected_account + " - " + client_name
                + "\nAccount status: " + current_client.getStatus()
                + "\nAccount balance: £" + current_client.getBalance() + "\n";
    }

    //get account status
    public String accountStatus(int selected_account) {
        Clients current_client = bank.selectAccount(selected_account);

        return current_client.getStatus();
    }
    //get account name
    public String accountName(int selected_account) {
        Clients current_client = bank.selectAccount(selected_account);

        return current_client.getName();
    }
    //get account balance
    public double accountBalance(int selected_account) {
        Clients current_client = bank.selectAccount(selected_account);
        
        return current_client.getBalance();
    }
    //set account active
    public void setActive(int selected_account) {
        Clients current_client = bank.selectAccount(selected_account);
        
        current_client.activateAccount();
    }
    //set account inactive
    public void setInactive(int selected_account) {
        Clients current_client = bank.selectAccount(selected_account);
        
        current_client.deactivateAccount();
    }



    //method to delete account
    public int deleteAccount(int selected_account) {

        Clients current_client = bank.selectAccount(selected_account);

        //if the account is active returns 0 or else return 1
        if("Active".equals(current_client.getStatus())) {
            return 0;
        } else {
            return 1;
        }
    }
    //do the delete bit
    public void doDelete(int selected_account) {

        bank.removeAccount(selected_account);
        System.out.println("");
    }

}