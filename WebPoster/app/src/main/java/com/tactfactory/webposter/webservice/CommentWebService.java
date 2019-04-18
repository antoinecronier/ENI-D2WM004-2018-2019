package com.tactfactory.webposter.webservice;

import com.google.gson.Gson;
import com.tactfactory.webposter.entities.Comment;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.webservice.base.BaseWebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class CommentWebService extends BaseWebService<Comment,List<Comment>> {

    private static final String BASE_CONNECTION = "https://jsonplaceholder.typicode.com/comments";

    public CommentWebService() {
        super(BASE_CONNECTION);
    }

    @Override
    protected List<Comment> parseDatas(String s) throws JSONException {
        List<Comment> result = new ArrayList<Comment>();

        JSONArray jsonArray = new JSONArray(s);
        Gson gson = new Gson();
        for (int i = 0; i < jsonArray.length(); i++) {
            result.add(gson.fromJson(jsonArray.getJSONObject(i).toString(),Comment.class));
        }

        return result;
    }
}
