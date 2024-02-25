package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Toys {

    private String SN;
    private String name;
    private String brand;
    private double price;
    private int avaiableCount;
    private int ageAppropriate;


	/**
	 * This is the constructor of the Toys class
	 * @param SN
	 * @param name
	 * @param brand
	 * @param price
	 * @param avaiableCount
	 * @param ageAppropriate
	 */
    public Toys(String SN, String name, String brand, double price, int avaiableCount, int ageAppropriate){
        this.SN = SN;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.avaiableCount = avaiableCount;
		this.ageAppropriate = ageAppropriate;
    }


	public String getSN() {
		return SN;
	}


	public void setSN(String SN) {
		this.SN = SN;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getAvaiableCount() {
		return avaiableCount;
	}


	public void setAvaiableCount(int avaiableCount) {
		this.avaiableCount = avaiableCount;
	}


	public int getAgeAppropriate() {
		return ageAppropriate;
	}


	public void setAgeAppropriate(int ageAppropriate) {
		this.ageAppropriate = ageAppropriate;
	}
    
    
}
