package ru.geekbrains.lesson8.MVP.Models;

import ru.geekbrains.lesson8.MVP.Presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class BookingModel implements Model {

    private Collection<Table> tables;

    public Collection<Table> loadTables(){
        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    public int reservationTable(Date reservationDate, int tableNo, String name) throws RuntimeException {
        Optional<Table> table = tables.stream().filter(t -> t.getNo() == tableNo).findFirst();
        if (table.isPresent()){
            //TODO: Проверка даты и времени резерва ..
            Reservation reservation = new Reservation(reservationDate, name);
            table.get().getReservations().add(reservation);
            return reservation.getId();
        }
        throw new RuntimeException("Некорректный номер столика.");
    }

    public boolean removeReservation (int reservationNo){
        for (Table table : tables) {
            for (Reservation reserv : table.getReservations()) {
                if (reserv.getId() == reservationNo){
                    table.getReservations().remove(reserv);
                    return true;
                }
            }
        }
        return false;
    }

    public int changeReservationTable (int oldReservation, Date reservationDate, int tableNo, String name) throws RuntimeException {
        if (removeReservation(oldReservation)){
            return reservationTable(reservationDate, tableNo, name);
        }
        throw new RuntimeException("Бронирование с таким номером не существует");
    }


}
