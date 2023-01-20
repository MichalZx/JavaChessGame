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
    /*
    @Override
    public boolean czySzach(int[] pozycjaKrola, int[][] ostatniRuch, int[] pozycjaKrolaPrzeciwnika, Figura[][] plansza){ //sprawdza dla każdej przeciwnej figury czy szachuje króla
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(plansza[i][j] != null){
                    if(plansza[i][j].getKolor() != getKolor()){
                        for( int[] pozycjaAtaku : plansza[i][j].sprawdzMozliweRuchy(new int[] {i, j}, ostatniRuch, pozycjaKrolaPrzeciwnika, pozycjaKrola)){
                            if(pozycjaKrola[0] == pozycjaAtaku[0] && pozycjaKrola[1] == pozycjaAtaku[1]){
                                System.out.println(getKolor() + "Król jest szachowany!!!");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    */

    @Override
    public int[][] czySzach(int[] pozycjaKrola, Color kolorSprawdzany){ //sprawdza dla każdej przeciwnej figury czy szachuje króla
        List<int[]> listaDozwolonyuchRuchow = new ArrayList<>();
        for(int i = pozycjaKrola[0] - 1, j = pozycjaKrola[1] + 1; i >= 0 && j <= 7; i--, j++){ //prawy dolny
            int [] dozwolonyRuch = new int[2];
            //goniec hetman
            if(Szachownica.plansza[i][j] != null && Szachownica.plansza[i][j].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && ( Szachownica.plansza[i][j] instanceof Goniec || Szachownica.plansza[i][j] instanceof Hetman )){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[0] + 1, j = pozycjaKrola[1] + 1; i <= 7 && j <= 7; i++, j++){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][j] != null && Szachownica.plansza[i][j].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && ( Szachownica.plansza[i][j] instanceof Goniec || Szachownica.plansza[i][j] instanceof Hetman )){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[0] - 1, j = pozycjaKrola[1] - 1; i >= 0 && j >= 0; i--, j--){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][j] != null && Szachownica.plansza[i][j].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && ( Szachownica.plansza[i][j] instanceof Goniec || Szachownica.plansza[i][j] instanceof Hetman )){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[0] + 1, j = pozycjaKrola[1] - 1; i <= 7 && j >= 0; i++, j--){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][j] != null && Szachownica.plansza[i][j].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && ( Szachownica.plansza[i][j] instanceof Goniec || Szachownica.plansza[i][j] instanceof Hetman )){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        //wieza hetman
        for(int i = pozycjaKrola[0] - 1; i >= 0; i--){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][pozycjaKrola[1]] != null && Szachownica.plansza[i][pozycjaKrola[1]].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && ( Szachownica.plansza[i][pozycjaKrola[1]] instanceof Wieza || Szachownica.plansza[i][pozycjaKrola[1]] instanceof Hetman )){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = pozycjaKrola[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[0] + 1; i < 8; i++){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][pozycjaKrola[1]] != null && Szachownica.plansza[i][pozycjaKrola[1]].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && ( Szachownica.plansza[i][pozycjaKrola[1]] instanceof Wieza || Szachownica.plansza[i][pozycjaKrola[1]] instanceof Hetman )){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = pozycjaKrola[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[1] - 1; i >= 0; i--){
            int[] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[pozycjaKrola[0]][i] != null && Szachownica.plansza[pozycjaKrola[0]][i].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && ( Szachownica.plansza[i][pozycjaKrola[1]] instanceof Wieza || Szachownica.plansza[i][pozycjaKrola[1]] instanceof Hetman )){
                dozwolonyRuch[0] = pozycjaKrola[0];
                dozwolonyRuch[1] = i;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[1] + 1; i < 8; i++){
            int[] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[pozycjaKrola[0]][i] != null && Szachownica.plansza[pozycjaKrola[0]][i].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && ( Szachownica.plansza[i][pozycjaKrola[1]] instanceof Wieza || Szachownica.plansza[i][pozycjaKrola[1]] instanceof Hetman )){
                dozwolonyRuch[0] = pozycjaKrola[0];
                dozwolonyRuch[1] = i;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        //koń
        if ( pozycjaKrola[0] + 2 <= 7 ){
            if ( pozycjaKrola[1] + 1 <= 7 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] + 2][pozycjaKrola[1] + 1] != null && Szachownica.plansza[pozycjaKrola[0] + 2][pozycjaKrola[1] + 1].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] + 2;
                    dozwolonyRuch[1] = pozycjaKrola[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaKrola[1] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] + 2][pozycjaKrola[1] - 1] != null && Szachownica.plansza[pozycjaKrola[0] + 2][pozycjaKrola[1] - 1].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] + 2;
                    dozwolonyRuch[1] = pozycjaKrola[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        if ( pozycjaKrola[0] - 2 >= 0 ){
            if ( pozycjaKrola[1] + 1 <= 7 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] - 2][pozycjaKrola[1] + 1] != null && Szachownica.plansza[pozycjaKrola[0] - 2][pozycjaKrola[1] + 1].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] - 2;
                    dozwolonyRuch[1] = pozycjaKrola[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaKrola[1] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] - 2][pozycjaKrola[1] - 1] != null && Szachownica.plansza[pozycjaKrola[0] - 2][pozycjaKrola[1] - 1].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] - 2;
                    dozwolonyRuch[1] = pozycjaKrola[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        if ( pozycjaKrola[1] + 2 <= 7 ){
            if ( pozycjaKrola[0] + 1 <= 7 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] + 2] != null && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] + 2].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] + 1;
                    dozwolonyRuch[1] = pozycjaKrola[1] + 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaKrola[0] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] + 2] != null && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] + 2].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] - 1;
                    dozwolonyRuch[1] = pozycjaKrola[1] + 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        if ( pozycjaKrola[1] - 2 >= 0 ){
            if ( pozycjaKrola[0] + 1 <= 7 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] - 2] != null && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] - 2].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] + 1;
                    dozwolonyRuch[1] = pozycjaKrola[1] - 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaKrola[0] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] != null && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2].getKolor() != Szachownica.plansza[pozycjaKrola[0]][pozycjaKrola[1]].getKolor() && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] - 1;
                    dozwolonyRuch[1] = pozycjaKrola[1] - 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        //pion
        // if(kolorSprawdzany == Color.YELLOW_BOLD){
        //     if(Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] - 1] != null && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] - 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] - 1] instanceof Pion){
        //         int[] dozwolonyRuch = new int[2];
        //         dozwolonyRuch[0] = pozycjaKrola[0] + 1;
        //         dozwolonyRuch[1] = pozycjaKrola[1] - 1;
        //         listaDozwolonyuchRuchow.add(dozwolonyRuch);
        //     }
        //     else if(Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] + 1] != null && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] + 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] + 1] instanceof Pion) {
        //         int[] dozwolonyRuch = new int[2];
        //         dozwolonyRuch[0] = pozycjaKrola[0] + 1;
        //         dozwolonyRuch[1] = pozycjaKrola[1] + 1;
        //         listaDozwolonyuchRuchow.add(dozwolonyRuch);
        //     }
        // }
        // else{
        //     if(Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 1] != null && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 1] instanceof Pion){
        //         int[] dozwolonyRuch = new int[2];
        //         dozwolonyRuch[0] = pozycjaKrola[0] - 1;
        //         dozwolonyRuch[1] = pozycjaKrola[1] - 1;
        //         listaDozwolonyuchRuchow.add(dozwolonyRuch);
        //     }
        //     else if(Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] + 1] != null && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] + 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] + 1] instanceof Pion) {
        //         int[] dozwolonyRuch = new int[2];
        //         dozwolonyRuch[0] = pozycjaKrola[0] - 1;
        //         dozwolonyRuch[1] = pozycjaKrola[1] + 1;
        //         listaDozwolonyuchRuchow.add(dozwolonyRuch);
        //     }
        // }

        int[][] zwracanaTablicaRuchow = new int[listaDozwolonyuchRuchow.size()][2];
        zwracanaTablicaRuchow = listaDozwolonyuchRuchow.toArray(zwracanaTablicaRuchow);
        if(zwracanaTablicaRuchow.length != 0){
            System.out.print(kolorSprawdzany + "Szach na królu!");
        }
        return zwracanaTablicaRuchow;
    }

    @Override
    public int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej, int[][] ostatniRuch, int[] pozycjaKrola, int[] pozycjaKrolaPrzeciwnika) {
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
            int[] dozwolonyRuch = new int[2];
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
