package Taxi.dao;

import Taxi.domain.Clients;

import java.util.List;

/**
 * Created by ${BIM} on 28.07.2016.
 */
public interface ClientsDao {
    List<Clients> findAll();
    Integer createClient(Clients clients);
}
