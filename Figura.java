public abstract class Figura {
    public Figura(Color kolor){
        this.kolor = kolor;
    }
    private final Color kolor; //kolor aby określić ruch piona(czy "czarny" czy "biały") i żeby wiedzieć czy gracz w danej turze może się ruszyć tą figurą
    public Color getKolor() {
        return kolor;
    }

    protected String znakFigury;
    public String getZnakFigury() { return znakFigury; }

    public int[][] czySzach(int[] pozycjaKrola, Color kolorSprawdzany){
        int[][] zwrotna = new int[0][];
        return zwrotna;
    }

//    private String pozycja; // nie wiem czy się przyda, później może tak, zapisywać np."A8" potem litera z chr na int -65 żeby wyszło jaki indeks na planszy
//
//    public String getPozycja() {
//        return pozycja;
//    }
//
//    public void setPozycja(String nowaPozycja) {
//        pozycja = nowaPozycja;
//    }

    public void Ruch(int[] pozycjaRuchu, int[] pozycjaFiguryWybranej, int[][] dozwoloneRuchy) { // figura idzie na pole "ruchu", poprzednie pole figury jest puste
        for (int[] pozycjaDozwolona : dozwoloneRuchy ){
            if ( pozycjaDozwolona[0] == pozycjaRuchu[0] && pozycjaDozwolona[1] == pozycjaRuchu[1] ) {
                Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]] = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]];
                Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] = null;
                break;
            }
        }
    }
    public abstract String CheckEnd(int[] pozycjaFigury);
    public abstract int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej, int[] pozycjaKrola, int[] pozycjaKrolaPrzeciwnika); //zwraca tablicę możłiwych ruchów
}
