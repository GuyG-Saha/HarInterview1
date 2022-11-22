package manipulators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileShuffle implements FileManipulations{
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

        FileWriter writer = new FileWriter(targetPathName + target);
        int i = 0;
        while (i < lines.size()) {
            int index = getRandomNumberInRange(0, lines.size());
            String randomLineVal = lines.get(index);
            writer.write(randomLineVal + "\r\n");
            lines.remove(index);
            //i++;
        }
        writer.close();
    }
    private int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
