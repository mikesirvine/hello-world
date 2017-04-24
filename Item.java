
/**
 * This is the class that defines the Inventory Item of a company 
 * 
 * @authors Mike Irvine and Jeremy Truscott 
 * 
 */
public class Item
{
    // the instance variables (fields)
   String itemNo;
   String itemName;
   int onHand;
   int committed;
   int onOrder;
   double unitPrice;
   int reorderPoint;
   int econOrderQty;
    
   // the constructors
   Item() {
       //empty constructer
       itemNo = null;
       itemName = null;
       onHand = 0;
       committed = 0;
       onOrder = 0;
       unitPrice = 0;
       reorderPoint = 0;
       econOrderQty = 0;
       
       System.out.println("Created Empty Item");
       //System.out.println("Item Name: " + itemName);
        //return this;
    
    }

   Item(String iNum,String itemNa,int oH,double uP,int rP,int eOQ) {
       //everything but committed and onorder constructer
       itemNo = iNum;
       itemName = itemNa;
       onHand = oH;
       unitPrice =uP;
       reorderPoint = rP;
       econOrderQty = eOQ;
        System.out.println("Created without commited and onOrder Item");
        //return this;
    
    }    

   Item(String iNum,String itemNa,int oH,int com,int oNo,double uP,int rP,int eOQ) {
       //everything constructer
       itemNo = iNum;
       itemName = itemNa;
       onHand = oH;
       committed = com;
       onOrder = oNo;
       unitPrice =uP;
       reorderPoint = rP;
       econOrderQty = eOQ;
       System.out.println("Created full Item");
        //return this;
    
    }
    
    //copy constructer
    Item(Item sourceItem) {
       itemNo = sourceItem.getItemNo();
       itemName = sourceItem.getItemName();
       onHand = sourceItem.getonHand();
       committed = sourceItem.getcommitted();
       onOrder = sourceItem.getonOrder();
       unitPrice = sourceItem.getUnitPrice();
       reorderPoint = sourceItem.getreorderPoint();
       econOrderQty = sourceItem.geteconOrderQty();
       
       System.out.println("Item copy creation");
        
        
    }
    
    //Getters

    public String getItemNo(){
        return itemNo;
    }

    public String getItemName(){
        return itemName;
    }
    
    public int getonHand(){
        return onHand;
    }
    public int getcommitted(){
        return committed;
    }
    public int getonOrder(){
        return onOrder;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    public int getreorderPoint(){
        return reorderPoint;
    }
    
    public int geteconOrderQty(){
        return econOrderQty;
    }
    
 

    // the mutators
   public void addOnOrder(int noOrdered) {
       onOrder += noOrdered;
    }

    // place the processing methods here 
   public void processOrderReceived(int noReceived) {
       onOrder -= noReceived;
       onHand += noReceived;
    }
    
   public void processOrderReturned(int noReturned) {
       if(noReturned > onHand)
         System.out.println("too many item returned ");
       else 
         onHand -= noReturned;
    }
    
   //5 ship items to customers 
   public void shipItemsToCustomers(int itemsToBeShipped ){
       
       
       System.out.println("******Item FUnction******.");
       if(itemsToBeShipped < committed){
           committed = committed -itemsToBeShipped;
           System.out.println("Shipment made *** 1 ***");
        
        } else if ( (itemsToBeShipped > committed ) && ( itemsToBeShipped <= (committed+ onHand) ) ) {
            //prcess shipment which is requested
            //difference between requested and committed is subtracted from onHand
            itemsToBeShipped = itemsToBeShipped-committed;
            onHand = onHand - itemsToBeShipped;
            System.out.println("Shipment made *** 2 ***");        
            committed = 0;
        
        
        } else if(itemsToBeShipped > committed+ onHand){
            System.out.println("Shipment is not possible, ammount on hand is not enough to fulfill order");
           
        }
       
   }
   //6: process customer order
   public void processCustOrder(int amountOrdered){
   
       System.out.println("$$$$$$$$$$ in processCust Order(6)$$$$$$$$$$ Item Level");
       if(amountOrdered <= onHand){
       System.out.println("$$$$$$$$$$ in processCust Order(6)did first if");
           committed += amountOrdered;
           onHand -= amountOrdered;
       } else {
       System.out.println("$$$$$$$$$$ in processCust Order(6)did second if");
           committed += onHand;
           onOrder += onHand - amountOrdered; 
           onHand = 0;
       }
   }
   //7:process customer returned
   public void processCustReturn(int amountReturned) {
       onHand += amountReturned;
   }
    
    
    /*load new data into created object */
   public void loadNewData(String ItNum,String ItName,int onHan,int comm, int onOrd,double unitP,int reOrdPoint, int ecoOrderQty) {
        itemNo = ItNum;
        itemName = ItName ;
        onHand = onHan;
        committed = comm;
        onOrder = onOrd;
        unitPrice = unitP;
        reorderPoint = reOrdPoint;
        econOrderQty = ecoOrderQty;
   }
    // place the print and toString methods here
    public void printItem(){
        System.out.println("In print item");
        System.out.println("Item Number\t\t"       + itemNo );
        System.out.println("Item Name\t\t"         + itemName); 
        System.out.println("On Hand\t\t\t"           + onHand );
        System.out.println("Committed\t\t"         + committed); 
        System.out.println("On Order\t\t"           + onOrder);
        System.out.println("Unit Price \t\t"        + unitPrice); 
        System.out.println("Reorder Point\t\t"      + reorderPoint);
        System.out.println("Economic Order Qty\t" + econOrderQty);
    }
    public String toString(){
        //System.out.println("In To String");
        return " "+itemNo +" "+itemName+" "+onHand+" "+committed+" "+onOrder+" "+unitPrice +" "+reorderPoint+" " +econOrderQty ;
    }
}
