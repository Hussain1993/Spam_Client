package com.Hussain.pink.triangle.Model.DatabaseQueries;

import com.Hussain.pink.triangle.Model.User;
import com.Hussain.pink.triangle.utils.DBUtils;
import org.apache.commons.dbutils.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Hussain on 08/12/2014.
 */
public class DatabaseQueries {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseQueries.class);

    private static final String PROPERTIES_FILE = "SpamClient.properties";
    private static final String CLASSNAME_KEY = "classname";
    private static final String PASSWORD_KEY = "password";
    private static final String USERNAME_KEY = "username";
    private static final String URL_KEY = "url";

    private static Connection conn;
    private static PreparedStatement stmt;

    private static void initDatabaseUtils() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        DBUtils.init(PROPERTIES_FILE,CLASSNAME_KEY,PASSWORD_KEY,USERNAME_KEY,URL_KEY);
    }

    public static boolean userExistsInDatabase(String username){
        String query = "SELECT USERNAME FROM USERS WHERE USERNAME = ?";
        try{
            if(!DBUtils.getInit())
            {
                initDatabaseUtils();
            }
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1,username);
            return stmt.executeQuery().isBeforeFirst();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            LOG.error("There was an error while initialising the database connection",e);
        }
        catch (SQLException e) {
            LOG.error("There was an error when getting the connection to the database",e);
        }
        finally {
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(stmt);
        }
        return false;
    }

    public static boolean addNewUserToDatabase(String username, String hashedPassword){
        String query = "INSERT INTO USERS(USERNAME,DATE_CREATED,PASSWORD) VALUES (?,?,?)";
        try{
            if(!DBUtils.getInit())
            {
                initDatabaseUtils();
            }
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1,username);
            stmt.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
            stmt.setString(3,hashedPassword);
            return stmt.executeUpdate() == 1;
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            LOG.error("There was an error while initialising the database connection",e);
        }
        catch (SQLException e) {
            LOG.error("There was an error when getting the connection to the database",e);
        }
        finally {
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(stmt);
        }
        return false;
    }

    public static User loginUser(String username, String hashedPassword){
        String query = "SELECT ID,USERNAME FROM USERS WHERE USERNAME=? AND PASSWORD=?";
        ResultSet usersReturned = null;
        try {
            if (!DBUtils.getInit()) {
                initDatabaseUtils();
            }
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(query);

            stmt.setString(1,username);
            stmt.setString(2,hashedPassword);

            usersReturned = stmt.executeQuery();

            //Check there are results returned by the array
            if(!usersReturned.first())
            {
                LOG.error("No users were found in the database with the username: {}",username);
            }
            //Check if there if there is more than one array
            else if(usersReturned.first() && usersReturned.next())
            {
                LOG.error("There was more than one user returned");
            }
            else
            {
                //Move the cursor back to the first row
                usersReturned.first();
                int id = usersReturned.getInt(1);
                String usernameReturned = usersReturned.getString(2);

                return new User(id,usernameReturned);
            }

        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            LOG.error("There was an error while initialising the database connection",e);
        }
        catch (SQLException e) {
            LOG.error("There was an error when getting the connection to the database",e);
        }
        finally {
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(usersReturned);
        }
        return null;
    }
}
