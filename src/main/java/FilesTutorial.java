import java.io.File;

/*
* Write a programs that takes a path and prints expanded directory tree
*
* https://en.wikipedia.org/wiki/Tree_%28command%29
*
* E.g.
* $ tree path/to/folder/
* path/to/folder/
* ├── a-first.html
* ├── b-second.html
* ├── subfolder
* │   ├── readme.html
* │   ├── code.cpp
* │   └── code.h
* └── z-last-file.html
*
* 1 directories, 6 files
* */

public class FilesTutorial {
  public static void main(String[] args) {
    String path = "/";

    String[] filesAndDirectories = new File(path).list();
    if (filesAndDirectories == null) return;

    System.out.println("Contents of " + path);

    for (String fileOrDirectoryName : filesAndDirectories) {
      File fileOrDirectory = new File(path + fileOrDirectoryName);
      boolean directory = fileOrDirectory.isDirectory();
      System.out.println(fileOrDirectory.getName() + " -> " + (directory ? "dir" : "file"));
    }
  }
}
