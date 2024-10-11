import java.util.Arrays;


/**
 * Autocomplete.
 */
public class Autocomplete {
   private static Term[] termsList = new Term[0];

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
	public Autocomplete(Term[] terms) {
      if(terms == null) {throw new NullPointerException();}
      termsList = Arrays.copyOf(terms, terms.length);
   }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
	public Term[] allMatches(String prefix) {
      if(prefix == null) {throw new NullPointerException();}
      Arrays.sort(termsList,Term.byPrefixOrder(prefix.length()));
      int first = BinarySearch.<Term>firstIndexOf(termsList, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
      int last = BinarySearch.<Term>lastIndexOf(termsList, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
      Term[] terms2 = Arrays.copyOfRange(termsList,first,last+1);
      Arrays.sort(terms2, Term.byDescendingWeightOrder());
      return terms2;
   }
}