package main.java;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

public class LocalStorage extends Skladiste {

    public LocalStorage(String path) {
        super(path);
    }

    public LocalStorage(String path, Config config)
    {
        super(path,config);
    }

    public LocalStorage(String path, int byteSizeLimit, ArrayList<String> bannedExtensions, int fileCountLimit) {
        super(path, byteSizeLimit, bannedExtensions, fileCountLimit);
    }


    @Override
    void createConfigFile(Config c) {
        File config = new File(getPath(), "config.json");
        config.exists();
        try {
            FileWriter fileWriter = new FileWriter(getPath() + "\\config.json");
            String json = getConfigJson();
            fileWriter.write(json);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    void readConfig() {

    }

    @Override
    void createDir(String path) {

    }

    @Override
    void putFiles(String path, String[] names) {

    }

    @Override
    void deleteFilesDirs(String path, String[] names) {

    }

    @Override
    void moveFiles(String path1, String path2, String[] names) {

    }

    @Override
    void downloadFile(String itemPath, String destinationDir) {

    }

    @Override
    void rename(String itemPath, String newName) {

    }

    @Override
    void sort(String path, String sortBy, boolean opadajuce) {

    }

    @Override
    void filter(String path) {

    }

    @Override
    boolean dirContainsFile(String dirPath, ArrayList<String> fileName) {
        return false;
    }

    @Override
    String whereIsFile(String fileName) {
        return null;
    }

    @Override
    ArrayList<Fajl> getAllFiles(String path) {
        return null;
    }

    @Override
    ArrayList<Fajl> getAllFilesNotSoDeep(String path) {
        return null;
    }

    @Override
    ArrayList<Fajl> getAllFilesDeep(String path) {
        return null;
    }

    @Override
    ArrayList<Fajl> getAllFilesWithExt(String ext, String path) {
        return null;
    }

    @Override
    ArrayList<Fajl> getAllFilesSubstring(String path, String substr) {
        return null;
    }

    @Override
    ArrayList<Fajl> getModified(String dirPath, Date from, Date to) {
        return null;
    }

    @Override
    void createPath() {

    }
}
