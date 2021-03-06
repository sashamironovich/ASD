package asd.practice5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BasicSortStrategyUnitTester.class,

		BubbleSortStrategyUnitTester.class,
		CombSortStrategyUnitTester.class,
		HeapSortStrategyUnitTester.class,
		InsertionSortStrategyUnitTester.class,
		MergeSortStrategyUnitTester.class,
		QuickSortStrategyUnitTester.class,
		SelectionSortStrategyUnitTester.class,
		ShellSortStrategyUnitTester.class,
		MergeInsertionSortStrategyUnitTester.class,
		MergeSortStrategyUnitTester.class,
		MergeWithComparingUnitTester.class,
		Quick3wayBarsStrategyUnitTester.class,
		Quick3WayInsertStrategyUnitTester.class,
		QuickInsertSortStrategyUnitTester.class
			})
public class AllUnitTests {

}
