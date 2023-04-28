package com.example.javateambot.service;

import com.example.javateambot.entity.Users;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Service
public class TelegramCatService {

    public TelegramCatService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }


    //КОНСУЛЬТАЦИЯ С НОВЫМ ПОЛЬЗОВАТЕЛЕМ
    private static final String NAME_OF_SCHELTER = "The Best Shelter";

    /**
     * Метод, который выводит приветственное сообщение и предлагает выбрать дальнейшие действия
     * @param chatId
     */
    private final TelegramBot telegramBot;
    public void sendWelcomeMessage(Long chatId) {
        String message = "Добрый день! Приветствуем Вас в приюте для животных \"" + NAME_OF_SCHELTER + "\".\n" +
                "Выберите пожалуйста, что Вас интересует:\n" +
                "1. Я впервые здесь и хочу узнать больше о приюте.\n" +
                "2. Я уже обращался(-лась) к Вам и хочу получить информацию о животном, которое ранее было у меня.\n" +
                "3. Я хочу отправить отчет о животном, которое я взял(-а) в этом приюте ранее.";
        telegramBot.execute(new SendMessage(chatId, message));
    }

    /**
     * Метод для пользователя, который впервые в нашем приюте.
     * Метод предлагает выбрать дальнейшие действия.
     */
    public void sendFirstTimeMessage(Long chatId) {
        String message = "Что Вам подсказать:\n" +
                "Рассказать о приюте\n" +
                "Выдать расписание работы приюта и адрес, схему проезда\n" +
                "Выдать общие рекомендации о технике безопасности на территории приюта\n" +
                "Оставить контактные данные, чтобы мы связались с Вами\n" +
                "Позвать оператора";
        telegramBot.execute(new SendMessage(chatId, message));
    }

    /**
     * Бот рассказывает о приюте.
     * @return информация о приюте
     */
    public String descriptionOfShelter() {
        return  "Наш приют " + NAME_OF_SCHELTER + " — это приют для собак и кошек, в котором волонтеры следят за " +
                         "здоровьем животных, выгуливают их, ухаживают за ними, а также помогают найти им новый дом";

    }

    /**
     * Бот выдаёт расписание работы приюта и адрес, схему проезда.
     * @return расписание работы приюта и адрес, схему проезда
     */
    public String infoAboutShelter() {
        return "Наш приют находится по адресу: г.Москва, 5112-й Проектируемый пр-д, стр. 1-3, 109383.\n" +
                "Как добраться: От метро Печатники идёт маршрутка № 438 до остановки «Батюнинский проезд» " +
                "(конечная). Оттуда 10 минут пешком до нашего приюта.\n" +
                "Режим работы: пн-пт с 9:00 до 21:00; сб, вс - выходные";
    }

    /**
     * Бот выдаёт общие рекомендации о технике безопасности на территории приюта.
     * @return общие рекомендации о технике безопасности на территории приюта
     */
    public String safetyRecommendations() {
        return "Обязательно предупреждайте о приезде в наш приют - без сопровождения волонтёра вас не пустят на территорию приюта.\n" +
                "Всех гостей встречает и сопровождает один из наших волонтёров.\n" +
                "Мы очень рады вашим визитам, поэтому сделаем всё, чтобы у вас не возникло проблем на проходной.\n" +
                "Администрация просит нас сообщать, что приедут гости и в каком количестве, так что лучше договориться о визите заранее.";
    }

    /**
     * Бот принимает и записывает контактные данные для связи.
     * @param firstName имя
     * @param lastName фамилия
     * @param numberUser номер телефона
     * @return записанные контактные данные для связи
     */
    public String recordingContactData(String firstName, String lastName, String numberUser) {
        Users newUser = new Users();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setNumberUser(numberUser);
//        userRepository.save(newUser);
        return firstName + " " + lastName + ", Ваш номер телефона " + numberUser + " записан";
    }

    /**
     * Метод зовет оператора, если бот не может ответить на вопросы клиента
     * @return текст, уведомляющий о том, что боту нужна помощь оператора
     */
    public String callVolunteer() {
        return "К сожалению, я не могу помочь Вам в решении вопроса. Сейчас Вам ответит оператор.";
    }


    //КОНСУЛЬТАЦИЯ С ПОТЕНЦИАЛЬНЫМ ХОЗЯИНОМ
    /**
     * Метод для потенциального хозяина животного.
     * Метод предлагает выбрать дальнейшие действия.
     */
    public void sendRulesAndDocsMessage(Long chatId) {
        String message = "Что Вам подсказать:\n" +
                "1. Правила знакомства с котом до того, как можно забрать ее из приюта\n" +
                "2. Список документов, необходимый, чтобы забрать питомца\n" +
                "3. Список рекомендаций по транспортировке животного\n" +
                "4. Список рекомендаций по обустройству дома для котенка\n" +
                "5. список рекомендаций по обустройству дома для кота" +
                "6. Список рекомендаций по обустройству дома для кота с ограниченными возможностями\n" +
                "7. Советы кинолога по первичному общению с котом\n" +
                "8. Рекомендации по проверенным кинологам для дальнейшего обращения к ним\n" +
                "9. Список причин, почему могут отказать и не дать забрать кота из приюта\n" +
                "10. Изменить контактные данные\n" +
                "11. Позвать оператора";
        telegramBot.execute(new SendMessage(chatId, message));
    }

    /**
     * Бот выдаёт правила знакомства с котом до того, как можно забрать ее из приюта.
     * @return правила знакомства с котом
     */
    public String rulesForDating() {
        return " Правила знакомства с котом:\n" +
                "1. Дайте коту время на адаптацию: Не пытайтесь сразу потискать кота или гладить его, дайте ему самому решать, когда он будет готов подойти к вам.\n"+
                "2. Говорите спокойно и мягко: Используйте мягкий тон голоса, чтобы кот чувствовал себя более комфортно\n." +
                "3. Используйте привлекательные запахи: Привлеките внимание кота с помощью запахов, которые ему нравятся, например, котовой мяты или кошачьей мочи.\n" +
                "4. Не пугайте кота: Избегайте громких звуков, быстрых движений и других факторов, которые могут испугать кота\n" +
                "5. Предложите еду: Коты обожают еду, поэтому можно предложить ему лакомство, чтобы привлечь его внимание.  \n"+
                "6. Дайте коту возможность исследовать: Коты любят исследовать новые места, поэтому дайте ему возможность ознакомиться с вашим домом или квартирой \n";
    }

    /**
     * Бот выдаёт список документов, необходимых для того, чтобы взять кота из приюта.
     * @return список документов, необходимых для того, чтобы взять кота из приюта
     */
    public String listOfDocuments() {
        return "Чтобы забрать кота из приюта необходимо приготовить следующий пакет документов:\n" +
                "1. Паспорт или иной документ, удостоверяющий личность.\n" +
                "\n" +
                "2. Документ, подтверждающий право собственности на жилье (квартиру или дом),в котором будет проживать животное. Это может быть, например,копия свидетельства о праве собственности или договор аренды жилья.\n" +
                "\n" +
                "3. Документ, подтверждающий финансовую способность содержать ,кошку-кота.Это может быть выписка из банка или трудовой договор, который подтверждает достаточный уровень дохода.\n" +
                "\n" +
                "4.Заполненная анкета на усыновление животного из приюта.\n" +
                "\n" +
                "5. Справка от ветеринара об отсутствии заболеваний, которые могут передаваться на других животных.\n" +
                "\n" +
                "6. Подписанный договор на усыновление кота из приюта, который подписывается между приютом и новым владельцем животного";
    }

    /**
     * Бот может выдать список рекомендаций по транспортировке животного.
     * @return список рекомендаций по транспортировке животного
     */
    public String recommendationsForTransportation() {
        return "Для комфортной транспортировки животного необходимо:\n" +
                "\n" +
                "1.Подходящий контейнер: животное должно находиться в контейнере, который соответствует его размеру,весу и виду. Контейнер должен быть достаточно прочным,и достаточно вентилируемым,чтобы обеспечить животному достаточный доступ к свежему воздуху.\n" +
                "\n" +
                "2. Безопасность: контейнер должен быть безопасным для животного.Для этого необходимо убедиться, что в контейнере нет острых предметов или других опасных предметов,которые могут нанести вред животному.\n" +
                "\n" +
                "3. Комфорт: животное должно находиться в комфортных условиях.Необходимо обеспечить достаточный доступ к воде и пище,а также мягкую подстилку или коврик для обеспечения комфорта животному во время транспортировки.\n";
    }

    /**
     * Бот выдает список рекомендаций по обустройству дома для котенка.
     * @return список рекомендаций по обустройству дома для котенка
     */
    public String homeImprovementForPuppy() {
        return "Для обустройства дома котенка необходимо:\n" +
                "1. Кормушка и миски для воды: убедитесь, что у котенка есть доступ к свежей воде и питательной пище. Расположите кормушку и миски для воды в удобном месте, которое котенок сможет легко найти\n" +
                "\n" +
                "2. Лоток: необходимо обеспечить котенку место для естественных нужд. Купите лоток, который подходит для размера котенка, и разместите его в тихом месте дома\n" +
                "\n" +
                "3. Игрушки: котята любят играть и исследовать окружающий мир. Купите несколько игрушек, чтобы помочь им заняться их любимыми играми.\n" +
                "\n" +
                "4. Когтеточка: котенок будет царапать, поэтому купите когтеточку, чтобы предоставить ему место для точения когтей.\n" +
                "\n" +
                "5. Уборка: убедитесь, что дом чист и безопасен для котенка. Уберите все опасные предметы, которые могут навредить котенку, и держите дом в чистоте.\n" +
                "\n" +
                "6. Место для отдыха: обеспечьте котенку место для отдыха, где он может чувствовать себя комфортно. Это может быть корзина или кровать для котов.\n" +
                "\n" +
                "7. Проверьте окна и двери: убедитесь, что окна и двери защищены, чтобы котенок не мог убежать на улицу или не попал в опасную ситуацию.\n" +
                "\n" +
                "8. Посетите ветеринара: необходимо проконсультироваться с ветеринаром и убедиться, что котенок здоров и получил все необходимые прививки."
                ;
    }

    /**
     * Бот может выдать список рекомендаций по обустройству дома для взрослой собаки.
     * @return список рекомендаций по обустройству дома для взрослой собаки
     */
    public String homeImprovementForAdultDog() {
        return "Для обустройства дома взрослого кота необходимо:\n" +
                "1. Кормушка и миски для воды: убедитесь, что у кота есть доступ к свежей воде и питательной пище. Расположите кормушку и миски для воды в удобном месте, которое кота сможет легко найти\n" +
                "\n" +
                "2. Лоток: необходимо обеспечить кота место для естественных нужд. Купите лоток, который подходит для размера кота, и разместите его в тихом месте дома\n" +
                "\n" +
                "3. Игрушки: кошки любят играть и исследовать окружающий мир. Купите несколько игрушек, чтобы помочь им заняться их любимыми играми.\n" +
                "\n" +
                "4. Когтеточка: кот будет царапать, поэтому купите когтеточку, чтобы предоставить ему место для точения когтей.\n" +
                "\n" +
                "5. Уборка: убедитесь, что дом чист и безопасен для кота. Уберите все опасные предметы, которые могут навредить коту, и держите дом в чистоте.\n" +
                "\n" +
                "6. Место для отдыха: обеспечьте коту место для отдыха, где он может чувствовать себя комфортно. Это может быть корзина или кровать для котов.\n" +
                "\n" +
                "7. Проверьте окна и двери: убедитесь, что окна и двери защищены, чтобы кот не мог убежать на улицу или не попал в опасную ситуацию.\n" +
                "\n" +
                "8. Посетите ветеринара: необходимо проконсультироваться с ветеринаром и убедиться, что котенок здоров и получил все необходимые прививки."
                ;
    }

    /**
     * Бот выдаёт список рекомендаций по обустройству дома для собаки с ограниченными возможностями.
     * @return список рекомендаций по обустройству дома для собаки с ограниченными возможностями
     */
    public String homeImprovementForDogWithDisabilities() {
        return "Для обустройства дома кота с ограниченными возможностями необходимо:\n" +
                "* Обеспечить безопасность. Убедитесь, что дом не содержит ничего, что может представлять опасность для кота, особенно если она имеет проблемы с движением. Убедитесь, что нет лестниц, выступающих предметов, острых углов и т.д.\n" +
                             "\n" +
                "* Создать комфортное место для отдыха. Убедитесь, что у кота есть место, где она может отдохнуть и поспать. Это может быть мягкое место на полу, подушка или кровать для кота.\n"+
                            "\n"+
                "* Изучить диету кота. Если у кота есть проблемы со здоровьем, возможно, ей понадобится специальная диета. Обсудите это со своим ветеринаром.\\n\" +\n" +
                            "\n" +
                "* Разработать программу занятий. Если у кота есть ограничения в движении, возможно, ей потребуется специальная программа занятий, которая поможет ей оставаться активной и здоровой. Обсудите это со своим ветеринаром или тренером по собакам.\\n\" +\n" +
                            "\n" +
                "* Обеспечить доступ к питьевой воде и корму. Убедитесь, что у кота всегда есть доступ к свежей питьевой воде и корму.\\n\" +\n" +
                               "\n" +
                "* Обеспечить необходимую медицинскую помощь. Если у кота есть физические проблемы, ей может потребоваться дополнительная медицинская помощь, например, регулярные посещения ветеринара, лекарства и т.д. Следуйте рекомендациям ветеринара.\\n\" +\n" +
                               "\n" +
                "* Обеспечить удобную среду обитания. Обеспечьте достаточное количество места для движения кота внутри дома,\n" +
                               "\n" +
                "* Регулярно проводить гигиенические процедуры. Убедитесь, что вы регулярно чистите место, где живет кот, и занимаетесь ее гигиеной \n" ;
    }

    /**
     * Бот выдаёт советы кинолога по первичному общению с собакой.
     * @return советы кинолога по первичному общению с собакой
     */
    public String TipsFromDogHandler() {
        return "Зоопсихологи рекомендуют рекоммендуют:\n" +
                "1. Учитесь понимать язык тела кошек. Кошки выражают свои чувства и намерения через позы тела, мимику и мяуканье. Изучите их язык тела, чтобы понимать, когда они рады, когда находятся в напряжении или страхе." +
                "                \n" +
                "2. Будьте терпеливы и почитайте кошку. Некоторые кошки нуждаются в большем времени, чтобы привыкнуть к новым людям и среде. Дайте им время, чтобы они могли исследовать свою новую окружающую среду и подойти к вам, когда они будут готовы.\n" +
                "                \n" +
                "3. Не используйте физическую силу. Кошки не реагируют на физическое наказание и могут стать защитнически настроенными, если их обижают. Вместо этого используйте положительное подкрепление, такое как лакомства и игрушки, чтобы поощрять желаемое поведение.\n" +
                "                \n" +
                "4. Учитесь играть с кошками. Кошки любят играть, и игры могут помочь им заняться физической активностью и укрепить связь между вами и вашей кошкой.\n" +
                "                \n" +
                "5. Оставайтесь спокойными и уверенными. Кошки чувствуют эмоции своих владельцев и могут стать напряженными, если вы волнуетесь или беспокоитесь. Постарайтесь оставаться спокойными и уверенными во время общения с вашей кошкой.\n" +
                "                \n" +
                "Помните, что каждая кошка уникальна и может иметь свои собственные предпочтения и потребности. Общение с вашей кошкой должно быть индивидуальным и адаптированным к ее потребностям и характеру.";
    }

    /**
     * Бот выдаёт рекомендации по проверенным кинологам для дальнейшего обращения к ним.
     * @return рекомендации по проверенным кинологам
     */
    public String InfoAboutDogHandler() {
        return "Рекомендуем кинологов:\n" +
                "1. Ирина Петрова. Опыт работы 5 лет.\n"+
                "Специализации:Грумер.Контакты +7-913-334-93-23\n" +
                "                \n" +
                "2. Владислава. Опыт работы 8 лет\n" +
                "Специализации: зоотехния, специализация – кинология,\n" +
                "Контакты +7-913-334-93-23\n" +
                "                \n" +
                "3. Илья Игоревич. Опыт работы 2 года\n" +
                "Специализации: кинолог, кликер-дрессировка," +
                "Контакты +7-913-334-93-23";
    }

    /**
     * Бот выдаёт список причин, почему могут отказать и не дать забрать кошку из приюта.
     * @return список причин, почему могут отказать и не дать забрать кошку из приюта
     */
    public String ReasonsForRefusal() {
        return "Причины отказа:\n" +
                "* Несоответствие требованиям: Например,  могут потребовать от вас доказательства того,что вы живете в доме с огороженным двором, чтобы собака не убежала. Или же, может быть, не разрешают выдачу животных людям, которые ранее были лишены права на содержание животных.\n" +
                                "\n" +
                "* Несоответствие характера собаки: Некоторые собаки могут иметь поведенческие проблемы,такие как агрессивность или страх, и приют может не считать вас подходящим владельцем для данного животного.\n" +
                "\n" +
                "* Приют может также не выдавать животных людям, которые не имеют опыта владения животными или не могут предоставить достаточное количество времени и внимания для ухода за собакой.\n" +
                               "\n" +
                "* Ограниченный запас: Если приют не имеет достаточного количества кошек-котов или если они имеют очень высокий спрос, они могут отказать вам в выдаче кошек-котов.";
    }

    //ВЕДЕНИЕ ПИТОМЦА
    /**
     * Метод, который принимает отчет от хозяина питомца
     * @param text описание состояния животного: рацион животного, общее самочувствие и привыкание к новому месту, изменение в поведении*
     * @param photo фото животного
     * @return текст о принятии/непринятии отчета
     */
    public String getReport(String text, MultipartFile photo) {
        if (text != null && photo != null) {
            //загрузить фото и текст в базу animals, а также установить сегодняшнюю дату отчетности
            return "Отчет принят";
        }
        if (text == null) {
            return "Загрузите текст!";
        }
        if (photo == null) {
            return "Загрузите фото!";
        }
        return "";
    }

    /**
     * Метод, который проверяет дату последнего отчета.
     * Если отчета не было более 2х дней, высылает напоминание
     * @param idAnimal ID животного
     * @param lastReportDate дата последней отчетности
     */
    public void reminderAboutReport(long idAnimal, LocalDate lastReportDate) {
        //сравниваем дату отчета и сегодняшнюю, если больше 2, то отправляем напоминание
    }

    /**
     * Метод, который проверяет закончился ли испытательный период.
     * Если испытательный период окончен - направляет поздравления.
     * @param idAnimal ID животного
     * @param lastDateProbationReriod дата окончания испытательного срока
     */
    public void probationPeriodPassed(long idAnimal, LocalDate lastDateProbationReriod) {
        //сравниваем дату окончания испыт.срока и сегодняшнюю, если больше, то поздравляем
    }

    /**
     * Метод, который позволяет увеличить испытательный срок.
     * Уведомляет об увеличении испытательного срока хозяина животного.
     * @param idAnimal ID животного
     * @param numberOfDays количество дней, на которое будет увеличен испытательный срок
     * @return новую дату окончания испытательного срока
     */
    public LocalDate probationPeriodExtended(long idAnimal, int numberOfDays) {
        //прибавляем к испыт.сроку кол-во дней и уведомляем об этом по номеру владельца
        LocalDate newLastDateProbationReriod = null; //ЗАМЕНИТЬ: вместо null по ID животного находим дату окончания испыт.срока
        return newLastDateProbationReriod;
    }

    /**
     * Метод, который уведомляем, что испытательныйсрок не пройден и необходимо обратиться лично к администрации за дальнейшей инструкцией
     * @param idAnimal ID животного
     */
    public void probationPeriodNotPassed(long idAnimal) {
        //уведомляем, что испыт.срок не пройден и необходимо обратиться лично к администрации за дальнейшей инструкцией
    }

    /**
     * Метод, который будет отправлять сообщения
     * @param chatId ID пользователя
     * @param s текст отправки
     */
    public void sendMessage(Long chatId, String s) {
    }

}



