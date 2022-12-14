import java.util.Scanner;
public class Main {
    public static void Ruch(){ //To się potem złąćzy w Playerze z ruchem
//        Szachownica szachownica = new Szachownica();
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj pozycje swojej figury w formacie [a2]: ");
        String pozycjaOut = sc.nextLine();
        char[] charPoleWybranej = pozycjaOut.toLowerCase().toCharArray();
        int[] pozycjaFiguryWybranej = {(charPoleWybranej[1]-56)*-1, charPoleWybranej[0]-97};
        int[][] mozliweRuchy = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].sprawdzMozliweRuchy(pozycjaFiguryWybranej);
//        for(int[] ruchy : mozliweRuchy) // dla sprawdzenia czy możliwe ruchy się prawidłowo obliczyły
//            System.out.println(ruchy[0] + " " + ruchy[1]);
        Szachownica.Rysuj(pozycjaFiguryWybranej, mozliweRuchy);
        System.out.print("Podaj pozycje ruchu z możliwych opcji w formacie [a2]: ");
        String pozycjaIn = sc.nextLine();
        char[]charPoleRuchu = pozycjaIn.toLowerCase().toCharArray();
        int[] pozycjaRuchu = {(charPoleRuchu[1]-56)*-1, charPoleRuchu[0]-97};
        Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].Ruch(pozycjaRuchu, pozycjaFiguryWybranej, mozliweRuchy);
        Szachownica.Rysuj();
    }
    public static void main(String[] args) {
        Szachownica.Rysuj();
        Ruch();

    }
}