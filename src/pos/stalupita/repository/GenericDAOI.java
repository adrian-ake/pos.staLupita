/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.repository;

import java.util.List;

/**
 *
 * @author adrian.ake
 */
public interface GenericDAOI {

    public List<Object> getAllObjects();

    public Object getObjectbyID(Integer id);

    public Object getObjectbyID(String id);

    public void saveObject(Object object);

    public void saveorUpdateObject(Object object);

    public void updateObject(Object object);
}
