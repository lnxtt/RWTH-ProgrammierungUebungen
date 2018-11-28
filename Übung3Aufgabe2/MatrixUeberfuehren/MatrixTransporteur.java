public class MatrixTransporteur
{
    public static void main(String args[]){
        int zeilen = 0;
        int spalten = 0;
        while(zeilen == 0){
            int zeilenInf = SimpleIO.getInt("Wie viele Zeilen hat die Matrix? (>= 1)");
            if(zeilenInf >= 1){
                zeilen = zeilenInf;
            }
        }
        while(spalten == 0){
            int spaltenInf = SimpleIO.getInt("Wie viele Spalten hat die Matrix? (>= 1)");
            if(spaltenInf >= 1){
                spalten = spaltenInf;
            }
        }
        int[][] eingegebeneMatrix = new int[zeilen][spalten];
        for(int a = 0;a < zeilen;a++){
            for(int b = 0;b < spalten;b++){
                int momWert = SimpleIO.getInt("Wie lautet die Zahl fuer Position (" + (a + 1) + ", "+ (b + 1) +")?");
                eingegebeneMatrix[a][b] = momWert;
            }
        }
        int[][] transportierteMatrix = new int[spalten][zeilen];
        for(int a = 0;a < spalten;a++){
            for(int b = 0;b < zeilen;b++){
                transportierteMatrix[a][b] = eingegebeneMatrix[b][a];
            }
        }
        matrixAusgeben("Matrix :", eingegebeneMatrix);
        matrixAusgeben("Transportierte Matrix :", transportierteMatrix);
    }

    private static void matrixAusgeben(String Titel, int[][] matrix){
        System.out.println(Titel);
        for(int a = 0;a<matrix.length;a++){
            for(int b = 0;b<matrix[a].length;b++){
                System.out.print(matrix[a][b] + ", ");
            }
            System.out.println("");
        }
    }
}
