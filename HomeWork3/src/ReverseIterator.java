import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ReverseIterator<T> implements Iterator<T> {


    private List<T> list;
    private int index;

    public ReverseIterator(List<T> list) {
        this.list = list;
        this.index = list.size()-1;
    }



    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return list.get(index--);
        } else {
            throw new NoSuchElementException();
        }
    }
}