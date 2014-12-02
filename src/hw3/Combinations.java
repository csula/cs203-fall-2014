package hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/*
 * Source: https://codereview.stackexchange.com/questions/26854/recursive-method-to-return-a-set-of-all-combinations
 */

public class Combinations<E> {

    public Set<Set<E>> getCombinationsFor(List<E> group, int subsetSize) {
        Set<Set<E>> resultingCombinations = new HashSet<Set<E>> ();
        int totalSize=group.size();
        if (subsetSize == 0) {
            emptySet(resultingCombinations);
        } else if (subsetSize <= totalSize) {
            List<E> remainingElements = new ArrayList<E>(group);
            E X = popLast(remainingElements);

            Set<Set<E>> combinationsExclusiveX = getCombinationsFor(remainingElements, subsetSize);
            Set<Set<E>> combinationsInclusiveX = getCombinationsFor(remainingElements, subsetSize-1);
            for (Set<E> combination : combinationsInclusiveX) {
                combination.add(X);
            }
            resultingCombinations.addAll(combinationsExclusiveX);
            resultingCombinations.addAll(combinationsInclusiveX);
        }
        return resultingCombinations;
    }

    private void emptySet(Set<Set<E>> resultingCombinations) {
        resultingCombinations.add(new HashSet<E>());
    }

    private E popLast(List<E> elementsExclusiveX) {
        return elementsExclusiveX.remove(elementsExclusiveX.size()-1);
    }
    
    private void print(List<E> list) {
        System.out.print("{ ");
        for (E i : list) {
            System.out.print(i + " ");
        }
        System.out.println("}");
    }
    
    private void printSetInteger(Set<E> set) {
        System.out.print("{ ");
        for (E i : set) {
            System.out.print(i + " ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        List<Integer> ll = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            ll.add(i);
        }
        
        Combinations<Integer> combo = new Combinations<Integer>();
        combo.print(ll);
        
        Set<Set<Integer>> S2 = combo.getCombinationsFor(ll, 4);

        for (Set<Integer> s : S2) {
            combo.printSetInteger(s);
        }
    }
}
