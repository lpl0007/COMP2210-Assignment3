# COMP 2210: Assignment 3

## Problem Description
You must develop the components of an autocomplete application. To keep things simple, we will assume that our autocomplete application will work in the context of something like a search engine. Autocomplete will take in a string (we’ll call it a prefix) and will output a list of likely completions (we’ll call each a query). So, a user could type a portion of a query and autocomplete would offer a list of predictions of the completed query that the user intends to complete. The strings can contain any Unicode character except newline.

Our autocomplete application can only work in one context at a time. For example, if we want to let users search for movie titles, we would have to load needed movie title data first. Once loaded, autocomplete can predict possible full movie titles based on a given prefix. Likewise, if we want to provide word completion similar to messaging apps, our autocomplete application would have to load needed word data first. Once loaded, autocomplete can predict possible whole words based on a given prefix.

The data that the autocomplete application needs will be a set of (query, weight) pairs that represent all possible completions. Each query will be a complete search query (like a complete movie title) that a user might want to search for. Each weight will be a non-negative integer that is a distinguishing attribute of the query that will be used for the purposes of ranking queries: The larger the weight, the more “likely” the query. For example, in a word-based autocomplete for a messaging app the individual queries would be words, and weights would be the frequency of occurrence; thus making more frequently used words the more likely predictions of autocomplete.

Each line consists of a word (query) and an integer (weight). The integer records the total number of occurrences of the associated word in some large corpus of English text. Note the data is arranged in descending order of weight. This data shows that “the” is the most frequently occurring English word, appearing over 23 billion times in the corpus from which the data was drawn. So, if “t” is the prefix, the autocomplete should return “the”, “to”, and “that” - in that order - as the first three predicted completions.

## Grade
100/100
