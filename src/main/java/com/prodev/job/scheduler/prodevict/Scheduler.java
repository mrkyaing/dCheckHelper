package com.prodev.job.scheduler.prodevict;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    private static Logger logger = Logger.getLogger(ProdevictApplication.class);
    private void doSomething() {
        logger.debug("im doing something");
        logger.error("im doing something - error -");
    }
    private BookingDAO bookingDAO;
    public Scheduler() {
        bookingDAO=new BookingDaoImpl();
    }
    @Scheduled(cron = "0 55 19 1/1 * ?",zone = "Asia/Rangoon")//// at 23:59  every day
    public void updateAutomaticallyOverDueDateBooking() {
        doSomething();
        LocalDateTime now=LocalDateTime.now();
        System.out.println("Java cron job expression:: " + now);
        try {
            int result= bookingDAO.updateAutoRejectAfterDueBookings(now.toLocalDate());
            System.out.println("Total "+result+" record(s) was updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}