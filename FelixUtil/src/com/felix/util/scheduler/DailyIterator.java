package com.felix.util.scheduler;

import java.util.Calendar;
import java.util.Date;

/**
 * A <code>DailyIterator</code> returns a sequence of dates on subsequent days
 * representing the same time each day.
 * 
 * Usage:
 *
 * Create a new class like that:
 * <code>
 * public class SampleTask extends SchedulerTask{
 *   
 *     public void run(){
 *         System.out.println("Hallo, ich bin eine Task: ");
 *     }
 * }
 * </code>
 * and create a new Scheduler
 * <code>  
 * Scheduler myScheduler = new Scheduler();
 * SampleTask myTask = new SampleTask();
 *
 * ScheduleIterator myDailyIterator = new DailyIterator(19, 15, 0);
 * myScheduler.schedule( myTask, myDailyIterator );
 * </code>
 */
public class DailyIterator implements ScheduleIterator {
	private final Calendar calendar = Calendar.getInstance();

	/**
	 * Constructor of the Daily Iterator. Feed it with the
	 * time on which the task should be performed
	 * 
	 * @param hourOfDay
	 * @param minute
	 * @param second
	 */
	public DailyIterator(int hourOfDay, int minute, int second) {
		this(hourOfDay, minute, second, new Date());
	}

	/**
	 * Constructor of the Daily Iterator. Feed it with the
	 * time on which the task should be performed and the Date
	 * from which on it should be performed
	 * 
	 * @param hourOfDay
	 * @param minute
	 * @param second
	 * @param date
	 */
	public DailyIterator(int hourOfDay, int minute, int second, Date date) {
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		calendar.set(Calendar.MILLISECOND, 0);
		if (!calendar.getTime().before(date)) {
			calendar.add(Calendar.DATE, -1);
		}
	}

	/**
	 * returns the next day to perform a task
	 */
	public Date next() {
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}

}
