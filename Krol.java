import java.util.ArrayList;
import java.util.List;

public class Krol extends Figura {
    public Krol(Color kolor){
        super(kolor);
        znakFigury = " K ";
    }

    private boolean czyWykonanoRuch;

    public void Roszada(){

    }
    public void czySzach(){

    }

    @Override
    public int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej) {
        List<int[]> listaDozwolonyuchRuchow = new ArrayList<>();
        if(pozycjaFiguryWybranej[0] != 0){
            if(pozycjaFiguryWybranej[1] != 0) {
                int[] dozwolonyRuchPrzekatna = new int[2];
                if (Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] - 1] == null) {
                    dozwolonyRuchPrzekatna[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuchPrzekatna[1] = pozycjaFiguryWybranej[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuchPrzekatna);
                } else if (Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] - 1].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()) {
                    dozwolonyRuchPrzekatna[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuchPrzekatna[1] = pozycjaFiguryWybranej[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuchPrzekatna);
                }
            }
            if(pozycjaFiguryWybranej[1] != 7) {
                int[] dozwolonyRuchPrzekatna = new int[2];
                if (Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] + 1] == null) {
                    dozwolonyRuchPrzekatna[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuchPrzekatna[1] = pozycjaFiguryWybranej[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuchPrzekatna);
                } else if (Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] + 1].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()) {
                    dozwolonyRuchPrzekatna[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuchPrzekatna[1] = pozycjaFiguryWybranej[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuchPrzekatna);
                }
            }
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1]] == null){
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            else if(Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1]].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
        }
        if(pozycjaFiguryWybranej[0] != 7){
            if(pozycjaFiguryWybranej[1] != 0) {
                int[] dozwolonyRuchPrzekatna = new int[2];
                if (Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] - 1] == null) {
                    dozwolonyRuchPrzekatna[0] = pozycjaFiguryWybranej[0] + 1;
                    dozwolonyRuchPrzekatna[1] = pozycjaFiguryWybranej[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuchPrzekatna);
                } else if (Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] - 1].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()) {
                    dozwolonyRuchPrzekatna[0] = pozycjaFiguryWybranej[0] + 1;
                    dozwolonyRuchPrzekatna[1] = pozycjaFiguryWybranej[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuchPrzekatna);
                }
            }
            if(pozycjaFiguryWybranej[1] != 7) {
                int[] dozwolonyRuchPrzekatna = new int[2];
                if (Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] + 1] == null) {
                    dozwolonyRuchPrzekatna[0] = pozycjaFiguryWybranej[0] + 1;
                    dozwolonyRuchPrzekatna[1] = pozycjaFiguryWybranej[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuchPrzekatna);
                } else if (Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] + 1].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()) {
                    dozwolonyRuchPrzekatna[0] = pozycjaFiguryWybranej[0] + 1;
                    dozwolonyRuchPrzekatna[1] = pozycjaFiguryWybranej[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuchPrzekatna);
                }
            }
            int [] dozwolonyRuch = {0, 0};
            if(Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1]] == null){
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 1;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            else if(Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1]].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()){
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 1;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
        }
        if(pozycjaFiguryWybranej[1] != 0) {
            int[] dozwolonyRuch = {0, 0};
            if (Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] - 1] == null) {
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0];
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 1;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            } else if (Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] - 1].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()) {
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0];
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 1;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
        }
        if(pozycjaFiguryWybranej[1] != 7) {
            int[] dozwolonyRuch = {0, 0};
            if (Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] + 1] == null) {
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0];
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 1;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            } else if (Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] + 1].getKolor() != Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]].getKolor()) {
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0];
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 1;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
        }
        int[][] zwracanaTablicaRuchow = new int[listaDozwolonyuchRuchow.size()][2];
        zwracanaTablicaRuchow = listaDozwolonyuchRuchow.toArray(zwracanaTablicaRuchow);
        return zwracanaTablicaRuchow;
    }
}
