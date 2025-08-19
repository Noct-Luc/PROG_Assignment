import java.util.Scanner;


public class Series extends SeriesModel{
    public Series( String SeriesId, String SeriesName, String SeriesAge, String SeriesNumberOfEpisodes){
        super(SeriesId,  SeriesName, SeriesAge, SeriesNumberOfEpisodes);
    }


    public static String captureSeries(){ // does not save multiple series
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        String age;
        String episodeNum = "";
        System.out.println("Enter the series ID");
        id = scanner.nextLine();
        System.out.println("Enter the series name");
        name= scanner.nextLine();
        System.out.println("Enter the series age restriction");
        age = scanner.nextLine();
        System.out.println("Enter the series number of episodeNum");
        episodeNum = scanner.nextLine();
        Series newSeries = new Series( id, name, age,episodeNum );
        seriesList.add(newSeries);
        System.out.println("Series successfully stored.");
        return id;
    };
    public static void searchSeries(){ // this method was obtained through chatGPT. This method searches for the series

        for (SeriesModel s : seriesList) {
            boolean foundIt = false;
            if (s.getSeriesId().equalsIgnoreCase(SeriesId)) {
                System.out.println("Series Found:");
                System.out.println("ID: " + s.getSeriesId());
                System.out.println("Name: " + s.getSeriesName());
                System.out.println("Age Restriction: " + s.getSeriesAge());
                System.out.println("Number of Episodes: " + s.getSeriesNumberOfEpisodes());
                foundIt = true;
            } else {
                System.out.println("Series not found");
            }

        }

    }

    public static void AgeRestriction() { // this method updates the age restriction
        Scanner scanner = new Scanner(System.in);
        int user = 0;
        while (true) {
            System.out.println("Enter the age restriction");
            user = scanner.nextInt();
            if (user > 18) {
                System.out.println(" You have entered the wrong age restriction");
                System.out.println("Please reenter the age restriction");
            } else if (user <= 2) {
                System.out.println(" You have entered the wrong age restriction");
                System.out.println("Please reenter the age restriction");
            } else {
                System.out.println("Age restriction updated");
                return;
            }

        }
    }


    public static void deleteSeries(){ // this method deletes the series
        Scanner scanner = new Scanner(System.in);
        String deleteID;
        boolean found = false;
        System.out.println("Enter the series ID of the series you want to delete");
        deleteID = scanner.nextLine();
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesId().equalsIgnoreCase(deleteID)) {
                seriesList.remove(i);
                System.out.println("Series successfully deleted.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Series with ID " + deleteID + " not found.");
        }
    }

    public static void displaySeries() { // this displays the full report of the series
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
            return;
        }

        for (SeriesModel s : seriesList) {
            System.out.println("Id: " + s.getSeriesId());
            System.out.println("Name: " + s.getSeriesName());
            System.out.println("Age: " + s.getSeriesAge());
            System.out.println("Episodes: " + s.getSeriesNumberOfEpisodes());
            System.out.println("----------------------------");
        }
    }
}


