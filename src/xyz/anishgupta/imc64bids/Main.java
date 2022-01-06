package xyz.anishgupta.imc64bids;

import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        TimeValue t = new TimeValue();
        //System.out.println(t.calculateTime(1,0,0));

        FlatCallsAndPuts f = new FlatCallsAndPuts();
        //System.out.println(f.calculateProfit(Arrays.asList(3,9,7), Arrays.asList(1,3,2), Arrays.asList(10,10), Arrays.asList(2,2)));

        FastRead g = new FastRead();


        //System.out.println(g.fastRead(700, 900, "{\"timestamp\":0,\"book\":\"AAPL\",\"bids\":[],\"asks\":[{\"price\":600,\"volume\":10}]}')"));

        //System.out.println(g.fastRead(500, 900, "{\"timestamp\":15,\"book\":\"TSLA\",\"bids\":[{\"price\":800,\"volume\":50},{\"price\":850,\"volume\":110}],\"asks\":[]}"));

       //List<Integer> range = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
       //System.out.println(range.toString());

        PointGroups p = new PointGroups();
        System.out.println(p.findGroups(Arrays.asList( 1,1, 2,2, 5,5 ), Arrays.asList(  5,5, 1,1, 3,3)).toString());

        OptionCombinations o = new OptionCombinations();
        System.out.println(o.countCombinations(3,2)); // 4083


    }
}
