package main.java;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public abstract class Skladiste {

    private String path;
    private Config configuration;

    //String name je ime foldera
    //vrv nam ne treba klasa fajl

    public Skladiste(String path, Config configuration){
        this.path = path;
        this.configuration = configuration;
        createConfigFile(getConfiguration());
    }

    public Skladiste(String path, int byteSizeLimit, ArrayList<String> bannedExtensions, int fileCountLimit) {
        this.path = path;
        configuration = new Config(byteSizeLimit, bannedExtensions, fileCountLimit);
        createConfigFile(getConfiguration());
    }

    public Skladiste(String path)
    {
        this.path = path;
        this.configuration = new Config();
        createConfigFile(getConfiguration());
    }

    abstract void createConfigFile(Config c);
    abstract void readConfig();

    public void setConfiguration(Config c)
    {
        this.configuration = c;
    }

    protected String getConfigJson() {
        JSONObject json = new JSONObject();
        json.put("maxSizeLimit", configuration.getByteSize());
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(configuration.getBannedExtensions());
        json.put("bannedExtensions", jsonArray);
        json.put("fileCountLimit", configuration.getMaxFileCount());
        return json.toString();
    }
    /*
    * Kreiranje direktorijuma na određenoj putanji u skladištu.
    * @param path
     */
    abstract void createDir(String path);

    /*
     * Smeštanje fajlova (jednog ili više) na određenu putanju u skladištu.
     * @param path
     * @param names[]
     */
    abstract void putFiles(String path, String []names);

    /*
     * Brisanje fajlova i direktorijuma iz skladišta.
     * @param path
     * @param names[]
     */
    abstract void deleteFilesDirs(String path, String []names);

    /*
     * Premeštanje fajlova iz jednog direktorijuma u drugi.
     * @param path1
     * @param path2
     * @param names[]
     */
    abstract void moveFiles(String path1, String path2, String []names);

    /*
     * Preuzimanje fajlova iz skladišta.
     * @param intemPath
     * @param destinationDir
     */
    abstract void downloadFile(String itemPath, String destinationDir);

    /*
     * Preimenovanje fajlova i foldera u skladištu.
     * @param itemPath
     * @param newName
     */
    abstract void rename(String itemPath, String newName);

    /*
     * Sortiranje, na primer po nazivu,
     *  datumu kreiranje ili modifikacije, rastuće ili opadajuće.
     * @param path
     * @param sortBy
     * @param opadajuce
     */
    abstract void sort(String path, String sortBy, boolean opadajuce);

    /*
    * Filtriranje podataka koji se prikazuju za fajlove koji su rezultati pretraga.
    * @param path
     */
    abstract void filter(String path);

    /*
    * Vraca da li određeni direktorijum sadrži fajl sa određenim imenom,
    *  ili više fajlova sa zadatom listom imena.
    * @param dirPath
    * @param fileName
     */
    abstract boolean dirContainsFile(String dirPath, ArrayList<String> fileName);

    /*
    * Vraca u kom folderu se nalazi fajl sa određenim zadatim imenom.
    * @param fileName
     */
    abstract String whereIsFile(String fileName);

    /*
    * Vraca sve fajlove u zadatom direktorijumu (vraća se naziv i metapodaci.
    * @param path
     */
    abstract ArrayList<Fajl> getAllFiles(String path);

    /*
    * Vraca sve fajlove iz svih direktorijuma u nekom direktorijumu.
    * @param path
     */

    abstract ArrayList<Fajl> getAllFilesNotSoDeep(String path);
    /*
    * Vraca sve fajlove u zadatom direktorijumu i svim poddirektorijumima.
    * @param path
     */
    abstract ArrayList<Fajl> getAllFilesDeep(String path);

    /*
    * Vraca fajlove sa određenom ekstenzijom.
    * @param ext
    * @param path putanja do
     */
    abstract ArrayList<Fajl> getAllFilesWithExt(String ext, String path);

    /*
    * Vraca fajlove koji u svom imenu sadrže, počinju,
    *  ili se završavaju nekim zadatim podstringom.
    * @param path
    * @param substr
    * @return
     */
    abstract ArrayList<Fajl> getAllFilesSubstring(String path, String substr);

    /*
    * Vraca fajlove koji su kreirani/modifikovani u nekom periodu, u nekom direktorijumu.
    *
    * @param dirPath
    * @param from
    * @param to
    *
    * @return
     */
    abstract ArrayList<Fajl> getModified(String dirPath, Date from, Date to);


    abstract void createPath();
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public Config getConfiguration()
    {
        return  configuration;
    }


}
