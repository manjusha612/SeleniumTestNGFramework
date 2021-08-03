package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class TestUtil {

    public static long Page_load_Timeout = 60;
    public static long Implicit_wait = 20;

    public static String getCurrentDate() {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return date;
    }

    public static String getTimeStamp() {
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        return timeStamp;
    }

    public static String randomNumber() {
        Random rand = new Random();
        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(1000);
        String ranNo = "SP" + Integer.toString(rand_int1);
        return ranNo;
    }

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static String getProperty(String propertyName) {
        Properties prop = new Properties();
        try {
            FileInputStream file = new FileInputStream("GlobalProperties.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to Locate File");
        }
        String propVal = prop.getProperty(propertyName);
        return propVal;
    }

}
