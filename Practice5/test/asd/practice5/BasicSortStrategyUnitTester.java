package asd.practice5;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicSortStrategyUnitTester extends SortStrategyUnitTester {
	
	@BeforeClass
	public static void setSortStrategy(){
		mySorter.setCurrentSortStrategy(new BasicSortStrategy());
	}
	
	@Override
	@Test
	public void testSortAscNoComparator() {
		mySorter.sortAsc(testDataCopy);
		assertTrue(isSortedAsc(testDataCopy));
	}

	@Override
	@Test
	public void testSortDescNoComparator() {
		mySorter.sortDesc(testDataCopy);
		assertTrue(isSortedDesc(testDataCopy));		
	}

	@Ignore
	@Override
	@Test	
	public void testSortAscWithComparator() {
		// TODO Auto-generated method stub
		
	}

	@Ignore
	@Override
	@Test
	public void testSortDescWithComparator() {
		// TODO Auto-generated method stub
		
	}
	
	
}
