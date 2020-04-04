package com.company;

/*

2017 Deserialization
A stream is fed to the input into which a class A or class B serialized object is written.
Deserialize the object in the getOriginalObject method so that if an exception occurs, a message is displayed and null returned.
Implement the Serializable interface where necessary.

Requirements:
1. Class B must be a descendant of Class A.
2. Class A must support the Serializable interface.
3. Class B should not explicitly support the Serializable interface.
4. The getOriginalObject method must return an A-type object derived from the ObjectInputStream stream.
5. The getOriginalObject method must return null if no type A object was received when attempting to deserialize.
6. The getOriginalObject method should return null if an exception was encountered when trying to deserialize.


 */

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        A a = null;
        try {
            a = (A) objectStream.readObject();
        } catch (NotSerializableException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return a;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}

