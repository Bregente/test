package org.junit;

import java.util.Comparator;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Sorter;

public class InternalTestClassArraySorter extends Sorter{

    public InternalTestClassArraySorter(Comparator<Description> comparator) {
        super(comparator);
        // TODO Auto-generated constructor stub
    }
    
    @Override

    public int compare(Description o1, Description o2) {

        System.out.println("Comparing" + o1 + " and " + o2);

        return super.compare(o1, o2);

    }





    public void apply(Object runner) {

        super.apply((Runner)runner);

    }

    public static class MethodNameComparator implements Comparator<Description> {

        public int compare(Description o1, Description o2) {

            return o1.getDisplayName().compareTo(o2.getDisplayName());

        }

    }

}
