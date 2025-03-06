package org.skypro.skyshop.model.interfaces;

import java.util.Comparator;

public class NameComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable obj1, Searchable obj2) {

        int size1 = obj1.getSearchableName ().length ();
        int size2 = obj2.getSearchableName ().length ();

        if ( size1 == size2 ) {
            return (obj1.getSearchableName ().compareTo ( obj2.getSearchableName () ));
        } else
            return (Integer.compare ( size1, size2 ));
    }
}
