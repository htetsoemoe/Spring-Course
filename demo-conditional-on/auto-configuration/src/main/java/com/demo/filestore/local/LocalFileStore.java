package com.demo.filestore.local;

import com.demo.filestore.FileStore;

public class LocalFileStore implements FileStore {
    @Override
    public void printFileStoreInfo() {
        System.out.println("Local File Store.");
    }
}
