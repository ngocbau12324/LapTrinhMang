
import com.mycompany.test_numberofdayinmonth.Utils;
//import org.eclipse.sisu.Parameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class TestCase {         
        @ParameterizedTest  
        @CsvFileSource(files = "src/test/resources/testcase.csv",numLinesToSkip = 1)
        public void testAll(int month, int year, int expected){
            Assertions.assertEquals(expected, Utils.findNumberOfDaysInMonth(month, year));
    }
    
}
