package com.emergentes.dao;

import com.emergentes.modelo.seminarios;
import com.emergentes.basedatos.conexion_bd;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IDseminario extends conexion_bd implements DAOseminarios {

    @Override
    public void insert(seminarios sem) throws Exception {
         try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO seminarios (titulo,fecha,cupo) VALUES (?,?,?,)");
            ps.setString(1, sem.getTitulo());
            ps.setString(2, sem.getFecha());
            ps.setInt(3, sem.getCupo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(seminarios sem) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE seminarios set titulo =?, fecha=?, cupo=?) WHERE id =?");
            ps.setString(1, sem.getTitulo());
            ps.setString(2, sem.getFecha());
            ps.setInt(3, sem.getCupo());
            ps.setInt(4,sem.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM seminarios WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public seminarios getById(int id) throws Exception {
        seminarios sem = new seminarios();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM seminarios WHERE id = ");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setFecha(rs.getString("fecha"));
                sem.setCupo(rs.getInt("cupo"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return sem;
    }

    @Override
    public List<seminarios> getAll() throws Exception {
        List<seminarios> lista = null;
        try {
            this.conectar();
            
            try (PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM seminarios")) {
                ResultSet rs = ps.executeQuery();
                
                lista = new ArrayList<seminarios>();
                while (rs.next()){
                    seminarios sem = new seminarios();
                    
                    sem.setId(rs.getInt("id"));
                    sem.setTitulo(rs.getString("titulo"));
                    sem.setFecha(rs.getString("fecha"));
                    sem.setCupo(rs.getInt("cupo"));
                    
                    lista.add(sem);
                }
                rs.close();
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
