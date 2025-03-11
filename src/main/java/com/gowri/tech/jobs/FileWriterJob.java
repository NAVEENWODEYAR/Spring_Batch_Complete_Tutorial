package com.gowri.tech.jobs;

/**
 * @author -NaveenWodeyar
 * @date -11-Mar-2025
 * @time - 10:09:52 pm
 * @location -
 */

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class FileWriterJob {

    public void writeDataToCSV() {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        
        // SQL Query to fetch data from your table
        String query = "SELECT column1, column2, column3 FROM your_table";
        
        // Path to save the CSV file
        String csvFilePath = "output.csv";

        // Establishing the connection and executing the query
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
             FileWriter fileWriter = new FileWriter(csvFilePath);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("Column1", "Column2", "Column3"))) {

            // Loop through the result set and write data to CSV
            while (resultSet.next()) {
                csvPrinter.printRecord(resultSet.getString("column1"),
                        resultSet.getString("column2"),
                        resultSet.getString("column3"));
            }
            // Close the printer
            csvPrinter.flush();
            System.out.println("Data has been written to CSV successfully.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.err.println("An error occurred while reading data or writing CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create an instance of the FileWriterJob and run the job
        new FileWriterJob().writeDataToCSV();
    }
}
