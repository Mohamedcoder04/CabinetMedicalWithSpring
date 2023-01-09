package com.gestion.cabinetmedical.services.implimantation;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.gestion.cabinetmedical.services.FlickrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class FlickrServiceImpl implements FlickrService {

    private Flickr flickr;

    @Autowired
    public FlickrServiceImpl(Flickr flickr) {
        this.flickr = flickr;
    }

    @Override
    public String save(InputStream photo, String title) throws FlickrException {
        UploadMetaData metaData = new UploadMetaData();
        metaData.setTitle(title);
        String photoId = flickr.getUploader().upload(photo, metaData);
        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
    }
}
