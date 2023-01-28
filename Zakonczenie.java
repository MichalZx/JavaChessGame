
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
        for (int i = 0; i < 8; i++) {   //poziom
            for (int j = 0; j < 8; j++) {   //Kolumna
                if(Szachownica.plansza[i][j]==null) continue;
                if(kolorSprawdzany==Szachownica.plansza[i][j].getKolor()){
                    int[] tab = {i,j};
                    if(skan(tab, false)==false) return false;   //wraca false
                }
            }
        }
        Player.KoniecGry(Color.BLACK); // koniec gry = PAT   0.5-0.5
        return true;
    }

    private static boolean skan(int[] koordynaty, boolean mat){
        int[][] mozliweRuchy=Szachownica.plansza[koordynaty[0]][koordynaty[1]].sprawdzMozliweRuchy(koordynaty, koordynaty, koordynaty);
        if(mozliweRuchy.length>0 && mat==false)return true;    //jest dostepny ruch, i sprawdza pat
        return false;    //brak dostaepnych ruchow
    }
}
