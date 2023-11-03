package ait.album.dao;

import ait.album.model.Photo;

import java.time.LocalDate;

public interface Album {

    boolean addPhoto(Photo photo);
    boolean removePhoto(int photoId, int albumId);
    boolean updatePhoto(int photoId, int albumId, String url);
    Photo getPhotoFromAlbum(int photoId, int albumId);
    Photo [] getAllPhotosFromAlbum(int album);
    Photo[] getPhotosBetweenDate(LocalDate dateFrom, LocalDate dateTo);
    int size();

}
