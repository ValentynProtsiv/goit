package TaskFour;

import java.util.stream.Stream;

@FunctionalInterface
interface RandNumber{
    Stream<Long> randomGen(long a,long c, double m);
}
class HelperClass{
    public Stream<Long> randomGen(long a,long c, long m, RandNumber randNumber){
        return randNumber.randomGen(a,c,m);
    }
}

public class TaskFour{
    public static void main(String[] args) {
        long seed = 0L;
        HelperClass helperClass = new HelperClass();
        Stream<Long> genre = helperClass.
                randomGen(25214903917L, 11, 2L << 48, new RandNumber() {
                    @Override
                    public Stream<Long> randomGen(long a, long c, double m) {
                        return Stream.iterate(seed, x -> (long) (1 * (a * x + c) % m));
                    }
                });
        genre.limit(10).forEach(System.out::println);
    }
}
