package storage;

import java.util.List;

public interface IGenericReadWriteData<T> {
    List<T> readData();
    void writeData(List<T> list);
}
