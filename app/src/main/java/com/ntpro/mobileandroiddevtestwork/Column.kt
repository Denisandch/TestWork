package com.ntpro.mobileandroiddevtestwork

enum class Column(val columnName: String) {
    TIME_STAMP("Время сделки"),
    INSTRUMENT_NAME("Название инструмента"),
    PRICE("Цена сделки"),
    AMOUNT("Объем сделки"),
    SIDE("Тип сделки")
}