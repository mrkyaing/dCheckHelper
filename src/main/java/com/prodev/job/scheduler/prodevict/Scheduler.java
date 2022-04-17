package com.prodev.job.scheduler.prodevict;

import java.sql.SQLException;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    private static Logger logger = Logger.getLogger(Scheduler.class);
    private void doSomething(String message) {
        logger.info("Schedule run and "+message);
    }
    private BookingDAO bookingDAO;
    public Scheduler() {
        bookingDAO=new BookingDaoImpl();
    }
    @Scheduled(cron = "0 08 21 1/1 * ?",zone = "Asia/Rangoon")// at 23:59  every day
    public void updateAutomaticallyOverDueDateBooking() {
        LocalDateTime now=LocalDateTime.now();
        System.out.println("Java cron job expression:: " + now);
        try {
            int result= bookingDAO.updateAutoRejectAfterDueBookings(now.toLocalDate());
            String message="Total "+result+" record(s) was updated successfully!";
            System.out.println(message);
            doSomething(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}