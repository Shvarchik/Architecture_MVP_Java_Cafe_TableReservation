package ru.geekbrains.lesson8.MVP.Presenters;

import ru.geekbrains.lesson8.MVP.Models.Table;

import java.util.Collection;

public interface View {
    void showTables(Collection<Table> tables);

    void setObserver(ViewObserver observer);

    void printReservationTableResult(int reservationNo);
    void printReservationRemoveResult(int reservationNo);
}
