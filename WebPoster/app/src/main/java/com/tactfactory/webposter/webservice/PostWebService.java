package com.tactfactory.webposter.webservice;

import com.google.gson.Gson;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.webservice.base.BaseWebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class PostWebService extends BaseWebService<Post,List<Post>> {

    private static final String BASE_CONNECTION = "https://jsonplaceholder.typicode.com/posts";

    public PostWebService() {
        super(BASE_CONNECTION);
    }

    @Override
    protected List<Post> parseDatas(String s) throws JSONException {
        List<Post> result = new ArrayList<Post>();

        JSONArray jsonArray = new JSONArray(s);
        Gson gson = new Gson();
        for (int i = 0; i < jsonArray.length(); i++) {
            result.add(gson.fromJson(jsonArray.getJSONObject(i).toString(),Post.class));
        }

        return result;
    }
}
