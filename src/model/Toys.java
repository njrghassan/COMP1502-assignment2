package model;

public class Toys {
    private String SN;
    private String name;
    private String brand;
    private double price;
    private int avaiableCount;
    private int ageAppropriate;


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


	public void setSN(String sN) {
		SN = sN;
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
