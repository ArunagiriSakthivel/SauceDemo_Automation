package utils;

import org.testng.annotations.DataProvider;

public class DataInjectionIntern {   
    @DataProvider(name = "userData")
    public Object[][] userData() {       
        return new Object[][]{            
                {" ", "secret_sauce"},{"standard_user", " "},{"locked_out_user", "secret_sauce"},
        };
    }
}
