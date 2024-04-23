package es.uji.prog_av;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ReaderTemplate {
    abstract void openSource(String source) throws FileNotFoundException;
    abstract void processHeaders(String headers) throws IOException;
    abstract void processData(String data) throws IOException;
    abstract void closeSource() throws IOException;
    abstract boolean hasMoreData() throws IOException;
    abstract String getNextData() throws IOException;

    protected String fileName;
    protected Table tabla;

    public ReaderTemplate(String fileName){
        this.fileName = fileName;
    }

    public final Table readTableFromSource() throws IOException {
        openSource(fileName);
        hasMoreData();
        processHeaders(getNextData());
        while(hasMoreData()){
            processData(getNextData());
        }
        closeSource();
        return tabla;
    }
}
