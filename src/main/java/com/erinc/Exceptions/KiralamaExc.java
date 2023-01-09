package com.erinc.Exceptions;

import java.io.File;
import java.io.FileWriter;

public class KiralamaExc extends RuntimeException{

    private final ErrorType errorType;


    public KiralamaExc(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
        Log(errorType);
    }

    public KiralamaExc(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
        Log(errorType);
    }

    public ErrorType getErrorType(){
        return this.errorType;
    }

    private void Log(ErrorType error)
    {
        String fileUrl = "c:\\LogData\\";
        File file = new File(fileUrl+"ErrorLogs.txt");
        try{
            file.createNewFile();
            FileWriter writer = new FileWriter(fileUrl+"ErrorLogs.txt",true);
            writer.write(error.toString()+"\n");
            writer.close();
        }
        catch (Exception e)
        {

        }


    }



}
