package ricdotnet;

/**
 * MiniBank Java Program
 * The excess of spaces is for better human readability
 * 
 * @author Ricardo Rocha - rrocha.uk
 * 
 */

import java.util.ArrayList;
import java.util.Collections;

public class Clients {

    private final String client_name;
    private final String client_address;
    private final int client_age;
    private double account_balance = 0; //cant be final because can be updated with new balance amounts (deposits and withdrawals)
    private String account_status; //cannot be final because has to be updated for delete account purposes
    private final String open_date;

    //ArrayList to save the transactions
    private final ArrayList<Transaction> unsorted_list = new ArrayList<>();

    /**
     *
     * @param client_name
     * @param client_address
     * @param client_age
     * @param open_date
     * @param account_balance
     * @param account_status
     * @param unsorted_list
     */
    public Clients(String client_name, String client_address, int client_age, String open_date, double account_balance, String account_status, ArrayList<Transaction> unsorted_list){
        // this.firstname = firstname;
        // this.lastname = lastname;
        this.client_name = client_name;
        this.client_address = client_address;
        this.client_age = client_age;
        //this.account_balance = account_balance; //if this line is on add double balance
        this.account_status = account_status;
        this.open_date = open_date;
        //this.accnumber = accnumber;

    } //end Clients method

    //account activator
    public void activateAccount(){
        account_status = "Active";
    }

    //acount deactivator
    public void deactivateAccount(){
        account_status = "Inactive";
    }

    /**
     * balance getter
     * @return
     */
    public double getBalance() {
        return account_balance;
    }

    /**
     * status getter
     * @return
     */
    public String getStatus() {
        return account_status;
    }

    /**
     * name getter
     * @return
     */
    public String getName() {
        return client_name;
    }

    /**
     * Setting the first deposit on the transactions without double adding
     * @deprecated
     * 
     * @param deposit_amount
     * @param transaction_date
     */
    public void setFirstDeposit(double deposit_amount, String transaction_date) {
         //add transaction on the list to be sorted
         // Transaction new_transaction_sorted = new Transaction(account_number, deposit_amount, "Deposit...");
         // sorted_list.add(new_transaction_sorted);
 
         System.out.println(transaction_date);
     
         //add transaction to the list NOT to be sorted
         Transaction new_transaction_unsorted = new Transaction(deposit_amount, "Deposit...", transaction_date);
         unsorted_list.add(new_transaction_unsorted);
    }

    /**
     * set a deposit
     * 
     * @param deposit_amount
     * @param transaction_date
     */
    public void setDeposit(double deposit_amount, String transaction_date){
        this.account_balance = account_balance + deposit_amount;

        //to keep the arraylist size on 6 remove the 0 when there are 6
        // if(sorted_list.size() == 6) {
        //     sorted_list.remove(0);
        // }

        //add transaction on the list to be sorted
        // Transaction new_transaction_sorted = new Transaction(account_number, deposit_amount, "Deposit...");
        // sorted_list.add(new_transaction_sorted);

        //add transaction to the list NOT to be sorted
        Transaction new_transaction_unsorted = new Transaction(deposit_amount, "Deposit...", transaction_date);
        unsorted_list.add(new_transaction_unsorted);
    }

    /**
     * will set a withdrawal transaction
     * 
     * @param withdrawal_amount
     * @param transaction_date
     */
    public void setWithdrawal(double withdrawal_amount, String transaction_date){
        this.account_balance = account_balance - withdrawal_amount;

        //to keep the array list on 6 transactions remove the 0 from the sorted
        // if(sorted_list.size() == 6) {
        //     sorted_list.remove(0);
        // }

        //add transaction on the list to be sorted
        // Transaction new_sorted_transaction = new Transaction(account_number, withdrawal_amount, "Withdrawal");
        // sorted_list.add(new_sorted_transaction);

        //ass transaction to the list NOT to be sorted
        Transaction new_unsorted_transaction = new Transaction(withdrawal_amount, "Withdrawal", transaction_date);
        unsorted_list.add(new_unsorted_transaction);
    }

