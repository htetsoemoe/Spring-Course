package com.demo.filestore.network;

import com.demo.filestore.FileStore;

public class NetworkFileStore implements FileStore {
    @Override
    public void printFileStoreInfo() {
        System.out.println("Network File Store.");
    }
}
