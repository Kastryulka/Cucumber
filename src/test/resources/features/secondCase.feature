# language: ru
# encoding: utf-8

Функция: Второй кейс

  Предыстория:
    Дано Открыта страница "Стартовая страница сайта DNS"

  @firstStep
  Сценарий: Проверка отображения ссылок в меню Бытовая техника
    Когда Курсор наведен на ссылку "Бытовая техника"
    Тогда Проверка: отображаются ссылки
      | Техника для кухни    |
      | Техника для дома     |
      | Встраиваемая техника |

  @secondStep
  Сценарий: Проверка количества ссылок в подменю Приготовление пищи
    Когда Курсор наведен на ссылку "Бытовая техника"
    Когда Курсор наведен на ссылку "Плиты и печи"
    Тогда Проверка: в подменю отображается больше 5 ссылок

  @thirdStep
  Сценарий: Проверка отображения количества товаров на странице Плиты электрические
    Когда Курсор наведен на ссылку "Бытовая техника"
    И Выполнен переход на страницу "Плиты и печи"
    Когда Открыта страница "Плиты и печи"
    И Выполнен переход на страницу "Плиты электрические"
    Когда Открыта страница "Плиты электрические"
    Тогда Проверка: в тексте заголовка отображается количество товаров больше 100