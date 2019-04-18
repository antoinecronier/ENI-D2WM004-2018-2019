package com.tactfactory.webposter.database;

import com.tactfactory.webposter.database.dao.AddressDao;
import com.tactfactory.webposter.database.dao.CommentDao;
import com.tactfactory.webposter.database.dao.CompanyDao;
import com.tactfactory.webposter.database.dao.GeoDao;
import com.tactfactory.webposter.database.dao.PostDao;
import com.tactfactory.webposter.database.dao.UserDao;
import com.tactfactory.webposter.database.dao.base.BaseDao;
import com.tactfactory.webposter.entities.Address;
import com.tactfactory.webposter.entities.Comment;
import com.tactfactory.webposter.entities.Company;
import com.tactfactory.webposter.entities.Geo;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.entities.User;

public class DbManager {
    private BaseDao<Address> addressDao;
    private BaseDao<Comment> commentDao;
    private BaseDao<Company> companyDao;
    private BaseDao<Geo> geoDao;
    private BaseDao<Post> postDao;
    private BaseDao<User> userDao;

    public BaseDao<Address> getAddressDao() {
        if (addressDao == null){
            addressDao = new AddressDao();
        }
        return addressDao;
    }

    public BaseDao<Comment> getCommentDao() {
        if (commentDao == null){
            commentDao = new CommentDao();
        }
        return commentDao;
    }

    public BaseDao<Company> getCompanyDao() {
        if (companyDao == null){
            companyDao = new CompanyDao();
        }
        return companyDao;
    }

    public BaseDao<Geo> getGeoDao() {
        if (geoDao == null){
            geoDao = new GeoDao();
        }
        return geoDao;
    }

    public BaseDao<Post> getPostDao() {
        if (postDao == null){
            postDao = new PostDao();
        }
        return postDao;
    }

    public BaseDao<User> getUserDao() {
        if (userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }

    public DbManager(){
    }
}
