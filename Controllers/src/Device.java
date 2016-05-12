public class Device {
	private String deviceName;
	private DeviceTypes deviceType;
	private boolean status;
	private int time;
	
	public void setName (String deviceName)
	{
		this.deviceName = deviceName;
	}
	public void setType (DeviceTypes deviceType)
	{
		this.deviceType = deviceType;
	}
	public String getName ()
	{
		return deviceName;
	}
	public DeviceTypes getDeviceType()
	{
		return deviceType;
	}
	public void turn_on ()
	{
		status = true;
	}
	public void turn_off ()
	{
		status = false;
	}
	public boolean checkStatus()
	{
		return status;
	}
	public void setTimer (int time)
	{
	}
	public void stopTimer (int time)
	{
		
	}
}

