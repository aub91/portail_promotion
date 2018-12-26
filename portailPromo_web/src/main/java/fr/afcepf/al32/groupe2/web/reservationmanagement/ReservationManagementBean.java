package fr.afcepf.al32.groupe2.web.reservationmanagement;

import fr.afcepf.al32.groupe2.entity.Reservation;
import fr.afcepf.al32.groupe2.entity.Shopkeeper;
import fr.afcepf.al32.groupe2.service.IServiceReservation;
import fr.afcepf.al32.groupe2.web.connexion.ConnectionBean;
import fr.afcepf.al32.groupe2.ws.itf.IWsPromoTemplate;
import fr.afcepf.al32.groupe2.ws.wsPromoTemplate.dto.PromotionTemplateResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
@RequestScope
public class ReservationManagementBean {
    @Autowired
    private ConnectionBean connectionBean;

    @Autowired
    private IServiceReservation serviceReservation;

    private List<Reservation> reservationList;

    private String withDrawalCode;

    public String validateReservation(Reservation reservation){
        if(reservation.getWithdrawalCode().equals(withDrawalCode)){
            reservation.getReservationProduct().setWithdrawalDate(new Date());
            serviceReservation.update(reservation);
        }
        withDrawalCode = null;
        return "commercant/gererReservationCommercant/gererReservation";
    }

    public List<Reservation> getReservationList() {
        Shopkeeper shopkeeper = (Shopkeeper) connectionBean.getLoggedUser();

        return serviceReservation.findAllByShopKeeper(shopkeeper).stream().sorted(Comparator.comparing(Reservation::getDateCreation)).collect(Collectors.toList());
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public String getWithDrawalCode() {
        return withDrawalCode;
    }

    public void setWithDrawalCode(String withDrawalCode) {
        this.withDrawalCode = withDrawalCode;
    }
}
