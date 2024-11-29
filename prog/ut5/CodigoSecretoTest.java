package ut5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CodigoSecretoTest {
    @Test
    @DisplayName("Constructor")
    void testConstructor() {
        int longitud = 50;
        CodigoSecreto codigoSecreto = new CodigoSecreto(longitud);
        Assertions.assertEquals(longitud, codigoSecreto.codigo.length);
        System.out.println(Arrays.toString(codigoSecreto.codigo));
    }

    @Test
    @DisplayName("Convertir de string a int[]")
    void testConvierteCodigo(){
        Assertions.assertAll(
                ()->Assertions.assertEquals(1111, arrayToInt(new CodigoSecreto(4).convierteCodigo("1111")) ),
                ()->Assertions.assertEquals(1, arrayToInt(new CodigoSecreto(1).convierteCodigo("1")) ),
                ()->Assertions.assertEquals(459507856, arrayToInt(new CodigoSecreto(4).convierteCodigo("459507856")) ),
                ()->Assertions.assertEquals(000, arrayToInt(new CodigoSecreto(4).convierteCodigo("000")) ),
                ()->Assertions.assertEquals(999, arrayToInt(new CodigoSecreto(4).convierteCodigo("999")) )
        );
    }

    @Test
    @DisplayName("Prueba codigo")
    void testPruebaCodigo(){
        CodigoSecreto codigoSecreto = new CodigoSecreto(5);
        codigoSecreto.codigo = new int[]{1, 3, 8, 2, 6};
        Assertions.assertAll(
                ()->Assertions.assertTrue( codigoSecreto.pruebaCodigo(new int[]{1, 3, 8, 2, 6}) ),
                ()->Assertions.assertFalse( codigoSecreto.pruebaCodigo(new int[]{1, 3, 8, 2, 4}) )
        );

    }

    @Test
    @DisplayName("muestra prueba")
    void testMuestraPrueba(){
        CodigoSecreto codigoSecreto = new CodigoSecreto(5);
        codigoSecreto.codigo = new int[]{1, 3, 8, 9};
        Assertions.assertAll(
                ()->Assertions.assertEquals("mmMM0", codigoSecreto.muestraPrueba(new int[]{5,5,5,5})),
                ()->Assertions.assertEquals("mM=M1", codigoSecreto.muestraPrueba(new int[]{2,2,8,8})),
                ()->Assertions.assertEquals("====4", codigoSecreto.muestraPrueba(new int[]{1,3,8,9}))
        );
    }

    int arrayToInt(int[] entrada){
        int longitud = entrada.length;
        int resultado = 0;
        for (int i = 0; i < longitud; i++) {
            resultado += entrada[i] * Math.pow(10, longitud-i-1);
        }
        return resultado;
    }

}
