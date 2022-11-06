package main.java;

import java.util.ArrayList;

public class Config {
    private int byteSize;
    private ArrayList<String> bannedExtensions;
    private int maxFileCount;

    public int getByteSize() {
        return byteSize;
    }

    public void setByteSize(int byteSize) {
        this.byteSize = byteSize;
    }

    public ArrayList<String> getBannedExtensions() {
        return bannedExtensions;
    }

    public void setBannedExtensions(ArrayList<String> bannedExtensions) {
        this.bannedExtensions = bannedExtensions;
    }

    public int getMaxFileCount() {
        return maxFileCount;
    }

    public void setMaxFileCount(int maxFileCount) {
        this.maxFileCount = maxFileCount;
    }

    public Config()
    {
        this.byteSize = 10000;
        this.bannedExtensions = new ArrayList<>();
        this.maxFileCount = 10;
    }

    public Config(int byteSize, ArrayList<String> bannedExtensions, int maxFileCount)
    {
        this.byteSize = byteSize;
        this.bannedExtensions = bannedExtensions;
        this.maxFileCount = maxFileCount;
    }
}
