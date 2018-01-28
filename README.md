Задание для финального проекта на Java Core

Необходимо реализовать консольное приложение, в котором есть сущности:
- Skill
Навык разработчика (Java, SQL, C++, etc.)
Long id, 
String name

- Developer
Разработчик
 
Long id, 
String firstName, 
String lastName, 
String specialty, 
Set<Skill> skills, 
BigDecimal salary

- Team
Команда, в которой работают разработчики

Long id, 
String name, 
Set<Developer> developers

- Project
Проект (над которым работают)
Long id, 
String name, 
Set<Team> teams

- Company
Которая выполняет проект(ы)

Long id, 
String name, 
Set<Project> projects

- Customer
Клиент компании, который является заказчиком проекта

Long id, 
String firstName, 
String lastName, 
String address, 
Set projects

Необходимо реализовать консольное приложение, которое позволяет выполнять все CRUD операции над всеми сущностями.
Использовать Java I/O (NIO).
Данные о сущностях должны храниться в отдельных текстовых файлах (skills.txt developers.txt, etc.)
Необходимо использовать шаблон MVCНеобходимо обработать все исключительные ситуации. 
Завершение программы кроме как по желанию пользователя (или форс-мажорных обстоятельств) - недопустимо.
Результатом выполнения задания должен быть репозиторий (github, bitbucket) с описанием задачи и UML диаграммами проекта.
