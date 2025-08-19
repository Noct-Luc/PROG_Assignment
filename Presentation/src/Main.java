import java.util.Scanner;
// this progeram is part of a video game ranking system
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dreamScape;
        int dreamNum;

        System.out.println("enter the location you started in");
        dreamScape = scanner.nextLine();
        System.out.println("enter number of dreams you had");
        dreamNum = Integer.parseInt(scanner.nextLine());

        DreamerSlept dreamerSlept = new DreamerSlept(dreamNum, dreamScape);
        System.out.println("The number of dreams you had was: "+ dreamNum);
        System.out.println("You are part of the: "+ dreamScape);
        System.out.println("You gained the: "+ DreamerSlept.dreamRank(dreamNum, dreamScape)











        );
    }
}