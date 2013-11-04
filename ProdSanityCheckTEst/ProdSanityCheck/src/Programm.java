import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class Programm {
    static Logger logger = LogManager.getLogger(Programm.class.getName());

    public static void main(String[] args) throws IOException {

        SanityCheck sanityCheck = new SanityCheck();
        try{
            sanityCheck.performSanityCheck();
        }
        catch(Exception e){
            logger.error(e);
        }
    }
}