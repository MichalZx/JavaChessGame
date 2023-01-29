import java.util.ArrayList;
import java.util.List;

public class Krol extends Figura {
    public Krol(Color kolor){
        super(kolor);
        znakFigury = " K ";
    }

    private boolean czyWykonanoRuch = false;

    @Override
    public void Ruch(int[] pozycjaRuchu, int[] pozycjaFiguryWybranej, int[][] dozwoloneRuchy) { // figura idzie na pole "ruchu", poprzednie pole figury jest puste
        for (int[] pozycjaDozwolona : dozwoloneRuchy ){
            if ( pozycjaDozwolona[0] == pozycjaRuchu[0] && pozycjaDozwolona[1] == pozycjaRuchu[1] ) {
                if( pozycjaRuchu[0] == 0 && pozycjaRuchu[1] == 2){
                    Szachownica.plansza[0][2] = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]];
                    Szachownica.plansza[0][3] = Szachownica.plansza[0][0];
                    Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] = null;
                    Szachownica.plansza[0][0] = null;
                }
                else if( pozycjaRuchu[0] == 0 && pozycjaRuchu[1] == 6){
                    Szachownica.plansza[0][6] = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]];
                    Szachownica.plansza[0][5] = Szachownica.plansza[0][7];
                    Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] = null;
                    Szachownica.plansza[0][7] = null;
                }
                else if( pozycjaRuchu[0] == 7 && pozycjaRuchu[1] == 2){
                    Szachownica.plansza[7][2] = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]];
                    Szachownica.plansza[7][3] = Szachownica.plansza[7][0];
                    Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] = null;
                    Szachownica.plansza[7][0] = null;
                }
                else if( pozycjaRuchu[0] == 7 && pozycjaRuchu[1] == 6){
                    Szachownica.plansza[7][6] = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]];
                    Szachownica.plansza[7][5] = Szachownica.plansza[7][7];
                    Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] = null;
                    Szachownica.plansza[7][7] = null;
                }
                else {
                    Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]] = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]];
                    Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] = null;
                }
                czyWykonanoRuch = true;
                break;
            }
        }
    }

    @Override
    public int[][] czySzach(int[] pozycjaKrola, Color kolorSprawdzany){ //sprawdza dla każdej przeciwnej figury czy szachuje króla
        List<int[]> listaDozwolonyuchRuchow = new ArrayList<>();
        for(int i = pozycjaKrola[0] - 1, j = pozycjaKrola[1] + 1; i >= 0 && j <= 7; i--, j++){ //prawy dolny
            int [] dozwolonyRuch = new int[2];
            //goniec hetman
            if(Szachownica.plansza[i][j] != null && Szachownica.plansza[i][j].getKolor() != kolorSprawdzany && ( Szachownica.plansza[i][j] instanceof Goniec || Szachownica.plansza[i][j] instanceof Hetman )){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[0] + 1, j = pozycjaKrola[1] + 1; i <= 7 && j <= 7; i++, j++){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][j] != null && Szachownica.plansza[i][j].getKolor() != kolorSprawdzany && ( Szachownica.plansza[i][j] instanceof Goniec || Szachownica.plansza[i][j] instanceof Hetman )){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[0] - 1, j = pozycjaKrola[1] - 1; i >= 0 && j >= 0; i--, j--){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][j] != null && Szachownica.plansza[i][j].getKolor() != kolorSprawdzany && ( Szachownica.plansza[i][j] instanceof Goniec || Szachownica.plansza[i][j] instanceof Hetman )){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = j;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[0] + 1, j = pozycjaKrola[1] - 1; i <= 7 && j >= 0; i++, j--){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][j] != null && Szachownica.plansza[i][j].getKolor() != kolorSprawdzany && ( Szachownica.plansza[i][j] instanceof Goniec || Szachownica.plansza[i][j] instanceof Hetman )){
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
            if(Szachownica.plansza[i][pozycjaKrola[1]] != null && Szachownica.plansza[i][pozycjaKrola[1]].getKolor() != kolorSprawdzany && ( Szachownica.plansza[i][pozycjaKrola[1]] instanceof Wieza || Szachownica.plansza[i][pozycjaKrola[1]] instanceof Hetman )){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = pozycjaKrola[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[0] + 1; i < 8; i++){
            int [] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[i][pozycjaKrola[1]] != null && Szachownica.plansza[i][pozycjaKrola[1]].getKolor() != kolorSprawdzany && ( Szachownica.plansza[i][pozycjaKrola[1]] instanceof Wieza || Szachownica.plansza[i][pozycjaKrola[1]] instanceof Hetman )){
                dozwolonyRuch[0] = i;
                dozwolonyRuch[1] = pozycjaKrola[1];
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[1] - 1; i >= 0; i--){
            int[] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[pozycjaKrola[0]][i] != null && Szachownica.plansza[pozycjaKrola[0]][i].getKolor() != kolorSprawdzany && ( Szachownica.plansza[i][pozycjaKrola[1]] instanceof Wieza || Szachownica.plansza[i][pozycjaKrola[1]] instanceof Hetman )){
                dozwolonyRuch[0] = pozycjaKrola[0];
                dozwolonyRuch[1] = i;
                listaDozwolonyuchRuchow.add(dozwolonyRuch);
                break;
            }
            else break;
        }
        for(int i = pozycjaKrola[1] + 1; i < 8; i++){
            int[] dozwolonyRuch = new int[2];
            if(Szachownica.plansza[pozycjaKrola[0]][i] != null && Szachownica.plansza[pozycjaKrola[0]][i].getKolor() != kolorSprawdzany && ( Szachownica.plansza[i][pozycjaKrola[1]] instanceof Wieza || Szachownica.plansza[i][pozycjaKrola[1]] instanceof Hetman )){
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
                if(Szachownica.plansza[pozycjaKrola[0] + 2][pozycjaKrola[1] + 1] != null && Szachownica.plansza[pozycjaKrola[0] + 2][pozycjaKrola[1] + 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] + 2;
                    dozwolonyRuch[1] = pozycjaKrola[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaKrola[1] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] + 2][pozycjaKrola[1] - 1] != null && Szachownica.plansza[pozycjaKrola[0] + 2][pozycjaKrola[1] - 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] + 2;
                    dozwolonyRuch[1] = pozycjaKrola[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        if ( pozycjaKrola[0] - 2 >= 0 ){
            if ( pozycjaKrola[1] + 1 <= 7 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] - 2][pozycjaKrola[1] + 1] != null && Szachownica.plansza[pozycjaKrola[0] - 2][pozycjaKrola[1] + 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] - 2;
                    dozwolonyRuch[1] = pozycjaKrola[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaKrola[1] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] - 2][pozycjaKrola[1] - 1] != null && Szachownica.plansza[pozycjaKrola[0] - 2][pozycjaKrola[1] - 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] - 2;
                    dozwolonyRuch[1] = pozycjaKrola[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        if ( pozycjaKrola[1] + 2 <= 7 ){
            if ( pozycjaKrola[0] + 1 <= 7 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] + 2] != null && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] + 2].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] + 1;
                    dozwolonyRuch[1] = pozycjaKrola[1] + 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaKrola[0] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] + 2] != null && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] + 2].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] - 1;
                    dozwolonyRuch[1] = pozycjaKrola[1] + 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        if ( pozycjaKrola[1] - 2 >= 0 ){
            if ( pozycjaKrola[0] + 1 <= 7 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] - 2] != null && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] - 2].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] + 1;
                    dozwolonyRuch[1] = pozycjaKrola[1] - 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
            if ( pozycjaKrola[0] - 1 >= 0 ){
                int[] dozwolonyRuch = new int[2];
                if(Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] != null && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 2] instanceof Skoczek){
                    dozwolonyRuch[0] = pozycjaKrola[0] - 1;
                    dozwolonyRuch[1] = pozycjaKrola[1] - 2;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                }
            }
        }
        //pion
         if(kolorSprawdzany == Color.YELLOW_BOLD){
             if(pozycjaKrola[1] != 0 &&  Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] - 1] != null && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] - 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] - 1] instanceof Pion){
                 int[] dozwolonyRuch = new int[2];
                 dozwolonyRuch[0] = pozycjaKrola[0] + 1;
                 dozwolonyRuch[1] = pozycjaKrola[1] - 1;
                 listaDozwolonyuchRuchow.add(dozwolonyRuch);
             }
             else if(pozycjaKrola[1] != 7 && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] + 1] != null && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] + 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] + 1][pozycjaKrola[1] + 1] instanceof Pion) {
                 int[] dozwolonyRuch = new int[2];
                 dozwolonyRuch[0] = pozycjaKrola[0] + 1;
                 dozwolonyRuch[1] = pozycjaKrola[1] + 1;
                 listaDozwolonyuchRuchow.add(dozwolonyRuch);
             }
         }
         else{
             if(pozycjaKrola[1] != 0 && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 1] != null && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] - 1] instanceof Pion){
                 int[] dozwolonyRuch = new int[2];
                 dozwolonyRuch[0] = pozycjaKrola[0] - 1;
                 dozwolonyRuch[1] = pozycjaKrola[1] - 1;
                 listaDozwolonyuchRuchow.add(dozwolonyRuch);
             }
             else if(pozycjaKrola[1] != 7 && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] + 1] != null && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] + 1].getKolor() != kolorSprawdzany && Szachownica.plansza[pozycjaKrola[0] - 1][pozycjaKrola[1] + 1] instanceof Pion) {
                 int[] dozwolonyRuch = new int[2];
                 dozwolonyRuch[0] = pozycjaKrola[0] - 1;
                 dozwolonyRuch[1] = pozycjaKrola[1] + 1;
                 listaDozwolonyuchRuchow.add(dozwolonyRuch);
             }
         }

        int[][] zwracanaTablicaRuchow = new int[listaDozwolonyuchRuchow.size()][2];
        zwracanaTablicaRuchow = listaDozwolonyuchRuchow.toArray(zwracanaTablicaRuchow);
        if(zwracanaTablicaRuchow.length != 0){
            System.out.print(kolorSprawdzany + "Szach na królu!\n");
        }
        System.out.print(kolorSprawdzany + "krol zostal sprawdzony!\n");
        return zwracanaTablicaRuchow;
    }

    @Override
    public int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej, int[] pozycjaKrola, int[] pozycjaKrolaPrzeciwnika) {
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
        if(!czyWykonanoRuch){
            if(getKolor() == Color.BLUE_BOLD && czySzach(pozycjaFiguryWybranej, Color.BLUE_BOLD).length == 0){
                if(Szachownica.plansza[7][0] != null && Szachownica.plansza[7][0] instanceof Wieza && !((Wieza) Szachownica.plansza[7][0]).getCzyWykonanoRuch() && Szachownica.plansza[7][1] == null && Szachownica.plansza[7][2] == null && Szachownica.plansza[7][3] == null && czySzach(new int[]{7, 3}, Color.BLUE_BOLD).length == 0 && czySzach(new int[]{7, 2}, Color.BLUE_BOLD).length == 0){
                    listaDozwolonyuchRuchow.add(new int[]{7,2});
                }
                if(Szachownica.plansza[7][7] != null && Szachownica.plansza[7][7] instanceof Wieza && !((Wieza) Szachownica.plansza[7][7]).getCzyWykonanoRuch() && Szachownica.plansza[7][6] == null && Szachownica.plansza[7][5] == null && czySzach(new int[]{7, 5}, Color.BLUE_BOLD).length == 0 && czySzach(new int[]{7, 6}, Color.BLUE_BOLD).length == 0){
                    listaDozwolonyuchRuchow.add(new int[]{7,6});
                }
            }
            else if(getKolor() == Color.YELLOW_BOLD && czySzach(pozycjaFiguryWybranej, Color.YELLOW_BOLD). length == 0){
                if(Szachownica.plansza[0][0] != null && Szachownica.plansza[0][0] instanceof Wieza && !((Wieza) Szachownica.plansza[0][0]).getCzyWykonanoRuch() && Szachownica.plansza[0][1] == null && Szachownica.plansza[0][2] == null && Szachownica.plansza[0][3] == null && czySzach(new int[]{0, 3}, Color.YELLOW_BOLD).length == 0 && czySzach(new int[]{0, 2}, Color.YELLOW_BOLD).length == 0){
                    listaDozwolonyuchRuchow.add(new int[]{0,2});
                }
                if(Szachownica.plansza[0][7] != null && Szachownica.plansza[0][7] instanceof Wieza && !((Wieza) Szachownica.plansza[0][7]).getCzyWykonanoRuch() && Szachownica.plansza[0][6] == null && Szachownica.plansza[0][5] == null && czySzach(new int[]{0, 5}, Color.YELLOW_BOLD).length == 0 && czySzach(new int[]{0, 6}, Color.YELLOW_BOLD).length == 0){
                    listaDozwolonyuchRuchow.add(new int[]{0,6});
                }
            }
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
