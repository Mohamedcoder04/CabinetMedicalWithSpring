package com.gestion.cabinetmedical.services;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface FlickrService {
    String save(InputStream photo, String title) throws FlickrException;
}
