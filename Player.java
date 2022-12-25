import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    public void Ruch(Color kolorGracza, Color kolorPrzeciwnika){ 
        Szachownica.Rysuj(); 
        System.out.print("Podaj pozycje swojej figury w formacie [a2]: ");
        String pozycjaOut = sc.nextLine();
        char[] charPoleWybranej = pozycjaOut.toLowerCase().toCharArray();
        int[] pozycjaFiguryWybranej = {(charPoleWybranej[1]-56)*-1, charPoleWybranej[0]-97};   
        if(CzyNalerzyDoSzachownicy(charPoleWybranej)){  
            if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]==null) {
                System.out.println(Color.RED+"Wybrano puste pole"+Color.RESET);
                Ruch(kolorGracza, kolorPrzeciwnika);
            }
            if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()==kolorGracza){    //tu sprawdza czy rusza sie wlasciwy gracz
                int[][] mozliweRuchy = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].sprawdzMozliweRuchy(pozycjaFiguryWybranej);
                if(mozliweRuchy.length==0){System.out.println("Brak możliwych ruchów"); Ruch(kolorGracza,kolorPrzeciwnika);} //jezeli nie ma mozliwych ruchow to od nowa
                Ruch2(pozycjaFiguryWybranej,mozliweRuchy,kolorGracza,kolorPrzeciwnika); 
            }
            else{
                System.out.println(kolorGracza+"Teraz ten gracz sie rusza"+Color.RESET);
                Ruch(kolorGracza, kolorPrzeciwnika);
            }
        }
        else{
            System.out.println(Color.RED+"Nieprawidłowa wartość!"+Color.RESET);
            Ruch(kolorGracza, kolorPrzeciwnika);
        }    
    }
    public void Ruch2(int[] pozycjaFiguryWybranej, int[][]mozliweRuchy,Color kolorGracza,Color kolorPrzeciwnika){
        Szachownica.Rysuj(pozycjaFiguryWybranej, mozliweRuchy);
        System.out.print("Podaj pozycje ruchu z możliwych opcji w formacie [a2]: ");
        String pozycjaIn = sc.nextLine();
        char[]charPoleWybranej = pozycjaIn.toLowerCase().toCharArray();
        int[] pozycjaRuchu = {(charPoleWybranej[1]-56)*-1, charPoleWybranej[0]-97};
        if(CzyNalerzyDoSzachownicy(charPoleWybranej) & CzyMozliwyRuch(pozycjaRuchu, mozliweRuchy)){ 
            ZapisPartii.ZapisRuchu(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].znakFigury,pozycjaIn.toLowerCase(),CzyNastapiloBicie(pozycjaRuchu,kolorPrzeciwnika),Character.toString(pozycjaFiguryWybranej[1]+97));     // zapis pozunieniac do pliku
            Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].Ruch(pozycjaRuchu, pozycjaFiguryWybranej, mozliweRuchy);
            Ruch(kolorPrzeciwnika,kolorGracza);     //zamiana kolejek - udany ruch
        }
        else if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]]==null){
            System.out.println(Color.RED+"Nieprawidłowa wartość!"+Color.RESET);
            Ruch2(pozycjaFiguryWybranej, mozliweRuchy,kolorGracza,kolorPrzeciwnika);
        }
        else if(CzyNalerzyDoSzachownicy(charPoleWybranej) & Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].getKolor()==kolorGracza){
            int[][] mozliweRuchy2 = Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].sprawdzMozliweRuchy(pozycjaRuchu);
            if(mozliweRuchy2.length>0){Ruch2(pozycjaRuchu, mozliweRuchy2, kolorGracza, kolorPrzeciwnika);}      //zmiana grajacej figury
            else{System.out.println("Brak możliwych ruchów");Ruch2(pozycjaFiguryWybranej, mozliweRuchy, kolorGracza, kolorPrzeciwnika);}    //gra ta sama figura dalej
        }
        else{
            System.out.println(Color.RED+"Nieprawidłowa wartość!"+Color.RESET);
            Ruch2(pozycjaFiguryWybranej, mozliweRuchy,kolorGracza,kolorPrzeciwnika);
        }
    }
    private boolean CzyNalerzyDoSzachownicy(char[] tab_pole){
        if(tab_pole.length==2 & (tab_pole[0]>=97 & tab_pole[0]<=104)&(tab_pole[1]>=49 & tab_pole[1]<=56))  {//pole znajduje sie na sachwonicy
            return true;
        }
        return false;
    }
    private boolean CzyMozliwyRuch(int[] pozycjaRuchu,int[][]mozliweRuchy){ //czy wykonany ruch nalerzy do mozliwych ruchow
        for (int[] is : mozliweRuchy) {
            //System.out.println(is[0]+"\t"+ pozycjaRuchu[0]+"\t"+is[1]+"\t"+pozycjaRuchu[1]);
            if(is[0]==pozycjaRuchu[0]&is[1]==pozycjaRuchu[1]){ 
                return true;
            }
        }
        return false;
    }
    private boolean CzyNastapiloBicie(int[] pozycjaRuchu, Color kolorprzeciwnika){
        if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]]!=null){ // to nie puste pole
            if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].getKolor()==kolorprzeciwnika){return true;} // nastapilo bicie przeciwnika
        }
        return false;
    }
    private void KoniecGry(Color wynik){ // niebieski to wygrywa niebieski, zolty to on, byle jaki iny to pat
        if(wynik==Color.BLUE_BOLD){System.out.println(Color.RED+"Koniec gry, Wygrywają Niebieskie (Białe)"+Color.RESET);}
        else if(wynik==Color.YELLOW_BOLD){System.out.println(Color.RED+"Koniec gry, Wygrywają Żółte (Czarne)"+Color.RESET);}
        else{System.out.println(Color.RED+"Koniec gry, PAT (Remis)"+Color.RESET);}
    }
}