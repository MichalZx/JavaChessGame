import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    private int[][] ostatniRuch = new int[2][2];
    private int[] pozycjaKrolaNiebieskich = new int[2];
    private int[] pozycjaKrolaZoltych = new int[2];

    public Player(){
        pozycjaKrolaNiebieskich[0] = 7;
        pozycjaKrolaNiebieskich[1] = 4;
        pozycjaKrolaZoltych[0] = 0;
        pozycjaKrolaZoltych[1] = 4;
    }

    public void Ruch(Color kolorGracza, Color kolorPrzeciwnika){ 
        Szachownica.Rysuj(); 
        System.out.print("Podaj pozycje swojej figury w formacie [a2]: ");
        String pozycjaOut = sc.nextLine();
        char[] charPoleWybranej = pozycjaOut.toLowerCase().toCharArray();
        if(charPoleWybranej.length!=2){
            System.out.println(Color.RED+"Nieprawidłowa wartość!"+Color.RESET);
            Ruch(kolorGracza, kolorPrzeciwnika);}
        int[] pozycjaFiguryWybranej = {(charPoleWybranej[1]-56)*-1, charPoleWybranej[0]-97};   
        if(CzyNalezyDoSzachownicy(charPoleWybranej)){
            if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]==null) {
                System.out.println(Color.RED+"Wybrano puste pole"+Color.RESET);
                Ruch(kolorGracza, kolorPrzeciwnika);
            }
            if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()==kolorGracza){    //tu sprawdza czy rusza sie wlasciwy gracz
                int[][] mozliweRuchy;
                if(kolorGracza == Color.BLUE_BOLD)
                    mozliweRuchy = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].sprawdzMozliweRuchy(pozycjaFiguryWybranej, ostatniRuch, pozycjaKrolaNiebieskich, pozycjaKrolaZoltych );
                else
                    mozliweRuchy = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].sprawdzMozliweRuchy(pozycjaFiguryWybranej, ostatniRuch, pozycjaKrolaZoltych, pozycjaKrolaNiebieskich);
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
        if(charPoleWybranej.length!=2){
            System.out.println(Color.RED+"Nieprawidłowa wartość!"+Color.RESET);
            Ruch(kolorGracza, kolorPrzeciwnika);}
        String promocja="0";
        int[] pozycjaRuchu = {(charPoleWybranej[1]-56)*-1, charPoleWybranej[0]-97};
        if(CzyNalezyDoSzachownicy(charPoleWybranej) & CzyMozliwyRuch(pozycjaRuchu, mozliweRuchy)){
            
            if(kolorGracza == Color.YELLOW_BOLD){
                if(Szachownica.plansza[pozycjaKrolaZoltych[0]][pozycjaKrolaZoltych[1]].czySzach(pozycjaKrolaZoltych, kolorGracza).length != 0) // sprawdza szacha dla obu króli (zwraca bool)
                    Ruch2(pozycjaFiguryWybranej, mozliweRuchy,kolorGracza,kolorPrzeciwnika);
                else{
                    Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].Ruch(pozycjaRuchu, pozycjaFiguryWybranej, mozliweRuchy); //wykonanie ruchu
                    if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].znakFigury==" I "){
                        promocja= Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].CheckEnd(pozycjaRuchu);
                    }
                    Szachownica.plansza[pozycjaKrolaNiebieskich[0]][pozycjaKrolaNiebieskich[1]].czySzach(pozycjaKrolaNiebieskich, kolorPrzeciwnika);
                }
            }
            else{
                if(Szachownica.plansza[pozycjaKrolaNiebieskich[0]][pozycjaKrolaNiebieskich[1]].czySzach(pozycjaKrolaNiebieskich, kolorGracza).length != 0)
                    Ruch2(pozycjaFiguryWybranej, mozliweRuchy,kolorGracza,kolorPrzeciwnika);
                else {
                    Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].Ruch(pozycjaRuchu, pozycjaFiguryWybranej, mozliweRuchy); //wykonanie ruchu
                    if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].znakFigury==" I "){
                        promocja= Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].CheckEnd(pozycjaRuchu);
                    }
                    Szachownica.plansza[pozycjaKrolaZoltych[0]][pozycjaKrolaZoltych[1]].czySzach(pozycjaKrolaZoltych, kolorPrzeciwnika); // sprawdza szacha dla obu króli (zwraca bool)
                }
            }
            if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]] instanceof Krol){ //aktualizuje pozycje króla jeżeli się poruszy
                if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].getKolor() == Color.BLUE_BOLD) pozycjaKrolaNiebieskich = pozycjaRuchu;
                else pozycjaKrolaZoltych = pozycjaRuchu;
            }
            
            ZapisPartii.ZapisRuchu(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].znakFigury,pozycjaIn.toLowerCase(),CzyNastapiloBicie(pozycjaRuchu,kolorPrzeciwnika),Character.toString(pozycjaFiguryWybranej[1]+97),promocja);     // zapis pozunieniac do pliku
            ostatniRuch[0] = pozycjaFiguryWybranej;
            ostatniRuch[1] = pozycjaRuchu;

            Ruch(kolorPrzeciwnika,kolorGracza);     //zamiana kolejek - udany ruch
        }
        else if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]]==null){
            System.out.println(Color.RED+"Nieprawidłowa wartość!"+Color.RESET);
            Ruch2(pozycjaFiguryWybranej, mozliweRuchy,kolorGracza,kolorPrzeciwnika);
        }
        else if(CzyNalezyDoSzachownicy(charPoleWybranej) & Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].getKolor()==kolorGracza){
            int[][] mozliweRuchy2;
            if(kolorGracza == Color.BLUE_BOLD)
                mozliweRuchy2 = Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].sprawdzMozliweRuchy(pozycjaRuchu, ostatniRuch, pozycjaKrolaNiebieskich, pozycjaKrolaZoltych);
            else
                mozliweRuchy2 = Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].sprawdzMozliweRuchy(pozycjaRuchu, ostatniRuch, pozycjaKrolaZoltych, pozycjaKrolaNiebieskich);
            if(mozliweRuchy2.length>0){Ruch2(pozycjaRuchu, mozliweRuchy2, kolorGracza, kolorPrzeciwnika);}      //zmiana grajacej figury
            else{System.out.println("Brak możliwych ruchów");Ruch2(pozycjaFiguryWybranej, mozliweRuchy, kolorGracza, kolorPrzeciwnika);}    //gra ta sama figura dalej
        }
        else{
            System.out.println(Color.RED+"Nieprawidłowa wartość!"+Color.RESET);
            Ruch2(pozycjaFiguryWybranej, mozliweRuchy,kolorGracza,kolorPrzeciwnika);
        }
    }
    private boolean CzyNalezyDoSzachownicy(char[] tab_pole){
        if(tab_pole.length==2 & (tab_pole[0]>=97 & tab_pole[0]<=104)&(tab_pole[1]>=49 & tab_pole[1]<=56))  {//pole znajduje sie na szachwonicy
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