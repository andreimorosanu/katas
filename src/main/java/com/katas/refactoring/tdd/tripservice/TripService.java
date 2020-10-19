package com.katas.refactoring.tdd.tripservice;

import com.katas.refactoring.tdd.tripservice.model.Trip;
import com.katas.refactoring.tdd.tripservice.model.User;
import com.katas.refactoring.tdd.tripservice.model.UserNotLoggedInException;
import com.katas.refactoring.tdd.tripservice.model.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    public List<Trip> getGivenFriendsTrips(User user) throws UserNotLoggedInException {
        List<Trip> tripList = new ArrayList<Trip>();
        User loggedUser = getLoggedUser();

        validateUserLoggedIn(loggedUser);

        boolean isFriend = isFriend(user, loggedUser);
        
        if (isFriend) {
            tripList = findTripsForUser(user);
        }
        return tripList;

    }

    private boolean isFriend(User user, User loggedUser) {
        boolean isFriend = false;
        for (User friend : user.getFriends()) {
            if (friend.equals(loggedUser)) {
                isFriend = true;
                break;
            }
        }
        return isFriend;
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
