Задание для финального проекта на Java Core

Необходимо реализовать консольное приложение, в котором есть сущности:
- **Skill** Навык разработчика (Java, SQL, C++, etc.)<br>
Long id; <br>
String name;

- **Developer** (Разработчик)<br>
Long id, <br>
String firstName, lastName, specialty; <br>
Set< Skill > skills; <br>
BigDecimal salary;

- **Team** (Команда, в которой работают разработчики)<br>
Long id; <br>
String name; <br>
Set< Developer > developers;

- **Project** Проект (над которым работают)<br>
Long id, <br>
String name, <br>
Set< Team > teams

- **Company** Которая выполняет проект(ы)
Long id, <br>
String name, <br>
Set< Project > projects

- **Customer** Клиент компании, который является заказчиком проекта
Long id, <br>
String firstName, lastName, address, <br>
Set projects

Необходимо реализовать консольное приложение, которое позволяет выполнять все CRUD операции над всеми сущностями.
Использовать Java I/O (NIO).
Данные о сущностях должны храниться в отдельных текстовых файлах (skills.txt developers.txt, etc.)
Необходимо использовать шаблон MVCНеобходимо обработать все исключительные ситуации. 
Завершение программы кроме как по желанию пользователя (или форс-мажорных обстоятельств) - недопустимо.
Результатом выполнения задания должен быть репозиторий (github, bitbucket) с описанием задачи и UML диаграммами проекта.
