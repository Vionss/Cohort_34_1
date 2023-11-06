package ait.album.dao;

import ait.album.model.Photo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class AlbumImpl implements Album {
    private Photo[] photos;
    private int size;
    private Comparator<Photo> comparator = (p1, p2) -> p1.getDate().compareTo(p2.getDate());


    public AlbumImpl(int capacity) {

        this.photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if (photo == null || size == photos.length || getPhotoFromAlbum(photo.getPhotoId(), photo.getAlbumId()) != null) {
            return false;
        }
        int index = Arrays.binarySearch(photos, 0, size, photo, comparator);
        index = index >=0 ? index : -index - 1;
        System.arraycopy(photos, index, photos, index + 1, size - index);
        photos[index] = photo;
        size++;
        return true;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                System.arraycopy(photos, i + 1, photos, i, size - i - 1);
                photos[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        Photo photo = getPhotoFromAlbum(photoId, albumId);
        if (photo == null) {
            return false;
        }
        photo.setUrl(url);
        return true;
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
        return findPhotoByPredicate(p -> p.getAlbumId() == album);
    }

    @Override
    public Photo[] getPhotosBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        Photo pattern = new Photo(0,0,null,null,dateFrom.atStartOfDay());
        int from = Arrays.binarySearch(photos,0, size, pattern, comparator);
        from = from >=0 ? from : -from -1;
        pattern = new Photo(0,0,null,null,dateTo.plusDays(1).atStartOfDay());
        int to = Arrays.binarySearch(photos,0, size, pattern, comparator);
        to = to >= 0 ? to : -to -1;
        return Arrays.copyOfRange(photos, from, to);
    }

    @Override
    public int size() {
        return size;
    }

    private Photo[] findPhotoByPredicate(Predicate<Photo> predicate) {
        Photo[] res = new Photo[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(photos[i])) {
                res[j++] = photos[i];
            }
        }
        return Arrays.copyOf(res, j);
    }
}
