import manipulators.FileManipulations;
import manipulators.FileReverse;
import manipulators.FileShuffle;
import manipulators.FileSort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class driver {
    private static final List<FileManipulations> allManipulators = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("You must supply 3 parameters to this application! quitting...");
            System.exit(1);
        } else {
            initFileManipulators();
            System.out.println("Welcome to File Manipulator!");
            FileManipulations manipulator =
                    allManipulators
                    .stream()
                    .filter(e -> e.getClass()
                            .getName()
                            .toLowerCase()
                            .contains(args[2].toLowerCase()))
                    .findAny().orElse(null);
            try {
                manipulator.execute(args[0], args[1]);
                System.out.println("Please check out output in file " + args[1]);
            } catch (IOException e) {
                System.err.println("Error Occurred: " + e.getMessage());
                System.exit(-1);
            } catch (NullPointerException e) {
                System.err.println("Could not find action to perform. Please check your input.");
                System.exit(1);
            }
        }
    }

    private static void initFileManipulators() {
        allManipulators.add(new FileSort());
        allManipulators.add(new FileReverse());
        allManipulators.add(new FileShuffle());
        /* Add any new manipulators here */
    }

}
