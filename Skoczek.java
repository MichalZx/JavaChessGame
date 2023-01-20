import java.util.ArrayList;
import java.util.List;

public class Skoczek extends Figura {
    public Skoczek(Color kolor){
        super(kolor);
        znakFigury = " S ";
    }

    @Override
    public int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej, int[][] ostatniRuch, int[] pozycjaKrola, int[] pozycjaKrolaPrzeciwnika) {
        List<int[]> listaDozwolonyuchRuchow = new ArrayList<>();
        if ( pozycjaFiguryWybranej[0] + 2 <= 7 ){
            if ( pozycjaFiguryWybranej[1] + 1 <= 7 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaFiguryWybranej[0] + 2][pozycjaFiguryWybranej[1] + 1] == null){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 2;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
                else if(Szachownica.plansza[pozycjaFiguryWybranej[0] + 2][pozycjaFiguryWybranej[1] + 1].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 2;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaFiguryWybranej[1] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaFiguryWybranej[0] + 2][pozycjaFiguryWybranej[1] - 1] == null){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 2;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
                else if(Szachownica.plansza[pozycjaFiguryWybranej[0] + 2][pozycjaFiguryWybranej[1] - 1].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 2;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        if ( pozycjaFiguryWybranej[0] - 2 >= 0 ){
            if ( pozycjaFiguryWybranej[1] + 1 <= 7 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaFiguryWybranej[0] - 2][pozycjaFiguryWybranej[1] + 1] == null){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 2;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
                else if(Szachownica.plansza[pozycjaFiguryWybranej[0] - 2][pozycjaFiguryWybranej[1] + 1].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 2;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaFiguryWybranej[1] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaFiguryWybranej[0] - 2][pozycjaFiguryWybranej[1] - 1] == null){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 2;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
                else if(Szachownica.plansza[pozycjaFiguryWybranej[0] - 2][pozycjaFiguryWybranej[1] - 1].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 2;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        if ( pozycjaFiguryWybranej[1] + 2 <= 7 ){
            if ( pozycjaFiguryWybranej[0] + 1 <= 7 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] + 2] == null){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
                else if(Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] + 2].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaFiguryWybranej[0] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] + 2] == null){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
                else if(Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] + 2].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        if ( pozycjaFiguryWybranej[1] - 2 >= 0 ){
            if ( pozycjaFiguryWybranej[0] + 1 <= 7 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] - 2] == null){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
                else if(Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] - 2].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaFiguryWybranej[0] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] - 2] == null){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
                else if(Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] - 2].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        int[][] zwracanaTablicaRuchow = new int[listaDozwolonyuchRuchow.size()][2];
        zwracanaTablicaRuchow = listaDozwolonyuchRuchow.toArray(zwracanaTablicaRuchow);
        return zwracanaTablicaRuchow;
    }
}
