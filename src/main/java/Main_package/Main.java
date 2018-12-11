package Main_package;

import picocli.CommandLine;

public class Main {

    public static void main(String[] args) {
        CommandLine.run(new PicoTerm(), args);
    }

}
