import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class activity_2 {

    public static void main(String[] args) {
        
        String filePath = ("C:\\Users\\jarre\\Documents\\COMP1002\\Week 1\\temperatures_365_days.csv");
        
        String[] dates;
        dates = new String[365];
        
        int[] temperatures;
        temperatures = new int[365] ;

        readTemperatureData(filePath, dates, temperatures);
        findExtremeDays(dates, temperatures);



    }

    public static void readTemperatureData(String filePath, String[] dates, int[] temperatures) {
        
        try {
            File tempFile = new File(filePath);
            Scanner reader = new Scanner(tempFile);


            String[] buffer;
            buffer = new String[2];
            int j = 0;

            String information = reader.nextLine();

            while (reader.hasNextLine()){
                information = reader.nextLine();
                buffer = information.split(",");
                dates[j] = buffer[0];
                temperatures[j] = Integer.parseInt(buffer[1]);
                j++;
            }
            reader.close();
        } catch (FileNotFoundException e){
            System.out.println("Error, File Not Found!\n");
        }
    }

    public static void findExtremeDays(String[] dates, int[] temperatures) {
        int maxTemp = temperatures[0];
        int minTemp = temperatures[0];

        String maxDay = dates[0];
        String minDay = dates[0];

        int i;

        for (i = 0; i < 364; i++) {
            if (temperatures[i] > maxTemp)
                maxTemp = temperatures[i];
                maxDay = dates[i];
            
            if (temperatures[i] < minTemp)
                minTemp = temperatures[i];
                minDay = dates[i];
            
        }

        System.out.println("Hottest Day: " + maxDay + " with temperature " + maxTemp + "\u00B0C");
        System.out.println("Coldest Day: " + minDay + " with temperature " + minTemp + "\u00B0C");
    }
}
