
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
$ java -jar URLDownloader-1.0-SNAPSHOT.jar <your_path>
```
Проект начнет компилироваться и веб страница или файл будут спаршены в указанную директорию(<your_path>).
Вы увидете что-то такое: