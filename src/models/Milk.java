package models;

import java.util.*;
/**
 * - A field called cartonSize. type: int
 * - A field called fatContent. type: String
 * - A constructor that takes in the two instance fields and with the super class fields
 * - An accessor and mutator
 * - A toString method that uses both sub-fields and super fields. toString should also indicate that the product is type Milk
 * 
 * @author Niall G
 *
 */
public class Milk extends DairyProduct
{
	private int cartonSize;
	private String fatContent;
	
	public Milk(String productName, int productCode, double unitCost, boolean inCurrentProductLine, 
				Date bestBeforeDate, int cartonSize, String fatContent)
	{
		super(productName, productCode, unitCost, inCurrentProductLine, bestBeforeDate);
		this.cartonSize = cartonSize;
		this.fatContent = fatContent;
	}
	
	//------------//
	//--ACCESSOR--//
	//------------//
	
	public int getCartonSize()
	{
		return cartonSize;
	}
	
	public String getFatContent()
	{
		return fatContent;
	}
	
	//-------------//
	//---MUTATOR---//
	//-------------//
	
	public void setCartonSize(int cartonSize)
	{
		this.cartonSize = cartonSize;
	}
	
	public void setFatContent(String fatContent)
	{
		this.fatContent = fatContent;
	}
	
	//------------//
	//---HELPER---//
	//------------//
	
	public String toString()
	{
		return super.toString() + "\nCarton Size: " + cartonSize + "ml" + "\nFat Content: " + fatContent + "mg";
	}
}














