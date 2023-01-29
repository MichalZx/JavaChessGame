import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pion extends Figura {
    public Pion(Color kolor) {
        super(kolor);
        znakFigury = " I ";
    }
    Scanner sc = new Scanner(System.in);
    private boolean czyWykonanoRuch = false;
    public boolean getCzyWykonanoRuch(){
        return czyWykonanoRuch;
    }
    public void setCzyWykonanoRuch(boolean czyWykonanoRuch){
        this.czyWykonanoRuch = czyWykonanoRuch;
    }

    @Override
    public void Ruch(int[] pozycjaRuchu, int[] pozycjaFiguryWybranej, int[][] dozwoloneRuchy) {
        for (int[] pozycjaDozwolona : dozwoloneRuchy ){
            if ( pozycjaDozwolona[0] == pozycjaRuchu[0] && pozycjaDozwolona[1] == pozycjaRuchu[1] ) {
                if(pozycjaRuchu[1] != pozycjaFiguryWybranej[1] && Szachownica.plansza[pozycjaDozwolona[0]][pozycjaDozwolona[1]] == null){
                    if(getKolor() == Color.YELLOW_BOLD){
                        Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]] = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]];
                        Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] = null;
                        Szachownica.plansza[pozycjaRuchu[0] - 1][pozycjaRuchu[1]] = null;
                    }
                    else{
                        Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]] = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]];
                        Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] = null;
                        Szachownica.plansza[pozycjaRuchu[0] + 1][pozycjaRuchu[1]] = null;
                    }
                }
                else{
                    Szachownica.plansza[pozycjaRuchu[0]][pozycjaRuchu[1]] = Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]];
                    Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1]] = null;
                }
                czyWykonanoRuch = true;
                break;
            }
        }
    }

    @Override
    public String CheckEnd(int[] pozycjaFigury){// zolty 7, niebieski 0
        Color kolor =Szachownica.plansza[pozycjaFigury[0]][pozycjaFigury[1]].getKolor();
        if(pozycjaFigury[0]==0 && kolor==Color.BLUE_BOLD)
            return Promocja(pozycjaFigury,kolor);
        else if (pozycjaFigury[0]==7 && kolor==Color.YELLOW_BOLD)
            return Promocja(pozycjaFigury,kolor);
        return "0";
    }
    public String Promocja(int[] pozycjaFigury, Color kolor){
        System.out.println("Wybierz figure: W / S / G / H ");
        String figura = sc.nextLine();
        if(figura.toLowerCase().equals("w")){
            Szachownica.plansza[pozycjaFigury[0]][pozycjaFigury[1]]=new Wieza(kolor);
        } else if(figura.toLowerCase().equals("s")){
            Szachownica.plansza[pozycjaFigury[0]][pozycjaFigury[1]]=new Skoczek(kolor);
        } else if(figura.toLowerCase().equals("g")){
            Szachownica.plansza[pozycjaFigury[0]][pozycjaFigury[1]]=new Goniec(kolor);
        } else if(figura.toLowerCase().equals("h")){
            Szachownica.plansza[pozycjaFigury[0]][pozycjaFigury[1]]=new Hetman(kolor);
        }
        else{
            System.out.println(Color.RED+"Nieprawid�owa warto��!"+Color.RESET);
            Promocja(pozycjaFigury, kolor);
        }
        return figura.toUpperCase();
    }

    @Override
    public int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej, int[] pozycjaKrola, int[] pozycjaKrolaPrzeciwnika) {
        List<int[]> listaDozwolonyuchRuchow = new ArrayList<>();
        int[][] ostatniRuch=Szachownica.ostatniRuch;
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
            //en passant
            if(pozycjaFiguryWybranej[0] == 3 && pozycjaFiguryWybranej[1] != 7 && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] + 1] instanceof Pion && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] + 1].getKolor() == Color.YELLOW_BOLD && Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] + 1] == null){
                if(ostatniRuch[0][0] + 2 == ostatniRuch[1][0] && ostatniRuch[1][1] == pozycjaFiguryWybranej[1] + 1 && ostatniRuch[1][0] == pozycjaFiguryWybranej[0]){
                    int[] dozwolonyRuch = new int[2];
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] + 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                    Szachownica.enPassant[0]=dozwolonyRuch;
                }
            }
            if(pozycjaFiguryWybranej[0] == 3 && pozycjaFiguryWybranej[1] != 0 && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] - 1] instanceof Pion && Szachownica.plansza[pozycjaFiguryWybranej[0]][pozycjaFiguryWybranej[1] - 1].getKolor() == Color.YELLOW_BOLD && Szachownica.plansza[pozycjaFiguryWybranej[0] - 1][pozycjaFiguryWybranej[1] - 1] == null){
                if(ostatniRuch[0][0] + 2 == ostatniRuch[1][0] && ostatniRuch[1][1] == pozycjaFiguryWybranej[1] - 1 && ostatniRuch[1][0] == pozycjaFiguryWybranej[0]){
                    int[] dozwolonyRuch = new int[2];
                    dozwolonyRuch[0] = pozycjaFiguryWybranej[0] - 1;
                    dozwolonyRuch[1] = pozycjaFiguryWybranej[1] - 1;
                    listaDozwolonyuchRuchow.add(dozwolonyRuch);
                    Szachownica.enPassant[1]=dozwolonyRuch;
                }
            }
        }
        int[][] zwracanaTablicaRuchow = new int[listaDozwolonyuchRuchow.size()][2];
        zwracanaTablicaRuchow = listaDozwolonyuchRuchow.toArray(zwracanaTablicaRuchow);
        return zwracanaTablicaRuchow;
    }
}
