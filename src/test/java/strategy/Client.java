package strategy;

import java.util.Arrays;
import org.junit.Test;

public class Client
{
    @Test
    public void test() {
        int[] arr = new int[]{6, 1, 2, 3, 5, 4};
        SortContext sortContext = new SortContext(new BubbleSort());
        sortContext.setSort(new InsertSort());
        sortContext.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        int[] arr = new int[]{6, 1, 2, 3, 5, 4};
        SortContext sortContext = new SortContext(SortStrategy.BUBBLE_SORT);
        sortContext.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
