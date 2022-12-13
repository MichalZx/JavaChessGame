import java.lang.reflect.Array;
import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    public void Ruch(){
        System.out.print("Podaj pozycję swojej figury w formacie [a2]: ");
        String pozycjaOut = sc.nextLine();
        Szachownica szachownica=new Szachownica();
        char[] tab_pole = pozycjaOut.toLowerCase().toCharArray();
        if(CzyNalerzyDoSzachownicy(tab_pole)){   
            System.out.println("wybrane pole to:"+szachownica.plansza[(tab_pole[1]-56)*-1][tab_pole[0]-97]);
            //kolejny warunek sprawdzajacy wybor prawidlowej figury
            jakiKolor(szachownica.plansza[(tab_pole[1]-56)*-1][tab_pole[0]-97]);
        }
        else{
            System.out.println(Color.RED+"Nieprawidłowa wartość!"+Color.RESET);
        }    
        
    }
    private boolean CzyNalerzyDoSzachownicy(char[] tab_pole){
        if(tab_pole.length==2 & (tab_pole[0]>=97 & tab_pole[0]<=104)&(tab_pole[1]>=49 & tab_pole[1]<=56))  {//pole znajduje sie na sachwonicy
            return true;
        }
        return false;
    }
    private void jakiKolor(String pole){
        
        char[] xxx=pole.toCharArray();
        for (char c : xxx) {
            System.out.println(c);//mialo wyswietlac znak po znaku jaki jest w komurce i nie dziala
        }
    }
    private boolean czyPrawidlowyKolor(Color kolor){
        //tutaj sprawdzanie czy kolor jest git
        //ewentualnie mozna zrobic 1 sprwdanie ale to zalerzy jak bedziemy oznaczac figury
        return false;
    }
}
