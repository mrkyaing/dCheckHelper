package com.prodev.job.scheduler.prodevict;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    private BookingDAO bookingDAO;
    public Scheduler() {
        bookingDAO=new BookingDaoImpl();
    }
    @Scheduled(cron = "0 59 23 1/1 * ?",zone = "Asia/Rangoon")//// at 23:59  every day

    public void updateAutomaticallyOverDueDateBooking() {
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