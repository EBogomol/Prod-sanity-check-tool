import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Report {

    public static void create(String FileLocation, String FileName) throws Exception{
       new File(FileLocation+FileName);
    }
    public static void write(String CheckResult, String Location, String FileName) throws IOException {
        FileWriter fileWriter = new FileWriter(Location+FileName, true);
        BufferedWriter out = new BufferedWriter(fileWriter);
        out.append("\r\n"+ CheckResult);
        out.flush();
    }
    public static void clear(String Location)throws Exception{
        FileUtils.cleanDirectory(new File(Location));
    }
}

