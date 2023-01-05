package ru.geekbrains.lesson8;

import ru.geekbrains.lesson8.MVP.Models.BookingModel;
import ru.geekbrains.lesson8.MVP.Presenters.BookingPresenter;
import ru.geekbrains.lesson8.MVP.Views.BookingView;

import java.util.Date;

public class Sample01 {

    public static void main(String[] args) {
        BookingModel bookingModel = new BookingModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(bookingModel, bookingView);
        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        bookingView.reservationTable(new Date(), 3, "Станислав");
        bookingView.changeReservationTable(1, new Date(), 2, "Станислав");
    }

}
