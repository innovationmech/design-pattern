package strategy;

import java.util.Arrays;
import org.junit.Test;

public class Client
{
    @Test
    public void test() {
        int[] arr = new int[]{6, 1, 2, 3, 5, 4};
        Sort sort = new Sort(new BubbleSort());
        sort.setSort(new InsertSort());
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        int[] arr = new int[]{6, 1, 2, 3, 5, 4};
        Sort sort = new Sort(SortStrategy.BUBBLE_SORT);
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
