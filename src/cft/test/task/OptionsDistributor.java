package cft.test.task;
import java.io.*;

public class OptionsDistributor {

    public void sortWithOptions(String[] argsData, TypeSortWriter typeSorter, StatisticsCollector stater, Rewriter rewriter) throws IOException {

        String pathToFile;
        String userPathForWrite;
        String prefix;

        if (argsData.length == 0) {
            System.out.println("Введите параметры обработки данных. Далее, укажите название текстового файла/файлов.");
        } else {

            for (int i = 0; i < argsData.length; i++) {

                switch (argsData[i]) {
                    case ("-o") -> {
                        userPathForWrite = (argsData[i + 1]);
                        typeSorter.setAnotherPath(userPathForWrite);
                    }

                    case ("-p") -> {
                        prefix = (argsData[i + 1]);
                        typeSorter.setPrefix(prefix);
                    }

                    case ("-a") -> {
                        rewriter.dataForRewrite();
                        typeSorter.rewriteData(rewriter);
                    }

                    case ("in1.txt") -> {
                        pathToFile = new File("in1.txt").getAbsolutePath();
                        typeSorter.sort(pathToFile);
                        typeSorter.write();
                    }
                    case ("in2.txt") -> {
                        pathToFile = new File("in2.txt").getAbsolutePath();
                        typeSorter.sort(pathToFile);
                        typeSorter.write();
                    }
                }
            }
        }
        for (String s : argsData)
            if (s.equals("-s")) {
                stater.printSimpleStat(typeSorter);

            } else if (s.equals("-f")) {
                stater.printSimpleStat(typeSorter);
                stater.generateFullStat(typeSorter);
                stater.minMaxNumbers();
                stater.sum();
                stater.average();
                stater.minAndMaxString();
            }
    }
}



