/*
 * Java 2 Practical - HaNoi Aptech
 */
package vn.techja.quanlybanhang.utilities;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;


public class FileUtils {

    public File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());
            return new File(resource.toURI());
        }

    }

    public InputStream getInputStreamFromResource(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream input = classLoader.getResourceAsStream(fileName);
        if (input == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());
            return input;
        }

    }
}
