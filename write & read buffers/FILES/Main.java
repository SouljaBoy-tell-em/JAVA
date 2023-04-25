import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

//        boolean createNewFile(): создает новый файл по пути, который передан в конструктор. В случае удачного создания возвращает true, иначе false
//        boolean delete(): удаляет каталог или файл по пути, который передан в конструктор. При удачном удалении возвращает true.
//        boolean exists(): проверяет, существует ли по указанному в конструкторе пути файл или каталог. И если файл или каталог существует, то возвращает true, иначе возвращает false
//        String getAbsolutePath(): возвращает абсолютный путь для пути, переданного в конструктор объекта
//        String getName(): возвращает краткое имя файла или каталога
//        String getParent(): возвращает имя родительского каталога
//        boolean isDirectory(): возвращает значение true, если по указанному пути располагается каталог
//        boolean isFile(): возвращает значение true, если по указанному пути находится файл
//        boolean isHidden(): возвращает значение true, если каталог или файл являются скрытыми
//        long length(): возвращает размер файла в байтах
//        long lastModified(): возвращает время последнего изменения файла или каталога. Значение представляет количество миллисекунд, прошедших с начала эпохи Unix
//        String[] list(): возвращает массив файлов и подкаталогов, которые находятся в определенном каталоге
//        File[] listFiles(): возвращает массив файлов и подкаталогов, которые находятся в определенном каталоге
//        boolean mkdir(): создает новый каталог и при удачном создании возвращает значение true
//        boolean renameTo(File dest): переименовывает файл или каталог

        

        File dir = new File("C:\\Users\\Alexander\\catalogs");
        System.out.println(dir.isDirectory());

        String[] string = new String[100];
        string = dir.list();

        for(String i : string)
            System.out.println(i);

        File newdir = new File("C:\\Users\\Alexander\\catalogs\\NEWCATALOG");
        newdir.mkdir();
        newdir.renameTo(new File("OLDCATALOG"));
    }
}
