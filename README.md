# Java Practice

## Table of contents

1. [Тема](#тема)
2. [Прогресс](#прогресс)
3. [Отчёт](#отчёт)
3. [Требования](#требования)

### Тема

Вариант 8. **Зарплатная ведомость**

### Прогресс

+ [готово] Этап 1.
+ [готово] Этап 2.
+ [] Этап 3.

### Отчёт
Первый этап: 
- ER-диаграмма(src\main\resources\img\ER.jpeg, erDescription.md)
- SQL-скрипты инициализации и заполнения бд (src\main\resources\SQLScripts)
- Сценарии использование (CONCEPT.md)

Второй этап:
- ДАО классы(src\main\java\com\step4kap\dao)
- Конфигурационный файл(src\main\java\com\step4kap\db\config\HibernateDatabaseConfig.java)
- Тесты(src\test\java\com\step4kap\dao)
 
### Требования

1. Система управления информацией о зарплатах служащих компании.
2. Поддерживаемые данные
  + Служащие
    - ФИО
    - Домашний адрес
    - Дата рождения
    - Образование
    - Стаж работы в компании
    - Текущая должность
    - Участие в проектах и выполняемые роли
    - История занимаемых должностей и участия в проектах проектов
    - Общая история всех выплат
    - Премии и даты их выписки
		
  + Проекты
    - Назавние, даты начал и окончания
    - Роли в проекте(руководитель, аналитик, секретарь, эксперт)
		
  + Политики выплат
    - По должностям
    - По проектам и ролям
    - За стаж
    - Премиальные на Новый год, дни рождения, круглые даты в истории компании
		
3. Поддерживаемые операции

  + Получение списка служащих, в т.ч. по должностям, проектам, стажу, премированных и пр.
  + Получение истории участия в проектах и карьерной истории для служащего
  + Получение истории выплат для служащего
  + Назначение служащего на новую должность, добавление в/удаление из проекта
  + Добавление и удаление служащего, чтение и редактирование данных о нем
  + Добавление и удаление проекта, чтение и редактирование данных о нем
  + Добавление и удаление политик выплат, чтение и редактирование данных о них
	

