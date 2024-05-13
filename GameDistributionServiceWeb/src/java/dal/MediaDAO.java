/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DAOInterface.IMediaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Media;
import dal.DAOInterface.IGameDAO;
import java.util.ArrayList;
import model.Category;
import model.Game;

/**
 *
 * @author ACER
 */
public class MediaDAO extends DBContext implements IMediaDAO {

    @Override
    public List<Media> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Media t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Media t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Media t) {
        String sql = "Delete from [Media] where Link = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setString(1, t.getLink());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public Media get(String link) {
        IGameDAO gameDAO = new GameDAO();
        String sql = "SELECT * FROM [dbo].[Media] where Link = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        ResultSet resultSet = null;
        try {
            preparedStatement.setString(1, link);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                Media m = new Media(gameDAO.get(resultSet.getInt("GameID")), link, resultSet.getInt("Type"));
                return m;
            }
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    @Override
    public int uploadVideo(Media g) {
        List<Game> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Game get = list.get(list.size() - 1);
            get.getGameID();

        }

        int count = 0;
        String sql = "INSERT INTO [dbo].[Media]\n"
                + "           ([GameID]\n"
                + "           ,[Link]\n"
                + "           ,[Type])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = getPreparedStatement(sql, connection);
        try {
            preparedStatement.setInt(1, 1);
            preparedStatement.setFloat(2, 0);
            preparedStatement.setInt(3, 0);
            count = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
        return count;
    }

    @Override
    public int uploadDemo(Media g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        GameDAO gdd = new GameDAO();

        List<Game> list = gdd.getGame();
        for (Game g : list) {
            System.out.println(g.getGameID());
        }
        
    }

}
