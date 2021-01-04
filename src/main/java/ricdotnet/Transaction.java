package ricdotnet;

/**
 * MiniBank Java Program
 * The excess of spaces is for better human readability
 * 
 * @author Ricardo Rocha - rrocha.uk
 * 
 */

public class Transaction implements Comparable<Transaction> {
//public class Transaction {}

    //private int account_number;
    private final double transaction_amount;
    private final String transaction_type;
    private final String transaction_date;

    // public Transaction(int account_number, double transaction_amount, String transaction_type) {
    //     this.account_number = account_number;
    //     this.transaction_amount = transaction_amount;
    //     this.transaction_type = transaction_type;
    // }

    /**
     *
     * @param transaction_amount
     * @param transaction_type
     * @param transaction_date
     */
    public Transaction(double transaction_amount, String transaction_type, String transaction_date) {
        //this.account_number = account_number;
        this.transaction_amount = transaction_amount;
        this.transaction_type = transaction_type;
        this.transaction_date = transaction_date;
    }

    /**
     *
     * @return
     */
    public double getTransactionAmount() {
        return transaction_amount;
    }

    //override toString
    @Override
    public String toString() {
        return " :: " + transaction_type + " :: £" + Double.toString(transaction_amount) + " :: " + transaction_date;
    }

    //comparable to compare transactions and sort them from lower to higher
    @Override
    public int compareTo(Transaction transaction_to_compare) {
        if(this.transaction_amount < ((Transaction) transaction_to_compare).transaction_amount) {
            return -1;
        }else if(this.transaction_amount == ((Transaction) transaction_to_compare).transaction_amount) {
            return 0;
        }else {
            return 1;
        }
    }
    
}