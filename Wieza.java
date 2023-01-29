import java.util.List;
import java.util.ArrayList;
public class Wieza extends Figura {
    public Wieza(Color kolor){
        super(kolor);
        znakFigury = " W ";
    }

    private boolean czyWykonanoRuch = false;
    public boolean getCzyWykonanoRuch(){
        return czyWykonanoRuch;
    }
    public void setCzyWykonanoRuch(boolean czyWykonanoRuch){
        this.czyWykonanoRuch = czyWykonanoRuch;
    }

    @Override
    public void Ruch(int[] pozycjaRuchu, int[] pozycjaFiguryWybranej, int[][] dozwoloneRuchy) { // figura idzie na pole "ruchu", poprzednie pole figury jest puste
        for (int[] pozycjaDozwolona : dozwoloneRuchy ){
            if ( pozycjaDozwolona[0] == pozycjaRuchu[0] && pozycjaDozwolona[1] == pozycjaRuchu[1] ) {
                Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]] = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]];
                Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] = null;
                czyWykonanoRuch = true;
                break;
            }
        }
    }

    @Override
    public int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej,int[] pozycjaKrola, int[] pozycjaKrolaPrzeciwnika) {
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

    @Override
    public String CheckEnd(int[] pozycjaFigury) {
        return null;
    }
}
