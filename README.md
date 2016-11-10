# TODO


A simple tool to put **todos** to a Java code with ability to cancel build if **todo** is unresolved

[![Maven Central](https://img.shields.io/maven-central/v/ru.noties.todo/processor.svg)](http://search.maven.org/#search|ga|1|g%3A%22ru.noties.todo%22%20AND%20a%3A%22processor%22) [![Maven Central](https://img.shields.io/maven-central/v/ru.noties.todo/annotations.svg)](http://search.maven.org/#search|ga|1|g%3A%22ru.noties.todo%22%20AND%20a%3A%22annotations%22)

```gradle
compile 'ru.noties.todo:annotations:X.X.X'
apt 'ru.noties.todo:processor:X.X.X'
```

```java
public @interface Todo {
    String value() default "";
    boolean blocker() default false;
}
```

If Todo marked as `blocker`, then the build will be cancelled.

## License

```
  Copyright 2016 Dimitry Ivanov (mail@dimitryivanov.ru)

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
```