public class Szachownica {
    public static Figura[][] plansza =
            {{ new Wieza(Color.YELLOW_BOLD), new Skoczek(Color.YELLOW_BOLD), new Goniec(Color.YELLOW_BOLD), new Hetman(Color.YELLOW_BOLD), new Krol(Color.YELLOW_BOLD), new Goniec(Color.YELLOW_BOLD), new Skoczek(Color.YELLOW_BOLD), new Wieza(Color.YELLOW_BOLD) },
            { new Pion(Color.YELLOW_BOLD), new Pion(Color.YELLOW_BOLD), new Pion(Color.YELLOW_BOLD), new Pion(Color.YELLOW_BOLD), new Pion(Color.YELLOW_BOLD), new Pion(Color.YELLOW_BOLD), new Pion(Color.YELLOW_BOLD), new Pion(Color.YELLOW_BOLD) },
            { null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null },
            { new Pion(Color.BLUE_BOLD), new Pion(Color.BLUE_BOLD), new Pion(Color.BLUE_BOLD), new Pion(Color.BLUE_BOLD), new Pion(Color.BLUE_BOLD), new Pion(Color.BLUE_BOLD), new Pion(Color.BLUE_BOLD), new Pion(Color.BLUE_BOLD) },
            { new Wieza(Color.BLUE_BOLD), new Skoczek(Color.BLUE_BOLD), new Goniec(Color.BLUE_BOLD), new Hetman(Color.BLUE_BOLD), new Krol(Color.BLUE_BOLD), new Goniec(Color.BLUE_BOLD), new Skoczek(Color.BLUE_BOLD), new Wieza(Color.BLUE_BOLD) }};
//    public String[][] plansza={{Color.YELLOW_BOLD+" W ",Color.YELLOW_BOLD+" S ",Color.YELLOW_BOLD+" G ",Color.YELLOW_BOLD+" H ",Color.YELLOW_BOLD+" K ",Color.YELLOW_BOLD+" G ",Color.YELLOW_BOLD+" S ",Color.YELLOW_BOLD+" W "},
//    {Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I "},
//    {"   ","   ","   ","   ","   ","   ","   ","   "},
//    {"   ","   ","   ","   ","   ","   ","   ","   "},
//    {"   ","   ","   ","   ","   ","   ","   ","   "},
//    {"   ","   ","   ","   ","   ","   ","   ","   "},
//    {Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I "},
//    {Color.BLUE_BOLD+" W ",Color.BLUE_BOLD+" S ",Color.BLUE_BOLD+" G ",Color.BLUE_BOLD+" H ",Color.BLUE_BOLD+" K ",Color.BLUE_BOLD+" G ",Color.BLUE_BOLD+" S ",Color.BLUE_BOLD+" W "}};
    public static void Rysuj(){
        int licznik=8, licznikV2=0;
        System.out.println(ConsoleColors.GREEN_BACKGROUND+" /  A  B  C  D  E  F  G  H  \\ "+ConsoleColors.RESET);
        for (Figura[] wiersz : plansza) {
            System.out.print(ConsoleColors.GREEN_BACKGROUND+" "+licznik+" "+ConsoleColors.RESET);
            for (Figura kolumna : wiersz) {
                if(kolumna != null){
                    if(licznikV2 %2== 0){
                        System.out.print(ConsoleColors.WHITE_BACKGROUND_BRIGHT+kolumna.getKolor()+kolumna.getZnakFigury()+ConsoleColors.RESET);
                    }
                    else System.out.print(ConsoleColors.BLACK_BACKGROUND+kolumna.getKolor()+kolumna.getZnakFigury()+ConsoleColors.RESET);
                }
                else{
                    if(licznikV2 %2== 0){
                        System.out.print(ConsoleColors.WHITE_BACKGROUND_BRIGHT+"   "+ConsoleColors.RESET);
                    }
                    else System.out.print(ConsoleColors.BLACK_BACKGROUND+"   "+ConsoleColors.RESET);
                }
                licznikV2++;
            }
            System.out.println(ConsoleColors.GREEN_BACKGROUND+" "+licznik+" "+ConsoleColors.RESET+"");
            licznik--;
            licznikV2--;
        }
        System.out.println(ConsoleColors.GREEN_BACKGROUND+" \\  A  B  C  D  E  F  G  H  / "+ConsoleColors.RESET);
        // testy kolorow
        // wynik:
        /*
        System.out.print(Color.WHITE_BACKGROUND);
        System.out.println(Color.GREEN_BOLD+" \\  A  B  C  D  E  F  G  H  / ZIELONY");
        System.out.println(Color.CYAN_BOLD+" \\  A  B  C  D  E  F  G  H  / CYAN");
        System.out.println(Color.RED_BOLD_BRIGHT+" \\  A  B  C  D  E  F  G  H  / CZERWONY");
        System.out.println(Color.MAGENTA_BOLD+" \\  A  B  C  D  E  F  G  H  / MAGENTE ");
        System.out.println(Color.BLUE_BOLD+" \\  A  B  C  D  E  F  G  H  / NIEBIESKI");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY ");
        System.out.println(Color.WHITE_BOLD+" \\  A  B  C  D  E  F  G  H  / BIALY");
        System.out.println(Color.BLACK_BOLD+" \\  A  B  C  D  E  F  G  H  / CZARNY");
        System.out.print(Color.BLACK_BACKGROUND);
        System.out.println(Color.GREEN_BOLD+" \\  A  B  C  D  E  F  G  H  / ZIELONY");
        System.out.println(Color.CYAN_BOLD+" \\  A  B  C  D  E  F  G  H  / CYAN");
        System.out.println(Color.RED_BOLD+" \\  A  B  C  D  E  F  G  H  / CZERWONY");
        System.out.println(Color.MAGENTA_BOLD+" \\  A  B  C  D  E  F  G  H  / MAGENTE ");
        System.out.println(Color.BLUE_BOLD+" \\  A  B  C  D  E  F  G  H  / NIEBIESKI");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY ");
        System.out.println(Color.WHITE_BOLD+" \\  A  B  C  D  E  F  G  H  / BIALY");
        System.out.println(Color.BLACK_BOLD+" \\  A  B  C  D  E  F  G  H  / CZARNY");
        System.out.print(Color.RED_BACKGROUND);
        System.out.println(Color.GREEN_BOLD+" \\  A  B  C  D  E  F  G  H  / ZIELONY");
        System.out.println(Color.CYAN_BOLD+" \\  A  B  C  D  E  F  G  H  / CYAN");
        System.out.println(Color.RED_BOLD_BRIGHT+" \\  A  B  C  D  E  F  G  H  / CZERWONY");
        System.out.println(Color.MAGENTA_BOLD+" \\  A  B  C  D  E  F  G  H  / MAGENTE ");
        System.out.println(Color.BLUE_BOLD+" \\  A  B  C  D  E  F  G  H  / NIEBIESKI");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY ");
        System.out.println(Color.WHITE_BOLD_BRIGHT+" \\  A  B  C  D  E  F  G  H  / BIALY");
        System.out.println(Color.BLACK_BOLD_BRIGHT+" \\  A  B  C  D  E  F  G  H  / CZARNY");

        System.out.print(Color.YELLOW_BACKGROUND);
        System.out.println(Color.GREEN_BOLD+" \\  A  B  C  D  E  F  G  H  / ZIELONY");
        System.out.println(Color.CYAN_BOLD+" \\  A  B  C  D  E  F  G  H  / CYAN");
        System.out.println(Color.RED_BOLD+" \\  A  B  C  D  E  F  G  H  / CZERWONY");
        System.out.println(Color.MAGENTA_BOLD+" \\  A  B  C  D  E  F  G  H  / MAGENTE ");
        System.out.println(Color.BLUE_BOLD+" \\  A  B  C  D  E  F  G  H  / NIEBIESKI");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY ");
        System.out.println(Color.WHITE_BOLD+" \\  A  B  C  D  E  F  G  H  / BIALY");
        System.out.println(Color.BLACK_BOLD+" \\  A  B  C  D  E  F  G  H  / CZARNY");
        System.out.print(Color.CYAN_BACKGROUND);
        System.out.println(Color.GREEN_BOLD+" \\  A  B  C  D  E  F  G  H  / ZIELONY");
        System.out.println(Color.CYAN_BOLD+" \\  A  B  C  D  E  F  G  H  / CYAN");
        System.out.println(Color.RED_BOLD+" \\  A  B  C  D  E  F  G  H  / CZERWONY");
        System.out.println(Color.MAGENTA_BOLD+" \\  A  B  C  D  E  F  G  H  / MAGENTE ");
        System.out.println(Color.BLUE_BOLD+" \\  A  B  C  D  E  F  G  H  / NIEBIESKI");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY ");
        System.out.println(Color.WHITE_BOLD+" \\  A  B  C  D  E  F  G  H  / BIALY");
        System.out.println(Color.BLACK_BOLD+" \\  A  B  C  D  E  F  G  H  / CZARNY");
        System.out.print(Color.MAGENTA_BACKGROUND);
        System.out.println(Color.GREEN_BOLD+" \\  A  B  C  D  E  F  G  H  / ZIELONY");
        System.out.println(Color.CYAN_BOLD+" \\  A  B  C  D  E  F  G  H  / CYAN");
        System.out.println(Color.RED_BOLD+" \\  A  B  C  D  E  F  G  H  / CZERWONY");
        System.out.println(Color.MAGENTA_BOLD+" \\  A  B  C  D  E  F  G  H  / MAGENTE ");
        System.out.println(Color.BLUE_BOLD+" \\  A  B  C  D  E  F  G  H  / NIEBIESKI");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY ");
        System.out.println(Color.WHITE_BOLD+" \\  A  B  C  D  E  F  G  H  / BIALY");
        System.out.println(Color.BLACK_BOLD+" \\  A  B  C  D  E  F  G  H  / CZARNY");
        System.out.print(Color.BLUE_BACKGROUND);
        System.out.println(Color.GREEN_BOLD+" \\  A  B  C  D  E  F  G  H  / ZIELONY");
        System.out.println(Color.CYAN_BOLD+" \\  A  B  C  D  E  F  G  H  / CYAN");
        System.out.println(Color.RED_BOLD+" \\  A  B  C  D  E  F  G  H  / CZERWONY");
        System.out.println(Color.MAGENTA_BOLD+" \\  A  B  C  D  E  F  G  H  / MAGENTE ");
        System.out.println(Color.BLUE_BOLD+" \\  A  B  C  D  E  F  G  H  / NIEBIESKI");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY ");
        System.out.println(Color.WHITE_BOLD+" \\  A  B  C  D  E  F  G  H  / BIALY");
        System.out.println(Color.BLACK_BOLD+" \\  A  B  C  D  E  F  G  H  / CZARNY");
        System.out.print(Color.GREEN_BACKGROUND);
        System.out.println(Color.GREEN_BOLD+" \\  A  B  C  D  E  F  G  H  / ZIELONY");
        System.out.println(Color.CYAN_BOLD+" \\  A  B  C  D  E  F  G  H  / CYAN");
        System.out.println(Color.RED_BOLD+" \\  A  B  C  D  E  F  G  H  / CZERWONY");
        System.out.println(Color.MAGENTA_BOLD+" \\  A  B  C  D  E  F  G  H  / MAGENTE ");
        System.out.println(Color.BLUE_BOLD+" \\  A  B  C  D  E  F  G  H  / NIEBIESKI");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY ");
        System.out.println(Color.WHITE_BOLD+" \\  A  B  C  D  E  F  G  H  / BIALY");
        System.out.println(Color.BLACK_BOLD+" \\  A  B  C  D  E  F  G  H  / CZARNY");


//WIELKIE ELIMINACJE XD

        System.out.print(Color.WHITE_BACKGROUND);
        System.out.println(Color.GREEN_BOLD+" \\  A  B  C  D  E  F  G  H  / ZIELONY");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY \n");

        System.out.println(Color.CYAN_BOLD+" \\  A  B  C  D  E  F  G  H  / CYAN");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY \n");

        System.out.println(Color.RED_BOLD_BRIGHT+" \\  A  B  C  D  E  F  G  H  / CZERWONY");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY \n");

        System.out.println(Color.MAGENTA_BOLD+" \\  A  B  C  D  E  F  G  H  / MAGENTE ");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY \n");

        System.out.println(Color.BLUE_BOLD+" \\  A  B  C  D  E  F  G  H  / NIEBIESKI");
        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY \n");

        System.out.println(Color.YELLOW_BOLD+" \\  A  B  C  D  E  F  G  H  /ZOLTY ");
        System.out.println(Color.WHITE_BOLD+" \\  A  B  C  D  E  F  G  H  / BIALY");
        System.out.println(Color.BLACK_BOLD+" \\  A  B  C  D  E  F  G  H  / CZARNY");
*/

    }
    public static void Rysuj(int[] pozycjaFiguryWybranej, int[][] dozwoloneRuchy) { //wyświetla planszę z możliwymi ruchami
        Boolean bialyLubCzarny = true; // biały = true, czarny = false
        System.out.println(ConsoleColors.GREEN_BACKGROUND + " /  A  B  C  D  E  F  G  H  \\ " + ConsoleColors.RESET);
        for (int i = 0; i < 8; i++) {
            System.out.print(ConsoleColors.GREEN_BACKGROUND + " " + (i-8)*-1 + " " + ConsoleColors.RESET);
            for (int j = 0; j < 8; j++) {
                Boolean czyDozwolony = false; //czy jest dozwolona czy nie, ważne przy wyborze czy kolorować pozycje czy nie
                if (plansza[i][j] != null) { // czy pozycja jest figurą
                    if (i == pozycjaFiguryWybranej[0] && j == pozycjaFiguryWybranej[1]){ // czy pozycja jest równa pozycji wybranej
                        if (bialyLubCzarny)
                            System.out.print(ConsoleColors.WHITE_BACKGROUND_BRIGHT + Color.MAGENTA_BOLD + plansza[i][j].getZnakFigury() + ConsoleColors.RESET);
                        else
                            System.out.print(ConsoleColors.BLACK_BACKGROUND + Color.MAGENTA_BOLD + plansza[i][j].getZnakFigury() + ConsoleColors.RESET);
                    }
                    else {
                        for (int[] pozycjaDozwolona : dozwoloneRuchy){ //sprawdza dla każdej dozwolonej czy jest równa aktualnej w pętli (troche nieoptymalne ale nic lepszego na ten moment nie wymyśle)
                            if (i == pozycjaDozwolona[0] && j == pozycjaDozwolona[1]){
                                if (bialyLubCzarny)
                                    System.out.print(ConsoleColors.WHITE_BACKGROUND_BRIGHT + Color.RED_BOLD + plansza[i][j].getZnakFigury() + ConsoleColors.RESET);
                                else
                                    System.out.print(ConsoleColors.BLACK_BACKGROUND + Color.RED_BOLD + plansza[i][j].getZnakFigury() + ConsoleColors.RESET);
//                            System.out.print(ConsoleColors.RED_BACKGROUND + plansza[i][j].getKolor() + plansza[i][j].getZnakFigury() + ConsoleColors.RESET);
                                czyDozwolony = true;
                                break;
                            }
                        }
                        if(!czyDozwolony)
                            if (bialyLubCzarny)
                                System.out.print(ConsoleColors.WHITE_BACKGROUND_BRIGHT + plansza[i][j].getKolor() + plansza[i][j].getZnakFigury() + ConsoleColors.RESET);
                            else
                                System.out.print(ConsoleColors.BLACK_BACKGROUND + plansza[i][j].getKolor() + plansza[i][j].getZnakFigury() + ConsoleColors.RESET);
                    }
                } else {
                    for (int[] pozycjaDozwolona : dozwoloneRuchy){ //sprawdza dla każdej dozwolonej czy jest równa aktualnej w pętli (troche nieoptymalne ale nic lepszego na ten moment nie wymyśle)
                        if (i == pozycjaDozwolona[0] && j == pozycjaDozwolona[1]){
                            if (bialyLubCzarny)
                                System.out.print(ConsoleColors.WHITE_BACKGROUND_BRIGHT + Color.RED_BOLD + " * " + ConsoleColors.RESET);
                            else
                                System.out.print(ConsoleColors.BLACK_BACKGROUND + Color.RED_BOLD + " * " + ConsoleColors.RESET);
//                            System.out.print(ConsoleColors.RED_BACKGROUND + "   " + ConsoleColors.RESET);
                            czyDozwolony = true;
                            break;
                        }
                    }
                    if (!czyDozwolony)
                        if(bialyLubCzarny)
                            System.out.print(ConsoleColors.WHITE_BACKGROUND_BRIGHT + "   " + ConsoleColors.RESET);
                        else
                            System.out.print(ConsoleColors.BLACK_BACKGROUND + "   " + ConsoleColors.RESET);
                }
                bialyLubCzarny = !bialyLubCzarny;
            }
            System.out.println(ConsoleColors.GREEN_BACKGROUND + " " + (i-8)*-1 + " " + ConsoleColors.RESET + "");
            bialyLubCzarny= !bialyLubCzarny;
        }
        System.out.println(ConsoleColors.GREEN_BACKGROUND + " \\  A  B  C  D  E  F  G  H  / " + ConsoleColors.RESET);
    }
}
