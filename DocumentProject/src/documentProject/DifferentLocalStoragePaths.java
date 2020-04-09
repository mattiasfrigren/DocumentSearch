package documentProject;

/**
 * Temp class for switching paths for local storage while developing.
 * Add your path here Anara!
 */

//TODO fixed the class to safer paths.
public class DifferentLocalStoragePaths {
    private static String mattiasPath = "C:\\Users\\91matfri\\IdeaProjects\\documentgroup";
    private static String henriksPath = "C:\\Users\\78henlar\\desktop\\javaprojekt\\documentgroup";
    private static String anarasPath = "C:\\Users\\88anazhu\\IdeaProjects\\documentgroup";

    public static String docPath =  henriksPath;
}

/**
 * If we want to create a folder at users desktop to immediately set a standard folder
 * new File(DifferentLocalStoragePaths.henriksPath).mkdir();
 * //public static String henriksPath = System.getProperty("user.home")+"\\desktop\\TextFilesFolder\\";
 */
