# Topics


### Краткое описание:
Программа способна добавлять топики, в которых содержаться сообщения
от авторизованных пользователей. Авторизация и регистрация происходит,
благодаря генерации jwt-токенов и соединения с базой данных(я использовал mysql).

### Тестирование:
Удобно использовать POSTMAN или curl-запросы.

[Скачать PostMan](https://www.postman.com/downloads)

### Что может пользователь:

##### Прежде всего, зарегистрироваться. Для этого используйте следующий запрос:
```sh
POST: http://localhost:8080/auth/register
```
##### с телом запроса(JSON):
```sh
{
    "username":"<your_username>",
    "password":"<your_password>"
}
```

##### После этого можно авторизоваться:
```sh
POST: http://localhost:8080/auth/login
```
##### с телом запроса(JSON):
```sh
{
    "username":"<your_username>", - то, что вводили выше
    "password":"<your_password>" - то, что вводили выше
}
```

##### В обоих случаях, то есть как после регистрации, так и после авторизации в ответе находится токен доступа:
```sh
eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiUk9MRV9VU0VSIiwic3ViIjoidSIsImlhdCI6MTcxMjUzNzYxMSwiZXhwIjoxNzEyNjgxNjExfQ.oajCAEa_TdZiMdAE_4IXsJA5PJ7Snk5UqfjD1pxvaTw
```
##### и его можно использовать для дальнейшей отправки запросов, которые нельзя отправлять не имея токен доступа. По умолчанию зарегистрированный имеет роль обычного пользователя(ROLE_USER).

##### Создание собственного топика:
```sh
POST: http://localhost:8080/example/topic
```
##### с телом запроса(JSON):
```sh
{
    "topicName":"topic_name"
}
```
##### Так же в базе данных создастся таблица из двух колонок: 
    topicId | topicName.

##### Создание сообщения в существующем топике:
```sh
POST: http://localhost:8080/example/message
```
##### с телом запроса(JSON):
```sh
{
    "topicId":1,
    "textMessage":"Hi, everyone !"
}
```
##### то есть сообщение попадет в топик с указанным topicId. При этом создастся общая таблица для всех сообщений со столбцами:
    messageId | creationDate | textMessage | topicId | userId




