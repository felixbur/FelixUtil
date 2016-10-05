package com.felix.util;

import java.util.Vector;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Test {
	public static Vector<String> getSevenDays() {
		Vector<String> retVec = new Vector<String>();
		DateTime now = new DateTime();
		for (int i = 0; i < 7; i++) {
			DateTime fut = now.plusDays(i);
			DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy_MM_dd");
			String fName = "epg_" + fmt.print(fut) + ".csv";
			System.out.println(fName);
			retVec.add(fName);
		}

		return retVec;
	}

	public static void main(String[] args) {
		Test.getSevenDays();
	}
}
