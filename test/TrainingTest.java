import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainingTest {

    Training training = new Training();


    @Test
    void addSessionTest(){
        String testKund = "Inte en riktig person";
        String testKund2 = "Alhambra Aromes";
        String testKund3 = "7805211234";

        assert(training.addSession("träningtest.txt",testKund).equals("Den angivna personen finns inte i systemet"));
        assert (training.addSession("träningtest.txt", testKund2).equals("Kundens träning har lagts till"));
        assert (training.addSession("träningtest.txt", testKund3).equals("Kundens träning har lagts till"));
    }



}