public class Main {
    public static void main(String[] args) {
        Player gracz = new Player();
        ZapisPartii.StartGry(); // tworzenie pliku i folderu jesli nie istnieje
        System.out.println("Zaczynają niebieskie!");
        gracz.Ruch(Color.BLUE_BOLD,Color.YELLOW_BOLD);//gracz , przeciwnik
    }
}