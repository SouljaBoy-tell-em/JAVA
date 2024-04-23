
### Как скомпилировать?
Для начала откройте консоль/терминал в папке с проектом. Чтобы скомпилировать Maven проект, следуйте этим шагам:
:
```sh
$ mvn install
```
```sh
$ mvn package
```
```sh
$ mvn compile
```

После этого будет создана папка target, в которой будет находится следующий jar файл:
```sh
URLDownloader-1.0-SNAPSHOT.jar 
```
Далее, мы должны перейти в папку "target":
```sh
$ cd target
```
И запустить jar файл:
```sh
$ java -jar URLDownloader-1.0-SNAPSHOT.jar <your_path_to_JSONFile>
```
Вы увидете что-то такое:
![Снимок экрана 2024-04-23 в 15 57 47](https://github.com/SouljaBoy-tell-em/JAVA/assets/60592559/9e172874-ec3b-4b31-b80f-3e638d3ee75f)
