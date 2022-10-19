import java.util.Scanner;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private String input;
    private Training training = new Training();
    private FileHandler fileHandler = new FileHandler();
    Main(){

        System.out.println("\nVälkommen till Gymhjälparen!\n");
        while(true){
            System.out.println("\nSkriv numret på den funktion du vill använda\n1.Kolla giltig medlem\n2.Lägga till träningspass\n3.Avsluta");
            input = scanner.nextLine();
            if(input.equals("1")){
                giltigMedlem();
            } else if (input.equals("2")) {
                customerSession();
            }else if(input.equals("3")){
                break;
            }else{
                System.out.println("Du har tyvärr inte valt en valbar funktion\n");
            }

        }



    }

    private void customerSession() {
        System.out.println("\nVilken medlem ska Träna?");
        input = scanner.nextLine();
        System.out.println(training.addSession("träning.txt", input));
    }

    private void giltigMedlem() {
        System.out.println("\nVilken medlem vill du kolla?");
        input = scanner.nextLine();
        System.out.println(fileHandler.customerChecker(input,false));
    }


    public static void main(String[] args) {

        Main main = new Main();
    }
}
