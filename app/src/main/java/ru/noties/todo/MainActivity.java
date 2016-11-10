package ru.noties.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

@Todo
public class MainActivity extends AppCompatActivity {

    @Todo(value = "this field must be removed", blocker = true)
    private int mSomeInt;

    @Override
    protected void onCreate(@Todo("Check this one") Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @Todo("Do we need this property here? It seems to be unused")
        final String someText = "hello, todo!";

    }
}
