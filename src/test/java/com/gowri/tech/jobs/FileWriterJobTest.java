package com.gowri.tech.jobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author -NaveenWodeyar
 * @date -12-Mar-2025
 * @time - 6:41:35 pm
 * @location -
 */

class FileWriterJobTest {
	

	    @Mock
	    private Connection mockConnection;

	    @Mock
	    private Statement mockStatement;

	    @Mock
	    private ResultSet mockResultSet;

	    @Mock
	    private FileWriter mockFileWriter;

	    @Mock
	    private CSVPrinter mockCsvPrinter;

	    @InjectMocks
	    private FileWriterJob fileWriterJob;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void testWriteDataToCSV_successful() throws SQLException, IOException {
	        // Arrange: Setup mocks to simulate database interaction
	        when(mockConnection.createStatement()).thenReturn(mockStatement);
	        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
	        when(mockResultSet.next()).thenReturn(true).thenReturn(false);  // Simulate one row of data
	        when(mockResultSet.getString("column1")).thenReturn("data1");
	        when(mockResultSet.getString("column2")).thenReturn("data2");
	        when(mockResultSet.getString("column3")).thenReturn("data3");
	        
	        // Create a mock for CSVPrinter's printRecord method
	        doNothing().when(mockCsvPrinter).printRecord(anyString(), anyString(), anyString());
	        
	        // Act: Call the method we are testing
	        fileWriterJob.writeDataToCSV();

	        // Assert: Verify the correct interactions
	        verify(mockCsvPrinter).printRecord("data1", "data2", "data3");
	        verify(mockCsvPrinter).flush();
	        verify(mockCsvPrinter, times(1)).flush();
	        System.out.println("Test passed successfully for writing data to CSV.");
	    }

	    @Test
	    void testWriteDataToCSV_sqlException() throws SQLException {
	        // Arrange: Setup mocks to simulate a SQLException
	        when(mockConnection.createStatement()).thenReturn(mockStatement);
	        when(mockStatement.executeQuery(anyString())).thenThrow(new SQLException("Database error"));

	        // Act and Assert: Test exception handling
	        Exception exception = assertThrows(SQLException.class, () -> {
	            fileWriterJob.writeDataToCSV();
	        });

	        assertEquals("Database error", exception.getMessage());
	    }

	    @Test
	    void testWriteDataToCSV_ioException() throws SQLException, IOException {
	        // Arrange: Setup mocks to simulate an IOException
	        when(mockConnection.createStatement()).thenReturn(mockStatement);
	        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
	        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
	        when(mockResultSet.getString("column1")).thenReturn("data1");
	        when(mockResultSet.getString("column2")).thenReturn("data2");
	        when(mockResultSet.getString("column3")).thenReturn("data3");
	        
	        // Simulate IOException during CSVPrinter initialization
	        when(mockCsvPrinter.printRecord(anyString(), anyString(), anyString()))
	                .thenThrow(new IOException("File writing error"));

	        // Act and Assert: Test exception handling
	        Exception exception = assertThrows(IOException.class, () -> {
	            fileWriterJob.writeDataToCSV();
	        });

	        assertEquals("File writing error", exception.getMessage());
	    }
	}

}