package com.appgate.pruebaTecnica.app.calculo;

import org.apache.tomcat.util.buf.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<Double> list = new ArrayList<Double>();
        list.add(1.38);
        list.add(6.38);
        list.add(78.38);
        String listado =list.toString().replace("[","").replace("]","");
        System.out.println("Listado "+listado);

        List<Double> strings = new ArrayList<>();

        for (String dato:listado.split(",")) {
            strings.add(Double.parseDouble(dato));
        }

//        List<Double> list2 = Collections.singletonList(Double.parseDouble( Arrays.asList(String.valueOf(listado.split(",")))));

        strings.forEach(System.out::println);

    }
}
