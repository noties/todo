package ru.noties.todo;

import javax.lang.model.element.Element;

class TodoItem {

    String message;
    boolean blocker;
    Element element;

    public TodoItem(String message, boolean blocker, Element element) {
        this.message = message;
        this.blocker = blocker;
        this.element = element;
    }
}
