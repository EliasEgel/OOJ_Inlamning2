import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Training {

    public String addSession(String file, String customer){
        String work= "Den angivna personen finns inte i systemet";
        String line;
        List<String> personer = new ArrayList<>();
        LocalDate date = LocalDate.now();
        try (BufferedReader reader = new BufferedReader(new FileReader("kunder.txt"))){

            while((line = reader.readLine()) != null){
                personer.add(line);
                line = reader.readLine();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        for(int i = 0 ; i< personer.size();i++){
            if(customer.equals(personer.get(i).substring(0,10))||(customer.equals(personer.get(i).substring(12)))){
                work = "Kundens träning har lagts till";
                customer = personer.get(i) + " " + date;
                try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
                    writer.newLine();
                    writer.write(customer);
                    break;

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }


        return work;
    }



}
