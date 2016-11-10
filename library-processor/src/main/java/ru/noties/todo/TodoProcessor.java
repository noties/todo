package ru.noties.todo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

public class TodoProcessor extends AbstractProcessor {

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(Todo.class.getName());
    }

    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            final TodoItemsParser parser = new TodoItemsParser();
            final List<TodoItem> items = parser.parse(roundEnv.getElementsAnnotatedWith(Todo.class));
            if (!CollectionUtils.isEmpty(items)) {
                Collections.sort(items, new BlockerComparator());
                log(Diagnostic.Kind.WARNING, null, "//TODO unresolved todos: %1$d", items.size());
                for (TodoItem item: items) {
                    final Diagnostic.Kind kind = item.blocker
                            ? Diagnostic.Kind.ERROR
                            : Diagnostic.Kind.WARNING;
                    log(kind, item.element, "//TODO %1$s", item.message);
                }
            }
        }
        return true;
    }

    private void log(Diagnostic.Kind kind, Element element, String message, Object... args) {
        if (messager != null) {
            final String out = String.format(message, args);
            if (element == null) {
                messager.printMessage(kind, out);
            } else {
                messager.printMessage(kind, out, element);
            }
        }
    }

    private static class BlockerComparator implements Comparator<TodoItem> {

        @Override
        public int compare(TodoItem o1, TodoItem o2) {
            // Android studio highlights here an error saying that we need at least KitKat...
            return Integer.compare(value(o1), value(o2));
        }

        int value(TodoItem item) {
            return item.blocker ? 1 : 0;
        }
    }
}
