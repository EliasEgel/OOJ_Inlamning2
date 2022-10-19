import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

public class FileHandler {
    public String customerChecker(String customer, boolean test) {
        String response = "Personen har inte tidigare varit kund";
        List<String> personer = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        String line;

        LocalDate date = LocalDate.now();
        if(test){
            date = LocalDate.parse("2022-10-19");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("kunder.txt"))){

            while((line = reader.readLine()) != null){
                personer.add(line);
                dates.add(reader.readLine());
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        for(int i = 0; i< personer.size();i++){
            if(customer.equals(personer.get(i).substring(0,10))||(customer.equals(personer.get(i).substring(12)))){
                if(compareDate(dates.get(i), date)<365){
                    response = "Kunden är en nuvarande medlem";
                    break;
                }else {
                    response = "Kunden är inte en nuvarande medlem";
                    break;
                }


            }
        }

        return response;
    }

    public int compareDate(String memberDate, LocalDate today){
        LocalDate customerDate = LocalDate.parse(memberDate);

        int timePassed = (int) DAYS.between(customerDate, today);

        return timePassed;
    }
}
