import java.io.IOException;


public class Programm {


    public static void main(String[] args) throws IOException {
        SanityCheck sanityCheck = new SanityCheck();
        try{
            sanityCheck.performSanityCheck();
        }
        catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}