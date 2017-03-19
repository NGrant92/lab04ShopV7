package controllers;
import java.util.*;

import static utils.ScannerInput.*;

import models.Butter;
import models.Milk;
import models.Product;

/**
 * This class runs the application and handles the Store with its Products.
 *  
 * @author
 */
public class MenuController
{

    private Scanner input;
    private Store store;

    public static void main(String[] args)
    {
    	new MenuController();
    }
    
    public MenuController()
    {
        input = new Scanner(System.in);

        //read in the details....
        System.out.print("Please enter the store location: ");
        String location = input.nextLine();

        store = new Store(location);
        runMenu();
    }

    /*
     * mainMenu() - This method displays the menu for the application, 
     * reads the menu option that the user entered and returns it.
     * 
     * @return     the users menu choice
     */
    private int mainMenu()
    { 
        System.out.println("\fShop Menu");
        System.out.println("---------");     
        System.out.println("  1) Add a Product");    
        System.out.println("  2) List the Products"); 
        System.out.println("  3) Update a Product");    
        System.out.println("  4) Remove Product (by index)");        
        System.out.println("---------");             
        System.out.println("  5) List the cheapest product");        
        System.out.println("---------");     
        System.out.println("  6) View store details"); 
        System.out.println("---------");
        System.out.println("  7) Save products (XML)");
        System.out.println("  8) Load products (XML)");
        System.out.println("  0) Exit");
        int option = validNextInt("==>> ");
        return option;
    }

    /*
     * This is the method that controls the loop.
     */
    private void runMenu()
    {
        int option = mainMenu();
        while (option != 0)
        {  
            switch (option)
            {
                case 1:    addProduct();
                           break;
                case 2:    System.out.println(store.listProducts());
                           break;
                case 3:    updateProduct();
                		   break;              
                case 4:    store.remove(getIndex());
                           break;              
                case 5:    System.out.println(store.cheapestProduct());
                		   break;
                case 6:    System.out.println(store.toString());
                		   break;
                case 7:    try 
                			{
                				store.save();
                			}
                			catch(Exception e)
                			{
                				System.err.println("Error writing to file: "+e);
                			}
                			break;
                case 8:    try
			                {
			                	store.load();
			                }
			                catch (Exception e)
			                {
			                	System.err.println("Error reading from file: "+e);
			                }
			                break;
                default:   System.out.println("Invalid option entered: " + option);
                           break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine(); //2nd read for bug in Scanner; String read is ignored after reading int.
            //display the main menu again
            option = mainMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    //gather the product data from the user and create a new product.
    private void addProduct()
    {  
        //dummy read of String to clear the buffer - bug in Scanner class.
        input.nextLine();
		   
        //gather details of the new product AND
		//store the new product in the array list
		store.add(readProductDetails());
    }
    
    private void updateProduct() 
    {
    	//retrieve the index for the product for update
    	int index = getIndex();
    	if (store.isValidIndex(index))
    	{
	  	   input.nextLine();  //dummy read - bug in Scanner class.
        	   
	  	   //gather details to update the selected product with
	  	   Product productDetails = readProductDetails();
	  		   
	  	   //retrieve the product and update it using the details entered in by the user
	  	   Product productToUpdate = store.get(index);
	  	   productToUpdate.setInCurrentProductLine(productDetails.isInCurrentProductLine());
	  	   productToUpdate.setProductCode(productDetails.getProductCode());
	  	   productToUpdate.setProductName(productDetails.getProductName());
	  	   productToUpdate.setUnitCost(productDetails.getUnitCost());
	  	}
	 }
    
    //===========================
    // HELPER / UTILITY METHODS
    //===========================
    
     private Product readProductDetails() 
     {
    	   //read the product details from the user and return them as a product object
    	   System.out.println("Enter the Product details...");
		   System.out.print("\tName:  ");
		   String productName = input.nextLine();
		   
		   int productCode = validNextInt("\tCode (between 1000 and 9999):  ");
		   double unitCost = validNextDouble("\tUnit Cost:  ");
		   
		   System.out.print("\tIs this product in your current line (y/n): ");
		   char currentProduct = input.next().charAt(0);
		   boolean inCurrentProductLine = false;
		   if ((currentProduct == 'y') || (currentProduct == 'Y'))
			   inCurrentProductLine = true;
		   
		   Date bestBeforeDate = validNextDate("\tEnter best before date: (dd/MM/yyy)");
		   
		   System.out.print("\tIs this product Butter or Milk?");
		   char dairyProduct = input.next().toLowerCase().charAt(0);
		   if(dairyProduct == 'b')
		   {
			   int packetGrams = validNextInt("\tEnter amount of grams per packet: ");
			   
			   boolean isSalted = false;
			   System.out.print("\tIs it salted? (y/n)");
			   char salted = input.next().toLowerCase().charAt(0);
			   if(salted == 'y')
			   {
				   isSalted = true;
			   }
			   
			   return (new Butter(productName, productCode, unitCost, inCurrentProductLine, 
					   bestBeforeDate, packetGrams, isSalted));
			   
		   }
		   else if(dairyProduct == 'm')
		   {
			   int cartonSize = validNextInt("\tEnter amount of grams per packet: ");
			   
			   System.out.print("\tEnter fat content: ");
			   String fatContent = input.nextLine();
			   
			   
			   return (new Milk(productName, productCode, unitCost, inCurrentProductLine, 
					   bestBeforeDate, cartonSize, fatContent));
		   }
		   else
		   {
			   return (new Product(productName, productCode, unitCost, inCurrentProductLine));
		   }
     }

	 private int getIndex()
	 {
		 System.out.println(store.listProducts());
		 if (store.size() > 0)
		 {
			 System.out.print("Please enter the index to select the product: ");
			 int index = input.nextInt();
			 if (store.isValidIndex(index))
			 {
				 return index;
			 }
			 else{
				 System.out.println("Invalid index entered: " + index ); 
				 return -1;  //error code - invalid index entered
			 }
		 }
		 else {
			 return -2;  //error code - empty array list
		 }
	 }
}
