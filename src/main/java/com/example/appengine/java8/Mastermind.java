package com.example.appengine.java8;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


/**
 * Sample Mastermind class...you should use your Mastermind v.4 code
 *    and modify it. Be sure and include the "implements Serializable"
 */
public class Mastermind implements Serializable {

    public String secretCode;
    public Mastermind(){
        secretCode="BBBB";  // just sample
    }
}