package com.katas.refactoring.tdd.tripservice;

import com.katas.refactoring.tdd.tripservice.model.CollaboratorCallException;
import com.katas.refactoring.tdd.tripservice.model.Trip;
import com.katas.refactoring.tdd.tripservice.model.User;

import java.util.List;

public class TripDAO {

    public static List<Trip> findTripsByUser(User user) {
        throw new CollaboratorCallException(
                "TripDAO should not be invoked on an unit test.");
    }
}
