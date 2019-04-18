package com.tactfactory.webposter.webservice;

import com.google.gson.Gson;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.entities.User;
import com.tactfactory.webposter.webservice.base.BaseWebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class UserWebService extends BaseWebService<User,List<User>> {

    private static final String BASE_CONNECTION = "https://jsonplaceholder.typicode.com/users";

    public UserWebService() {
        super(BASE_CONNECTION);
    }

    @Override
    protected List<User> parseDatas(String s) throws JSONException {
        List<User> result = new ArrayList<User>();

        JSONArray jsonArray = new JSONArray(s);
        Gson gson = new Gson();
        for (int i = 0; i < jsonArray.length(); i++) {
            result.add(gson.fromJson(jsonArray.getJSONObject(i).toString(),User.class));
        }

        return result;
    }
}
