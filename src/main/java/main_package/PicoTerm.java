package main_package;

import id.PolishID;

import static picocli.CommandLine.*;

@Command(name = "ID", mixinStandardHelpOptions = true, version = ("ID checker" + " v1.0"))
public class PicoTerm implements Runnable {

    @Parameters(arity = "1..*", paramLabel = "ID", description = "type ID number to check")
    private String[] ids;

    public void run() {
        for (String id : ids) {
            PolishID polishID = new PolishID(id);
            if (polishID.validate(id))
                System.out.println(id + " is correct Polish ID card number.");
            else
                System.out.println(id + " is incorrect Polish ID card number. Try again.");
        }
    }


}
