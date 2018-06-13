/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.repository;

/**
 *
 * @author adrian.ake
 */
public interface GenericDAOI {

    public void saveOrUpdate(Object obj);

    public void save(Object obj);
   
}
