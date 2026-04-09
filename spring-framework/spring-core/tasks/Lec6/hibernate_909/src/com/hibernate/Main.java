package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Friend;
import com.hibernate.model.Post;
import com.hibernate.model.User;
import com.hibernate.model.UserDetails;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

        // create user
        User newUser = new User("Mohamed", 22);

        // create user details
        UserDetails details =
                new UserDetails("Mansoura", "01012345678");

        session.save(details);

        newUser.setUserDetails(details);

        // create friends
        Friend friend1 = new Friend("Ahmed");
        Friend friend2 = new Friend("Ali");

        session.save(friend1);
        session.save(friend2);

        newUser.getFriends().add(friend1);
        newUser.getFriends().add(friend2);

        // create posts
        Post post1 = new Post("First Post", "Hello Hibernate");
        Post post2 = new Post("Second Post", "Oracle Database");

        post1.setUser(newUser);
        post2.setUser(newUser);

        session.save(post1);
        session.save(post2);

        // save user
        session.save(newUser);

        session.getTransaction().commit();

        // test lazy and eager
        Session session2 = factory.openSession();

        User user = session2.get(User.class, newUser.getId());

        System.out.println("User Name: " + user.getName());

        System.out.println("Friends:");
        for (Friend friend : user.getFriends()) {
            System.out.println(friend.getName());
        }

        System.out.println("User Details Address:");
        System.out.println(user.getUserDetails().getAddress());

        session2.close();
        session.close();
        factory.close();
    }
}