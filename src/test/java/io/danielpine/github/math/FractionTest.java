package io.danielpine.github.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class FractionTest {

    @Test
    public void testFindMinalFrom() {
	List<Integer> list = Arrays.asList(10, 1, 2, 3, 1, 1, 4, 5, 6, 7, 8, 9, 10);
	List<Integer> reduce = minimumSubListBy(list, (a, b) -> a - b);
	System.out.println(reduce);
    }

    public static <T extends Comparable<T>> List<T> minimumSubListBy(List<T> list,
	    Comparator<T> comparator) {
	return list.parallelStream()
		.reduce(new ArrayList<T>(),
			(minums, node) -> {
			    if (minums.isEmpty()) {
				minums.add(node);
				return minums;
			    } else if (comparator.compare(node, minums.get(0)) < 0) {
				return Lists.newArrayList(node);
			    } else if (comparator.compare(node, minums.get(0)) == 0) {
				minums.add(node);
				return minums;
			    } else {
				return minums;
			    }
			},
			(p, b) -> {
			    if (comparator.compare(p.get(0), b.get(0)) < 0) {
				return p;
			    } else if (comparator.compare(p.get(0), b.get(0)) == 0) {
				p.addAll(b);
				return p;
			    } else {
				return b;
			    }
			});
    }

    @Test
    public void test() {
	List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	Fraction process = Fraction.of(0);
	for (Integer integer : list) {
	    process = process.add(Fraction.of(1, list.size()));
	    System.out.println(process);
	}
    }
}
