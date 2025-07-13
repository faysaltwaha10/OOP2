
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySortReverse {
    public static void main(String[] args) {

        String[] pallets = {"B14", "A11", "B12", "A13", "A15", "B16", "A17", "B18", "A19", "B20"};

        // Sorting the array in ascending order
        System.out.println("Sorted ....");
        Arrays.sort(pallets);
        for (String pallet : pallets) {
            System.out.println("-- " + pallet);
        }

       
        System.out.println("\nReversed ....");
        List<String> palletList = Arrays.asList(pallets);
        Collections.reverse(palletList); 
        for (String pallet : palletList) {
            System.out.println("-- " + pallet);
        }

    
    }
}