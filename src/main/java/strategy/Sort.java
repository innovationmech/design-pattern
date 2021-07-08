package strategy;

public class Sort implements ISort
{
    private ISort sort;

    Sort(ISort sort) {
        this.sort = sort;
    }

    Sort(SortStrategy strategy) {
        setStrategy(strategy);
    }

    @Override
    public void sort(int[] arr)
    {
        sort.sort(arr);
    }

    public void setSort(ISort sort) {
        this.sort = sort;
    }

    public void setStrategy(SortStrategy strategy) {
        switch (strategy) {
            case BUBBLE_SORT:
                sort = new BubbleSort();
                break;
            case SELECTION_SORT:
                sort = new SelectionSort();
                break;
            case INSERT_SORT:
                sort = new InsertSort();
                break;
            default:
                throw new IllegalArgumentException("There's no such strategy yet.");
        }
    }
}
