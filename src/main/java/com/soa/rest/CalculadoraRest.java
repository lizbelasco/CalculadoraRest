/**
 * 
 */
package com.soa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soa.business.CalculadoraBusiness;
import com.soa.dto.EntradaCalculadora;
import com.soa.dto.SalidaCalculadora;

/**
 * 
 */
@RestController
public class CalculadoraRest {

    @Autowired
    private CalculadoraBusiness calculadoraBusiness;
    
    @PostMapping("/calculadora")
    public ResponseEntity<SalidaCalculadora> calcular(
            @RequestBody EntradaCalculadora entradaCalculadora) {
        ResponseEntity<SalidaCalculadora> re = null;
        
        SalidaCalculadora salidaCalculadora = new SalidaCalculadora();
        double result = calculadoraBusiness.calcular(
                entradaCalculadora.getNumero1(),
                entradaCalculadora.getNumero2(), 
                entradaCalculadora.getOperacion());
        salidaCalculadora.setResultado(result);
        re = new ResponseEntity<SalidaCalculadora>(
                salidaCalculadora, HttpStatus.OK);
        return re;
    }
}
