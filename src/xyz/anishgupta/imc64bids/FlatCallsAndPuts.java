package xyz.anishgupta.imc64bids;

import java.util.*;

public class FlatCallsAndPuts {
    public int calculateProfit(List<Integer> callStrikePrices, List<Integer> callVolumes, List<Integer> putStrikePrices, List<Integer> putVolumes) {
        //throw new UnsupportedOperationException("Function not yet implemented.");
        int maxSoFar = 0;

        int m = callStrikePrices.size();
        int n = putStrikePrices.size();

        int callMasks = 1 << m;
        int putMasks = 1 << n;

        for (int i = 1; i < callMasks; i++)
        {
            int lots = 0;
            int price = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) > 0) {//The j-th element is used
                    //System.out.print(callVolumes.get(j) + " at " + callStrikePrices.get(j) + "; ");
                    lots += callVolumes.get(j);
                    price -= callStrikePrices.get(j)*callVolumes.get(j);
                }
            }
            //System.out.print("lots: " + lots + " price: " + price);
            for (int k = 1; k < putMasks; k++)
            {
                int p_lots = 0;
                int p_price = 0;
                for (int l = 0; l < n; l++) {
                    if ((k & (1 << l)) > 0) {//The j-th element is used
                        //System.out.print(putVolumes.get(l) + " at " + putStrikePrices.get(l) + "; ");
                        p_lots += putVolumes.get(l);
                        p_price += putStrikePrices.get(l)*putVolumes.get(l);
                    }
                }
                //System.out.print("lots: " + lots + " price: " + price);

                if (p_lots == lots) {
                    maxSoFar = Math.max(maxSoFar, price+p_price);
                }

                //System.out.println();
            }
            //System.out.println();
        }

        return maxSoFar;
    }
}
