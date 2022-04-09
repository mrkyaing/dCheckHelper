package com.prodev.job.scheduler.prodevict;

import java.sql.SQLException;
import java.time.LocalDate;

public interface BookingDAO {
    int updateAutoRejectAfterDueBookings(LocalDate queryDate) throws SQLException;
}
