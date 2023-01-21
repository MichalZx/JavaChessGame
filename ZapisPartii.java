import java.io.*;

public class ZapisPartii {      // szyblie tworzenie na poczatku kazdej gry
    private static String pathFile;
    public static void StartGry(){
        File theDir = new File("Zapisane_gry"); // tworzenie foleru ktory zawiera rozgrywki
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        int licznik = new File("Zapisane_gry").list().length; //liczba plikow w folderze
        pathFile ="Zapisane_gry/Partia_szachow ("+(licznik+1)+").txt"; // nazwa pliku by nie bulo dublowania
        File plik = new File(pathFile);
        try {           // tworzenie pliku
            if (plik.createNewFile()) {
                System.out.println("File created: " + plik.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void ZapisRuchu( String figura, String nowaPozycja, boolean byloBicie, String kolumnaPiona, String promocja){
        String symbolFigury=figura.split(" ")[1];
        String ruch;
        //System.out.println(figura==" I ");
        if(byloBicie==true){
            if(figura==" I " && promocja.equals("0"))               // txt do zapisania w pliku
                {ruch=kolumnaPiona+":"+nowaPozycja+"\n"; } 
            else if(figura==" I " && (promocja.equals("0")==false))               // txt do zapisania w pliku
                {ruch=kolumnaPiona+":"+nowaPozycja+"\n"+nowaPozycja+promocja+"\n"; } 
            else{ruch=symbolFigury+":"+nowaPozycja+"\n"; }
        }
        else{
            if(figura==" I "&&promocja.equals("0"))               // txt do zapisania w pliku
            {ruch=nowaPozycja+"\n"; } 
            else if(figura==" I " && (promocja.equals("0")==false))               // txt do zapisania w pliku
            {ruch=nowaPozycja+promocja+"\n"; } 
            else{ruch=symbolFigury+nowaPozycja+"\n"; }
        }  
        try (Writer out = new BufferedWriter(new FileWriter(pathFile, true));) {
            out.append(ruch);           // tu dopisuje
            out.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();        
        }
    }
    public static void RezultatPartii(String wynik){ //1-0 blue win / 0-1 yellow win / 0.5-0.5 - PAT
        try (Writer out = new BufferedWriter(new FileWriter(pathFile, true));) {
            out.append(wynik);           // tu dopisuje
            out.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();        
        }
    }
}
