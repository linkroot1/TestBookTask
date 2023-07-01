# TestBookTask
Приложение содержит 4 endpoints:
1) GET /api/v1/books - получить список книг
2) GET /api/v1/sorted_books - получить список книг по названию в обратном алфавитном порядке
3) GET /api/v1/grouped_books - чтобы получить массив книг, сгруппированных по автору
4) POST /api/v1/create - добавить книгу в список

Скрипт для БД PostgreSQL надодится в src/main/db
Для запуска приложение необходимо:
1) Создать БД и подключить в SpringConfig
2) Настроить TomcatServer
