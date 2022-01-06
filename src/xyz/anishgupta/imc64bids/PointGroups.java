package xyz.anishgupta.imc64bids;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PointGroups {
    public List<Integer> findGroups(List<Integer> firstPoints, List<Integer> secondPoints) {
        //throw new UnsupportedOperationException("Function not yet implemented.");
        int N = firstPoints.size()/2;

        List<Integer> ret = new ArrayList<>(2*N);
        for (int i=1; i<=N/2; i++) {
            ret.add(i);
            ret.add(i);
        }
        for (int i=1; i<=N/2; i++) {
            ret.add(i);
            ret.add(i);
        }
        return ret;

        //List<Integer> range = IntStream.rangeClosed(1, 2*N).boxed().collect(Collectors.toList());
        //return range;
    }
}
