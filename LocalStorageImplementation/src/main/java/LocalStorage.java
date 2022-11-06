
import main.java.Fajl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;

public class LocalStorage extends Skladiste {

    String putanja = "C:\\Users\\Admin\\Desktop";
    Config config = new Config();

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

    //maxFileCount
    //byteSize

    private boolean checkFileCount(String path){
        File noviFajl = new File(path);
        return getConfiguration().getMaxFileCount() > noviFajl.list().length;
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
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
            System.out.println("Directory " + dir.getName() + " successfully created on " + dir.getPath());
        } else {
            System.out.println("Directory already exists");
        }
    }

    public static void metoda(String path, ArrayList<String> files){
        try {
            for(String s: files){
                Path temp = Files.move
                        (Paths.get(s),
                                Paths.get(path + "\\itachi.png"), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        ArrayList<String> lista = new ArrayList<>();
        lista.add("C:\\Users\\Admin\\Desktop\\itachi.png");
        metoda("C:\\Users\\Admin\\Desktop\\Skladiste",  lista);
    }

    @Override
    public void putFiles(String path, ArrayList<String> files) {
        //C:\Users\Admin\Desktop
        if(checkFileCount(path)){
            try {
                Path destinationDir = Files.createTempDirectory(path);
                for(String s: files){
                    Path fileToMovePath = Files.createTempDirectory(s);
                    Files.move(fileToMovePath, destinationDir.resolve(s),  StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("Max file count reached.");
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
        //vratiti u kom folderu se nalazi fajl sa određenim zadatim imenom,

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
