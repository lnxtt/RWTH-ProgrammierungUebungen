import java.util.Arrays;
public class Minimum{
    public static int arrayMin(int[] inputArray){
        if (inputArray == null || inputArray.length == 0){
            return Integer.MAX_VALUE;
        }
        if (inputArray.length == 1){
            return inputArray[0];
        }
        int min = arrayMin(Arrays.copyOfRange(inputArray, 1, inputArray.length));
        return inputArray[0] < min ? inputArray[0] : min;
    }
}
