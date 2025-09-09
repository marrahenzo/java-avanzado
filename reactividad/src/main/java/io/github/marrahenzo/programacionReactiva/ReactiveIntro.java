package io.github.marrahenzo.programacionReactiva;

import io.reactivex.rxjava3.core.Observable;

public class ReactiveIntro {
    public static void main(String[] args) {
        Observable<String> courseStream = Observable.just("HTML", "CSS", "JavaScript", "React", "Node.js");

        courseStream.subscribe(
                course -> System.out.println("Subscribing to: " + course),
                error -> System.out.println("Error: " + error),
                () -> System.out.println("Completed"));
    }
}
