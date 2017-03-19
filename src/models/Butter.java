package models;

import java.util.*;
/**
 * - A field called packetGrams. type: int
 * - A field called isSalted. type: boolean
 * - A constructor that takes in the two instance fields and with the super class fields
 * - An accessor and mutator
 * - A toString method that uses both sub-fields and super fields. toString should also indicate that the product is type Butter
 * 
 * @author Niall G
 *
 */
public class Butter extends DairyProduct
{
	private int packetGrams;
	private boolean isSalted;
	
	public Butter(String productName, int productCode, double unitCost, boolean inCurrentProductLine, 
				Date bestBeforeDate, int packetGrams, boolean isSalted)
	{
		super(productName, productCode, unitCost, inCurrentProductLine, bestBeforeDate);
		this.packetGrams = packetGrams;
		this.isSalted = isSalted;
	}
	
	//------------//
	//--ACCESSOR--//
	//------------//
	
	public int getPacketGrams()
	{
		return packetGrams;
	}
	
	public boolean getisSalted()
	{
		return isSalted;
	}
	
	//-------------//
	//---MUTATOR---//
	//-------------//
	
	public void setPacketGrams(int packetGrams)
	{
		this.packetGrams = packetGrams;
	}
	
	public void setisSalted(boolean isSalted)
	{
		this.isSalted = isSalted;
	}
	
	//------------//
	//---HELPER---//
	//------------//
	
	public String toString()
	{
		return super.toString() + "\nPacket Grams: " + packetGrams + "g" + "\nIs salted? " + isSalted + "\nProduct: BUTTER";
	}
}














