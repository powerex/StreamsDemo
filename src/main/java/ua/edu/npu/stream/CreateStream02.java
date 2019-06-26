package ua.edu.npu.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream02 {

    static {
        File file = new File("file.txt");
        file.deleteOnExit();
        PrintWriter out = null;
        try {
            out = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println("a1");
        out.println("a2");
        out.println("a3");
        out.close();
    }

    public static void main(String[] args) {

        //Stream from collection
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");

        //Stream from values
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        System.out.println("streamFromValues = " + streamFromValues.collect(Collectors.toList()));

        //Stream from array
        String[] array = {"a1","a2","a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);
        System.out.println("streamFromArrays = " + streamFromArrays.collect(Collectors.toList()));

        //Stream from file
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"));
            System.out.println("streamFromFiles = " + streamFromFiles.collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Stream chars from String
        IntStream streamFromString = "123".chars();
        streamFromString.forEach((e)->System.out.print(e + " , "));
        System.out.println();

        //Stream using StreamBuilder
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> streamFromBuilder = builder.add("a1").add("a2").add("a3").build();
        System.out.println("streamFromBuilder = " + streamFromBuilder.collect((Collectors.toList())));

        //Create parallel stream
        Stream<String> parallelStream = collection.parallelStream();
        System.out.println("parallelStream = " + parallelStream.collect(Collectors.toList()));

        //Infinity stream via iterate
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1);
        System.out.println("streamFromIterate = " + streamFromIterate.limit(3).collect(Collectors.toList()));

        //Infinity stream via generate
        Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
        System.out.println("streamFromGenerate = " + streamFromGenerate.limit(3).collect(Collectors.toList()));

        //Empty stream
        Stream<String> streamEmpty = Stream.empty();
        System.out.println("streamEmpty = " + streamEmpty.collect(Collectors.toList()));
    }
}
