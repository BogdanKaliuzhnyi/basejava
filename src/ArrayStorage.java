/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    void clear() {
        if (storageSize != 0) {
            for (int i = 0; i < storageSize; i++) {
                storage[i] = null;
                storageSize = 0;
            }
        }
    }

    void save(Resume r) {
        if (storageSize < storage.length) {
            if (get(r.uuid) == null) {
                storage[storageSize] = r;
                storage[storageSize].uuid = r.uuid;
                storageSize++;
            } else {
                System.out.println(r.uuid);
                System.out.println("----------------------------");
                System.out.println("A resume with uuid " + r.uuid + " already in the storage. This resume will not be saved");
                System.out.flush();
            }
        } else {
            System.out.println("----------------------------");
            System.out.println("The storage is full. Can't save new resume");
            System.out.flush();
        }
    }

    Resume get(String uuid) {
        if (storageSize != 0) {
            for (int i = 0; i < storageSize; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (storageSize != 0) {
            for (int i = 0; i < storageSize; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = storage[storageSize - 1];
                    storage[i].uuid = storage[storageSize - 1].uuid;
                    storage[storageSize - 1] = null;
                    storageSize--;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] outputStorage = new Resume[storageSize];
        if (storageSize != 0) {
            for (int i = 0; i < storageSize; i++) {
                outputStorage[i] = new Resume();
                outputStorage[i].uuid = storage[i].uuid;
            }
        }
        return outputStorage;
    }

    int size() {
        return storageSize;
    }
}
