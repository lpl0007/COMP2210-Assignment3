import java.util.Comparator;

/**
 * Autocomplete term representing a (query, weight) pair.
 * 
 */
public class Term implements Comparable<Term> {

    private final String q;
    private final long w;
    /**
     * Initialize a term with the given query and weight.
     * This method throws a NullPointerException if query is null,
     * and an IllegalArgumentException if weight is negative.
     */
    public Term(String query, long weight) {
      if(query == null) {throw new NullPointerException();}
      if(weight < 0) {throw new IllegalArgumentException();}
      q = query;
      w = weight;
    }

    /**
     * Compares the two terms in descending order of weight.
     */
    public static Comparator<Term> byDescendingWeightOrder() {
      return new Comparator<Term>() {
         @Override
         public int compare(Term a, Term b) {
            Long aTerm = a.w;
            Long bTerm = b.w;
            return bTerm.compareTo(aTerm);
         }
      };
    }

    /**
     * Compares the two terms in ascending lexicographic order of query,
     * but using only the first length characters of query. This method
     * throws an IllegalArgumentException if length is less than or equal
     * to zero.
     */
    public static Comparator<Term> byPrefixOrder(int length) {
      if(length <= 0) {throw new IllegalArgumentException();}
      return new Comparator<Term>() {
         @Override
         public int compare(Term a, Term b) {
            String aTerm;
            String bTerm;
            if(a.q.length() >= length) {
               aTerm = a.q.substring(0,length);
            }
            else {
               aTerm = a.q;
            }
            if(b.q.length() >= length) {
               bTerm = b.q.substring(0,length);
            }
            else {
               bTerm = b.q;
            }
            return aTerm.compareTo(bTerm);
         }
      };
    }

    /**
     * Compares this term with the other term in ascending lexicographic order
     * of query.
     */
    @Override
    public int compareTo(Term other) {
      return q.compareTo(other.q);
    }

    /**
     * Returns a string representation of this term in the following format:
     * query followed by a tab followed by weight
     */
    @Override
    public String toString(){
      return q + "	" + w;
    }
}