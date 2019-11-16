import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        try {
            //List<String> allLines = Files.readAllLines(Paths.get(path + "/1.in"));
            List<String> allLines = Files.readAllLines(Paths.get(path + "/2.in"));
            for (String line : allLines) {
                var arg = line.split(" ");
                System.out.println(getMinBase(Integer.parseInt(arg[0]), Integer.parseInt(arg[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int getMinBase(int age, int limit) {
        int minAge = age, minBaseAge = 10;
        for (int i = 11; i < limit; i++) {
            var result = convertAgeFromBaseToBase(age, i);
            if (minAge > result) {
                minAge = result;
                minBaseAge = i;
            }
        }
        return minBaseAge;
    }

    private static Integer convertAgeFromBaseToBase(int age, int base) {
        var index = age;
        var rest = 0;
        ArrayList<Integer> results = new ArrayList<>();
        var Continue = true;
        while (Continue) {
            rest = index % base;
            index = index / base;
            results.add(rest);
            Continue = index != 0;
        }
        Collections.reverse(results);
        return Integer.parseInt(results.stream().map(Object::toString).collect(Collectors.joining("")));
    }
}
