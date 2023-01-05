package ru.geekbrains.lesson8.MVP.Presenters;

import ru.geekbrains.lesson8.MVP.Models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();
    int reservationTable(Date reservationDate, int tableNo, String name);
    boolean removeReservation (int reservationNo);
    int changeReservationTable (int oldReservation, Date reservationDate, int tableNo, String name);
}
