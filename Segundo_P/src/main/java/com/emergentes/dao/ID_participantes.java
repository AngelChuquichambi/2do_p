package com.emergentes.dao;

import com.emergentes.modelo.participantes;
import com.emergentes.basedatos.conexion_bd;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ID_participantes extends conexion_bd implements DAOparticipantes {

    @Override
    public void insert(participantes par) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO participantes (apellidos,nombres,id_seminario,confirmado) VALUES (?,?,?,?)");
            ps.setString(1, par.getApellidos());
            ps.setString(2, par.getNombres());
            ps.setInt(3, par.getId_seminario());
            ps.setInt(4, par.getConfirmado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(participantes par) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE participantes SET apellidos=?, nombres=?, id_seminario=?, comfirmado=? WHERE id=?");
            ps.setString(1, par.getApellidos());
            ps.setString(2, par.getNombres());
            ps.setInt(3, par.getId_seminario());
            ps.setInt(4, par.getConfirmado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM participantes WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public participantes getById(int id) throws Exception {
        participantes par = new participantes();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("select * from participantes where id = ");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                par.setId(rs.getInt("id"));
                par.setApellidos(rs.getString("apellidos"));
                par.setNombres(rs.getString("nombres"));
                par.setId_seminario(rs.getInt("id_seminario"));
                par.setConfirmado(rs.getInt("confirmado"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return par;
    }

    @Override
    public List<participantes> getAll() throws Exception {
        List<participantes> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("select * from participantes");            
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<participantes>();
            while (rs.next()){
                participantes par = new participantes();
                
                par.setId(rs.getInt("id"));
                par.setApellidos(rs.getString("apellidos"));
                par.setNombres(rs.getString("nombres"));
                par.setId_seminario(rs.getInt("id_seminario"));
                par.setConfirmado(rs.getInt("confirmado"));
                
                lista.add(par);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
