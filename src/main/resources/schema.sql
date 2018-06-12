use test;

DROP TABLE IF EXISTS book;

CREATE TABLE  book  (
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   title VARCHAR(100) NOT NULL,
   description VARCHAR(255) NOT NULL,
   author VARCHAR(150) NOT NULL,
   isbn VARCHAR(20) NOT NULL,
   printYear INT(10) NOT NULL,
   readAlready BIT NOT NULL
   )

ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci;


INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Как раскрутить блог в Instagram", "-", "Аліона Хільт", "978-5-17-983111-2", 2018, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Linux глазами хакера", "-", "Михаил Фленов", "978-5-9775-3333-1", 2014, true);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Homo Deus. Людина божественна. За лаштунками майбутнього", "-", "Юваль Ной Харари", "978-617-7559-40-4", 2018, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Приручи своих драконов", "-", "Хосе Стивенс", "978-5-4461-0697-4", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Building Blockchain Projects", "-", "Нараян Прасті", "978-5-9775-3976-0", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Unity в действии", "-", "Джозеф Гокінґ", "978-5-4461-0854-1", 2017, true);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Майнкрафт. Только факты", "-", "Эгмонт Россия Лтд", "978-5-4471-3963-6", 2014, true);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Важкі рішення", "-", "Хиллари Родэм Клинтон", "978-617-7279-29-6", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Микросервисы на платформе .NET", "-", "Крістіан Хорсдал", "978-5-496-03221-6", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("The Question. Будущее", "-", "Макс Фрай, Людмила Улицкая, Александр Невзоров, Демьян Кудрявцев, Евгений Водолазкин", "978-5-17-099358-1", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("О добрых и недобрых лицах, любви и границах", "-", "Анна Федосова", "978-5-9614-6615-7", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Фріланс на західному ринку", "-", "Роман Стоянович", "978-617-7535-43-9", 2017, true);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Continuous delivery", "-", "Еберхард Вольф", "978-5-4461-0480-2", 2015, true);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Будущее вещей. Как сказка и фантастика становятся реальностью", "-", "Дэвид Роуз", "978-5-91671-843-0", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Виртуальные миллиарды", "-", "Ерік Гейсінгер", "978-966-415-060-6", 2015, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Биткоин. Графический роман о криптовалюте", "-", "Хосе Анхель Арес, Жозеп Бускет, Алекс Преукшат", "978-5-699-98500-5", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Ілюзія знання. Чому ми ніколи не думаємо на самоті", "-", "Стивен Сломан, Филип Фернбах", "978-617-7544-04-2", 2018, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Игры, в которые играют люди", "-", "Эрик Берн", "978-5-04-090530-0", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Регулярные выражения за 10 минут", "-", "Бен Форта", "978-5-8459-2133-8", 2016, true);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Создаем нейронную сеть", "-", "Тарік Рашид", "978-5-9909445-7-2", 2017, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Бложе мой", "-", "Артемій Лєбєдєв", "978-5-98062-096-7", 2017, true);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Квантовая магия", "-", "Сергей Доронин", "978-9573-0844-7", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Вид сверху. Потрясающие снимки Земли со спутников", "-", "Бенджамин Грант", "978-5-9614-6615-7", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Сила уверенности в себе", "-", "Брайан Трейси", "978-985-15-3322-6", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Достаточно ли вы умны, чтобы работать в Google?", "-", "Уильям Паундстоун", "978-5-00074-194-8", 2016, true);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Секреты JavaScript ниндзя", "-", "Джон Резиг", "978-5-9908911-8-0", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Google Android. Программирование для мобильных устройств", "-", "Олексій Голощапов", "978-5-9775-0729-5", 2012, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Экстремальное программирование. Разработка через тестирование", "-", "Кент Бек", "978-5-496-025706", 2016, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Чистилище. Финал", "-", "Сергей Тармашев", "978-5-17-092806-4", 2017, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Почему Вселенная не может существовать без Бога?", "-", "Дипак Чопра", "978-5-17-089358-4", 2015, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Играть, чтобы жить. Книга 2. Клан", "-", "Дмитрий Рус", "978-5-699-66752-9", 2013, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Достаточно ли мы умны, чтобы судить об уме животных?", "-", "Франс Де Вааль", "978-5-91671-617-7", 2017, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Путеводитель по лжи", "-", "Дэниел Левитин", "978-5-00100-840-8", 2017, false);

INSERT INTO Book (title, description, author, isbn, printYear, readAlready)
VALUES ("Главный рубильник", "-", "Тим Ву", "978-5-91657-532-3", 2014, false);
