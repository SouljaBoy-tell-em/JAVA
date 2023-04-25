import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {

        File file = new File("archive.zip");

        try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {

            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            ZipEntry zipEntry = new ZipEntry("file.txt");
            ZipEntry zipEntry1 = new ZipEntry("file1.txt");
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.putNextEntry(zipEntry1);
        } catch(Exception e) {

            System.out.println(e.getMessage());
        }

        try(FileInputStream fileInputStream = new FileInputStream(file)) {

            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            ZipEntry save = zipInputStream.getNextEntry();
            System.out.println("name: " + save.getName());
            System.out.println("size: " + save.getSize());
            save = zipInputStream.getNextEntry();
            System.out.println("name: " + save.getName());
            System.out.println("size: " + save.getSize());
        } catch(Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
