import java.util.ArrayList;
import java.util.Date;

public abstract class Skladiste {

    private String path;
    //String name je ime foldera
    //vrv nam ne treba klasa fajl

    public Skladiste(){

    }

    abstract void createDir(String path);

    abstract void putFiles(String path, String []names);

    abstract void deleteFilesDirs(String path, String []names);

    abstract void moveFiles(String path1, String path2, String []names);

    abstract void downloadFile(String itemPath, String destinationDir);

    abstract void rename(String itemPath, String newName);

    abstract void sort(String path, String sortBy, boolean opadajuce);

    abstract void filter(String path);

    abstract boolean dirContainsFile(String dirPath, ArrayList<String> fileName);

    abstract String whereIsFile(String fileName);

    abstract ArrayList<Fajl> getAllFiles(String path);

    abstract ArrayList<Fajl> getAllFilesNotSoDeep(String path);

    abstract ArrayList<Fajl> getAllFilesDeep(String path);

    abstract ArrayList<Fajl> getAllFilesWithExt(String ext, String path);

    abstract ArrayList<Fajl> getAllFilesSubstring(String path, String substr);

    abstract ArrayList<Fajl> getModified(String dirPath, Date from, Date to);

}
