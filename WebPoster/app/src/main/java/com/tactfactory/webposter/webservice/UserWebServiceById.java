package com.tactfactory.webposter.webservice;

import com.google.gson.Gson;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.entities.User;
import com.tactfactory.webposter.webservice.base.BaseWebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class UserWebServiceById extends BaseWebService<User,User> {

    private static final String BASE_CONNECTION = "https://jsonplaceholder.typicode.com/users";

    public UserWebServiceById(Post post) {
        super(BASE_CONNECTION + "/" + post.getUserId());
    }

    @Override
    protected User parseDatas(String s) {
        Gson gson = new Gson();
        return (User) gson.fromJson(s,User.class);
    }
}
