package com.usa.doctorsapp.repository.crudrepository;

import com.usa.doctorsapp.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    public List<Reservation> findAllByStatus(String status);
    public List<Reservation> findAllByStartDateAfterAAndStartDateBefore(Date dateOne, Date dateTwo);
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT (c.client) desc")
    public List<Object[]> countTotalReservationByClient();
    }

