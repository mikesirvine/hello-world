// import required libraries
import java.util.*;  // import the Scanner Class
import java.io.*; 

/**
 * This is the interface that the user will use to process Inventory
 * 
 * @authors  Mike Irvine and Jeremy Truscott 
 * @ Due Date
 */

public class Interface 
{
    
    public static void main(String args[])
    {
        //clear screen first
        System.out.print('\u000C');
        
        int choice = 1;
        boolean done = false;
        //Interface IF = new Interface();
        Warehouse WH = new Warehouse();
        //WH = new Warehouse();
        WH.loadData();
        //Print out all items in stock
        
        System.out.println("Stock List:");
        
        WH.printAll();
        // define necessary variables here
        
        // place here the code for the processing requirements
        //the next 3 items help with input
        Scanner input = new Scanner(System.in);
        //inputLine to get item number
        String inputLine;
        //tempInt to input number of items to be processed
        String stringInt;
        int tempInt;
        String trashLine;
        
        while(!done){
            //WH.printAll();
            
            choice = showMenu();
            
            switch (choice) {
                case 1://student answer
                    //Inventory Information Inquiry 
                    System.out.println("you pressed 1");
               
                    System.out.println("Input Item Number:");
                    inputLine = input.nextLine();
                    
                    if(WH.isValid(inputLine))
                        WH.printItem(inputLine);
                        else {
                        System.out.println("** Invalid item number entered.");
                    }
                    //WH.printAll();
                    break;
                case 2:
                    //Order Inventory Items

                    System.out.println("you pressed 2");
                    System.out.println("Input Item Number:");
                    inputLine = input.nextLine();
                    
                    if(WH.isValid(inputLine)){
                        WH.printItem(inputLine);
                        
                        System.out.println("Input amount to be ordered:");

                        tempInt = input.nextInt();
                        
                        //while(input.hasNext())
                        //might want to test temp input.
                        WH.OrderInventory(inputLine,tempInt);
                        //tempInt = input.nextInt();
                        trashLine = input.nextLine();//** gets rid of extra newline*                        
                    } else {
                        System.out.println("Invalid item number entered.");
                    }
                    //QM.PrintCorrectAnswers();
                    break;
                case 3:

                //Received shipment from Supplier
                    System.out.println("you pressed 3");
                    System.out.println("Input Item Number:");
                    inputLine = input.nextLine();
                    
                    if(WH.isValid(inputLine)){
                        WH.printItem(inputLine);
                        
                        System.out.println("Input amount to be recieved:");
                        tempInt= input.nextInt();                        
                        //might want to test temp input.
                        WH.processOrderReceived(inputLine,tempInt);
                        trashLine = input.nextLine();//** gets rid of extra newline*                                                
                    } else {
                        System.out.println("Invalid item number entered.");
                    }

                    break;
                case 4:
                    //Return Items to Supplier
                    System.out.println("you pressed 4");
                    System.out.println("Input Item Number:");
                    inputLine = input.nextLine();
                    
                    if(WH.isValid(inputLine)){
                        WH.printItem(inputLine);
                        
                        System.out.println("Input number returned to supplier:");
                        tempInt= input.nextInt();                        
                        //might want to test temp input.
                        WH.processOrderReturned(inputLine,tempInt);
                        trashLine = input.nextLine();//** gets rid of extra newline*                                                
                    } else {
                        System.out.println("Invalid item number entered.");
                    }

                    break;
                case 5:
                    //Ship Items to Customers
                    System.out.println("you pressed 5");
                    
                    System.out.println("Input Item Number:");
                    inputLine = input.nextLine();
                    
                    if(WH.isValid(inputLine)){
                        WH.printItem(inputLine);
                        
                        System.out.println("Input number to be be shipped to the customer:");
                        tempInt= input.nextInt();                        
                        //might want to test temp input.
                        WH.shipItemstoCustomers(inputLine,tempInt);
                        trashLine = input.nextLine();//** gets rid of extra newline*                        
                    } else {
                        System.out.println("Invalid item number entered.");
                    }
                    
                    
                    
                    
                    break;
                case 6:
                    //Process Customer Order
                    System.out.println("you pressed 6");
                    
                    System.out.println("Input Item Number:");
                    inputLine = input.nextLine();
                    
                    if(WH.isValid(inputLine)){
                        WH.printItem(inputLine);
                        
                        System.out.println("Input amount ordered by the customer:");
                        tempInt= input.nextInt();                        
                        //might want to test temp input.
                        WH.processCustomerOrder(inputLine,tempInt);
                        //System.out.println("after process 6");
                        trashLine = input.nextLine();//** gets rid of extra newline*                        
                    } else {
                        System.out.println("Invalid item number entered.");
                    }
                    
                    break;
                case 7:
                    //Process Customer Returns
                    System.out.println("you pressed 7");

                    System.out.println("Input Item Number:");
                    inputLine = input.nextLine();
                    
                    if(WH.isValid(inputLine)){
                        WH.printItem(inputLine);
                        
                        System.out.println("Input amount returned by the customer:");
                        tempInt= input.nextInt();                        
                        //might want to test temp input.
                        WH.processCustomerReturn(inputLine,tempInt);

                        trashLine = input.nextLine();//** gets rid of extra newline*                        
                    } else {
                        System.out.println("Invalid item number entered.");
                    }

                    
                    
                    break;
                case 8:
                    //End of Day processing
                    System.out.println("you pressed 8");
                    break;
                case 9:
                    //exit program
                    System.out.println("you pressed 9");
                    done = true;
                    break;
                case 0:
                default:
                    System.out.println("Error, invalid command.");
                    
                
            }//end switch 
    
            //if(choice == 9)
               
         
        }
        System.out.println ("Thank you for using the Inventory Processing System");
    }//end of main

