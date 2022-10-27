import java.util.ArrayList;
import java.util.Date;

public abstract class Skladiste {

    private String path;
    //String name je ime foldera

    public Skladiste(){

    }

    /*
    * Kreiranje direktorijuma na određenoj putanji u skladištu.
     */
    abstract void createDir(String path);

    /*
     * Smeštanje fajlova (jednog ili više) na određenu putanju u skladištu.
     */
    abstract void putFiles(String path, String []names);

    /*
     * Brisanje fajlova i direktorijuma iz skladišta.
     */
    abstract void deleteFilesDirs(String path, String []names);

    /*
     * Premeštanje fajlova iz jednog direktorijuma u drugi.
     */
    abstract void moveFiles(String path1, String path2, String []names);

    /*
     * Preuzimanje fajlova iz skladišta.
     */
    abstract void downloadFile(String itemPath, String destinationDir);

    /*
     * Preimenovanje fajlova i foldera u skladištu.
     */
    abstract void rename(String itemPath, String newName);

    /*
     * Sortiranje, na primer po nazivu,
     *  datumu kreiranje ili modifikacije, rastuće ili opadajuće,.
     */
    abstract void sort(String path, String sortBy, boolean opadajuce);

    /*
    * Filtriranje podataka koji se prikazuju za fajlove koji su rezultati pretraga.
     */
    abstract void filter(String path);

    /*
    * Vraca da li određeni direktorijum sadrži fajl sa određenim imenom,
    *  ili više fajlova sa zadatom listom imena.
     */
    abstract boolean dirContainsFile(String dirPath, ArrayList<String> fileName);

    /*
    * Vraca u kom folderu se nalazi fajl sa određenim zadatim imenom.
     */
    abstract String whereIsFile(String fileName);

    abstract ArrayList<Fajl> getAllFiles(String path);

    abstract ArrayList<Fajl> getAllFilesNotSoDeep(String path);

    abstract ArrayList<Fajl> getAllFilesDeep(String path);

    abstract ArrayList<Fajl> getAllFilesWithExt(String ext, String path);

    abstract ArrayList<Fajl> getAllFilesSubstring(String path, String substr);

    abstract ArrayList<Fajl> getModified(String dirPath, Date from, Date to);

}
