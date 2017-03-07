package com.stackoverflow.p42618757.api;

import java.rmi.RemoteException;

import javax.ejb.Remote;


@Remote
public interface ServiceBeanInterface {

    String getHelloString() throws RemoteException;

}
