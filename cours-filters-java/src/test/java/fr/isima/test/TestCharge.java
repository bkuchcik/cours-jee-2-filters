package fr.isima.test;

import com.github.kittinunf.fuel.Fuel;

import java.text.DateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class TestCharge {

    public static void main(String[] args) {
        final int nombreAppel = 10000;
        final List<Runnable> tasks = new ArrayList<>();
        final Instant start = Instant.now();

        IntStream.range(0, nombreAppel).forEach((range) -> tasks.add(createCallHi(range)));

        tasks.parallelStream().forEach(Runnable::run);

        System.err.println("Finished in " + Duration.between(start, Instant.now()).getSeconds() + " seconds");
    }

    private static Runnable createCallHi(int range) {
        return () -> {
            try {
                Fuel.get("http://localhost:8080/cours-jee-2-fr.isima.filters/welcome/hi?nick=loadTest").responseString();
            } catch (Exception networkError) {
                networkError.printStackTrace();
            }
        };
    }
}