    //public static void ProcessCommand(int choice, boolean done){
    //public static void ProcessCommand(int choice,Warehouse wh){
             /*   switch (choice) {
                case 1://student answer
                    //Inventory Information Inquiry 
                    System.out.println("you pressed 1");
                    //QM.PrintStudentAnswers();
                    System.out.println("testing printall");
                    wh.printAll();
                    break;
                case 2:
                    //Order Inventory Items
                    System.out.println("you pressed 2");
                    //QM.PrintCorrectAnswers();
                    break;
                case 3:
                    //Received shipment from Supplier
                    System.out.println("you pressed 3");
                    break;
                case 4:
                    //Return Items to Supplier
                    System.out.println("you pressed 4");
                    break;
                case 5:
                    //Ship Items to Customers
                    System.out.println("you pressed 5");
                    break;
                case 6:
                    //Process Customer Order
                    System.out.println("you pressed 6");
                    break;
                case 7:
                    //Process Customer Returns
                    System.out.println("you pressed 7");
                    break;
                case 8:
                    //End of Day processing
                    System.out.println("you pressed 8");
                    break;
                case 9:
                    System.out.println("you pressed 9");
                    break;
                case 0:
                default:
                    System.out.println("Error, invalid command.");
                    
                
            }//end switch 
               */ 

        
    //}
    
    /**
     *  The Inventory processing menu
     */
    public static int showMenu()
    {
        int menuInput;
        int inputLine = 0;
        //String inputLine = "";
        //int inputLine = 0;
        
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("\nMENU:");
        System.out.println("1) Inventory Item Inquiry");
        System.out.println("2) Order inventory items from Supplier");
        System.out.println("3) Receive shipment from Suppliers");
        System.out.println("4) Return items to Supplier");
        System.out.println("5) Ship items to Customers");
        System.out.println("6) Process Customer Order");
        System.out.println("7) Process Customer Returns");
        System.out.println("8) End of Day Processing");
        System.out.println();
        System.out.println("9) Exit");
        
        //while(input.hasNext() ) {
            if(input.hasNextInt())
                inputLine = input.nextInt();
            //inputLine = input.nextLine();
            //System.out.println("input Line ="+inputLine);
        //}
        menuInput = inputLine;
        //System.out.println("menu choice:"+menuInput);
        return menuInput;        
    }

   
}
