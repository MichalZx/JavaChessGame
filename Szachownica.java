public class Szachownica {
    public String[][] plansza={{Color.YELLOW_BOLD+" W ",Color.YELLOW_BOLD+" S ",Color.YELLOW_BOLD+" G ",Color.YELLOW_BOLD+" H ",Color.YELLOW_BOLD+" K ",Color.YELLOW_BOLD+" G ",Color.YELLOW_BOLD+" S ",Color.YELLOW_BOLD+" W "},
    {Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I ",Color.YELLOW_BOLD+" I "},
    {"   ","   ","   ","   ","   ","   ","   ","   "},
    {"   ","   ","   ","   ","   ","   ","   ","   "},
    {"   ","   ","   ","   ","   ","   ","   ","   "},
    {"   ","   ","   ","   ","   ","   ","   ","   "},
    {Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I ",Color.BLUE_BOLD+" I "},
    {Color.BLUE_BOLD+" W ",Color.BLUE_BOLD+" S ",Color.BLUE_BOLD+" G ",Color.BLUE_BOLD+" H ",Color.BLUE_BOLD+" K ",Color.BLUE_BOLD+" G ",Color.BLUE_BOLD+" S ",Color.BLUE_BOLD+" W "}};
    public void Rysuj(){
        int licznik=8, licznikV2=0;
        System.out.println(ConsoleColors.GREEN_BACKGROUND+" /  A  B  C  D  E  F  G  H  \\ "+ConsoleColors.RESET);
        for (String[] strings : plansza) {
            System.out.print(ConsoleColors.GREEN_BACKGROUND+" "+licznik+" "+ConsoleColors.RESET);
            for (String string : strings) {
                if(licznikV2 %2== 0){
                    System.out.print(ConsoleColors.WHITE_BACKGROUND_BRIGHT+string+ConsoleColors.RESET);
                }
                else System.out.print(ConsoleColors.BLACK_BACKGROUND+string+ConsoleColors.RESET);
                licznikV2++;
            }
            System.out.println(ConsoleColors.GREEN_BACKGROUND+" "+licznik+" "+ConsoleColors.RESET);
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
}
