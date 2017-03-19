package models;
/**
 * Represents a Product.  Stores the product name, product code,
 * unitCost and whether the product is in the current product
 * line or not.
 *  
 * @author Siobhan Drohan
 * @version 1.0 (25th Jan 2017)
 */
public class Product
{
    //instance fields
    private String productName;
    private int productCode;
    private double unitCost;
    private boolean inCurrentProductLine;

    /**
     * Constructor for objects of class Product
     * 
     * @param productName Name of the product
     * @param productCode Code of the product (between 1000 and 9999)
     * @param unitCost Unit cost of the product (greater than zero)
     * @param inCurrentProductLine indicates whether the 
     *        product is in the current product line or not
     */
    public Product(String productName, int productCode, 
                   double unitCost, boolean inCurrentProductLine){
        this.productName = productName;
        if ((productCode >= 1000) && (productCode <= 9999)){
            this.productCode = productCode;
        }
        else{
            this.productCode = 1;
        }
        if (unitCost > 0){
            this.unitCost = unitCost;
        }
        else{
            this.unitCost = 0;
        }
        this.inCurrentProductLine = inCurrentProductLine;
    }

    //-------
    //getters
    //-------
    /**
     * Returns the product name for the specified object
     * 
     * @return The Product Name 
     */
    public String getProductName(){
        return productName;
    }

    /**
     * Returns the unit cost for the specified object
     * 
     * @return The Unit Cost 
     */
    public double getUnitCost(){
        return unitCost;
    }

    /**
     * Returns the product code for the specified object
     * 
     * @return The Product Code 
     */
    public int getProductCode() {
        return productCode;
    }

    /**
     * Returns a boolean indicating if the product is in 
     * the current product line 
     * 
     * @return Is the product in the current product line
     */
    public boolean isInCurrentProductLine() {
        return inCurrentProductLine;
    }

    //-------
    //setters
    //-------
    /**
     * Updates the Product Code to the value passed as 
     * a parameter (must be between 1000 and 9999).
     * 
     * @param productCode The new Product Code
     */
    public void setProductCode(int productCode) {
        if ((productCode >= 1000) && (productCode <= 9999)){
            this.productCode = productCode;
        }  
    }

    /**
     * Updates the Product Name to the value passed as a parameter 
     * 
     * @param productName The new Product Name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Updates the Unit Cost to the value passed as a 
     * parameter (must be greater than zero).
     * 
     * @param unitCost The new unit cost for the product
     */
    public void setUnitCost(double unitCost) {
        if (unitCost > 0){
            this.unitCost = unitCost;
        }
    }

    /**
     * Updates the boolean indicating whether the product 
     * is in the current product line or not.  
     * 
     * @param inCurrentProductLine Indicator that determines if 
     *        the product is in the current product line or not.
     */
    public void setInCurrentProductLine(boolean inCurrentProductLine) {
        this.inCurrentProductLine = inCurrentProductLine;
    }
    
    /**
     * Returns a user-friendly string representation of the Product object
     * 
     * @return User-friendly String representing the current Product
     */
    public String toString(){
        return  "Product: " + productName
              + "(code: " + productCode + ")" 
              + ". Unit cost: " + unitCost
              + ".  In current product line: " + inCurrentProductLine;
              
    }

}