package com.Hussain.pink.triangle.Utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Hussain on 11/12/2014.
 */
public class FileIO {
    public static final int OPEN_MODE = 1;
    public static final int SAVE_MODE = 2;

    public static String openFileDialog(Component component, int mode){
        String filePath = null;
        int returnValue = 0;
        JFileChooser fileChooser = new JFileChooser();
        switch (mode)
        {
            case OPEN_MODE: returnValue = fileChooser.showOpenDialog(component); break;
            case SAVE_MODE: returnValue = fileChooser.showSaveDialog(component); break;
        }
        if(returnValue ==  JFileChooser.APPROVE_OPTION)
        {
            filePath = fileChooser.getSelectedFile().getPath();
        }
        return  filePath;
    }

    public static boolean fileExists(String filePath){
        if(filePath == null)
        {
            return false;
        }
        File f = new File(filePath);
        return f.exists();
    }
}
