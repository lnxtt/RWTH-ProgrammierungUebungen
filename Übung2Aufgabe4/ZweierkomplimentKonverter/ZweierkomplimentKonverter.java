public class ZweierkomplimentKonverter
{
    static SimpleIO simpleIO = new SimpleIO();
    
    public static void main(String[] args) 
    {
        boolean wahlGetroffen = false;
        while(wahlGetroffen == false){
            String wahl = simpleIO.getString("Bitte waehlen Sie aus:" + "\n" + "Decimal: Dezimalzahl ins Zweierkomplement konvertieren." + "\n" + "Binary: 8-Bit-Zweierkomplement als Dezimalzahl darstellen.");
            switch(wahl){
                case "Decimal":
                    wahlGetroffen = true;
                    decimalKonvertierung();
                case "Binary":
                    wahlGetroffen = true;
                    binaryKonvertierung();
                default:
                    wahlGetroffen = false;
                }
        }
    }
    
    public static void decimalKonvertierung(){
        boolean korrekteEingabe = false;
        boolean zahlIstNegativ = false;
        int dezimalzahl = 0;
        while(korrekteEingabe == false){
            dezimalzahl = simpleIO.getInt("Bitte geben Sie eine ganze Zahl zwischen -128 und 127 ein.");
            if(dezimalzahl >= -128 && dezimalzahl <= 127){
                korrekteEingabe = true;
                if(dezimalzahl < 0){
                    zahlIstNegativ = true;
                    dezimalzahl = dezimalzahl * -1;
                }
            }
        }
        
        int[] binaerZahl = dezimalzahlInBinaerZahlKonvertieren(dezimalzahl);
        int[] zweierkomp = new int[8];
        if(zahlIstNegativ == true){
            int[] einerkomp = einerkomplimentBilden(binaerZahl);
            zweierkomp = einsZuEinerkomplementAddieren(einerkomp);
        }
        else{
            zweierkomp = binaerZahl;
        }
        simpleIO.output("Ihre Dezimalzahl im Zweierkomplement dargestellt ist " + intArrayZuStringKonvertieren(zweierkomp));
    } 

    public static void binaryKonvertierung(){
        boolean korrekteEingabe = false;
        boolean zahlIstNegativ = false;
        String zweierkomplement = "";
        while(korrekteEingabe == false){
            zweierkomplement = simpleIO.getString("Bitte geben Sie eine ganze Zahl im 8-Bit-Zweierkomplement ein.");
            if(zweierkomplement.length() == 8){
                boolean falscherCharacter = false;
                for(int i = 0; i < 8;i++){
                    if(zweierkomplement.charAt(i) != '1' && zweierkomplement.charAt(i) != '0'){
                            falscherCharacter = true;
                    }
                }
                if(falscherCharacter == false){
                    if(zweierkomplement.charAt(0)=='1'){
                        zahlIstNegativ = true;
                    }
                    korrekteEingabe = true;
                }
            }
        }
        
        int[] binaerZahl = stringZuIntArrayKonvertieren(zweierkomplement);
        if(zahlIstNegativ){
            int[] einerkomplement = einerkomplimentBilden(binaerZahl);
            binaerZahl = einsZuEinerkomplementAddieren(einerkomplement);
        }
        int ergebnis = binaerzahlZuDezimalzahlKonvertieren(binaerZahl);
        if(zahlIstNegativ){
            ergebnis = ergebnis*-1;
        }
        simpleIO.output("Ihr 8-Bit-Zweierkomplement entspricht der Dezimalzahl " + ergebnis);
    }
    
    private static int[] stringZuIntArrayKonvertieren(String target){
        int[] result = new int[8];
        for(int i = 0;i<8;i++){
            if(target.charAt(i)== '1'){
                result[i] = 1;
            }
            else{
                result[i] = 0;
            }
        }
        return result;
    }
    
    private static int binaerzahlZuDezimalzahlKonvertieren(int[] binaerzahl){
        int result = 0;
        for(int i = 0;i < 8;i++){
            if(binaerzahl[i] == 1){
                result += potenzVonZwei(7-i);
            }
        }
        return result;
    }
    
    private static int potenzVonZwei(int grad){
        int result = 1; 
        if(grad >= 1){
            result = 2;
            for(int i = 1;i < grad;i++){
                result = result*2;
            }
        }
        return result;
    }
    
    private static int[] dezimalzahlInBinaerZahlKonvertieren(int dezimalzahl){
        int reste[] = new int[8];
        int binaerZahl[] = new int[8];
        int count = 0;
        while(dezimalzahl != 0){
            int rest = dezimalzahl%2;
            reste[count] = rest;
            count++;
            dezimalzahl = dezimalzahl / 2;        
        }
        for(int i = 0;i < 8;i++){
            binaerZahl[i] = reste[7-i];
        }
        return binaerZahl;
    }
    
    private static int[] einerkomplimentBilden(int[] binaerZahl){
        int[] result = new int[8];
        for(int i = 0;i<8;i++){
            if(binaerZahl[i] == 1){
                result[i] = 0;
            }
            else{
                result[i] = 1;
            }
        }
        return result;
    }
    
    private static int[] einsZuEinerkomplementAddieren(int[] einerkompliment){
        int[] result = new int[8];
        int[] übertrag = new int[9];
        übertrag[8] = 1;
        for(int i = 7;i >= 0;i--){
            if(einerkompliment[i] == 1 && übertrag[i+1] == 1){
                result[i] = 0;
                übertrag[i] = 1;
            }
            if(einerkompliment[i] == 0 && übertrag[i+1] == 1 || einerkompliment[i] == 1 && übertrag[i+1] == 0){
                result[i] = 1;
                übertrag[i] = 0;
            }
             if(einerkompliment[i] == 0 && übertrag[i+1] == 0){
                result[i] = 0;
                übertrag[i] = 0;
            }
        }
        return result;
    }
    
    private static String intArrayZuStringKonvertieren(int[] array){
        String result = "";
        for(int i = 0;i < array.length;i++){
            result += String.valueOf(array[i]);
        }
        return result;
    }
}
