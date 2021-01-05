package ricdotnet;

/**
 * MiniBank Java Program
 * The excess of spaces is for better human readability
 * 
 * @author Ricardo Rocha - rrocha.uk
 * 
 */

import java.util.*;
import javax.swing.*;

/**
 *
 * @author ricardorocha
 */
public class BankGUI extends javax.swing.JFrame {
    
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    static Scanner input = new Scanner(System.in);


    /**
     * First 2 lines is for java libraries
     * 3rd line is for custom hash map
     */
    static HashMap<Integer, Clients> client = new HashMap<Integer, Clients>();
    static MiniBank bank = new MiniBank(); //create object from MiniBank class
    //static MiniBankCustom<Integer, Clients> bank = new MiniBankCustom<Integer, Clients>();
    
    //this arraylist will always exist because it stores transactions
    static ArrayList<Transaction> transactions; //call transaction class


    static String client_name;
    static String client_address;
    static int account_number;
    static int client_age;
    static double account_balance;
    static String account_status;
    

    //online variable for while loops
    @Deprecated static boolean program_on = true; //when true keeps the user on the main menu - if set to false quits the program
    @Deprecated static boolean on_account_menu = true; //when true keeps the user on account menu. when set to false goes back to main menu
    @Deprecated static int option;

    //variables for menu option
    static int account_option; //variable for account menu selection
    static int selected_account; //registers the selected account

    /**
     * Creates new form BankGUI
     */
    public BankGUI() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewAccountDetails = new javax.swing.JFrame();
        NewAccountTitle = new javax.swing.JLabel();
        NewAccountName = new javax.swing.JLabel();
        NewAccountAddress = new javax.swing.JLabel();
        NewAccountAge = new javax.swing.JLabel();
        NewAccountBalance = new javax.swing.JLabel();
        NewAccountNumber = new javax.swing.JLabel();
        NewAccountAddressInput = new javax.swing.JTextField();
        NewAccountNameInput = new javax.swing.JTextField();
        NewAccountAgeInput = new javax.swing.JTextField();
        NewAccountBalanceInput = new javax.swing.JTextField();
        NewAccountNumberInput = new javax.swing.JLabel();
        NewAccountCreateButton = new javax.swing.JButton();
        NewAccountClearButton1 = new javax.swing.JButton();
        NewAccountCloseButton = new javax.swing.JButton();
        AvailableAccounts = new javax.swing.JFrame();
        AvailableAccountsResult = new javax.swing.JScrollPane();
        AvailableAccountsTextResult = new javax.swing.JTextPane();
        AvailableAccountsTitle = new javax.swing.JLabel();
        AvailableAccountsCloseButton = new javax.swing.JButton();
        SelectAnAccount = new javax.swing.JFrame();
        SelectAnAccountList = new javax.swing.JScrollPane();
        SelectAnAccountTextList = new javax.swing.JTextArea();
        SelectAnAccountNumberInput = new javax.swing.JTextField();
        SelectAnAccountNumberLabel = new javax.swing.JLabel();
        SelectAnAccountTitle = new javax.swing.JLabel();
        SelectAnAccountCloseButton = new javax.swing.JButton();
        SelectAnAccountSelectButton = new javax.swing.JButton();
        SelectAnAccountAddAccountButton = new javax.swing.JButton();
        SelectedAccount = new javax.swing.JFrame();
        SelectedAccountDetails = new javax.swing.JScrollPane();
        SelectedAccountDetailsText = new javax.swing.JTextPane();
        SelectedAccountTitle = new javax.swing.JLabel();
        SelectedAccountCloseButton = new javax.swing.JButton();
        DepositButton = new javax.swing.JButton();
        WithdrawButton = new javax.swing.JButton();
        LastTransactionsUnordered = new javax.swing.JButton();
        LastSixTransactionsOrdered = new javax.swing.JButton();
        DeleteAccount = new javax.swing.JButton();
        SelectedAccountNumber = new javax.swing.JLabel();
        LastSixTransactionsOrderedCA = new javax.swing.JButton();
        DepositFrame = new javax.swing.JFrame();
        DepositAmountLabel = new javax.swing.JLabel();
        DepositAmountInput = new javax.swing.JTextField();
        ConfirmDepositButton = new javax.swing.JButton();
        WithdrawalFrame = new javax.swing.JFrame();
        WithdrawAmountLabel = new javax.swing.JLabel();
        WithdrawAmountInput = new javax.swing.JTextField();
        ConfirmWithdrawButton = new javax.swing.JButton();
        LastSixTransactionsOrderedResult = new javax.swing.JFrame();
        LastSixTransactionsOrderedResultCloseButton = new javax.swing.JButton();
        LastSixTransactionsOrderedResultTextBox = new javax.swing.JScrollPane();
        LastSixTransactionsOrderedResultText = new javax.swing.JTextPane();
        LastSixOrderedTransactionsResultTitle = new javax.swing.JLabel();
        LastTransactionsUnorderedResult = new javax.swing.JFrame();
        LastTransactionsUnorderedResultCloseButton1 = new javax.swing.JButton();
        LastTransactionsUnorderedResultTextBox = new javax.swing.JScrollPane();
        LastTransactionsUnorderedResultText = new javax.swing.JTextPane();
        LastUnorderedTransactionsResultTitle = new javax.swing.JLabel();
        LastSixTransactionsOrderedResultCA = new javax.swing.JFrame();
        LastSixTransactionsOrderedResultCloseButtonCA = new javax.swing.JButton();
        LastSixTransactionsOrderedResultTextBoxCA = new javax.swing.JScrollPane();
        LastSixTransactionsOrderedResultTextCA = new javax.swing.JTextPane();
        LastSixOrderedTransactionsResultTitleCA = new javax.swing.JLabel();
        MainTitle = new javax.swing.JLabel();
        AddAccount = new javax.swing.JButton();
        PrintAccounts = new javax.swing.JButton();
        SelectAccount = new javax.swing.JButton();
        Quit = new javax.swing.JButton();

