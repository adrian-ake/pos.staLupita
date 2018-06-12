/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.herramientas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Adrian Alonso Aké Ek
 */
public class SpringContextLoad {
    
    private static ApplicationContext context = null;
    
    public static ApplicationContext getContext(){
        if(context == null){
            context = new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
        }else if(!((ClassPathXmlApplicationContext)context).isRunning()){
            context = new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
        }
        return context;
    }
    
}
