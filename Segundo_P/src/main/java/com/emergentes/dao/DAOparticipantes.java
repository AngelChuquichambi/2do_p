package com.emergentes.dao;

import com.emergentes.modelo.participantes;
import java.util.List;

public interface DAOparticipantes {

    public void insert(participantes par) throws Exception;

    public void update(participantes par) throws Exception;

    public void delete(int id) throws Exception;

    public participantes getById(int id) throws Exception;

    public List<participantes> getAll() throws Exception;
}
