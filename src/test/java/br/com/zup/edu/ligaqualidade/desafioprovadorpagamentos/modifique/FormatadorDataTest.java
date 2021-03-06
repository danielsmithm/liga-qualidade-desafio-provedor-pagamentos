package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FormatadorDataTest {

    @Test
    void formatarData() {
        assertEquals("06/03/2021", FormatadorData.formatarData(LocalDate.of(2021,3,6)));
    }

    @Test
    void parseData() {
        assertEquals(LocalDate.of(2021,3,6), FormatadorData.parseData("06/03/2021"));
    }

}