package strategy;

public class SortContext implements ISort
{
    private ISort sort;

    SortContext(ISort sort) {
        this.sort = sort;
    }

    SortContext(SortStrategy strategy) {
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
