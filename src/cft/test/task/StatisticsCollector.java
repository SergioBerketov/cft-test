package cft.test.task;
import java.util.*;

public class StatisticsCollector {
    private int intCount;
    private int floatsCount;
    private int strCount;

    private String intFileName;
    private String floatFileName;
    private String strFileName;

    private List<Long> allIntegers = new ArrayList<>();
    protected List<Double> allFloats = new ArrayList<>();
    private List<String> allStrings = new ArrayList<>();

    private Map<String, Integer> shortStatList = new HashMap<>();

    public void printSimpleStat(TypeSortWriter typeSorter) {
        intCount = typeSorter.getIntCount();
        floatsCount = typeSorter.getFloatsCount();
        strCount = typeSorter.getStrCount();

        intFileName = typeSorter.getIntFileName();
        floatFileName = typeSorter.getFloatFileName();
        strFileName = typeSorter.getStrFileName();

        if (intCount != 0)
            shortStatList.put(intFileName, intCount);
        if (floatsCount != 0)
            shortStatList.put(floatFileName, floatsCount);
        if (strCount != 0)
            shortStatList.put(strFileName, strCount);

        System.out.println();
        for (Map.Entry<String, Integer> entry : shortStatList.entrySet()) {
            System.out.println("Количество элементов в файле: " + entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();
    }

    public void generateFullStat(TypeSortWriter typeSorter) {
        allIntegers = typeSorter.getAllIntegers();
        allFloats = typeSorter.getAllFloats();
        allStrings = typeSorter.getAllStrings();

        intFileName = typeSorter.getIntFileName();
        floatFileName = typeSorter.getFloatFileName();
        strFileName = typeSorter.getStrFileName();
    }

    public void minMaxNumbers() {
        if (!allIntegers.isEmpty()) {
            Long maxInt = Collections.max(allIntegers);
            System.out.println("Максимальное значение в файле " + intFileName + " = " + maxInt);
            Long minInt = Collections.min(allIntegers);
            System.out.println("Минимальное значение в файле " + intFileName + " = " + minInt);
        }

        System.out.println();

        if (!allFloats.isEmpty()) {
            Double maxDouble = Collections.max(allFloats);
            System.out.println("Максимальное значение в файле " + floatFileName + " = " + maxDouble);
            Double minDouble = Collections.min(allFloats);
            System.out.println("Минимальное значение в файле " + floatFileName + " = " + minDouble);
        }
        System.out.println();
    }

    public void sum() {
        if (!allIntegers.isEmpty()) {
            long[] integersSum = new long[]{allIntegers.stream()
                    .mapToLong(Long::longValue)
                    .sum()};
            System.out.println("Сумма элементов в файле " + intFileName
                    + " = " + Arrays.toString(integersSum).replaceAll("^\\[|\\]$", ""));
        }
        if (!allFloats.isEmpty()) {
            double[] doubleSum = new double[]{allFloats.stream()
                    .mapToDouble(Double::doubleValue)
                    .sum()};
            System.out.println("Сумма элементов в файле " + floatFileName
                    + " = " + Arrays.toString(doubleSum).replaceAll("^\\[|\\]$", ""));
            System.out.println();
        }
    }

    public void average() {
        if (!allIntegers.isEmpty()) {
            long sum1 = 0;
            for (long x : allIntegers) {
                sum1 += x;
            }
            System.out.println("Cреднее арифметическое чисел в файле " + intFileName + " = " + sum1 / allIntegers.size());
        }
        if (!allFloats.isEmpty()) {
            double sum2 = 0;
            for (double x : allFloats) {
                sum2 += x;
            }
            System.out.println("Cреднее арифметическое чисел в файле " + floatFileName + " = " + sum2 / allFloats.size());
            System.out.println();
        }
    }

    public void minAndMaxString() {
        if (!allIntegers.isEmpty()) {
            String min = allStrings.stream().min(Comparator.comparingInt(String::length)).get();
            System.out.println("Самая короткая строка в файле " + strFileName + ": " + min);
        }
        if (!allFloats.isEmpty()) {
            String max = allStrings.stream().max(Comparator.comparingInt(String::length)).get();
            System.out.println("Самая длинная строка в файле " + strFileName + ": " + max);
        }
    }
}
