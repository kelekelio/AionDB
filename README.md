# AionDB

![alt text](https://aionpowerbook.com/spring/spring_readme.jpg)

Aion Database using Spring Boot.

Technologies used so far: Spring Boot, Thymeleaf, DataTables, Bootstrap

Done so far:

1. Multitenancy: Allowing to swicth between classic and live databased at runtime. Value stored as cookie. TODO: Create form to add ?server parameter to url witch radion buttn switch
2. Database l10n based localization support for the whole project. Allows #{STRING_NAME} to be used from any template.
3. GET APIs for items (ID), translations (NAME), and dungeons (full list). POST and DELETE APIs redundant. DB updated by external project.
5. Some item lists. TODO: add extra filters
6. Basic Dungeon list