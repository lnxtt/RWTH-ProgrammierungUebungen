public class Statistics
{
    public int[] values = new int[100];
    int valueCount = 0;

    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        statistics.addValue(2);
        statistics.addValue(105);
        statistics.addValue(-366);
        statistics.addValue(44);
        statistics.addValue(11);
        SimpleIO.output("Minimum: " + statistics.getMinimum());
        SimpleIO.output("Maximum: " + statistics.getMaximum());
        SimpleIO.output("Durchschnitt: " + statistics.getAverage());
    }

    public void addValue(int value) {
        if(valueCount < 100){
            values[valueCount] = value;
            valueCount++;
        }
        else{
            SimpleIO.output("Maximale Anzahl von Werten erreicht");
        }
    }

    public int getMinimum() {
        if(valueCount != 0){    //Kontrolliert falls addValue noch nie aufgerufen wurde
            int min = values[0];
            for(int i = 1;i <= valueCount;i++){
                if(values[i] < min){
                    min = values[i];
                }
            }
            return min;
        }
        else{
            SimpleIO.output("Fuegen sie erst Werte ein");
            return 0;
        }
    } 

    public int getMaximum() {
        if(valueCount != 0){    //Kontrolliert falls addValue noch nie aufgerufen wurde
            int max = values[0];
            for(int i = 1;i <= valueCount;i++){
                if(values[i] > max){
                    max = values[i];
                }
            }
            return max;
        }
        else{
            SimpleIO.output("Fuegen sie erst Werte ein");
            return 0;
        }
    }

    public double getAverage(){
        if(valueCount != 0){    //Kontrolliert falls addValue noch nie aufgerufen wurde
            double sum = 0;
            for(int i = 0;i <= valueCount;i++){
                sum += values[i];
            }
            double average = sum/valueCount;
            return average;
        }
        else{
            SimpleIO.output("Fuegen sie erst Werte ein");
            return 0;
        }
    }
}
