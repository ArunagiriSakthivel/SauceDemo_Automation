package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {   
    private static final String CSV_PATH = "/data.csv";  
    public static List<String[]> readCSV(String filePath) throws CsvValidationException {      
        List<String[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(CSVUtils.class.getResourceAsStream(filePath)))) {
            String[] line;          
            while ((line = reader.readNext()) != null) {               
                data.add(line);
            }
        } catch (IOException e) {            
            e.printStackTrace();
        }       
        return data;
    }  
    @DataProvider(name = "csvData")
    public static Object[][] getDataFromCSV() throws CsvValidationException {      
        List<String[]> csvData = readCSV(CSV_PATH);     
        Object[][] data = new Object[csvData.size()][];       
        for (int i = 0; i < csvData.size(); i++) {
            data[i] = csvData.get(i);
        }       
        return data;
    }
}
