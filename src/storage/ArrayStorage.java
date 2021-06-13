package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;

    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if(index >= 0){
            storage[index] = r;
        } else {
            printMessage("resume " + r.getUuid() + " not found!");
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size + 1 > storage.length) {
            printMessage("storage already full!");
        } else {
            if (getIndex(r.getUuid()) >= 0) {
                printMessage("resume " + r.getUuid() + " already exist!");
            } else {
                storage[size++] = r;
            }
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if(index >= 0 ){
            return storage[index];
        }
        printMessage("resume " + uuid + " not found!");
        return null;
    }

    public void delete(String uuid) {
        if (size > 0) {
            int index = getIndex(uuid);
            if(index >= 0 ){
                storage[index] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            } else {
                printMessage("resume " + uuid + " not found!");
            }
        } else {
            printMessage("storage is empty!");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private void printMessage(String message) {
        System.out.println("WARNING: " + message);
    }
    
    private int getIndex(String uuid){
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)){
                return i;
            }
        }

        return -1;
    }
}
