package employee;
public class Address {
	private String areaName;
	private String cityName;
	private String pinCode;
	public Address(String areaName,String cityName,String pinCode)
	{
		this.areaName=areaName;
		this.cityName=cityName;
		this.pinCode=pinCode;
	}
	
	public String getAreaName() {
		return areaName;
	}


	public String getCityName() {
		return cityName;
	}

	public String getPinCode() {
		return pinCode;
	}


	public void printAddress()
	{
		System.out.println("Area Name : "+this.getAreaName());
		System.out.println("City Name : "+this.getCityName());
		System.out.println("PinCode   : "+this.getPinCode());
	}
}
