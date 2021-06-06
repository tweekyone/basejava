/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                break;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume r : storage) {
            if (r != null && r.uuid.equals(uuid)) {
                return r;
            }
        }
        return null;
    }

    void delete(String uuid) {
        Integer deleted = null;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                deleted = i;
                storage[i] = null;
                break;
            }
        }
        if (deleted != null) {
            for (int i = deleted; i < storage.length - 1; i++) {
                if (storage[i + 1] == null) break;
                storage[i] = storage[i + 1];
                storage[i + 1] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[size()];
        if (newStorage.length == 0) {
            return newStorage;
        }
        for (int i = 0; i < newStorage.length; i++) {
            newStorage[i] = storage[i];
        }
        return newStorage;
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                size = i;
                break;
            }
        }
        return size;
    }
}
