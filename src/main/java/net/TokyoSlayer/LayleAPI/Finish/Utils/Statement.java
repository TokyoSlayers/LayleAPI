package net.TokyoSlayer.LayleAPI.Finish.Utils;

import net.TokyoSlayer.LayleAPI.Finish.Utils.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Statement {

    public void createTable(){
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `LayleServ_State` (ServerName VARCHAR(255),Stat VARCHAR(255),NumberPlayers int(11),Tps int(255))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createStatement(String state, String serverName,int tps){
        try {
            PreparedStatement sts = MySQL.getConnection().prepareStatement("SELECT `Stat` FROM `LayleServ_State` WHERE `ServerName`='" + serverName + "'");
            ResultSet rs = sts.executeQuery();
            if(!rs.next()) {
                sts.close();
                sts = MySQL.getConnection().prepareStatement("INSERT INTO `LayleServ_State` (ServerName, Stat,NumberPlayers,Tps) VALUES ('" + serverName + "','" + state + "','" + 0 + "','"+ tps +"')");
                sts.executeUpdate();
                sts.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setStatement(String state, String serverName){
        try {
            PreparedStatement sts = MySQL.getConnection().prepareStatement("UPDATE `LayleServ_State` SET `Stat`='" + state + "' WHERE `ServerName`='"+ serverName +"'");
            sts.executeUpdate();
            sts.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getStatement(String serverName){
        String dif = "null";
        try {
            PreparedStatement sts = MySQL.getConnection().prepareStatement("SELECT `Stat` FROM `LayleServ_State` WHERE `ServerName`='" + serverName + "'");
            ResultSet rs = sts.executeQuery();
            if (rs.next()){
                dif = rs.getString("Stat");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dif;
    }

    public void setTps(int tps, String serverName){
        try {
            PreparedStatement sts = MySQL.getConnection().prepareStatement("UPDATE `LayleServ_State` SET `Tps`='" + tps + "' WHERE `ServerName`='"+ serverName +"'");
            sts.executeUpdate();
            sts.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getTps(String serverName){
        int dif = 0;
        try {
            PreparedStatement sts = MySQL.getConnection().prepareStatement("SELECT `Tps` FROM `LayleServ_State` WHERE `ServerName`='" + serverName + "'");
            ResultSet rs = sts.executeQuery();
            if (rs.next()){
                dif = rs.getInt("Tps");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dif;
    }

    public void setNumberPlayer(int numberPlayer, String serverName){
        try {
            PreparedStatement sts = MySQL.getConnection().prepareStatement("UPDATE `LayleServ_State` SET `NumberPlayers`='" + numberPlayer + "' WHERE `ServerName`='"+ serverName +"'");
            sts.executeUpdate();
            sts.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNumberPlayer(String serverName){
        int dif = 0;
        try {
            PreparedStatement sts = MySQL.getConnection().prepareStatement("SELECT `NumberPlayers` FROM `LayleServ_State` WHERE `ServerName`='" + serverName + "'");
            ResultSet rs = sts.executeQuery();
            if (rs.next()){
                dif = rs.getInt("NumberPlayers");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dif;
    }
}
