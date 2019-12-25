package com.Shikhov.SortingTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import com.Shikhov.SortingTool.printer.*;
import static com.Shikhov.SortingTool.StaticMethods.*;

enum DataType {
    LONG,
    LINE,
    WORD
}

enum SortingType {
    NATURAL,
    BYCOUNT
}

enum IOType {
    FILE,
    STDIO
}

public class SortingTool {
    public static void main(String[] args) {
        SortingTool tool = new SortingTool();
        tool.processCliArgs(args);
        ArrayList<String> data = tool.getStringInputData();
        tool.processData(data);
    }

    private DataType dataType;
    private SortingType sortingType;
    private IOType outputType;
    private IOType inputType;
    private final File outputFile = null;
    private File inputFile;
    private Printer printer;

    public SortingTool() {
        this.dataType = DataType.WORD;
        this.sortingType = SortingType.NATURAL;
        this.inputType = IOType.STDIO;
        this.outputType = IOType.STDIO;
        this.inputFile = null;
    }

    public void setPrinter(File outputFile){
        if (!Objects.equals(null, outputFile) && outputFile.isFile()){
            printer = new FilePrinter(new StandardPrinter(), outputFile);
        } else {
            printer = new StandardPrinter();
        }
    }

    public void setPrinter(){
        setPrinter(null);
    }

    void processCliArgs(String[] cliArgs) {
        List<String> cliArgList = Arrays.asList(cliArgs);
        this.setOutputType(getOutputFileFromCli(cliArgList));
        this.setSortingType(getSortingTypeFromCli(cliArgList));
        this.setInputSource(getInputFileFromCli(cliArgList));
        this.setDataType(getDataTypeFromCli(cliArgList));
        printWrongCliArgs(cliArgs);
    }

    void processData(ArrayList<String> data) {
        switch (dataType){
            case LINE:
                if (sortingType == SortingType.BYCOUNT){
                    HashMap<String, Integer> map = createCounter(data);
                    LinkedHashMap<String, Integer> sortedMap = sortHashMapByKey(map);
                    printer.printLineCounterStats(sortedMap);
                } else {
                    Collections.sort(data);
                    printer.printSortedLineStats(data);
                }
                break;
            case LONG:
                ArrayList<Long> numberList = convertStringListToLongList(data);
                if (sortingType == SortingType.BYCOUNT){
                    HashMap<Long, Integer> map = createCounter(numberList);
                    LinkedHashMap<Long, Integer> sortedMap = sortHashMapByKey(map);
                    printer.printNumberCounterStats(sortedMap);
                } else {
                    Collections.sort(numberList);
                    printer.printSortedNumberStats(numberList);
                }
                break;
            case WORD:
            default:
                if (sortingType == SortingType.BYCOUNT){
                    HashMap<String, Integer> map = createCounter(data);
                    LinkedHashMap<String, Integer> sortedMap = sortHashMapByKey(map);
                    printer.printWordCounterStats(sortedMap);
                } else {
                    Collections.sort(data);
                    printer.printSortedWordStats(data);
                }
                break;
        }
    }

    void setDataType(DataType cliDataType){
        dataType = Objects.requireNonNullElse(cliDataType, DataType.WORD);
        System.out.println("Set the data type to " + dataType.name());
    }

    void setInputSource(File cliInputFile){
        if (cliInputFile != null) {
            inputFile = cliInputFile;
            inputType = IOType.FILE;
        } else {
            inputType = IOType.STDIO;
        }
    }

    void setSortingType(SortingType cliSortingType){
        sortingType = Objects.requireNonNullElse(cliSortingType, SortingType.NATURAL);
        System.out.println("Set the sorting type to " + sortingType.name());
    }

    void setOutputType(File outputFile){
        if (outputFile == null){
            outputType = IOType.STDIO;
            setPrinter();
        } else {
            try {
                if (outputFile.createNewFile()) {
                    System.out.println("A new output file is created at " + outputFile.getAbsolutePath());
                } else {
                    System.out.println("Using the already created output file: " + outputFile.getAbsolutePath());
                }
                setPrinter(outputFile);
            } catch (IOException e){
                System.out.println("Something went wrong when creating the output file...");
            }
            outputType = IOType.FILE;
        }
    }

    ArrayList<String> getStringInputData(){
        if (inputType == IOType.FILE) {
            return getDataFromFile(inputFile);
        }
        return getDataFromStdin();
    }

    ArrayList<String> getDataFromStdin(){
        return scanData(new Scanner(System.in));
    }

    ArrayList<String> getDataFromFile(File inputFile){
        try (Scanner scanner = new Scanner(inputFile)) {
            return scanData(scanner);
        } catch (FileNotFoundException e){
            System.out.println("No input file found.");
            return null;
        }
    }

    ArrayList<String> scanData(Scanner scanner){
        ArrayList<String> data = new ArrayList<>();
        switch (dataType){
            case LINE:
                while (scanner.hasNextLine()){
                    data.add(scanner.nextLine());
                }
                break;
            case WORD:
            case LONG:
                while (scanner.hasNext()){
                    data.add(scanner.next());
                }
                break;
        }
        return data;
    }
}