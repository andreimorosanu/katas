package com.katas.refactoring.tdd.tripservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserShould {

    @Test
    public void returnTrueWhenUsersAreFriends() throws Exception {
        User loggedUser = new User();
        User friend = new User();

        friend.addFriend(loggedUser);

        assertTrue(friend.isFriendWith(loggedUser));
    }

}