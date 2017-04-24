import java.util.ArrayList;

/**
 * Warehouse contains the different items in stock
 * 
 * @authors Mike Irvine and Jeremy Truscott
 *
 */
public class Warehouse
{
   // instance variables (fields)  
    //Should have an arraylist of items
    //ArrayList<Item> Stock;
    Item[] Stock;
    int NumberOfItems;
    // the constructor
   public Warehouse(){

       System.out.println("Created a warehouse.");
       //Stock = new ArrayList<Item>();     

       Stock = new Item[60];
       
    }
    
    /**
     * This is the hardcoded data to be loaded into the instance variables.  
     */
    public int loadData()
    {   
        //Item check = new Item();
        //System.out.println("test "+ check.getItemName());
        
        System.out.println("Loading Data...");
            
       // Stock.add(new Item());
       // System.out.println("testing add:");
       // System.out.println(Stock.get(0).getItemNo());
       // System.out.println(Stock.get(0).getItemName());
        //itemNo,itemName,onHand,committed,onOrder,unitPrice,reorderPoint,econOrderQty
        Stock[0] = new Item();
        Stock[0].loadNewData("A11111", "Widgets", 30, 50, 70, 2.50, 20, 50);
        NumberOfItems += 1;
        Stock[1] = new Item();
        Stock[1].loadNewData("B22222", "Gadgets", 10, 20, 0, 4.00, 50, 100);
        NumberOfItems += 1;
        Stock[2] = new Item();
        Stock[2].loadNewData("C33333", "Trinkets", 100, 20, 35, 3.75, 80, 150);
        NumberOfItems += 1;
        Stock[3] = new Item();
        Stock[3].loadNewData("D44444", "Pickets", 0, 100, 20, 8.35, 25, 75);
        NumberOfItems += 1;
        Stock[4] = new Item();        
        Stock[4].loadNewData("E55555", "Sockets", 200, 300, 150, 1.00, 200, 400);
        NumberOfItems += 1;
        // number of items is 5;
        System.out.println("Data loaded...");        
        return 1;
    }
       
    public boolean isValid(String ItemInput){
        for(int i = 0;i < NumberOfItems;i++){
            System.out.println("Checking is valid");
            if(Stock[i].getItemNo().equalsIgnoreCase(ItemInput)){
                System.out.println("match found at:"+(i+1));
                return true;
            }
            //System.out.println(Stock[i]);
            
        }
       return false;

    }
    
    public boolean printItem(String ItemInput){
        for(int i = 0;i < NumberOfItems ; i++){
           // System.out.println("print item test");
            if(Stock[i].getItemNo().equalsIgnoreCase(ItemInput)){
                Stock[i].printItem();
                return true;
                   
            }
            //System.out.println(Stock[i]);
   
        }
        return false;

    }
    //2: order Iventroy items
    public boolean OrderInventory(String ItemInput,int noOrdered){
        for(int i = 0;i < NumberOfItems ; i++){
            System.out.println("OrderInventory");
            if(Stock[i].getItemNo().equalsIgnoreCase(ItemInput)){
                Stock[i].printItem();
                //update Item info at array element 1
                Stock[i].addOnOrder(noOrdered);
                Stock[i].printItem();
                
                return true;
                   
            }
            System.out.println(Stock[i]);
   
        }
        return false;

    }  
        //3: process order recieved
        public boolean processOrderReceived(String ItemInput,int noReceived){
        for(int i = 0;i < NumberOfItems ; i++){
            System.out.println("processOrderReceived test");
            if(Stock[i].getItemNo().equalsIgnoreCase(ItemInput)){
                Stock[i].printItem();
                //update Item info at array element 1
                Stock[i].processOrderReceived(noReceived);
                Stock[i].printItem();
                
                return true;
                   
            }
            System.out.println(Stock[i]);
   
        }
        return false;

    }  
    //4: processOrderReturned
        public boolean processOrderReturned(String ItemInput,int noReturned){
        for(int i = 0;i < NumberOfItems;i++){
            System.out.println("processOrderReturned test");
            if(Stock[i].getItemNo().equalsIgnoreCase(ItemInput)){
               // Stock[i].printItem();
                //update Item info at array element 1
               Stock[i].processOrderReturned(noReturned);
               Stock[i].printItem();
                
               return true;
                   
            }
            System.out.println(Stock[i]);
   
        }
        return false;

    }  
    
    //5:Ship Items to Customers
        public boolean shipItemstoCustomers(String ItemInput,int itemsToBeShipped){
            
        System.out.println("shipItemstoCustomers test*******");
        int i;    
        for(i = 0;i < NumberOfItems;i++){
            //System.out.println("shipItemstoCustomers test");
            if(Stock[i].getItemNo().equalsIgnoreCase(ItemInput)){
                //Stock[i].printItem();
                //update Item info at array element 1
               Stock[i].shipItemsToCustomers(itemsToBeShipped);
               Stock[i].printItem();
                
                return true;
                   
            }
            
   
        }
        System.out.println("Item not found");
        return false;

    }  
    //6: process customer order
    public boolean processCustomerOrder(String ItemInput,int numberOrderedByCustomer){
        //System.out.println("processCustomerOrder test warehouse level &&&&&&&&&&&&&");
        int i;    
        for(i = 0;i < NumberOfItems;i++){
            //System.out.println("shipItemstoCustomers test");
            if(Stock[i].getItemNo().equalsIgnoreCase(ItemInput)){
                //Stock[i].printItem();
                //update Item info at array element 1
               Stock[i].processCustOrder(numberOrderedByCustomer);
               
               Stock[i].printItem();
                
                return true;
                   
            }
        }
        System.out.println("Item not found");
        return false;
    }
    //7: process customer order
    public boolean processCustomerReturn(String ItemInput,int numberReturnedByCustomer){
       //System.out.println("processCustomerOrder test warehouse level &&&&&&&&&&&&&");
        int i;    
        for(i = 0;i < NumberOfItems;i++){
            //System.out.println("shipItemstoCustomers test");
            if(Stock[i].getItemNo().equalsIgnoreCase(ItemInput)){
                //Stock[i].printItem();
                //update Item info at array element 1
               Stock[i].processCustReturn(numberReturnedByCustomer);
               
               Stock[i].printItem();
                
                return true;
                   
            }
        }
        System.out.println("Item not found");
        return false;
    }
    public void printTheInventoryReport(){
        for(int i = 0;i < NumberOfItems;i++){
            //System.out.println("Printall test");
            System.out.println(Stock[i]);
   
        }
    }
    
    
    public void printAll(){
        for(int i = 0;i < NumberOfItems;i++){
            //System.out.println("Printall test");
            System.out.println(Stock[i]);
   
        }
    }
}
