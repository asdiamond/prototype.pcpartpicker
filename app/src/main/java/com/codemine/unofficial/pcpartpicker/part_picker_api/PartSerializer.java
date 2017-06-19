package com.codemine.unofficial.pcpartpicker.part_picker_api;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Aleksandr on 5/27/2017.
 */
public class PartSerializer {
    private static void serializeComputerParts(String filename, ArrayList<ComputerPart> computerParts) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        for (Object curr : computerParts) {
            out.writeObject(curr);
        }
        out.close();
        fileOut.close();
    }

    private static <T> ArrayList<T> deserializeComputerParts(String filename) throws IOException {
            FileInputStream in = new FileInputStream(filename);
            ObjectInputStream inputStream = new ObjectInputStream(in);
            ArrayList<T> parts = new ArrayList<>();
        try {
            for(Object curr; (curr = inputStream.readObject()) != null; ) parts.add((T)curr);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return parts;
    }
}
