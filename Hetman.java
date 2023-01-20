import java.util.ArrayList;
import java.util.List;

public class Hetman extends Figura {
    public Hetman(Color kolor){
        super(kolor);
        znakFigury = " H ";
    }

    @Override
    public int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej, int[][] ostatniRuch, int[] pozycjaKrola, int[] pozycjaKrolaPrzeciwnika) {
        List<int[]> listaDozwolonyuchRuchow = new ArrayList<>();
        for(int i = pozycjaFiguryWybranej[0] - 1, j = pozycjaFiguryWybranej[1] + 1; i >= 0 && j <= 7; i--, j++){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][j] == null){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            else if(Szachownica.plansza[i][j].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaFiguryWybranej[0] + 1, j = pozycjaFiguryWybranej[1] + 1; i <= 7 && j <= 7; i++, j++){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][j] == null){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            else if(Szachownica.plansza[i][j].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaFiguryWybranej[0] - 1, j = pozycjaFiguryWybranej[1] - 1; i >= 0 && j >= 0; i--, j--){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][j] == null){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            else if(Szachownica.plansza[i][j].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaFiguryWybranej[0] + 1, j = pozycjaFiguryWybranej[1] - 1; i <= 7 && j >= 0; i++, j--){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][j] == null){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            else if(Szachownica.plansza[i][j].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaFiguryWybranej[0] - 1; i >= 0; i--){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][pozycjaFiguryWybranej[1]] == null){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            else if(Szachownica.plansza[i][pozycjaFiguryWybranej[1]].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaFiguryWybranej[0] + 1; i < 8; i++){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][pozycjaFiguryWybranej[1]] == null){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            else if(Szachownica.plansza[i][pozycjaFiguryWybranej[1]].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaFiguryWybranej[1] - 1; i >= 0; i--){
            int[] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[pozycjaFiguryWybranej[0]][i] == null){
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0];
                dozwolonyRuch[1] = i;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][i].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0];
                dozwolonyRuch[1] = i;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaFiguryWybranej[1] + 1; i < 8; i++){
            int[] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[pozycjaFiguryWybranej[0]][i] == null){
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0];
                dozwolonyRuch[1] = i;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            else if(Szachownica.plansza[pozycjaFiguryWybranej[0]][i].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0];
                dozwolonyRuch[1] = i;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        int[][] zwracanaTablicaRuchow = new int[listaDozwolonyuchRuchow.size()][2];
        zwracanaTablicaRuchow = listaDozwolonyuchRuchow.toArray(zwracanaTablicaRuchow);
        return zwracanaTablicaRuchow;
    }
}
