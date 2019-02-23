package asd.practice5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MergeWithInsertAndComparingUnitTester extends SortStrategyUnitTester {
    @BeforeClass
    public static void setSortStrategy(){
        mySorter.setCurrentSortStrategy(new MergeWithInsertAndComparing());
    }

    @Test
    @Override
    public void testSortAscNoComparator() {
        mySorter.sortAsc(testDataCopy);
        Assert.assertTrue(isSortedAsc(testDataCopy));
        System.out.println(Arrays.toString(testDataCopy));

    }

    @Test
    @Override
    public void testSortDescNoComparator() {
        mySorter.sortDesc(testDataCopy);
        assertTrue(isSortedDesc(testDataCopy));

    }

    @Ignore
    @Test
    @Override
    public void testSortAscWithComparator() {

    }

    @Ignore
    @Test
    @Override
    public void testSortDescWithComparator() {

    }
}
