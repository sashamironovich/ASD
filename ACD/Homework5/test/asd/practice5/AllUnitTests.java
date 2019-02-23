package asd.practice5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		BubbleSortStrategyUnitTester.class,
		CombSortStrategyUnitTester.class,
		HeapSortStrategyUnitTester.class,
		InsertionSortStrategyUnitTester.class,
		MergeSortStrategyUnitTester.class,
		QuickSortStrategyUnitTester.class,
		SelectionSortStrategyUnitTester.class,
		ShellSortStrategyUnitTester.class,
		MergeInsertionSortStrategyUnitTester.class,

		MergeWithComparingUnitTester.class,
		Quick3wayBarsStrategyUnitTester.class,
		Quick3WayInsertStrategyUnitTester.class,
		QuickInsertSortStrategyUnitTester.class,
		MergeWithInsertAndComparingUnitTester.class
			})
public class AllUnitTests {

}
