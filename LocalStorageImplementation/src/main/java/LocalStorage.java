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
    void putFiles(String path, ArrayList<String> files) {

    }

    @Override
    void deleteFilesDirs(ArrayList<String> paths) {

    }

    @Override
    void moveFiles(String destinationPath, ArrayList<String> files) {

    }

    @Override
    void downloadFile(String itemPath, String destinationDir) {

    }

    @Override
    void rename(String itemPath, String newName) {

    }

    @Override
    void sort(String sortBy, boolean opadajuce) {

    }

    @Override
    void filter(String path, ArrayList<String> parametriZaFilter) {

    }

    @Override
    boolean dirContainsFiles(String dirPath, ArrayList<String> files) {
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
    ArrayList<Fajl> getAllFilesWithExt(String ext) {
        return null;
    }

    @Override
    ArrayList<Fajl> getAllFilesSubstring(String substr) {
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
