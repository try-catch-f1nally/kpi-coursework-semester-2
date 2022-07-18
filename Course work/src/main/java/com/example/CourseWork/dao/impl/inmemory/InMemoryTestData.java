package com.example.CourseWork.dao.impl.inmemory;

import com.example.CourseWork.model.Finding;
import com.example.CourseWork.model.User;

import java.util.Arrays;

public class InMemoryTestData {

    public static void generateTo(InMemoryDatabase database) {
        database.findings.clear();
        database.users.clear();

        User nastya = new User(1, "Настя", "nastya@example.com", "passwordhash");
        User borys = new User(2, "Борис", "boryska777@example.com", "passwordhash");
        User andriy = new User(3, "Андрій", "andriy_chered@example.com", "passwordhash");
        User diana = new User(4, "Діана", "dianka120401@example.com", "passwordhash");
        User max = new User(5, "Максим", "max@example.com", "passwordhash");
        Arrays.asList(nastya, borys, andriy, diana, max).forEach(user -> database.users.put(user.getUserId(), user));

        Finding backpack = new Finding(1, "Рюкзак Nike сірий", "Знайшла на вул.Парниковій 22, район Крошня. Всередині спортивна форма, пляшка з водою.",
                Arrays.asList("рюкзак", "сірий", "крошня", "nike"), "0971234567", nastya);
        Finding samsung = new Finding(2, "Samsung galaxy A10 чорний", "Був знайдений 28.05 біля магазину \"АТБ\" на Богунії. На екрані поклеєне розби",
                Arrays.asList("Samsung", "самсунг", "Богунія", "чорний"), "borys@example.com", borys);
        Finding airpods = new Finding(3, "Apple AirPods 2020", "Знайдені бездротові навушники airpods у червоному чохлі. Хтось залишив на лавці на Малікова",
                Arrays.asList("airpods", "apple", "tws", "навушники", "малікова", "червоний"), "0987654321", nastya);
        Finding bag = new Finding(4, "Сумка \"Guess\" рожева з ланцюжком", "Сумка залишена на задньому сидінні автобуса маршруту 110. Всередині гаманець, косметичка, дзеркальце та інші речі.",
                Arrays.asList("сумка", "guess", "рожевий", "ланцюжок", "автобус"), "0738473294", andriy);
        Finding passport = new Finding(5, "Паспорт Іванова Івана Івановича", "Знайшов біля Богунського районного суда на землі. Віддам при підтвердженні особистості іншими документами.",
                Arrays.asList("паспорт", "документи", "центр"), "diana@example.com", diana);
        Finding bankCard = new Finding(6, "Банківська картка monobank", "Хтось забув вийняти з банкомату на вул.Грушевського. Віддам власнику який зможе назвати останні чотири цифри 4441 1144 4123 **** та CVC код",
                Arrays.asList("monobank", "банк", "картка", "гроші", "центр"), "max@example.com", max);
        Finding autoKey = new Finding(7, "Ключі від автомобіля Ford Fiesta", "Знайшов в гідропарку біля кіоску с морозивом",
                Arrays.asList("ключі", "авто", "ford", "гідропарк", "корбутівка"), "0682736501", borys);
        Arrays.asList(backpack, samsung, airpods, bag, passport, bankCard, autoKey).
                forEach(finding -> database.findings.put(finding.getFindingId(), finding));

        nastya.getListOfFindings().addAll(Arrays.asList(backpack, airpods));
        borys.getListOfFindings().addAll(Arrays.asList(samsung, autoKey));
        andriy.getListOfFindings().addAll(Arrays.asList(bag));
        diana.getListOfFindings().addAll(Arrays.asList(passport));
        max.getListOfFindings().addAll(Arrays.asList(bankCard));
    }
}
