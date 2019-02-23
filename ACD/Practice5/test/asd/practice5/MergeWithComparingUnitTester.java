package asd.practice5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MergeWithComparingUnitTester extends SortStrategyUnitTester {
    @BeforeClass
    public static void setSortStrategy(){
        mySorter.setCurrentSortStrategy(new MergeWithComparing());
    }

    @Test
    @Override
    public void testSortAscNoComparator() {
        mySorter.sortAsc(testDataCopy);
        Assert.assertTrue(isSortedAsc(testDataCopy));

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
