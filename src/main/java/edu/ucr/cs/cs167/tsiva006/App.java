package edu.ucr.cs.cs167.tsiva006;

import java.util.function.Function;

public class App {

    public static void printNumbers(int from, int to, Function<Integer, Boolean> filter) {
        System.out.printf("Printing numbers in the range [%d,%d]\n", from, to);
        for (int i = from; i <= to; i++) {
            if (filter.apply(i)) {
                System.out.println(i);
            }
        }
    }

    public static Function<Integer, Boolean> combineWithAnd(Function<Integer, Boolean>... filters) {
        return x -> {
            for (Function<Integer, Boolean> filter : filters) {
                if (!filter.apply(x)) {
                    return false;
                }
            }
            return true;
        };
    }

    public static Function<Integer, Boolean> combineWithOr(Function<Integer, Boolean>... filters) {
        return x -> {
            for (Function<Integer, Boolean> filter : filters) {
                if (filter.apply(x)) {
                    return true;
                }
            }
            return false;
        };
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Error: You must provide at least three inputs: start, end, and criteria.");
            return;
        }

        int from = Integer.parseInt(args[0]);
        int to = Integer.parseInt(args[1]);
        String baseInput = args[2];

        String[] baseParts = baseInput.split("[,v]");
        boolean isAnd = baseInput.contains(",");
        boolean isOr = baseInput.contains("v");

        Function<Integer, Boolean>[] filters = new Function[baseParts.length];
        for (int i = 0; i < baseParts.length; i++) {
            int base = Integer.parseInt(baseParts[i]);
            filters[i] = x -> x % base == 0;
        }

        Function<Integer, Boolean> combinedFilter;
        if (isAnd) {
            combinedFilter = combineWithAnd(filters);
        } else if (isOr) {
            combinedFilter = combineWithOr(filters);
        } else {
            System.err.println("Error: Separator not recognized. Use ',' for AND or 'v' for OR operations.");
            return;
        }

        printNumbers(from, to, combinedFilter);
    }
}


// original functions:
// printEvenNumbers(from, to);
// printNumbersDivisibleByThree(from, to);