package ru.noties.todo;

import java.util.Collection;

class CollectionUtils {

    static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    private CollectionUtils() {}
}
