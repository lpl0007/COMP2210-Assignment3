import java.util.Arrays;
import java.util.Comparator;

/**
 * Binary search.
 */
public class BinarySearch {

    /**
     * Returns the index of the first key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if((a == null) || (key == null) || (comparator == null)) {throw new NullPointerException();}
      Key[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b, comparator);
      int start = 0;
      int middle = 0;
      int end = b.length-1;
      boolean notMatch = false;
      while(start <= end) {
          middle = (start + end) / 2;
          if(comparator.compare(b[middle],key) < 0) {
            start = middle + 1;
          }
          else if(comparator.compare(b[middle],key) > 0) {
            end = middle - 1;
          }
          else {
            while(!notMatch) {
               if(middle - 1 < 0) {
                  break;
               }
               if(comparator.compare(b[middle - 1],key) == 0) {
                  middle--;
               }
               else {
                  notMatch = true;
               }
            }
            break;
          }
      }
      return middle;
    }

    /**
     * Returns the index of the last key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if((a == null) || (key == null) || (comparator == null)) {throw new NullPointerException();}
      Key[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b, comparator);
      int start = 0;
      int middle = 0;
      int end = b.length-1;
      boolean notMatch = false;
      while(start <= end) {
          middle = (start + end) / 2;
          if(comparator.compare(b[middle],key) < 0) {
            start = middle + 1;
          }
          else if(comparator.compare(b[middle],key) > 0) {
            end = middle - 1;
          }
          else {
            while(!notMatch) {
               if(middle + 1 > b.length - 1) {
                  break;
               }
               if(comparator.compare(b[middle + 1],key) == 0) {
                  middle++;
               }
               else {
                  notMatch = true;
               }
            }
            break;
          }
      }
      return middle;
    }
}