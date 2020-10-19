package com.katas.refactoring.tdd.tripservice;


import com.katas.refactoring.tdd.tripservice.model.Trip;
import com.katas.refactoring.tdd.tripservice.model.User;
import com.katas.refactoring.tdd.tripservice.model.UserNotLoggedInException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TripServiceShould {

    private static final User NOT_LOGGED_USER = new User();

    private List<Trip> trips;

    private User loggedUser = new User();
    private User friend = new User();
    private User nonFriend = new User();

    private TripService tripService;

    @Test
    public void throwExceptionWhenUserNoLoggedIn() {
        //setup
        loggedUser = null;
        tripService = createTripService();

        //execute
        assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(NOT_LOGGED_USER));
    }

    @Test
    public void notReturnTripsWhenLoggedUserIsNotAFriend() {
        //setup
        tripService = createTripService();
        nonFriend.setTrips(asList(new Trip()));
        nonFriend.setFriends(asList(new User()));

        //execute
        List<Trip> trips = tripService.getTripsByUser(nonFriend);
        assertEquals(0, trips.size());
    }

    @Test
    public void returnTripsIfUserFriendsWithLoggedUser() {
        //setup
        tripService = createTripService();
        loggedUser.setTrips(asList(new Trip()));

        friend.setTrips(asList(new Trip(), new Trip()));
        friend.setFriends(asList(loggedUser));

        //execute
        List<Trip> trips = tripService.getTripsByUser(friend);
        assertEquals(2, trips.size());
    }


    private TripService createTripService() {
        return new TripService() {

            @Override
            protected List<Trip> findTripsForUser(User user) {
                return user.getTrips();
            }

            @Override
            protected User getLoggedUser() {
                return loggedUser;
            }
        };
    }

}