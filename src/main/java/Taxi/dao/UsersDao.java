package Taxi.dao;

import Taxi.domain.Users;

import java.util.List;

/**
 * Created by ${BIM} on 02.09.2016.
 */
public interface UsersDao {
    List<Users> findAll();
}
