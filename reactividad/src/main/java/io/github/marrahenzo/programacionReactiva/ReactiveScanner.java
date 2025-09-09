package io.github.marrahenzo.programacionReactiva;

import java.util.Scanner;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class ReactiveScanner {
    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();

        subject.subscribe(course -> System.out.println("Subscribing to: " + course),
                error -> System.out.println("Error: " + error),
                () -> System.out.println("Completed"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a course: ");
            String course = scanner.nextLine();
            if (course.equals("exit")) {
                subject.onComplete();
                break;
            }
            subject.onNext(course);
        }
    }
}
