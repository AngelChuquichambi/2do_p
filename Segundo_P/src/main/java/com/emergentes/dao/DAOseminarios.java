package com.emergentes.dao;

import java.util.List;
import com.emergentes.modelo.seminarios;

public interface DAOseminarios {
    
    public void insert(seminarios sem) throws Exception;

    public void update(seminarios sem) throws Exception;

    public void delete(int id) throws Exception;

    public seminarios getById(int id) throws Exception;

    public List<seminarios> getAll() throws Exception;
}
