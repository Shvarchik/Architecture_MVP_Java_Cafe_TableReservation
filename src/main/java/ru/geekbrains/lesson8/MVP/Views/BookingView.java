package ru.geekbrains.lesson8.MVP.Views;

import ru.geekbrains.lesson8.MVP.Models.Table;
import ru.geekbrains.lesson8.MVP.Presenters.View;
import ru.geekbrains.lesson8.MVP.Presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {


    private ViewObserver observer;

    public void showTables(Collection<Table> tables){
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void printReservationTableResult(int reservationNo) {
        System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d", reservationNo);
        System.out.println();
    }


    /**
     * СОБЫТИЕ: Пользователь нажал на кнопку бронирования
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     */
    public void reservationTable(Date reservationDate, int tableNo, String name){
        observer.onReservationTable(reservationDate, tableNo, name);
    }

    /**
     * СОБЫТИЕ: Пользователь нажал на кнопку изменить бронирование
     * @param oldReservation
     * @param reservationDate
     * @param tableNo
     * @param name
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        try {observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printReservationRemoveResult(int reservationNo) {
        System.out.println(String.format("Резерв №%d отменен", reservationNo));
    }




}
