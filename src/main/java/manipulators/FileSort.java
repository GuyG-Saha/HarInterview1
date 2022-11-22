package manipulators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSort implements FileManipulations {
    @Override
    public void execute(String origin, String target) throws IOException {
        FileReader fileReader = new FileReader(originPathName + origin);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        Collections.sort(lines, Collator.getInstance());
        FileWriter writer = new FileWriter(targetPathName + target);
        for(String str: lines) {
            writer.write(str + "\r\n");
        }
        writer.close();
    }
}
