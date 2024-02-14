package cft.test.task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TypeSortWriter {

    private String anotherPathForWrite;
    private String prefix;

    private int intCount;
    private int floatsCount;
    private int strCount;

    private String inFileName;
    private String intFileName;
    private String floatFileName;
    private String strFileName;

    private List<String> allIntForWrite = new ArrayList<>();
    private List<String> allFloForWrite = new ArrayList<>();
    private List<String> allStrForWrite = new ArrayList<>();

    private List<Long> allIntegers = new ArrayList<>();
    private List<Double> allFloats = new ArrayList<>();
    private List<String> allStrings = new ArrayList<>();
    private List<String> arrForSortTextData = new ArrayList<>();

    public void sort(String argsArgument) throws IOException {

        inFileName = argsArgument;

        if (argsArgument.contains("txt")) {
            String buf;

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(argsArgument))) {
                while ((buf = bufferedReader.readLine()) != null) {
                    if (!arrForSortTextData.contains(buf)) {
                        arrForSortTextData.add(buf);
                    }
                }
            }

            intFileName = "./integers.txt";
            floatFileName = "./floats.txt";
            strFileName = "./strings.txt";

            if (anotherPathForWrite != null && prefix != null) {
                intFileName = anotherPathForWrite + "/" + prefix + "integers.txt";
                floatFileName = anotherPathForWrite + "/" + prefix + "floats.txt";
                strFileName = anotherPathForWrite + "/" + prefix + "strings.txt";

            } else if (prefix != null) {
                intFileName = ("./" + prefix + "integers.txt");
                floatFileName = ("./" + prefix + "floats.txt");
                strFileName = ("./" + prefix + "strings.txt");

            } else if (anotherPathForWrite != null) {
                intFileName = anotherPathForWrite + "/integers.txt";
                floatFileName = anotherPathForWrite + "/floats.txt";
                strFileName = anotherPathForWrite + "/strings.txt";
            }

            for (String txt : arrForSortTextData) {

                if (isLong(txt)) {
                    if (!allIntForWrite.contains(txt)) {
                        allIntForWrite.add(txt);
                    }
                    if (!allIntegers.contains(Long.parseLong(txt))) {
                        intCount++;
                        allIntegers.add(Long.parseLong(txt));
                    }

                } else if (isDouble(txt)) {
                    if (!allFloForWrite.contains(txt)) {
                        allFloForWrite.add(txt);
                    }
                    if (!allFloats.contains(Double.parseDouble(txt))) {
                        floatsCount++;
                        allFloats.add(Double.parseDouble(txt));
                    }

                } else {
                    if (!allStrForWrite.contains(txt)) {
                        allStrForWrite.add(txt);
                    }
                    if (!allStrings.contains(txt)) {
                        strCount++;
                        allStrings.add(txt);
                    }
                }
            }
        }
    }

    public void write() {

        if (!allIntForWrite.isEmpty()) {
            try (BufferedWriter integerWriter =
                         new BufferedWriter(new FileWriter((intFileName), false))) {
                for (String i : allIntForWrite) {
                    integerWriter.write(i);
                    integerWriter.newLine();
                    integerWriter.flush();
                }
            } catch (IOException e) {
                System.out.println("Не удалось записать данные типа Integer в " + intFileName);
            }
        }

        if (!allFloForWrite.isEmpty()) {
            try (BufferedWriter floatWriter =
                         new BufferedWriter(new FileWriter((floatFileName), false));) {
                for (String f : allFloForWrite) {
                    floatWriter.write(f);
                    floatWriter.newLine();
                    floatWriter.flush();
                }
            } catch (IOException e) {
                System.out.println("Не удалось записать данные типа Float в " + floatFileName);
            }
        }

        try (BufferedWriter stringWriter =
                     new BufferedWriter(new FileWriter((strFileName), false))) {
            for (String s : allStrForWrite) {
                stringWriter.write(s);
                stringWriter.newLine();
                stringWriter.flush();
            }
        } catch (IOException e) {
            System.out.println("Не удалось записать данные типа String в " + strFileName);
        }
    }

    public void setAnotherPath(String userPathForWrite) {
        this.anotherPathForWrite = userPathForWrite;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void rewriteData(Rewriter fileRewriter) {
        List<String> userText = fileRewriter.getUserTextArr();
        arrForSortTextData.addAll(userText);
    }

    public static boolean isLong(String s) throws NumberFormatException {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getIntCount() {
        return intCount;
    }

    public int getFloatsCount() {
        return floatsCount;
    }

    public int getStrCount() {
        return strCount;
    }

    public String getIntFileName() {
        return intFileName;
    }

    public String getFloatFileName() {
        return floatFileName;
    }

    public String getStrFileName() {
        return strFileName;
    }

    public List<Long> getAllIntegers() {
        return allIntegers;
    }

    public List<Double> getAllFloats() {
        return allFloats;
    }

    public List<String> getAllStrings() {
        return allStrings;
    }
}
