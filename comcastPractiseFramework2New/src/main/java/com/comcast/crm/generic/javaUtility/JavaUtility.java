package com.comcast.crm.generic.javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int randomInt = random.nextInt();
		return randomInt;
	}

	public String getSystemDate() {
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateObj);
		return date;
	}

	public String getRequiredDate(int days) {
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = sim.getCalendar();
		cal.add(cal.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;

	}

}
