package ait.album.dao;

import ait.album.model.Photo;

import java.time.LocalDate;
import java.util.function.Predicate;

public class AlbumImpl implements Album {
    private Photo[] photos;
    private int size;

    public AlbumImpl(int capacity) {
        this.photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if (photo == null || size == photos.length || getPhotoFromAlbum(photo.getPhotoId(), photo.getAlbumId()) != null) {
            return false;
        }
        photos[size++] = photo;
        return true;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        int photoToRemove = -1;
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                photoToRemove = i;
                break;
            }
        }
//            for (int i = 0; i < size; i++) {
//                if(i == photoToRemove){
//                    photos[i] = photos[i + 1];
//                    photos[size - 1] = null;
//                    size--;
//                    return true;
//                }
//        }
        System.arraycopy(photos, photoToRemove + 1, photos, photoToRemove, size -photoToRemove -1 );
        photos[--size] = null;
        return true;

    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                photos[i].setUrl(url);
                return true;
            }
        }
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo[] getAllPhotosFromAlbum(int album) {
        int count = 0;
        Photo[] res = new Photo[size];
        for (int i = 0; i < size; i++) {
            if (photos[i].getAlbumId() == album) {
                res[count++] = photos[i];
            }
        }
        Photo[] foundPhotos = new Photo[count];
        System.arraycopy(res, 0, foundPhotos, 0, count);
        return foundPhotos;
    }

    @Override
    public Photo[] getPhotosBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        return new Photo[0];
    }

    @Override
    public int size() {
        return size;
    }
}
