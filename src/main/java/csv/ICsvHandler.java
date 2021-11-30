package csv;

import java.util.List;

public interface ICsvHandler {
    void setPath(String aPath);
    String getPath();
    boolean load();
    List<List<String>> getData();
    String getlastError();
}
