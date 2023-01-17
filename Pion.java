import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import javax.print.event.PrintEvent;

public class Pion extends Figura {
    Scanner sc = new Scanner(System.in);
    public Pion(Color kolor) {
        super(kolor);
        znakFigury = " I ";
    }

    private boolean czyWykonanoRuch = false;

    public void bicieWPrzelocie(){

    }

    @Override
    public void Ruch(int[] pozycjaRuchu, int[] pozycjaFiguryWybranej, int[][] dozwoloneRuchy) {
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
            System.out.println(Color.RED+"Nieprawidłowa wartość!"+Color.RESET);
            Promocja(pozycjaFigury, kolor);
        }
        return figura.toUpperCase();
    }

    @Override
    public int[][] sprawdzMozliweRuchy(int[] pozycjaFiguryWybranej) {
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
        }
        int[][] zwracanaTablicaRuchow = new int[listaDozwolonyuchRuchow.size()][2];
        zwracanaTablicaRuchow = listaDozwolonyuchRuchow.toArray(zwracanaTablicaRuchow);
        return zwracanaTablicaRuchow;
    }
}
