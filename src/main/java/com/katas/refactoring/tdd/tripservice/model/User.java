package com.katas.refactoring.tdd.tripservice.model;

import java.util.List;

public class User {

    private List<Trip> trips;
    private List<User> friends;

    public List<User> getFriends() {
        return friends;
    }


    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
