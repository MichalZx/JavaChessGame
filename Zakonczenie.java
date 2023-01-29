
public class Zakonczenie {
    /* public static int[][] YellowKoordynaty={{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},
                                            {1,0},{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
    public static int[][] BlueKoordynaty={{6,0},{6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{6,7},
                                            {7,0},{7,1},{7,2},{7,3},{7,4},{7,5},{7,6},{7,7}}; */   //pierwsza liczba bedzie czy zbita figura , jezeli tak to jest 99
    public static boolean Pat(Color kolorSprawdzany){
        int licznik=0;
        /* if(kolorSprawdzany==Color.YELLOW_BOLD){
            for (int[] is : YellowKoordynaty) {
                if(is[0]>7) {
                    licznik++;
                    continue;
                }
                else if(skan(is, false)==true) break;
                else licznik++;
            }
        }
        else{
            for (int[] is : BlueKoordynaty) {
                if(is[0]>7) {
                    licznik++;
                    continue;
                }
                else if(skan(is, false)==false) break;
                else licznik++;
            }
        } */
        for (int i = 0; i <= 7; i++) {   //poziom
            for (int j = 0; j <= 7; j++) {   //Kolumna
                if(Szachownica.plansza[i][j]==null) continue;
                if(kolorSprawdzany==Szachownica.plansza[i][j].getKolor()){
                    int[] tab = {i,j};
                    if(skan(tab)==false) return false;   //wraca false
                }
            }
        }
        Player.KoniecGry(Color.BLACK); // koniec gry = PAT   0.5-0.5
        return true;
    }

    private static boolean skan(int[] koordynaty){
        int[][] mozliweRuchy=Szachownica.plansza[koordynaty[0]][koordynaty[1]].sprawdzMozliweRuchy(koordynaty, koordynaty, koordynaty);
        if(mozliweRuchy.length>0)return true;    //jest dostepny ruch, i sprawdza pat
        return false;    //brak dostaepnych ruchow
    }

    public static boolean Mat(Color kolorGracza, int[] pozycjaKrola, int[] pozycjaKrolaPrzeciwnika){ // przeciwnik , przeciwnik, moj
        System.out.println("Rozpoczynam sprawdzanie Mata dla krola na pozycji:"+pozycjaKrola[0]+" "+pozycjaKrola[1]);
        boolean mat=true;
        Color kolorPrzeciwnika=Color.BLUE_BOLD;
        if(kolorGracza==Color.BLUE_BOLD) kolorPrzeciwnika=Color.YELLOW_BOLD;
        for (int i = 0; i <= 7; i++) {   //poziom
            System.out.println("Rzad: "+i);
            for (int j = 0; j <= 7; j++) {   //Kolumna
                System.out.println("kolumna: "+j);
                if(Szachownica.plansza[i][j]==null) continue;
                if(kolorGracza==Szachownica.plansza[i][j].getKolor()){
                    int[] pozycjaFiguryWybranej = {i,j};
                    int[][] mozliweRuchy=Szachownica.plansza[i][j].sprawdzMozliweRuchy(pozycjaFiguryWybranej, pozycjaKrola, pozycjaKrolaPrzeciwnika);
                    if (mozliweRuchy.length==0) continue;   // brak mozliwych ruchow dla wybranej figury 

                    for (int[] pozycjaRuchu : mozliweRuchy) {
                        //boolean enPassant=false;
                        
                        Figura zbitaFigura=null;
                        boolean bicie= CzyNastapiloBicie(pozycjaRuchu, kolorPrzeciwnika);
                        int[] polePotencjalnieZbitej=pozycjaRuchu.clone();
                        if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Krol){ //aktualizuje pozycje króla jeżeli się poruszy
                            if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor() == kolorGracza) pozycjaKrola = pozycjaRuchu;
                            else pozycjaKrolaPrzeciwnika = pozycjaRuchu;
                        }
                        System.out.println("Pozycja szachowanego krola: "+pozycjaKrola[0]+" "+pozycjaKrola[1]+"\n Pozycja krola przeciwnego: "+pozycjaKrolaPrzeciwnika[0]+" "+pozycjaKrolaPrzeciwnika[1]);
                        boolean czyZrobionoRuch = true;
                        if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Pion)
                            czyZrobionoRuch = ((Pion)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).getCzyWykonanoRuch();
                        else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Wieza)
                            czyZrobionoRuch = ((Wieza)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).getCzyWykonanoRuch();
                        else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Krol)
                            czyZrobionoRuch = ((Krol)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).getCzyWykonanoRuch();
                        /* for (int k = 0; k < 2; k++) {
                            if(pozycjaRuchu[0]==Szachownica.enPassant[i][0] && pozycjaRuchu[1]==Szachownica.enPassant[i][1]){       // czy byl en passant
                                bicie=true;
                                //enPassant=true;
                                if(kolorGracza==Color.BLUE_BOLD) polePotencjalnieZbitej[0]-=1;
                                else polePotencjalnieZbitej[0]+=1;
                            } 
                        }*/
                        if(bicie){
                            zbitaFigura = Szachownica.plansza[polePotencjalnieZbitej[0]][polePotencjalnieZbitej[1]];  // zapisuje typ zbitej figury
                        }
                        Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].Ruch(pozycjaRuchu, pozycjaFiguryWybranej, mozliweRuchy); //wykonanie ruchu
                        if(Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].czySzach(pozycjaKrola, kolorGracza).length == 0) mat=false;// sprawdza szacha dla  krola (zwraca bool)
                            int[][] ctrlZ={{pozycjaFiguryWybranej[0],pozycjaFiguryWybranej[1]}};
                            Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].Ruch(pozycjaFiguryWybranej,pozycjaRuchu , ctrlZ); //Cofniecie ruchu
                            Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]]=zbitaFigura;
                            System.out.println("ctrl z");
                            if(czyZrobionoRuch == false){
                                if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Pion)
                                    ((Pion)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).setCzyWykonanoRuch(false);
                                else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Wieza)
                                    ((Wieza)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).setCzyWykonanoRuch(false);
                                else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] instanceof Krol){
                                    pozycjaKrola=pozycjaFiguryWybranej;
                                    ((Krol)Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]]).setCzyWykonanoRuch(false);
                                }
                            }
                        
                        if(mat==false){
                            System.out.println("np. dla figury: "+i+" "+j);
                            return false;
                        }
                    }//koniec fora sprawdzajacego szacha
                    
                }
            }
        }// koniec sprawdzania wszystkich rzedow
        Player.KoniecGry(kolorPrzeciwnika); // koniec gry = wygrywa przeciwnik MAT - brak mozliwych ruchow by obronic mata
        return true;
    }

    
    private static boolean CzyNastapiloBicie(int[] pozycjaRuchu, Color kolorprzeciwnika){
        if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]]!=null){ // to nie puste pole
            if(Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]].getKolor()==kolorprzeciwnika){return true;} // nastapilo bicie przeciwnika
        }
        return false;
    }
}
