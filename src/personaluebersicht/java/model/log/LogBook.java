package personaluebersicht.java.model.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class LogBook {
    private static LogBook Instance = null;

    private Vector<String> entries;
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;
    private boolean fileWritingEnabled = false;

    private LogBook() {
        entries = new Vector<String>();

        this.file = new File("logbook.log");

        try {
            if (!file.createNewFile()) {
                reader = new BufferedReader(new FileReader(file));
                readFile();
                reader.close();

                writer = new BufferedWriter(new FileWriter(file));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LogBook getLogBookInstance() {
        if (Instance == null) {
            Instance = new LogBook();
        }

        return Instance;
    }

    public void addEntry(String entry) {
        if (fileWritingEnabled) {
            writeFile(entry);
        }

        entries.add(entry);
    }

    public String getEntry(int index) {
        return entries.get(index);
    }

    public int getSize() {
        return entries.size();
    }

    public void logBookClose() {
    }

    public void printLog() {
        for (String entry : entries) {
            System.out.println(entry);
        }
    }

    private void writeFile(String entry) {
        try {
            writer.append(entry);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() {
        try {
            while (reader.ready()) {
                entries.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
