/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.Slider;
import Entity.User;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Vector;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phuan
 */
public class DAOSlider extends DBContext {

    public Vector<Slider> getSlider(String sql) {
        Vector<Slider> vector = new Vector<Slider>();
        try {
            Statement sta = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                int sliderID = rs.getInt("sliderID");
                String title = rs.getString("title");
                String image = rs.getString("image");
                String link = rs.getString("link");
                int status = rs.getInt("status");
                String notes = rs.getString("notes");
                int userID = rs.getInt("userID");
                User us = new User();

                Slider sl = new Slider(sliderID, title, image, link, status, notes, us);
                vector.add(sl);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }

        return vector;

    }
      public Vector<Integer> getStatus(String sql) {
        Vector<Integer> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                vector.add(rs.getInt("status"));
            }
        } catch (Exception ex) {
        }

        return vector;
    }
 public int updateSlider(Slider obj) {
        int n = 0;
        String sql = "UPDATE [dbo].[Slider]\n"
                + "   SET \n [title] = ?" 
                + "      ,[image] = ?\n"
                + "      ,[link] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[notes] = ?\n"
                + "      ,[UserID] = ?\n"
                + " WHERE [sliderID] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getTitle());
            pre.setString(2, obj.getImage());
            pre.setString(3, obj.getLink());
            pre.setInt(4, obj.getStatus());
            pre.setString(5,obj.getNotes());
            pre.setInt(6, obj.getUserID());
            pre.setInt(7, obj.getSliderID());
            
            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
           
        }
        
        return n;
    }
    public static void main(String[] args) {
        DAOSlider db = new DAOSlider();
        System.out.println(db.getSlider(" SELECT top 1 * FROM Slider ORDER BY page_order"));
    }
}
