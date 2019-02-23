package asd.practice5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortStrategyUnitTester extends SortStrategyUnitTester {

    @BeforeClass
    public static void setCurrentStrategy(){
        mySorter.setCurrentSortStrategy(new QuickSortStrategy());
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

    
    @Test
    @Override
    public void testSortAscWithComparator() {
        mySorter.sortAsc(itemsDataCopy,Item.BY_WEIGHT);
        Assert.assertTrue(isSortedAsc(itemsDataCopy,Item.BY_WEIGHT));


    }


    @Test
    @Override
    public void testSortDescWithComparator() {
        mySorter.sortDesc(itemsDataCopy,Item.BY_WEIGHT);
        Assert.assertTrue(isSortedDesc(itemsDataCopy,Item.BY_WEIGHT));


    }
}