        NewAccountDetails.setTitle("Add a New Account");
        NewAccountDetails.setLocationByPlatform(true);
        NewAccountDetails.setName("newaccountdetails"); // NOI18N
        NewAccountDetails.setSize(new java.awt.Dimension(408, 360));

        NewAccountTitle.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        NewAccountTitle.setText("New Account Details");

        NewAccountName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountName.setText("Name:");

        NewAccountAddress.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountAddress.setText("Address:");

        NewAccountAge.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountAge.setText("Age:");

        NewAccountBalance.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountBalance.setText("Starting Balance:");

        NewAccountNumber.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountNumber.setText("Account Number:");

        NewAccountAddressInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountAddressInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAccountAddressInputActionPerformed(evt);
            }
        });

        NewAccountNameInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAccountNameInputActionPerformed(evt);
            }
        });

        NewAccountAgeInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountAgeInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAccountAgeInputActionPerformed(evt);
            }
        });

        NewAccountBalanceInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountBalanceInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAccountBalanceInputActionPerformed(evt);
            }
        });

        NewAccountNumberInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountNumberInput.setText("");

        NewAccountCreateButton.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountCreateButton.setText("Add Account");
        NewAccountCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAccountCreateButtonActionPerformed(evt);
            }
        });

        NewAccountClearButton1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountClearButton1.setText("Clear");
        NewAccountClearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAccountClearButton1ActionPerformed(evt);
            }
        });

        NewAccountCloseButton.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NewAccountCloseButton.setText("Close");
        NewAccountCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAccountCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewAccountDetailsLayout = new javax.swing.GroupLayout(NewAccountDetails.getContentPane());
        NewAccountDetails.getContentPane().setLayout(NewAccountDetailsLayout);
        NewAccountDetailsLayout.setHorizontalGroup(
            NewAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewAccountDetailsLayout.createSequentialGroup()
                .addGroup(NewAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewAccountDetailsLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(NewAccountTitle))
                    .addGroup(NewAccountDetailsLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(NewAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NewAccountAddress)
                            .addComponent(NewAccountName)
                            .addComponent(NewAccountAge)
                            .addComponent(NewAccountBalance)
                            .addComponent(NewAccountNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(NewAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NewAccountNumberInput)
                            .addComponent(NewAccountNameInput, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(NewAccountAddressInput)
                            .addComponent(NewAccountAgeInput)
                            .addComponent(NewAccountBalanceInput))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewAccountDetailsLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(NewAccountCloseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewAccountClearButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewAccountCreateButton)
                .addGap(18, 18, 18))
        );
        NewAccountDetailsLayout.setVerticalGroup(
            NewAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewAccountDetailsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(NewAccountTitle)
                .addGap(18, 18, 18)
                .addGroup(NewAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewAccountName)
                    .addComponent(NewAccountNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewAccountAddress)
                    .addComponent(NewAccountAddressInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewAccountAge)
                    .addComponent(NewAccountAgeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewAccountBalance)
                    .addComponent(NewAccountBalanceInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewAccountNumber)
                    .addComponent(NewAccountNumberInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NewAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewAccountClearButton1)
                    .addComponent(NewAccountCreateButton)
                    .addComponent(NewAccountCloseButton))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        AvailableAccounts.setTitle("Available Accounts");
        AvailableAccounts.setLocationByPlatform(true);
        AvailableAccounts.setName("AvailableAccounts"); // NOI18N
        AvailableAccounts.setSize(new java.awt.Dimension(500, 380));
        AvailableAccounts.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                AvailableAccountsWindowActivated(evt);
            }
        });

        AvailableAccountsTextResult.setEditable(false);
        AvailableAccountsTextResult.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        AvailableAccountsResult.setViewportView(AvailableAccountsTextResult);

        AvailableAccountsTitle.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        AvailableAccountsTitle.setText("Available Accounts");

        AvailableAccountsCloseButton.setText("Close");
        AvailableAccountsCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvailableAccountsCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AvailableAccountsLayout = new javax.swing.GroupLayout(AvailableAccounts.getContentPane());
        AvailableAccounts.getContentPane().setLayout(AvailableAccountsLayout);
        AvailableAccountsLayout.setHorizontalGroup(
            AvailableAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AvailableAccountsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AvailableAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AvailableAccountsLayout.createSequentialGroup()
                        .addComponent(AvailableAccountsTitle)
                        .addGap(0, 290, Short.MAX_VALUE))
                    .addComponent(AvailableAccountsResult)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AvailableAccountsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AvailableAccountsCloseButton)))
                .addContainerGap())
        );
        AvailableAccountsLayout.setVerticalGroup(
            AvailableAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AvailableAccountsLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(AvailableAccountsTitle)
                .addGap(18, 18, 18)
                .addComponent(AvailableAccountsResult, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AvailableAccountsCloseButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        SelectAnAccount.setTitle("Select an Account");
        SelectAnAccount.setLocationByPlatform(true);
        SelectAnAccount.setSize(new java.awt.Dimension(345, 260));
        SelectAnAccount.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                SelectAnAccountWindowActivated(evt);
            }
        });

        SelectAnAccountTextList.setEditable(false);
        SelectAnAccountTextList.setColumns(20);
        SelectAnAccountTextList.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        SelectAnAccountTextList.setRows(5);
        SelectAnAccountList.setViewportView(SelectAnAccountTextList);

        SelectAnAccountNumberInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        SelectAnAccountNumberLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        SelectAnAccountNumberLabel.setText("Account number:");

        SelectAnAccountTitle.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        SelectAnAccountTitle.setText("Select an Account");

        SelectAnAccountCloseButton.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        SelectAnAccountCloseButton.setText("Close");
        SelectAnAccountCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectAnAccountCloseButtonActionPerformed(evt);
            }
        });

        SelectAnAccountSelectButton.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        SelectAnAccountSelectButton.setText("Select");
        SelectAnAccountSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectAnAccountSelectButtonActionPerformed(evt);
            }
        });

        SelectAnAccountAddAccountButton.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        SelectAnAccountAddAccountButton.setText("Add an Account");
        SelectAnAccountAddAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectAnAccountAddAccountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SelectAnAccountLayout = new javax.swing.GroupLayout(SelectAnAccount.getContentPane());
        SelectAnAccount.getContentPane().setLayout(SelectAnAccountLayout);
        SelectAnAccountLayout.setHorizontalGroup(
            SelectAnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectAnAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SelectAnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SelectAnAccountLayout.createSequentialGroup()
                        .addComponent(SelectAnAccountList)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SelectAnAccountLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SelectAnAccountAddAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectAnAccountCloseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectAnAccountSelectButton)
                        .addGap(12, 12, 12))
                    .addGroup(SelectAnAccountLayout.createSequentialGroup()
                        .addGroup(SelectAnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SelectAnAccountLayout.createSequentialGroup()
                                .addComponent(SelectAnAccountNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SelectAnAccountNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SelectAnAccountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        SelectAnAccountLayout.setVerticalGroup(
            SelectAnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectAnAccountLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(SelectAnAccountTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SelectAnAccountList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SelectAnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectAnAccountNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectAnAccountNumberLabel))
                .addGap(9, 9, 9)
                .addGroup(SelectAnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectAnAccountCloseButton)
                    .addComponent(SelectAnAccountSelectButton)
                    .addComponent(SelectAnAccountAddAccountButton))
                .addContainerGap())
        );

        SelectedAccount.setLocationByPlatform(true);
        SelectedAccount.setSize(new java.awt.Dimension(464, 308));

        SelectedAccountDetailsText.setEditable(false);
        SelectedAccountDetailsText.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        SelectedAccountDetails.setViewportView(SelectedAccountDetailsText);

        SelectedAccountTitle.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        SelectedAccountTitle.setText("Account details and options.");

        SelectedAccountCloseButton.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        SelectedAccountCloseButton.setText("Close");
        SelectedAccountCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedAccountCloseButtonActionPerformed(evt);
            }
        });

        DepositButton.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        DepositButton.setText("Deposit Money");
        DepositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositButtonActionPerformed(evt);
            }
        });

        WithdrawButton.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        WithdrawButton.setText("Withdraw Money");
        WithdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WithdrawButtonActionPerformed(evt);
            }
        });

        LastTransactionsUnordered.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        LastTransactionsUnordered.setText("Last Movements");
        LastTransactionsUnordered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastTransactionsUnorderedActionPerformed(evt);
            }
        });

        LastSixTransactionsOrdered.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        LastSixTransactionsOrdered.setText("Last 6 Ordered");
        LastSixTransactionsOrdered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastSixTransactionsOrderedActionPerformed(evt);
            }
        });

        DeleteAccount.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        DeleteAccount.setText("Delete Account");
        DeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAccountActionPerformed(evt);
            }
        });

        SelectedAccountNumber.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        SelectedAccountNumber.setText("placeholder");

        LastSixTransactionsOrderedCA.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        LastSixTransactionsOrderedCA.setText("Last 6 Ordered - Custom Algorithm");
        LastSixTransactionsOrderedCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastSixTransactionsOrderedCAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SelectedAccountLayout = new javax.swing.GroupLayout(SelectedAccount.getContentPane());
        SelectedAccount.getContentPane().setLayout(SelectedAccountLayout);
        SelectedAccountLayout.setHorizontalGroup(
            SelectedAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectedAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SelectedAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SelectedAccountLayout.createSequentialGroup()
                        .addGroup(SelectedAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SelectedAccountDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LastSixTransactionsOrderedCA, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SelectedAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DepositButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(WithdrawButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LastTransactionsUnordered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LastSixTransactionsOrdered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SelectedAccountCloseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(SelectedAccountLayout.createSequentialGroup()
                        .addComponent(SelectedAccountTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectedAccountNumber)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        SelectedAccountLayout.setVerticalGroup(
            SelectedAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SelectedAccountLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(SelectedAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectedAccountTitle)
                    .addComponent(SelectedAccountNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SelectedAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SelectedAccountLayout.createSequentialGroup()
                        .addComponent(DepositButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WithdrawButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LastTransactionsUnordered)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LastSixTransactionsOrdered)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectedAccountCloseButton))
                    .addGroup(SelectedAccountLayout.createSequentialGroup()
                        .addComponent(SelectedAccountDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LastSixTransactionsOrderedCA)))
                .addGap(13, 13, 13))
        );

        DepositFrame.setTitle("Make a deposit.");
        DepositFrame.setLocationByPlatform(true);
        DepositFrame.setSize(new java.awt.Dimension(260, 103));

        DepositAmountLabel.setText("Amount to Deposit:");

        ConfirmDepositButton.setText("Deposit");
        ConfirmDepositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmDepositButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DepositFrameLayout = new javax.swing.GroupLayout(DepositFrame.getContentPane());
        DepositFrame.getContentPane().setLayout(DepositFrameLayout);
        DepositFrameLayout.setHorizontalGroup(
            DepositFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DepositFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DepositAmountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DepositFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ConfirmDepositButton, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(DepositAmountInput))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DepositFrameLayout.setVerticalGroup(
            DepositFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DepositFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DepositFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepositAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DepositAmountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ConfirmDepositButton)
                .addContainerGap())
        );

        WithdrawalFrame.setTitle("Make a withdrawal.");
        WithdrawalFrame.setLocationByPlatform(true);
        WithdrawalFrame.setSize(new java.awt.Dimension(260, 103));

        WithdrawAmountLabel.setText("Amount to Withdraw:");

        ConfirmWithdrawButton.setText("Withdraw");
        ConfirmWithdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmWithdrawButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout WithdrawalFrameLayout = new javax.swing.GroupLayout(WithdrawalFrame.getContentPane());
        WithdrawalFrame.getContentPane().setLayout(WithdrawalFrameLayout);
        WithdrawalFrameLayout.setHorizontalGroup(
            WithdrawalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WithdrawalFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(WithdrawAmountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(WithdrawalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ConfirmWithdrawButton, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(WithdrawAmountInput))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WithdrawalFrameLayout.setVerticalGroup(
            WithdrawalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WithdrawalFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WithdrawalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WithdrawAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WithdrawAmountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ConfirmWithdrawButton)
                .addContainerGap())
        );

        LastSixTransactionsOrderedResult.setTitle("Last Six Transactions Sorted");
        LastSixTransactionsOrderedResult.setLocationByPlatform(true);
        LastSixTransactionsOrderedResult.setSize(new java.awt.Dimension(331, 313));

        LastSixTransactionsOrderedResultCloseButton.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        LastSixTransactionsOrderedResultCloseButton.setText("Close");
        LastSixTransactionsOrderedResultCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastSixTransactionsOrderedResultCloseButtonActionPerformed(evt);
            }
        });

        LastSixTransactionsOrderedResultText.setEditable(false);
        LastSixTransactionsOrderedResultTextBox.setViewportView(LastSixTransactionsOrderedResultText);

        LastSixOrderedTransactionsResultTitle.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        LastSixOrderedTransactionsResultTitle.setText("Last Six Ordered Transactions");

        javax.swing.GroupLayout LastSixTransactionsOrderedResultLayout = new javax.swing.GroupLayout(LastSixTransactionsOrderedResult.getContentPane());
        LastSixTransactionsOrderedResult.getContentPane().setLayout(LastSixTransactionsOrderedResultLayout);
        LastSixTransactionsOrderedResultLayout.setHorizontalGroup(
            LastSixTransactionsOrderedResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LastSixTransactionsOrderedResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LastSixTransactionsOrderedResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LastSixTransactionsOrderedResultTextBox)
                    .addComponent(LastSixOrderedTransactionsResultTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LastSixTransactionsOrderedResultLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LastSixTransactionsOrderedResultCloseButton)
                .addContainerGap())
        );
        LastSixTransactionsOrderedResultLayout.setVerticalGroup(
            LastSixTransactionsOrderedResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LastSixTransactionsOrderedResultLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(LastSixOrderedTransactionsResultTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LastSixTransactionsOrderedResultTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LastSixTransactionsOrderedResultCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        LastTransactionsUnorderedResult.setTitle("Last Transactions Unsorted");
        LastTransactionsUnorderedResult.setLocationByPlatform(true);
        LastTransactionsUnorderedResult.setSize(new java.awt.Dimension(298, 313));

        LastTransactionsUnorderedResultCloseButton1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        LastTransactionsUnorderedResultCloseButton1.setText("Close");
        LastTransactionsUnorderedResultCloseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastTransactionsUnorderedResultCloseButton1ActionPerformed(evt);
            }
        });

        LastTransactionsUnorderedResultText.setEditable(false);
        LastTransactionsUnorderedResultTextBox.setViewportView(LastTransactionsUnorderedResultText);

        LastUnorderedTransactionsResultTitle.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        LastUnorderedTransactionsResultTitle.setText("Last Unsorted Transactions");

        javax.swing.GroupLayout LastTransactionsUnorderedResultLayout = new javax.swing.GroupLayout(LastTransactionsUnorderedResult.getContentPane());
        LastTransactionsUnorderedResult.getContentPane().setLayout(LastTransactionsUnorderedResultLayout);
        LastTransactionsUnorderedResultLayout.setHorizontalGroup(
            LastTransactionsUnorderedResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LastTransactionsUnorderedResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LastTransactionsUnorderedResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LastTransactionsUnorderedResultTextBox)
                    .addComponent(LastUnorderedTransactionsResultTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LastTransactionsUnorderedResultLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LastTransactionsUnorderedResultCloseButton1)
                .addContainerGap())
        );
        LastTransactionsUnorderedResultLayout.setVerticalGroup(
            LastTransactionsUnorderedResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LastTransactionsUnorderedResultLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(LastUnorderedTransactionsResultTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LastTransactionsUnorderedResultTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LastTransactionsUnorderedResultCloseButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        LastSixTransactionsOrderedResultCA.setTitle("Last Six Transactions Sorted");
        LastSixTransactionsOrderedResultCA.setLocationByPlatform(true);
        LastSixTransactionsOrderedResultCA.setSize(new java.awt.Dimension(331, 313));

        LastSixTransactionsOrderedResultCloseButtonCA.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        LastSixTransactionsOrderedResultCloseButtonCA.setText("Close");
        LastSixTransactionsOrderedResultCloseButtonCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastSixTransactionsOrderedResultCloseButtonCAActionPerformed(evt);
            }
        });

        LastSixTransactionsOrderedResultTextCA.setEditable(false);
        LastSixTransactionsOrderedResultTextBoxCA.setViewportView(LastSixTransactionsOrderedResultTextCA);

        LastSixOrderedTransactionsResultTitleCA.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        LastSixOrderedTransactionsResultTitleCA.setText("Last Six Ordered - Custom Algorithm");

        javax.swing.GroupLayout LastSixTransactionsOrderedResultCALayout = new javax.swing.GroupLayout(LastSixTransactionsOrderedResultCA.getContentPane());
        LastSixTransactionsOrderedResultCA.getContentPane().setLayout(LastSixTransactionsOrderedResultCALayout);
        LastSixTransactionsOrderedResultCALayout.setHorizontalGroup(
            LastSixTransactionsOrderedResultCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LastSixTransactionsOrderedResultCALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LastSixTransactionsOrderedResultCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LastSixTransactionsOrderedResultTextBoxCA)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LastSixTransactionsOrderedResultCALayout.createSequentialGroup()
                        .addGap(0, 205, Short.MAX_VALUE)
                        .addComponent(LastSixTransactionsOrderedResultCloseButtonCA))
                    .addComponent(LastSixOrderedTransactionsResultTitleCA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        LastSixTransactionsOrderedResultCALayout.setVerticalGroup(
            LastSixTransactionsOrderedResultCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LastSixTransactionsOrderedResultCALayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(LastSixOrderedTransactionsResultTitleCA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LastSixTransactionsOrderedResultTextBoxCA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LastSixTransactionsOrderedResultCloseButtonCA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiniBank - Ricardo Rocha");
        setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        setForeground(java.awt.Color.white);
        setLocationByPlatform(true);
        setName("MainFrame"); // NOI18N

        MainTitle.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        MainTitle.setText("MiniBank - Welcome");
        MainTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MainTitle.setName("Main Title"); // NOI18N

        AddAccount.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        AddAccount.setText("Add Account");
        AddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAccountActionPerformed(evt);
            }
        });

        PrintAccounts.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        PrintAccounts.setText("Print Accounts");
        PrintAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintAccountsActionPerformed(evt);
            }
        });

        SelectAccount.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        SelectAccount.setText("Select Account");
        SelectAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectAccountActionPerformed(evt);
            }
        });

        Quit.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        Quit.setText("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Quit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SelectAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrintAccounts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MainTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(MainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrintAccounts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(Quit)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PrintAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintAccountsActionPerformed
        // TODO add your handling code here:
        AvailableAccounts.setVisible(true);
    }//GEN-LAST:event_PrintAccountsActionPerformed

    private void SelectAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectAccountActionPerformed
        // TODO add your handling code here:
        //String selected_account = JOptionPane.showInputDialog(null, "Enter an account number: ");
        SelectAnAccountNumberInput.setText("");
        
        SelectAnAccount.setVisible(true);
    }//GEN-LAST:event_SelectAccountActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed

    private void AddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAccountActionPerformed
        int number = bank.generateAccountNumber();
        NewAccountNumberInput.setText(String.valueOf(number));
        
        NewAccountNameInput.setText("");
        NewAccountAddressInput.setText("");
        NewAccountAgeInput.setText("");
        NewAccountBalanceInput.setText("");
        
        NewAccountDetails.setVisible(true);
    }//GEN-LAST:event_AddAccountActionPerformed

    private void NewAccountAddressInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAccountAddressInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewAccountAddressInputActionPerformed

    private void NewAccountNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAccountNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewAccountNameInputActionPerformed

    private void NewAccountAgeInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAccountAgeInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewAccountAgeInputActionPerformed

    private void NewAccountBalanceInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAccountBalanceInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewAccountBalanceInputActionPerformed

    private void NewAccountCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAccountCreateButtonActionPerformed
        // TODO add your handling code here:
        //int number = bank.generateAccountNumber();
        //NewAccountNumberInput.setText(String.valueOf(number));
        
        //try {
            client_name = NewAccountNameInput.getText();
            client_address = NewAccountAddressInput.getText();
            account_number = Integer.parseInt(NewAccountNumberInput.getText());
        
            if(client_name.isEmpty()) {
                JOptionPane.showMessageDialog(NewAccountDetails, "Please enter a name.");
                return;
            }
            if(client_address.isEmpty()) {
                JOptionPane.showMessageDialog(NewAccountDetails, "Please enter an address.");
                return;
            }
        
        try {
            client_age = Integer.parseInt(NewAccountAgeInput.getText());
            
            if(client_age < 18) {
                JOptionPane.showMessageDialog(NewAccountDetails, "The client has to be 18 or older.");
                return;
            } else if(client_age > 65) {
                JOptionPane.showMessageDialog(NewAccountDetails, "The client has to be 65 or younger.");
                return;
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(NewAccountDetails, "Please enter a valid Age.");
            return;
        }
        try {
            account_balance = Double.parseDouble(NewAccountBalanceInput.getText());
            
            if(account_balance < 0) {
                JOptionPane.showMessageDialog(NewAccountDetails, "The starting balance cannot be negative.");
                return;
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(NewAccountDetails, "Please enter a valid balance.");
            return;
        }
        
        if(account_balance == 0) {
            account_status = "Inactive";
        } else {
            account_status = "Active";
        }
        
            Clients customer = new Clients(client_name, client_address, client_age, bank.print_date, account_balance, account_status, transactions);
            //bank.put(account_number, customer);
            client.put(account_number, customer);
        
            //only set a first deposit if the starting balance is more than 0
            if(account_balance > 0) {
                bank.setFirstDeposit(account_number, account_balance); //setting a first deposit
            } else {
                JOptionPane.showMessageDialog(NewAccountDetails, "This account is being set as Inactive.\n"
                        + "Please make a deposit of at least 1£ to set is as Active.\n"
                        + "By being set as Inactive this account can be removed from the system.");
            }
        
            JOptionPane.showMessageDialog(NewAccountDetails, "Account added successfully. :)");
            NewAccountDetails.setVisible(false);
            
            AvailableAccountsTextResult.setText(bank.existingAccounts()); //update the printed accounts if window is opened
            
            //update select account window if open
            SelectAnAccountNumberInput.setEnabled(true);
            SelectAnAccountTextList.setText(bank.printAccountNumbers());
            
        //} catch (NumberFormatException e) {
        //    JOptionPane.showMessageDialog(NewAccountDetails, "Something is wrong on the form.");
        //}
        
    }//GEN-LAST:event_NewAccountCreateButtonActionPerformed

    private void NewAccountClearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAccountClearButton1ActionPerformed
        // TODO add your handling code here:
        NewAccountNameInput.setText("");
        NewAccountAddressInput.setText("");
        NewAccountAgeInput.setText("");
        NewAccountBalanceInput.setText("");
    }//GEN-LAST:event_NewAccountClearButton1ActionPerformed

    private void AvailableAccountsWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_AvailableAccountsWindowActivated
        // TODO add your handling code here:
        
        AvailableAccountsTextResult.setText(bank.existingAccounts());
    }//GEN-LAST:event_AvailableAccountsWindowActivated

    private void AvailableAccountsCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvailableAccountsCloseButtonActionPerformed
        // TODO add your handling code here:
        AvailableAccounts.setVisible(false);
    }//GEN-LAST:event_AvailableAccountsCloseButtonActionPerformed

    private void SelectAnAccountCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectAnAccountCloseButtonActionPerformed
        // TODO add your handling code here:
        SelectAnAccount.setVisible(false);
    }//GEN-LAST:event_SelectAnAccountCloseButtonActionPerformed

    private void NewAccountCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAccountCloseButtonActionPerformed
        // TODO add your handling code here:
        NewAccountDetails.setVisible(false);
    }//GEN-LAST:event_NewAccountCloseButtonActionPerformed

    private void SelectAnAccountSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectAnAccountSelectButtonActionPerformed
        // TODO add your handling code here:
        
        
        try {
            selected_account = Integer.parseInt(SelectAnAccountNumberInput.getText());
            
            if(bank.selectAccount(selected_account) != null) {
                //JOptionPane.showMessageDialog(SelectAnAccount, "account exists.");
                SelectAnAccount.setVisible(false);
                
                SelectedAccountNumber.setText(String.valueOf(selected_account)); //set label as account number
                SelectedAccount.setTitle("Editing account #: " + String.valueOf(selected_account)); //set the window title
                SelectedAccountDetailsText.setText("" + bank.selectAccount(selected_account)); //print account details
                SelectedAccount.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(SelectAnAccount, "That account does not exist. Please enter another number.");
                SelectAnAccountNumberInput.setText("");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(SelectAnAccount, "Enter a valid account number (numbers only).");
            SelectAnAccountNumberInput.setText("");
        }
    }//GEN-LAST:event_SelectAnAccountSelectButtonActionPerformed

    private void SelectAnAccountWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_SelectAnAccountWindowActivated
        // TODO add your handling code here:
        SelectAnAccountTextList.setText(bank.printAccountNumbers());
        SelectAnAccountAddAccountButton.setVisible(false);
        
        if("There are no bank accounts in the system.".equals(bank.existingAccounts())) {
            SelectAnAccountNumberInput.setEnabled(false);
            SelectAnAccountAddAccountButton.setVisible(true);
        }
        
    }//GEN-LAST:event_SelectAnAccountWindowActivated

    private void LastTransactionsUnorderedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastTransactionsUnorderedActionPerformed
        // TODO add your handling code here:
        selected_account = Integer.parseInt(SelectedAccountNumber.getText()); //parse account number as int

        LastTransactionsUnorderedResultText.setText(bank.getUnsortedTransactions(selected_account));
        
        LastTransactionsUnorderedResult.setVisible(true);
    }//GEN-LAST:event_LastTransactionsUnorderedActionPerformed

    private void SelectedAccountCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedAccountCloseButtonActionPerformed
        // TODO add your handling code here:
        SelectedAccount.setVisible(false);
    }//GEN-LAST:event_SelectedAccountCloseButtonActionPerformed

    private void DeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAccountActionPerformed
        // TODO add your handling code here:
        
        selected_account = Integer.parseInt(SelectedAccountNumber.getText()); //parse account number as int
        
        if(bank.deleteAccount(selected_account) == 0) { //check if account is active
            JOptionPane.showMessageDialog(SelectedAccount, "This account is still Active.\n"
                    + "Please withdraw all the money to mark is as Inactive.");
            
            return;
        }
  
        
        String delete_confirm = JOptionPane.showInputDialog(SelectedAccount, "Please write 'delete this account' on the text box.");
        SelectedAccount.setVisible(false);
        
        //JOptionPane.showMessageDialog(SelectedAccount, delete_confirm);
        
        if("delete this account".equals(delete_confirm)) {
            
            bank.doDelete(selected_account); //delete the account
            JOptionPane.showMessageDialog(SelectedAccount, "Account deleted with success!");
            SelectedAccount.setVisible(false);
            
            AvailableAccountsTextResult.setText(bank.existingAccounts()); //update the printed accounts if window is opened
            
            //Update select an account window if it is open
            SelectAnAccountTextList.setText(bank.printAccountNumbers());
            //SelectAnAccountAddAccountButton.setVisible(false);
            if("There are no bank accounts in the system.".equals(bank.existingAccounts())) {
                SelectAnAccountNumberInput.setEnabled(false);
                SelectAnAccountAddAccountButton.setVisible(true);
            }
            
        } else {
            //if the confirm message is wrong show this
            JOptionPane.showMessageDialog(SelectedAccount, "Confirmation failed. Please try again.");
        }
    }//GEN-LAST:event_DeleteAccountActionPerformed

    private void LastSixTransactionsOrderedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastSixTransactionsOrderedActionPerformed
        // TODO add your handling code here:
        selected_account = Integer.parseInt(SelectedAccountNumber.getText()); //parse account number as int

        LastSixTransactionsOrderedResultText.setText(bank.getSortedTransactions(selected_account));
        
        LastSixTransactionsOrderedResult.setVisible(true);
    }//GEN-LAST:event_LastSixTransactionsOrderedActionPerformed

    private void LastSixTransactionsOrderedResultCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastSixTransactionsOrderedResultCloseButtonActionPerformed
        // TODO add your handling code here:
        LastSixTransactionsOrderedResult.setVisible(false);
    }//GEN-LAST:event_LastSixTransactionsOrderedResultCloseButtonActionPerformed

    private void DepositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositButtonActionPerformed
        // TODO add your handling code here:
        DepositFrame.setVisible(true);
    }//GEN-LAST:event_DepositButtonActionPerformed

    private void ConfirmDepositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmDepositButtonActionPerformed
        // TODO add your handling code here:
        try {
            double deposit_amount = Double.parseDouble(DepositAmountInput.getText());
            
            selected_account = Integer.parseInt(SelectedAccountNumber.getText()); //parse account number as int
            
            //Clients current_client = bank.selectAccount(selected_account);
            
            if(deposit_amount < 0) {
                JOptionPane.showMessageDialog(SelectedAccount, "You cannot deposit a negative amount.");
            } else if(deposit_amount == 0) {
                JOptionPane.showMessageDialog(SelectedAccount, "Thanks for not depositing anything.");
            } else {
            
                bank.setDeposit(selected_account, deposit_amount);
                //current_client.setDeposit(deposit_amount, bank.print_date);
                
                JOptionPane.showMessageDialog(SelectedAccount, "Thanks for depositing.\n"
                        + "Your new balance is: £" + bank.accountBalance(selected_account));
                
                if("Inactive".equals(bank.accountStatus(selected_account))) {
                    JOptionPane.showMessageDialog(SelectedAccount, "This account is now set as Active and cannot be deleted.\n"
                            + "If you wish do delete this account please withdraw all the money from it to be marked as Inactive.");
                    
                    bank.setActive(selected_account);
                }
                
                DepositAmountInput.setText("");
                DepositFrame.setVisible(false);
                
                SelectedAccountDetailsText.setText("" + bank.selectAccount(selected_account)); //update account details
                AvailableAccountsTextResult.setText(bank.existingAccounts());
                
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(SelectedAccount, "Please enter a valid amount.");
        }
    }//GEN-LAST:event_ConfirmDepositButtonActionPerformed

    private void ConfirmWithdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmWithdrawButtonActionPerformed
        // TODO add your handling code here:
        try {
            double withdraw_amount = Double.parseDouble(WithdrawAmountInput.getText());
            
            selected_account = Integer.parseInt(SelectedAccountNumber.getText()); //parse account number as int
            
            //Clients current_client = bank.selectAccount(selected_account);
            
            if(withdraw_amount < 0) {
                JOptionPane.showMessageDialog(SelectedAccount, "You cannot withdraw a negative amount.");
            } else if(withdraw_amount == 0) {
                JOptionPane.showMessageDialog(SelectedAccount, "Thanks for not withdrawing anything.");
            } else if(withdraw_amount > bank.accountBalance(selected_account)) {
                JOptionPane.showMessageDialog(SelectedAccount, "You do not have enough money to withdraw.");
            } else {
            
                bank.setWithdrawal(selected_account, withdraw_amount);
                //current_client.setWithdrawal(withdraw_amount, bank.print_date);
                
                JOptionPane.showMessageDialog(SelectedAccount, "Thanks for withdrawing.\n"
                        + "Your new balance is: £" + bank.accountBalance(selected_account));
                
                if(bank.accountBalance(selected_account) == 0) {
                    JOptionPane.showMessageDialog(SelectedAccount, "This account is being set as Inactive.\n"
                            + "Please make a deposit of at least 1£ to set is as Active.\n"
                            + "By being set as Inactive this account can be removed from the system.");
                    
                    bank.setInactive(selected_account); //deactivate account
                }
                
                WithdrawAmountInput.setText("");
                WithdrawalFrame.setVisible(false);
                
                SelectedAccountDetailsText.setText("" + bank.selectAccount(selected_account)); //update account details
                AvailableAccountsTextResult.setText(bank.existingAccounts());
                
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(SelectedAccount, "Please enter a valid amount.");
        }
    }//GEN-LAST:event_ConfirmWithdrawButtonActionPerformed

    private void WithdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WithdrawButtonActionPerformed
        // TODO add your handling code here:
        WithdrawalFrame.setVisible(true);
    }//GEN-LAST:event_WithdrawButtonActionPerformed

    private void LastTransactionsUnorderedResultCloseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastTransactionsUnorderedResultCloseButton1ActionPerformed
        // TODO add your handling code here:
        LastTransactionsUnorderedResult.setVisible(false);
    }//GEN-LAST:event_LastTransactionsUnorderedResultCloseButton1ActionPerformed

    private void LastSixTransactionsOrderedCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastSixTransactionsOrderedCAActionPerformed
        // TODO add your handling code here:
        selected_account = Integer.parseInt(SelectedAccountNumber.getText()); //parse account number as int

        LastSixTransactionsOrderedResultTextCA.setText(bank.getCustomSortedTransactions(selected_account));
        
        LastSixTransactionsOrderedResultCA.setVisible(true);
    }//GEN-LAST:event_LastSixTransactionsOrderedCAActionPerformed

    private void LastSixTransactionsOrderedResultCloseButtonCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastSixTransactionsOrderedResultCloseButtonCAActionPerformed
        // TODO add your handling code here:
        LastSixTransactionsOrderedResultCA.setVisible(false);
    }//GEN-LAST:event_LastSixTransactionsOrderedResultCloseButtonCAActionPerformed

    private void SelectAnAccountAddAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectAnAccountAddAccountButtonActionPerformed
        // TODO add your handling code here:
        int number = bank.generateAccountNumber();
        NewAccountNumberInput.setText(String.valueOf(number));
        
        NewAccountNameInput.setText("");
        NewAccountAddressInput.setText("");
        NewAccountAgeInput.setText("");
        NewAccountBalanceInput.setText("");
        
        NewAccountDetails.setVisible(true);
    }//GEN-LAST:event_SelectAnAccountAddAccountButtonActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        // try {
        //     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        //         if ("Nimbus".equals(info.getName())) {
        //             javax.swing.UIManager.setLookAndFeel(info.getClassName());
        //             break;
        //         }
        //     }
        // } catch (ClassNotFoundException ex) {
        //     java.util.logging.Logger.getLogger(BankGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        // } catch (InstantiationException ex) {
        //     java.util.logging.Logger.getLogger(BankGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        // } catch (IllegalAccessException ex) {
        //     java.util.logging.Logger.getLogger(BankGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        //     java.util.logging.Logger.getLogger(BankGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        // }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAccount;
    private javax.swing.JFrame AvailableAccounts;
    private javax.swing.JButton AvailableAccountsCloseButton;
    private javax.swing.JScrollPane AvailableAccountsResult;
    private javax.swing.JTextPane AvailableAccountsTextResult;
    private javax.swing.JLabel AvailableAccountsTitle;
    private javax.swing.JButton ConfirmDepositButton;
    private javax.swing.JButton ConfirmWithdrawButton;
    private javax.swing.JButton DeleteAccount;
    private javax.swing.JTextField DepositAmountInput;
    private javax.swing.JLabel DepositAmountLabel;
    private javax.swing.JButton DepositButton;
    private javax.swing.JFrame DepositFrame;
    private javax.swing.JLabel LastSixOrderedTransactionsResultTitle;
    private javax.swing.JLabel LastSixOrderedTransactionsResultTitleCA;
    private javax.swing.JButton LastSixTransactionsOrdered;
    private javax.swing.JButton LastSixTransactionsOrderedCA;
    private javax.swing.JFrame LastSixTransactionsOrderedResult;
    private javax.swing.JFrame LastSixTransactionsOrderedResultCA;
    private javax.swing.JButton LastSixTransactionsOrderedResultCloseButton;
    private javax.swing.JButton LastSixTransactionsOrderedResultCloseButtonCA;
    private javax.swing.JTextPane LastSixTransactionsOrderedResultText;
    private javax.swing.JScrollPane LastSixTransactionsOrderedResultTextBox;
    private javax.swing.JScrollPane LastSixTransactionsOrderedResultTextBoxCA;
    private javax.swing.JTextPane LastSixTransactionsOrderedResultTextCA;
    private javax.swing.JButton LastTransactionsUnordered;
    private javax.swing.JFrame LastTransactionsUnorderedResult;
    private javax.swing.JButton LastTransactionsUnorderedResultCloseButton1;
    private javax.swing.JTextPane LastTransactionsUnorderedResultText;
    private javax.swing.JScrollPane LastTransactionsUnorderedResultTextBox;
    private javax.swing.JLabel LastUnorderedTransactionsResultTitle;
    private javax.swing.JLabel MainTitle;
    private javax.swing.JLabel NewAccountAddress;
    private javax.swing.JTextField NewAccountAddressInput;
    private javax.swing.JLabel NewAccountAge;
    private javax.swing.JTextField NewAccountAgeInput;
    private javax.swing.JLabel NewAccountBalance;
    private javax.swing.JTextField NewAccountBalanceInput;
    private javax.swing.JButton NewAccountClearButton1;
    private javax.swing.JButton NewAccountCloseButton;
    private javax.swing.JButton NewAccountCreateButton;
    private javax.swing.JFrame NewAccountDetails;
    private javax.swing.JLabel NewAccountName;
    private javax.swing.JTextField NewAccountNameInput;
    private javax.swing.JLabel NewAccountNumber;
    private javax.swing.JLabel NewAccountNumberInput;
    private javax.swing.JLabel NewAccountTitle;
    private javax.swing.JButton PrintAccounts;
    private javax.swing.JButton Quit;
    private javax.swing.JButton SelectAccount;
    private javax.swing.JFrame SelectAnAccount;
    private javax.swing.JButton SelectAnAccountAddAccountButton;
    private javax.swing.JButton SelectAnAccountCloseButton;
    private javax.swing.JScrollPane SelectAnAccountList;
    private javax.swing.JTextField SelectAnAccountNumberInput;
    private javax.swing.JLabel SelectAnAccountNumberLabel;
    private javax.swing.JButton SelectAnAccountSelectButton;
    private javax.swing.JTextArea SelectAnAccountTextList;
    private javax.swing.JLabel SelectAnAccountTitle;
    private javax.swing.JFrame SelectedAccount;
    private javax.swing.JButton SelectedAccountCloseButton;
    private javax.swing.JScrollPane SelectedAccountDetails;
    private javax.swing.JTextPane SelectedAccountDetailsText;
    private javax.swing.JLabel SelectedAccountNumber;
    private javax.swing.JLabel SelectedAccountTitle;
    private javax.swing.JTextField WithdrawAmountInput;
    private javax.swing.JLabel WithdrawAmountLabel;
    private javax.swing.JButton WithdrawButton;
    private javax.swing.JFrame WithdrawalFrame;
    // End of variables declaration//GEN-END:variables
}