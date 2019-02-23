package asd.practice5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Quick3wayBarsStrategyUnitTester extends SortStrategyUnitTester {
    @BeforeClass
    public static void setCurrentStrategy(){
        mySorter.setCurrentSortStrategy(new Quick3wayBarsStrategy());
    }

    @Test
    @Override
    public void testSortAscNoComparator() {
        mySorter.sortAsc(testDataCopy);
        Assert.assertTrue(isSortedAsc(testDataCopy));

    }
    @Test

    @Override
    public  void testSortDescNoComparator() {
        mySorter.sortDesc(testDataCopy);
        Assert.assertTrue(isSortedDesc(testDataCopy));

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
