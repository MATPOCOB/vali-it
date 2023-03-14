import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

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
  public static void main(String[] args) throws IOException {
    try (Stream<Path> files = Files.list(Path.of("/"))) {
      files.forEach(file -> {
        boolean directory = file.toFile().isDirectory();
        System.out.println((directory ? "/" : "") + file.getFileName());
      });
    }
  }
}
