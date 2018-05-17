package com.parthi.spring.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm:ss");

	/*// @Scheduled defines when a particular method runs.
	 * All the scheduled methods should have a void return type and should not accept any arguments.
	 * 
	 * fixedRate method will be executed every 2 seconds even if the previous invocation of the task is not finished.
	 */ 
	@Scheduled(fixedRate = 2000)
	public void scheduleTaskWithFixedRate() {
		logger.info("FixedRate Task :: The time is now {}", dateTimeFormatter.format(new Date()));
	}
	
	/*//
	 * 
	 * fixedDelay method will be executed 2 seconds after the completion of the last invocation.
	 */
	@Scheduled(fixedDelay = 2000)
	public void scheduleTaskWithFixedDelay() {
		logger.info("Fixed Delay Task :: Execution Time - {}", dateTimeFormatter.format(new Date()));
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException ex) {
			logger.error("Ran into an error {}", ex);
			throw new IllegalStateException(ex);
		}
	}
	
	/*//
	 * InitialDelay parameter with fixedRate and fixedDelay to delay the first execution of the task with 
	 * the specified number of milliseconds. 
	 */
	@Scheduled(fixedRate = 2000, initialDelay = 5000)
	public void scheduleTaskWithInitialDelay() {
		logger.info("Fixed Rate Task with Initial Delay :: Execution Time - {}", dateTimeFormatter.format(new Date()));
	}

	/*//
	 * Cron scheduled task to be executed every minute. 
	 * 
    // "0 0 * * * *" = the top of every hour of every day.
    // "* /10 * * * * *" = every ten seconds.
    // "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
    // "0 0 6,19 * * *" = 6:00 AM and 7:00 PM every day.
    // "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day.
    // "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
    // "0 0 0 25 12 ?" = every Christmas Day at midnight
	 */
	@Scheduled(cron = "0 * * * * ?")
	public void scheduleTaskWithCronExpression() {
		logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(new Date()));
	}

} 
