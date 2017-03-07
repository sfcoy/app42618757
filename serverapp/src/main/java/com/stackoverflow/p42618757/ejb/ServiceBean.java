package com.stackoverflow.p42618757.ejb;

import javax.ejb.Stateless;

import com.stackoverflow.p42618757.api.ServiceBeanInterface;

/**
 * @author sfcoy
 */
@Stateless
public class ServiceBean implements ServiceBeanInterface {

    @Override
    public String getHelloString() {
        return "Hello";
    }
    
}
