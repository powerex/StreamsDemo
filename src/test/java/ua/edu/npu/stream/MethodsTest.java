package ua.edu.npu.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class MethodsTest {

    private Collection<String> collection;

    @Before
    public void init() {
        collection = Arrays.asList("a1", "a2", "a3", "a1");
    }

    @Test
    public void shouldReturnTwoWhenFilterCount() {
        long count = collection.stream().filter("a1"::equals).count();
        assertEquals("Elements must be 2" ,2, count);
    }

    @Test
    public void shouldReturnFirstOrEmptyWhenEmpty() {
        final String s = collection.stream().findFirst().orElse("0");
        assertEquals("Must be a1", "a1", s);
    }

    @Test
    public void shouldReturnLastOrEmptyWhenEmpty() {
        final String s = collection.stream().skip(collection.size()-1).findAny().orElse("Empty");
        assertEquals("Must be a1", "a1", s);
    }

    @Test
    public void shouldReturnFoundedElement() {
        final String s = collection.stream().filter("a3"::equals).findFirst().get();
        assertEquals("Must be a3", "a3", s);
    }

    @Test
    public void shouldReturnThirdElement() {
        final String s = collection.stream().skip(2).findFirst().get();
        assertEquals("Must be a3", "a3", s);
    }

    @Test
    public void shouldReturnTwolementAfterSecond() {
        final Object[] objects = collection.stream().skip(1).limit(2).toArray();
        Object[] expected = {"a2", "a3"};
        assertEquals("Must be [a2, a3]", expected, objects);
    }

    @Test
    public void shouldReturnCollectionsSameElements() {
        final Collection<String> coll = collection.stream()
                .filter((s) -> s.contains("1"))
                .collect(Collectors.toList());
        Collection<String> expected = Arrays.asList("a1", "a1");
        assertEquals(expected, coll);
    }

    @Test
    public void shouldReturnTrueWhenAnyMatch() {
        final boolean b = collection.stream().anyMatch("a1"::equals);
        assertTrue("Must be true", b);
    }

    @Test
    public void shouldReturnFalseWhenAnyMatch() {
        final boolean b = collection.stream().anyMatch("a8"::equals);
        assertFalse("Must be false", b);
    }

    @Test
    public void shouldReturnFalseWhenAllContains() {
        final boolean b = collection.stream().allMatch((s) -> s.contains("1"));
        assertFalse("Must be false" , b);
    }

    @Test
    public void shouldReturnTrueWhenNoneMatch() {
        final boolean b = collection.stream().noneMatch("a7"::equals);
        assertTrue("Must be true", b);
    }

    @Test
    public void shouldReturnSummOddNumbers() {
        final Integer collect = Arrays.asList(1, 2, 3, 4)
                .stream()
                .collect(Collectors.summingInt(((p) -> p % 2 == 1 ? p : 0)));
        assertEquals("Sum 1 + 3 = 4", java.util.Optional.ofNullable(collect), 4);
    }

    @Test
    public void shouldReturnAverageReducedByOne() {
        final Double collect = Arrays.asList(1, 2, 3, 4)
                .stream()
                .collect(Collectors.averagingInt((p) -> p - 1));
        assertEquals("Average 1.5", collect, 1.5, 1e-4);
    }

    @Test
    public void shouldReturnStatisticIncreasedByThree() {
        final IntSummaryStatistics collect = Arrays.asList(1, 2, 3, 4)
                .stream()
                .collect(Collectors.summarizingInt((p) -> p + 3));
        final String expected = "IntSummaryStatistics{count=4, sum=22, min=4, average=5,500000, max=7}";
        assertTrue(expected.equals(collect.toString()));
    }



}
