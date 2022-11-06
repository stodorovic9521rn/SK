package main.java;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GoogleDrive extends Skladiste {

    /**
     * Application name.
     */
    private static Drive drive;
    private static final String APPLICATION_NAME = "";
    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /**
     * Directory to store authorization tokens for this application.
     */
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES =
            Collections.singletonList(DriveScopes.DRIVE_METADATA_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "../resources/client_secret.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {
        // Load client secrets.
        InputStream in = GoogleDrive.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        //returns an authorized Credential object.
        return credential;
    }

    public static void main(String... args) throws IOException, GeneralSecurityException, IOException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        drive = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        // Print the names and IDs for up to 10 files.
        FileList result = drive.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files:");
            for (File file : files) {
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
            }
        }
    }
    public GoogleDrive(String path, Config configuration) {
        super(path, configuration);

    }

    public GoogleDrive(String path, int byteSizeLimit, ArrayList<String> bannedExtensions, int fileCountLimit) {
        super(path, byteSizeLimit, bannedExtensions, fileCountLimit);
    }

    public GoogleDrive(String path) {
        super(path);
    }

    @Override
    void createConfigFile(Config c) {

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
