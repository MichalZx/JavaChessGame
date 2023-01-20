import java.util.List;
import java.util.ArrayList;
public class Wieza extends Figura {
    public Wieza(Color kolor){
        super(kolor);
        znakFigury = " W ";
    }

    private boolean czyWykonanoRuch;

    public void Roszada(){

    }

    @Override
    public int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej, int[][] ostatniRuch, int[] pozycjaKrola, int[] pozycjaKrolaPrzeciwnika) {
        List<int[]> listaDozwolonyuchRuchow = new ArrayList<>();
        for(int i = pozycjaFiguryWybranej[0] - 1; i >= 0; i--){ //tylko gora
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
        for(int i = pozycjaFiguryWybranej[0] + 1; i < 8; i++){  // dol
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
        for(int i = pozycjaFiguryWybranej[1] - 1; i >= 0; i--){ //lewo
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
        for(int i = pozycjaFiguryWybranej[1] + 1; i < 8; i++){  //prawo
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
