package personaluebersicht.facade;

import java.util.Vector;

import personaluebersicht.model.log.LogBook;

public class LogbuchFacade {
    LogBook logBook;

    public LogbuchFacade(){
        logBook = LogBook.getLogBookInstance();
    }

    public Vector<String> getLogList(){
        Vector<String> logList = new Vector<>();

        for (int i = 0; i < logBook.getSize(); i++) {
            logList.add(logBook.getEntry(i));
        }

        return logList;
    }
}
