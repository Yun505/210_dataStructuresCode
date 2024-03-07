/*
 * Copyright 2023 Marc Liberatore.
 */

package comparators;

import java.util.Comparator;

/**
 * A comparator to determine which of two WebPageRecords represents a longer web
 * page. The page with the larger `length` attribute is comes before the other.
 * If there is a tie, break it using the length of the first line -- again,
 * larger comes first.
 * If there is still a tie, break it by comparing which URL comes
 * lexicographically first.
 * Any remaining ties mean the two WebPageRecords should be considered equal.
 */
public class LargestPageComparator implements Comparator<WebPageRecord> {
    @Override
    public int compare(WebPageRecord x, WebPageRecord y) {
        String urlX = x.URL;
        String urlY = y.URL;
        
        int lenComparison = Integer.compare(y.length, x.length);
        if (lenComparison != 0) {
            return lenComparison;
        }

        // if equal
        int first_lineComp = y.firstLine.compareTo(x.firstLine);
        if (first_lineComp != 0){
            return first_lineComp;
        }


        return urlX.compareTo(urlY);
        
    }
}