    /**
     * this method when called will always set the unsorted list as unmodifiable
     * by doing this it will always print not sorted avoiding even the sorting overriding from Transaction.java
     * 
     * @return
     */
    public String getUnsortedTransactions() {

        /**
         * set unsorted list unmodifiable
         * making this unmodifiable the compareTo() method will never change it
         **/
        Collections.unmodifiableList(unsorted_list);

        int id = 1; //this defines an ID for the transaction list. not related to index value

        //enhanced loop to print the unsorted list
        String result = "";
        //System.out.println("##### UNSORTED TRANSACTIONS #####");
        for (Transaction print : unsorted_list) {
            //System.out.println(Integer.toString(id) + print);
            result = result + id + print + "\n";
            id++;
        }
        //System.out.println();

        //return unsorted_list; //return the unsorted list
        return result;
    }

    /**
     * calling this method will sort the transactions list and then sort it
     * it used the compareTo() method from comparable to sort
     * 
     * @return
     */
    public String getSortedTransactions() {

        //clone the unsorted_list to be sorted
        @SuppressWarnings("unchecked")
        ArrayList<Transaction> sorted_list = (ArrayList<Transaction>)unsorted_list.clone();

        /**
         * remove index 0 until sorted_list.size() is 6 if sorted_list.size() is larger than 6
         * ex: if sorted_list.size() is 10 then 10-6 = 4
         * removes the first 4 elements.
         * the loop iterates 4 times removing 4 times the index 0.
         **/
        if(sorted_list.size() > 6) {

            int list_size = sorted_list.size() - 6;

            for(int i = 0; i < list_size; i++) {
                sorted_list.remove(0);
            }
        }

        //sort the list
        Collections.sort(sorted_list);


        int id = 1; //this defines an ID for the transaction list. not related to index value

        //enhanced loop to print the sorted list
        String result = "";
        //System.out.println("##### LAST SIX TRANSACTIONS - SORTED #####");
        for (Transaction print : sorted_list) {
            //System.out.println(Integer.toString(id) + print);
            result = result + id + print + "\n";
            id++;
        }
        //System.out.println();
        
        //return sorted_list; //return the sorted list
        return result;

    }

    /**
     * custom algorithm to sort transactions by amount
     * 
     * @return
     */
    public String getCustomSortedTransactions() {

        //clone the unsorted_list to be sorted
        //ArrayList<Transaction> custom_sorted_list = (ArrayList<Transaction>)unsorted_list.clone();

        @SuppressWarnings("unchecked")
        ArrayList<Transaction> custom_sorted_list = (ArrayList<Transaction>)unsorted_list.clone();

        //keep only the last 6 transactions
        if(custom_sorted_list.size() > 6) {

            int list_size = custom_sorted_list.size() - 6;

            for(int i = 0; i < list_size; i++) {
                custom_sorted_list.remove(0);
            }
        }

        //bubble sort algorithm
        Transaction custom_sorted_list_temp;

        int n = custom_sorted_list.size(); //get the list size (6 values only)

        for(int i = 0; i < n - 1; i++){

            for(int j = 0; j < n - i - 1; j++){

                if(custom_sorted_list.get(j).getTransactionAmount() > custom_sorted_list.get(j+1).getTransactionAmount()) {
                    custom_sorted_list_temp = custom_sorted_list.get(j);
                    custom_sorted_list.set(j, custom_sorted_list.get(j + 1));
                    custom_sorted_list.set(j + 1, custom_sorted_list_temp);
                }

            }

        }

        int id = 1; //this defines an ID for the transaction list. not related to index value

        //enhanced loop to print the sorted list
        String result = "";
        //System.out.println("##### LAST SIX TRANSACTIONS - SORTED #####");
        for (Transaction print : custom_sorted_list) {
            //System.out.println(Integer.toString(id) + print);
            result = result + id + print + "\n";
            id++;
        }
        //System.out.println();

        return result;
    }

    /**
     * prints accounts details
     * 
     * @return
    */
    public String accounts() {
        return client_name + " :: " + client_age + " :: " + client_address + " :: " + open_date + " :: £" + account_balance + " :: " + account_status + "\n";
    }

    @Override //for account list printing
    public String toString(){
        String result = "Client name: " + client_name + "\n"
                + "Client address: " + client_address + "\n"
                + "Client age: " + client_age + "\n"
                + "Date open: " + open_date + "\n"
                + "Account balance: £" + account_balance + "\n"
                + "Account status: " + account_status + "\n"
                + "********** \n\n";
        
        return result;
        //return client_name + " :: " + client_age + " :: " + client_address + " :: " + open_date + " :: £" + account_balance + " :: " + account_status + "\n";
    }

} //end main class