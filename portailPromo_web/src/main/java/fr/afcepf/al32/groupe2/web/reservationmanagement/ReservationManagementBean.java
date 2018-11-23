package fr.afcepf.al32.groupe2.web.reservationmanagement;

import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Reservation;
import fr.afcepf.al32.groupe2.entity.Shopkeeper;
import fr.afcepf.al32.groupe2.service.IServiceReservation;
import fr.afcepf.al32.groupe2.web.connexion.ConnectionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
@RequestScope
public class ReservationManagementBean {
    @Autowired
    private ConnectionBean connectionBean;

    @Autowired
    private IServiceReservation serviceReservation;

    private List<Reservation> bookList;

    public List<Reservation> getBookList() {
        Shopkeeper shopkeeper = (Shopkeeper) connectionBean.getLoggedUser();

//        return serviceReservation.findAllByShopKeeper(shopkeeper);
        return null;
    }

    public void setBookList(List<Reservation> bookList) {
        this.bookList = bookList;
    }
}
