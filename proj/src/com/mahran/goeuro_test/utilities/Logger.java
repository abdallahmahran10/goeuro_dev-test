package com.mahran.goeuro_test.utilities;

/**
 * logger singletone class to log console TO BE IMPLMENTED: log in file
 * 
 * @author Abdallah
 *
 */
public class Logger {
	static Logger loggerInstant;
	private boolean enable;

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * default ctor
	 */
	private Logger() {
		setEnable(true);
	}

	/**
	 * static method that return the singletone object
	 * 
	 * @return singletone static object
	 */
	public static Logger getInstant() {
		if (loggerInstant == null)
			loggerInstant = new Logger();
		return loggerInstant;
	}

	/**
	 * log info
	 * 
	 * @param msg
	 *            msg to log
	 */
	public void INFO(String msg) {
		log("INFO: " + msg);
	}

	/**
	 * log error from error obj
	 * 
	 * @param e
	 *            error ob
	 */
	public void ERROR(Exception e) {
		log("ERROR: cause: " + e.getMessage());
	}

	/**
	 * log error
	 * 
	 * @param msg
	 *            error msg
	 */
	public void ERROR(String msg) {
		log("ERROR: " + msg);
	}

	/**
	 * log a warning msg
	 * 
	 * @param msg
	 *            warning msg
	 */
	public void WARNING(String msg) {
		log("WARNING: " + msg);
	}

	/**
	 * generic method that log string to console
	 * 
	 * @param msg
	 *            string to be logged
	 */
	private void log(String msg) {
		if (!enable)
			return;
		// 1- log to file
		// 2- log to console
		System.out.println(msg);
	}

}
