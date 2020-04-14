package documentProject;

/**
 * Temp class for switching paths for local storage while developing.
 *
 */

//TODO fixed the class to safer paths.
    // comment in your own path when u need it and comment out the other.
public class DifferentLocalStoragePaths {

    //final private static String docPath = "C:\\Users\\91matfri\\IdeaProjects\\documentgroup";
    final private static String docPath = "C:\\Users\\78henlar\\desktop\\javaprojekt\\documentgroup";
    //final private static String docPath = "C:\\Users\\88anazhu\\IdeaProjects\\documentgroup";

    public static String getDocPath() {
        return docPath;
    }
}


