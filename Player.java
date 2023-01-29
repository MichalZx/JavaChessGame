import java.util.Scanner;
public class Player {
    Scanner sc = new Scanner(System.in);
    private int[] pozycjaKrolaNiebieskich = new int[2];
    private int[] pozycjaKrolaZoltych = new int[2];
    Figura zbitaFigura;
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
                    mozliweRuchy = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].sprawdzMozliweRuchy(pozycjaFiguryWybranej, pozycjaKrolaNiebieskich, pozycjaKrolaZoltych );
                else
                    mozliweRuchy = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].sprawdzMozliweRuchy(pozycjaFiguryWybranej, pozycjaKrolaZoltych, pozycjaKrolaNiebieskich);
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
            Ruch(kolorGracza, kolorPrzeciwnika);
        }
        boolean enPassant=false;
        String promocja="0";
        int[] pozycjaRuchu = {(charPoleWybranej[1]-56)*-1, charPoleWybranej[0]-97};
        if(CzyNalezyDoSzachownicy(charPoleWybranej) & CzyMozliwyRuch(pozycjaRuchu, mozliweRuchy)){
            boolean bicie= CzyNastapiloBicie(pozycjaRuchu, kolorPrzeciwnika);
            int[] polePotencjalnieZbitej=pozycjaRuchu.clone();
            if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Krol){ //aktualizuje pozycje króla jeżeli się poruszy
                if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor() == Color.BLUE_BOLD) pozycjaKrolaNiebieskich = pozycjaRuchu;
                else pozycjaKrolaZoltych = pozycjaRuchu;
            }
            boolean czyZrobionoRuch = true;
            if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Pion)
                czyZrobionoRuch = ((Pion)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).getCzyWykonanoRuch();
            else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Wieza)
                czyZrobionoRuch = ((Wieza)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).getCzyWykonanoRuch();
            else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Krol)
                czyZrobionoRuch = ((Krol)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).getCzyWykonanoRuch();

            for (int i = 0; i < 2; i++) {
                if(pozycjaRuchu[0]==Szachownica.enPassant[i][0] && pozycjaRuchu[1]==Szachownica.enPassant[i][1]){       // czy byl en passant
                    bicie=true;
                    enPassant=true;
                    if(kolorGracza==Color.BLUE_BOLD) polePotencjalnieZbitej[0]-=1;
                    else polePotencjalnieZbitej[0]+=1;
                }
            }
            if(bicie){
                zbitaFigura = Szachownica.plansza[polePotencjalnieZbitej[0]][polePotencjalnieZbitej[1]];  // zapisuje typ zbitej figury
            }
            Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].Ruch(pozycjaRuchu, pozycjaFiguryWybranej, mozliweRuchy); //wykonanie ruchu
            if(kolorGracza == Color.YELLOW_BOLD){
                if(Szachownica.plansza[pozycjaKrolaZoltych[0]][pozycjaKrolaZoltych[1]].czySzach(pozycjaKrolaZoltych, kolorGracza).length != 0){ // sprawdza szacha dla obu króli (zwraca bool)
                    int[][] ctrlZ={{pozycjaFiguryWybranej[0],pozycjaFiguryWybranej[1]}};
                    Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].Ruch(pozycjaFiguryWybranej,pozycjaRuchu , ctrlZ); //Cofniecie ruchu
                    if(bicie){
                    Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]]=zbitaFigura;}
                    System.out.println("ctrl z");
                    zbitaFigura=null; 
                    if(czyZrobionoRuch == false){
                        if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Pion)
                            ((Pion)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).setCzyWykonanoRuch(false);
                        else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Wieza)
                            ((Wieza)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).setCzyWykonanoRuch(false);
                        else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Krol)
                            ((Krol)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).setCzyWykonanoRuch(false);
                    }
                    Ruch2(pozycjaFiguryWybranej, mozliweRuchy,kolorGracza,kolorPrzeciwnika);
                }
                else{
                    if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].znakFigury==" I "){
                        promocja= Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].CheckEnd(pozycjaRuchu); // czy byla promocja
                    }
                    if(Szachownica.plansza[pozycjaKrolaNiebieskich[0]][pozycjaKrolaNiebieskich[1]].czySzach(pozycjaKrolaNiebieskich, kolorPrzeciwnika).length !=0){
                        if(Zakonczenie.Mat(kolorPrzeciwnika,pozycjaKrolaNiebieskich ,pozycjaKrolaZoltych )==false) System.out.println("Szach, ale nie mat\n");
                    }
                }
            }
            else{
                if(Szachownica.plansza[pozycjaKrolaNiebieskich[0]][pozycjaKrolaNiebieskich[1]].czySzach(pozycjaKrolaNiebieskich, kolorGracza).length != 0){
                    int[][] ctrlZ={{pozycjaFiguryWybranej[0],pozycjaFiguryWybranej[1]}};
                    Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].Ruch(pozycjaFiguryWybranej,pozycjaRuchu , ctrlZ); //Cofniecie ruchu  
                    if(bicie){
                    Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]]=zbitaFigura; }
                    zbitaFigura=null; 
                    System.out.println("ctrl z");
                    if(czyZrobionoRuch == false){
                        if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Pion)
                            ((Pion)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).setCzyWykonanoRuch(false);
                        else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Wieza)
                            ((Wieza)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).setCzyWykonanoRuch(false);
                        else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Krol)
                            ((Krol)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).setCzyWykonanoRuch(false);
                    }
                    Ruch2(pozycjaFiguryWybranej, mozliweRuchy,kolorGracza,kolorPrzeciwnika);
                }
                else {
                    if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].znakFigury==" I "){
                        promocja= Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].CheckEnd(pozycjaRuchu);     // czy byla promocja
                    }
                    if(Szachownica.plansza[pozycjaKrolaZoltych[0]][pozycjaKrolaZoltych[1]].czySzach(pozycjaKrolaZoltych, kolorPrzeciwnika).length !=0){
                        if(Zakonczenie.Mat(kolorPrzeciwnika,pozycjaKrolaZoltych ,pozycjaKrolaNiebieskich )==false) System.out.println("Szach, ale nie mat\n");
                    } // sprawdza szacha dla obu króli (zwraca bool)
                }
            }
            
            
            ZapisPartii.ZapisRuchu(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].znakFigury,pozycjaIn.toLowerCase(), bicie, Character.toString(pozycjaFiguryWybranej[1]+97),promocja, enPassant);     // zapis pozunieniac do pliku
            Szachownica.ostatniRuch[0] = pozycjaFiguryWybranej;
            Szachownica.ostatniRuch[1] = pozycjaRuchu;
            int[] tab={99,99};
            Szachownica.enPassant[0]=tab;   //reset enpasanta
            Szachownica.enPassant[1]=tab;
            Zakonczenie.Pat(kolorPrzeciwnika);  //sprawdzanie PAta
            Ruch(kolorPrzeciwnika,kolorGracza);     //zamiana kolejek - udany ruch
        }
        else if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]]==null){
            System.out.println(Color.RED+"Nieprawidłowa wartość!"+Color.RESET);
            Ruch2(pozycjaFiguryWybranej, mozliweRuchy,kolorGracza,kolorPrzeciwnika);
        }
        else if(CzyNalezyDoSzachownicy(charPoleWybranej) & Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].getKolor()==kolorGracza){
            int[][] mozliweRuchy2;
            if(kolorGracza == Color.BLUE_BOLD)
                mozliweRuchy2 = Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].sprawdzMozliweRuchy(pozycjaRuchu, pozycjaKrolaNiebieskich, pozycjaKrolaZoltych);
            else
                mozliweRuchy2 = Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].sprawdzMozliweRuchy(pozycjaRuchu, pozycjaKrolaZoltych, pozycjaKrolaNiebieskich);
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
    /* private void ZmianiaPozycji(int[] pozA, int[] pozB, boolean bity, Color kolorGracza){ // nie wypali bo el passat, roszada;
        if(kolorGracza==Color.BLUE_BOLD){
            for (int i=0;i<16;i++) {
                if(Zakonczenie.BlueKoordynaty[i][0]==pozA[0] && Zakonczenie.BlueKoordynaty[i][1]==pozA[1]){
                    Zakonczenie.BlueKoordynaty[i]=pozB;
                    break;
                }
            }
            if (bity) {
                for (int i=0;i<16;i++) {
                    if(Zakonczenie.YellowKoordynaty[i][0]==pozB[0] && Zakonczenie.YellowKoordynaty[i][1]==pozB[1]){
                        Zakonczenie.YellowKoordynaty[i][0]=99;
                        break;
                    }
                }
            }
        }

    } */
    public static void KoniecGry(Color wynik){ // niebieski to wygrywa niebieski, zolty to on, byle jaki iny to pat
        if(wynik==Color.BLUE_BOLD){
            System.out.println(Color.RED+"Koniec gry, Wygrywają Niebieskie (Białe)"+Color.RESET);
            ZapisPartii.RezultatPartii("1-0");
        }
        else if(wynik==Color.YELLOW_BOLD){
            System.out.println(Color.RED+"Koniec gry, Wygrywają Żółte (Czarne)"+Color.RESET);
            ZapisPartii.RezultatPartii("0-1");
        }
        else{
            System.out.println(Color.RED+"Koniec gry, PAT (Remis)"+Color.RESET);
            ZapisPartii.RezultatPartii("0.5-0.5");
        }
    }
}