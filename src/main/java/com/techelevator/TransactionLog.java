package com.techelevator;

import javax.swing.*;
import java.io.DataInput;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionLog {

    private  String logPath = "log.txt";
    private File logFile = new File(logPath);
    private String logMessage = "%s %-20s Input/Output: $%-10.2f Balance: $%-10.2f";

    public TransactionLog() {
        if (logFile.exists()) {
            logFile.delete();
        }
    }

    public File getLogFile() {
        return logFile;
    }

    public void log(String name, double moneySpent, double currentBalance) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        String strDate = dateFormat.format(date);
        String line = String.format(logMessage, strDate, name, moneySpent, currentBalance);

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
            writer.append(line + System.lineSeparator());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
