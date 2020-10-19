package com.katas.refactoring.tdd.tripservice.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Trip> trips;
    private List<User> friends = new ArrayList<>();

    public List<User> getFriends() {
        return friends;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public boolean isFriendWith(User user) {
        boolean isFriend = false;
        for (User friend : this.getFriends()) {
            if (friend.equals(user)) {
                isFriend = true;
                break;
            }
        }

        return isFriend;
    }

    public void addFriend(User user) {
        friends.add(user);
    }
}
