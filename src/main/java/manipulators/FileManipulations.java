package manipulators;

import java.io.IOException;

public interface FileManipulations {

    void execute(String origin, String target) throws IOException;

    final String originPathName = "C:\\temp\\";
    final String targetPathName = "C:\\temp\\";

}
