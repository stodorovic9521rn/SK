import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Skladiste {

    private String path;
    private int maxSizeLimit;
    private List<String> bannedExtensions;
    private int fileCountLimit;


    //String name je ime foldera
    //vrv nam ne treba klasa fajl

    public Skladiste(String path){
        this.path = path;
        maxSizeLimit = 127;
        bannedExtensions = new ArrayList<>();
        fileCountLimit = 20;
    }

    public Skladiste(String path, int maxSizeLimit, List<String> bannedExtensions, int fileCountLimit) {
        this.path = path;
        this.maxSizeLimit = maxSizeLimit;
        this.bannedExtensions = bannedExtensions;
        this.fileCountLimit = fileCountLimit;
    }



    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getMaxSizeLimit() {
        return maxSizeLimit;
    }

    public List<String> getBannedExtensions() {
        return bannedExtensions;
    }

    public int getFileCountLimit() {
        return fileCountLimit;
    }

    public Object getConfiguration(IConfig config){
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject json = (JSONObject) jsonParser.parse(new FileReader("config.json"));
            switch (config) {
                case BANNED_EXTENSIONS -> {
                    return json.get("bannedExtensions");
                }
                case FILE_COUNT_LIMIT -> {
                    return json.get("fileCountLimit");
                }
                case MAX_SIZE_LIMIT -> {
                    return json.get("maxSizeLimit");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateConfiguration(){
        try {
            FileWriter fileWriter = new FileWriter("config.json");
            JSONObject json = new JSONObject();
            json.put("maxSizeLimit", maxSizeLimit);
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(bannedExtensions);
            json.put("bannedExtensions", jsonArray);
            json.put("fileCountLimit", fileCountLimit);
            fileWriter.write(json.toString());
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    abstract ArrayList<File> getAllFiles(String path);

    /*
    * Vraca sve fajlove iz svih direktorijuma u nekom direktorijumu.
    * @param path
     */

    abstract ArrayList<File> getAllFilesNotSoDeep(String path);
    /*
    * Vraca sve fajlove u zadatom direktorijumu i svim poddirektorijumima.
    * @param path
     */
    abstract ArrayList<File> getAllFilesDeep(String path);

    /*
    * Vraca fajlove sa određenom ekstenzijom.
     */
    abstract ArrayList<File> getAllFilesWithExt(String ext, String path);

    /*
    * Vraca fajlove koji u svom imenu sadrže, počinju,
    *  ili se završavaju nekim zadatim podstringom.
     */
    abstract ArrayList<File> getAllFilesSubstring(String path, String substr);

    /*
    * Vraca fajlove koji su kreirani/modifikovani u nekom periodu, u nekom direktorijumu.
    *
    * @param
    *
    * @return
     */
    abstract ArrayList<File> getModified(String dirPath, Date from, Date to);

}
