package com.katas.refactoring.tdd.tripservice;

import com.katas.refactoring.tdd.tripservice.model.Trip;
import com.katas.refactoring.tdd.tripservice.model.User;
import com.katas.refactoring.tdd.tripservice.model.UserNotLoggedInException;
import com.katas.refactoring.tdd.tripservice.model.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    public List<Trip> getGivenFriendsTrips(User user) throws UserNotLoggedInException {

        User loggedUser = getLoggedUser();

        validateUserLoggedIn(loggedUser);

        boolean isFriend = user.isFriendWith(loggedUser);

        if (isFriend) {
            return findTripsForUser(user);
        }
        return new ArrayList<>();

    }

    private void validateUserLoggedIn(User loggedUser) {
        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }
    }


    protected List<Trip> findTripsForUser(User user) {
        return TripDAO.findTripsByUser(user);
    }

    protected User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }
}
