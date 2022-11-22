package manipulators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class FileReverse implements FileManipulations {
    @Override
    public void execute(String origin, String target) throws IOException {
        FileReader fileReader = new FileReader(originPathName + origin);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Stack<String> lines = new Stack<>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.push(line);
        }
        bufferedReader.close();
        FileWriter writer = new FileWriter(targetPathName + target);
        while (!lines.empty()) {
            writer.write(lines.pop() + "\r\n");
        }
        writer.close();
    }
}
