package personaluebersicht.java.facade;

import java.util.Vector;

import personaluebersicht.java.model.log.LogBook;

/**
 * the facade for the LogBook class
 * 
 * @author Gabriel Egli
 * @since 2022-06-21
 * @version 1.0
 */
public class LogbuchFacade {
    LogBook logBook;

    public LogbuchFacade() {
        logBook = LogBook.getLogBookInstance();
    }

    
    /** 
     * returns all current logs.
     * 
     * @return Vector<String> A vector of String representing all the log entries.
     */
    public Vector<String> getLogList() {
        Vector<String> logList = new Vector<>();

        for (int i = 0; i < logBook.getSize(); i++) {
            logList.add(logBook.getEntry(i));
        }

        return logList;
    }
}
