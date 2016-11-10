package ru.noties.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;

class TodoItemsParser {

    List<TodoItem> parse(Set<? extends Element> elements) {

        if (CollectionUtils.isEmpty(elements)) {
            return null;
        }

        final List<TodoItem> list = new ArrayList<>();

        for (Element element: elements) {
            final Todo todo = element.getAnnotation(Todo.class);
            if (todo != null) {
                list.add(new TodoItem(todo.value(), todo.blocker(), element));
            }
        }

        if (list.size() == 0) {
            return null;
        } else {
            return list;
        }
    }
}
