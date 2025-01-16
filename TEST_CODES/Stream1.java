package test.codes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
        List<String>list=List.of("hello","world","im","dash");
        List<String>newList=list.stream().filter(s->s.startsWith("d")).collect(Collectors.toList());
        newList.stream().forEach(System.out::println);
        //Stream.of("abinash","amit","don","ram").filter(s->s.startsWith("a")).forEach(System.out::println);

       // Stream.of("abinash","amit","don","ram").sorted().map(s->s.toUpperCase()).forEach(System.out::println);
        // Stream.concat(list.stream(),newList.stream()).forEach(System.out::println);
        //System.out.println(newList.stream().anyMatch(s->s.contains("da")));
    List<Integer> in= Arrays.asList(1,2,3,3,3,4,5,5);
   List<Integer> list2 = in.stream().distinct().toList();
    int[] arr= list2.stream().mapToInt(Integer::intValue).toArray();
    long[] crr=list2.stream().mapToLong(Integer::longValue).toArray();
    }
}
