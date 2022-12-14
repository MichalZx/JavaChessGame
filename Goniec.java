import java.util.ArrayList;
import java.util.List;

public class Goniec extends Figura {
    public Goniec(Color kolor){
        super(kolor);
        znakFigury = " G ";
    }

    @Override
    public int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej) {
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
        int[][] zwracanaTablicaRuchow = new int[listaDozwolonyuchRuchow.size()][2];
        zwracanaTablicaRuchow = listaDozwolonyuchRuchow.toArray(zwracanaTablicaRuchow);
        return zwracanaTablicaRuchow;
    }
}
