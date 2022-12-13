public abstract class Figura {
    public Figura(Color kolor){
        this.kolor = kolor;
    }
    private final Color kolor; //kolor aby określić ruch piona(czy "czarny" czy "biały") i żeby wiedzieć czy gracz w danej turze może się ruszyć tą figurą

    public Color getKolor() {
        return kolor;
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

    public abstract void Ruch();
    public abstract void sprawdzMozliweRuchy();
}
