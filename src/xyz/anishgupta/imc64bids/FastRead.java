package xyz.anishgupta.imc64bids;

import java.util.*;
import java.util.function.*;

public class FastRead {
    public String fastRead(double maxBuyPrice, double minSellPrice, String marketState) {
        //throw new UnsupportedOperationException("Function not yet implemented.");
        int reader = 0;
        String ret = "";

        ret += "S13";
        reader += 13;

        while (marketState.charAt(reader) != ',') {
            ret += " R1";
            ++reader;
        }
        ret += " R1";
        ++reader;

        ret += " S8";
        reader += 8;

        while (marketState.charAt(reader) != '"') {
            ret += " R1";
            ++reader;
        }
        ret += " R1";
        ++reader;

        ret += " S9";
        reader += 9;


//        while (marketState.charAt(reader) != ']') {
//            ret += " R1";
//            reader ++;
//            ret += " S8";
//            reader += 8;
//            int start_price = reader;
//            while (marketState.charAt(reader) != ',') {
//                ret += " R1";
//                reader++;
//            }
//            int bidPrice = Integer.parseInt(marketState.substring(start_price, reader));
//            System.out.println(bidPrice);
//            ret += " R1";
//            reader ++;
//            if (minSellPrice <= bidPrice) {
//                return ret;
//            }
//            ret += " S9";
//            reader += 9;
//            while (marketState.charAt(reader) != '}') {
//                ret += " R1";
//                reader ++;
//            }
//            // }
//            ret += " R1";
//            reader ++;
//            if (marketState.charAt(reader) == ',') {
//                // System.out.println("triggered");
//                ret += " R1";
//                reader++;
//            }
//        }
//        // ']'
//        ret += " R1";
//        reader ++;
//
//        ret += " S9";
//        reader += 9;
//
//        while (marketState.charAt(reader) != ']') {
//            ret += " R1";
//            reader ++;
//            ret += " S8";
//            reader += 8;
//            int start_price = reader;
//            while (marketState.charAt(reader) != ',') {
//                ret += " R1";
//                reader++;
//            }
//            int askPrice = Integer.parseInt(marketState.substring(start_price, reader));
//            ret += " R1";
//            reader ++;
//            if (maxBuyPrice >= askPrice) {
//                return ret;
//            }
//            ret += " S9";
//            reader += 9;
//            while (marketState.charAt(reader) != '}') {
//                ret += " R1";
//                reader ++;
//            }
//            // }
//            ret += " R1";
//            reader ++;
//            if (marketState.charAt(reader) == ',') {
//                // System.out.println("triggered");
//                ret += " R1";
//                reader++;
//            }
//        }
//        // ']'
//        ret += " R1";
//        reader ++;

        ret += " R1";
        boolean quote = marketState.charAt(reader) == '{'; // otherwise ]
        if (!quote) {
            reader++;
        }
        while (quote) {
            reader++; // move to "price"
            //                   ^
            ret += " S8";
            reader += 8;
            int start_price = reader;
            while (marketState.charAt(reader) != ',') {
                ret += " R1";
                reader++;
            }
            int bidPrice = Integer.parseInt(marketState.substring(start_price, reader));
            ret += " R1";
            reader++;
            if (minSellPrice <= bidPrice) {
                return ret;
            }
            ret += " S9";
            reader += 9;
            while (marketState.charAt(reader) != '}') {
                ret += " R1";
                reader ++;
            }
            ret += " R1";
            reader ++;

            ret += " R1";
            quote = marketState.charAt(reader) == ','; // else ]
            reader ++;

            if (quote) {
                ret += " S1";
            }

            // process
            // read } and r1 increment repeater
            // read , or ]
            // if , then quote is true, setup for another one, if ] then false
        }
        System.out.println(marketState.charAt(reader));
        ret += " S9";
        reader += 9;
        ret += " R1";
        boolean quote2 = marketState.charAt(reader) == '{'; // otherwise ]
        System.out.println(marketState.charAt(reader));
        while (quote2) {
            reader++; // move to "price"
            //                   ^
            ret += " S8";
            reader += 8;
            int start_price = reader;
            while (marketState.charAt(reader) != ',') {
                ret += " R1";
                reader++;
            }
            int askPrice = Integer.parseInt(marketState.substring(start_price, reader));
            ret += " R1";
            reader++;
            if (maxBuyPrice >= askPrice) {
                return ret;
            }
            ret += " S9";
            reader += 9;
            while (marketState.charAt(reader) != '}') {
                ret += " R1";
                reader ++;
            }
            ret += " R1";
            reader ++;

            ret += " R1";
            quote2 = marketState.charAt(reader) == ','; // else ]
            reader ++;

            if (quote2) {
                ret += " S1";
            }
            // process
            // read } and r1 increment repeater
            // read , or ]
            // if , then quote is true, setup for another one, if ] then false
        }


        return ret;
    }
}
