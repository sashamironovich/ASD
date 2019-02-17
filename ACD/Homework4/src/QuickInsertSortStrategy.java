public class QuickInsertSortStrategy implements SortStrategy {
    @Override
    public String getName() {
        return "QUICK INSERT SORT";
    }

        public void quickInsert(int[] list, int start, int end)
        {
            if (start < end)
            {
                // This is where we switch to Insertion Sort!

                if ((end-start) < 9){

                    this.insertionSort(list, start, end + 1);
                }else
                {
                    int part = this.partition(list, start, end);
                    this.quickInsert(list, start, part - 1);
                    this.quickInsert(list, part + 1, end);
                }
            }
        }
        public void insertionSort(int[] list, int start, int end)
        {
            for (int x = start + 1; x < end; x++)
            {
                int val = list[x];
                int j = x - 1;
                while (j >= 0 && val < list[j])
                {
                    list[j + 1] = list[j];
                    j--;
                }
                list[j + 1] = val;
            }
        }
        private int partition(int[] list, int leftIndex, int rightIndex)
        {
            int left = leftIndex;
            int right = rightIndex;
            int pivot = list[leftIndex];
            while (left < right)
            {
                if (list[left] < pivot)
                {
                    left++;
                    continue;
                }
                if (list[right] > pivot)
                {
                    right--;
                    continue;
                }
                int tmp = list[left];
                list[left] = list[right];
                list[right] = tmp;
                left++;
            }
            return left;
        }

    @Override
    public void sort(int[] a) {
        quickInsert(a,0,a.length-1);
    }
}
