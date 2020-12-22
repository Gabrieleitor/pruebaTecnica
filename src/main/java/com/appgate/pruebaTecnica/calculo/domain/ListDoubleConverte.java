package com.appgate.pruebaTecnica.calculo.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.*;

@Converter
public class ListDoubleConverte implements AttributeConverter<List<Double>, String>  {

    @Override
    public String convertToDatabaseColumn(List<Double> operandos) {
        return  Objects.isNull(operandos) ? null : operandos.toString().replace("[", "").replace("]", "");
    }

    @Override
    public List<Double> convertToEntityAttribute(String aDouble) {
        if (Objects.isNull(aDouble) || Objects.equals("",aDouble)) {
            return new ArrayList<>();
        } else {
            List<Double> strings = new ArrayList<>();
            for (String dato : aDouble.split(",")) {
                strings.add(Double.parseDouble(dato));
            }
            return strings;
        }

    }
}
