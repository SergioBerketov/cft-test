package cft.test.task;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        TypeSortWriter typeSorter = new TypeSortWriter();
        OptionsDistributor distributor = new OptionsDistributor();
        StatisticsCollector stater = new StatisticsCollector();
        Rewriter fileRewriter = new Rewriter();

        distributor.sortWithOptions(args, typeSorter, stater, fileRewriter);

    }
}
