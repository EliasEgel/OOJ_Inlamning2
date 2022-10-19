import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    FileHandler fileHandler = new FileHandler();
    private boolean test = true;


    @Test
    void customerCheckerTest(){
        assert (fileHandler.customerChecker("Alhambra Aromes", test).equals("Kunden är en nuvarande medlem"));
        assert (fileHandler.customerChecker("8906138493", test).equals("Kunden är inte en nuvarande medlem"));
        assert(fileHandler.customerChecker("Elias Egelrud", test).equals("Personen har inte tidigare varit kund"));
    }




    @Test
    void compareDateTest() {
        LocalDate date = LocalDate.parse("2022-10-19");
        String compareDate1 = "2019-12-02";
        String compareDate2 = "2017-12-02";
        String compareDate3 = "2018-03-07";

        assert(fileHandler.compareDate(compareDate1, date)>0);
        assert(fileHandler.compareDate(compareDate2, date)>0);
        assert (fileHandler.compareDate(compareDate3,date)>365);

    }
}