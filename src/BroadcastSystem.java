import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by ivan on 3/21/2017.
 */
public class BroadcastSystem {

    Queue<String> BSQueue = new Queue<String>() {
        @Override
        public boolean add(String s) {
            return false;
        }

        public String remove() {
            return null;
        }

        public String element() {
            return null;
        }

        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<String> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends String> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    }


}



