package org.hbrs.se1.ws24.exercises.uebung4.meineLösung;
import java.io.*;
import java.util.List;


public class PersistenceStrategyStream<T> implements PersistenceStrategy<T> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     * Look-up in Google for further help! Good source:
     * https://www.digitalocean.com/community/tutorials/objectoutputstream-java-write-object-file
     * (Last Access: Oct, 15th 2024)
     */
    public void save(List<T> T) throws PersistenceException {
        ObjectOutputStream oos;
        try{
            oos = new ObjectOutputStream(new FileOutputStream(location));
            oos.writeObject(T);
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Member konnten nicht gespeichert werden: " + e.getMessage());
        }

        try{
            oos.close();
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Output Stream konnte nicht geschlossen werden: " + e.getMessage());
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<T> load() throws PersistenceException {
        // Some Coding hints ;-)

        ObjectInputStream ois = null;

        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        try {

            // Tipp: Use a directory (ends with "/") to implement a negative test case ;-)
            ois = new ObjectInputStream(new FileInputStream(location));
            Object obj = ois.readObject();

            if(obj instanceof List<?>){
                return (List<T>) obj;
            } else {
                throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable,"Falscher Datentyp");
            }
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Member konnten nicht geladen werden: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Laden fehlgeschlagen, Klasse nicht gefunden " + e.getMessage());
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Input Stream konnte nicht geschlossen werden " + e.getMessage());
            }
        }
        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams
    }
}
