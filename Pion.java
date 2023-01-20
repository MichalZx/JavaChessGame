import java.util.ArrayList;
import java.util.List;

public class Pion extends Figura {
    public Pion(Color kolor) {
        super(kolor);
        znakFigury = " I ";
    }

    private boolean czyWykonanoRuch = false;

    @Override
    public void Ruch(int[] pozycjaRuchu, int[] pozycjaFiguryWybranej, int[][] dozwoloneRuchy) {
        for (int[] pozycjaDozwolona : dozwoloneRuchy ){
            if ( pozycjaDozwolona[0] == pozycjaRuchu[0] && pozycjaDozwolona[1] == pozycjaRuchu[1] ) {
                Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]] = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]];
                Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] = null;
                if(pozycjaFiguryWybranej[1] != pozycjaRuchu[1]){
                    if(getKolor() == Color.YELLOW_BOLD) { Szachownica.plansza[pozycjaRuchu[0] - 1][pozycjaRuchu[1]] = null; }
                    else if(getKolor() == Color.BLUE_BOLD) { Szachownica.plansza[pozycjaRuchu[0] + 1][pozycjaRuchu[1]] = null; }
                }
                czyWykonanoRuch = true;
                break;
            }
        }
    }

    @Override
    public int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej, int[][] ostatniRuch, int[] pozycjaKrola, int[] pozycjaKrolaPrzeciwnika) {
        List<int[]> listaDozwolonyuchRuchow = new ArrayList<>();
        if ( getKolor() == Color.YELLOW_BOLD && pozycjaFiguryWybranej[0] != 7){
            if ( Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1]] == null ) {
                int[] dozwolonyRuch = new int[2];
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 1;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                if ( !czyWykonanoRuch && Szachownica.plansza[pozycjaFiguryWybranej[0] + 2][pozycjaFiguryWybranej[1]] == null){
                    int[] dozwolonyPierwszyRuch = new int[2];
                    dozwolonyPierwszyRuch[0] = pozycjaFiguryWybranej[0] + 2;
                    dozwolonyPierwszyRuch[1] = pozycjaFiguryWybranej[1];
                    listaDozwolonyuchRuchow.add(dozwolonyPierwszyRuch);
                }
            }
            if(pozycjaFiguryWybranej[1] != 7 && Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] + 1] != null && Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] + 1].getKolor() != Color.YELLOW_BOLD){
                int[] dozwolonyRuch = new int[2];
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 1;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 1;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            if(pozycjaFiguryWybranej[1] != 0 && Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] - 1] != null && Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] - 1].getKolor() != Color.YELLOW_BOLD){
                int[] dozwolonyRuch = new int[2];
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 1;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 1;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            if(pozycjaFiguryWybranej[0] == 4 && pozycjaFiguryWybranej[1] != 7 && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] + 1] instanceof Pion && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] + 1].getKolor() == Color.BLUE_BOLD && Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] + 1] == null){
                if(ostatniRuch[0][0] - 2 == ostatniRuch[1][0] && ostatniRuch[1][1] == pozycjaFiguryWybranej[1] + 1 && ostatniRuch[1][0] == pozycjaFiguryWybranej[0]){
                    int[] dozwolonyRuch = new int[2];
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if(pozycjaFiguryWybranej[0] == 4 && pozycjaFiguryWybranej[1] != 0 && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] - 1] instanceof Pion && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] - 1].getKolor() == Color.BLUE_BOLD && Szachownica.plansza[pozycjaFiguryWybranej[0] + 1][pozycjaFiguryWybranej[1] - 1] == null){
                if(ostatniRuch[0][0] - 2 == ostatniRuch[1][0] && ostatniRuch[1][1] == pozycjaFiguryWybranej[1] - 1 && ostatniRuch[1][0] == pozycjaFiguryWybranej[0]){
                    int[] dozwolonyRuch = new int[2];
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] + 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        else if (getKolor() == Color.BLUE_BOLD && pozycjaFiguryWybranej[0] != 0) {
            if ( Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1]] == null ) {
                int[] dozwolonyRuch = new int[2];
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                if ( !czyWykonanoRuch && Szachownica.plansza[pozycjaFiguryWybranej[0] - 2][pozycjaFiguryWybranej[1]] == null){
                    int[] dozwolonyPierwszyRuch = new int[2];
                    dozwolonyPierwszyRuch[0] = pozycjaFiguryWybranej[0] - 2;
                    dozwolonyPierwszyRuch[1] = pozycjaFiguryWybranej[1];
                    listaDozwolonyuchRuchow.add(dozwolonyPierwszyRuch);
                }
            }
            if(pozycjaFiguryWybranej[1] != 7 && Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] + 1] != null && Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] + 1].getKolor() != Color.BLUE_BOLD ){
                int[] dozwolonyRuch = new int[2];
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 1;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            if(pozycjaFiguryWybranej[1] != 0 && Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] - 1] != null && Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] - 1].getKolor() != Color.BLUE_BOLD){
                int[] dozwolonyRuch = new int[2];
                dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 1;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
            }
            if(pozycjaFiguryWybranej[0] == 3 && pozycjaFiguryWybranej[1] != 7 && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] + 1] instanceof Pion && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] + 1].getKolor() == Color.YELLOW_BOLD && Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] + 1] == null){
                if(ostatniRuch[0][0] + 2 == ostatniRuch[1][0] && ostatniRuch[1][1] == pozycjaFiguryWybranej[1] + 1 && ostatniRuch[1][0] == pozycjaFiguryWybranej[0]){
                    int[] dozwolonyRuch = new int[2];
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if(pozycjaFiguryWybranej[0] == 3 && pozycjaFiguryWybranej[1] != 0 && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] - 1] instanceof Pion && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] - 1].getKolor() == Color.YELLOW_BOLD && Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] - 1] == null){
                if(ostatniRuch[0][0] + 2 == ostatniRuch[1][0] && ostatniRuch[1][1] == pozycjaFiguryWybranej[1] - 1 && ostatniRuch[1][0] == pozycjaFiguryWybranej[0]){
                    int[] dozwolonyRuch = new int[2];
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        int[][] zwracanaTablicaRuchow = new int[listaDozwolonyuchRuchow.size()][2];
        zwracanaTablicaRuchow = listaDozwolonyuchRuchow.toArray(zwracanaTablicaRuchow);
        return zwracanaTablicaRuchow;
    }
}
