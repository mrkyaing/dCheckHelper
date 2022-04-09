package com.prodev.job.scheduler.prodevict;

import org.springframework.stereotype.Service;

import java.sql.*;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDate;
@Service
public class BookingDaoImpl implements BookingDAO{
    @Override
    public int updateAutoRejectAfterDueBookings(LocalDate queryDate) throws SQLException {
        DataSource dataSource = null;
        Connection connection = null;
        String  sqlQuery="UPDATE Booking SET status='REJECT' WHERE booking_Date<=? AND status='PENDING'";
        PreparedStatement prepStatement = null;
        int result = 0;
        try {
            // Get the configured data source
            dataSource = ConfigDataSource.source();
            // Attempt for connection to MySQL
            connection = dataSource.getConnection();
            prepStatement = connection.prepareStatement(sqlQuery);
            prepStatement.setDate(1, Date.valueOf(queryDate));
            result = prepStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("error:"+e.getMessage());
        }finally {
            if (connection != null)
                try {
                    connection.close();
            }
            catch (SQLException ignore) {}
        }
        return result;
    }
}
