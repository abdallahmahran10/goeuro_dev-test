package com.mahran.goeuro_test.utilities;

public class Logger {
	static Logger loggerInstant;
	private boolean enable;
	
	private Logger()
	{
		setEnable(true);
	}
	//
	public static Logger getInstant()
	{
		if(loggerInstant==null)
			loggerInstant = new Logger();
		return loggerInstant;
	}
	//
	public void INFO(String msg)
	{
		log("INFO: " + msg);
	}

	public void ERROR(Exception e)
	{
		log("ERROR: " + e.getMessage());
	}
	
	public void ERROR(String msg)
	{
		log("ERROR: " + msg);
	}

	public void WARNING(String msg)
	{
		log("WARNING: " + msg);
	}

	private void log(String msg) {
		if(!enable)
			return;
		// 1- log to file
		// 2- log to console
		System.out.println(msg);
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
