package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatadorData {

    public static final DateTimeFormatter DATA_BRASILEIRA_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static String formatarData(LocalDate localDate) {
        return DATA_BRASILEIRA_FORMATTER.format(localDate);
    }

    static LocalDate parseData(String data){
        return LocalDate.parse(data, DATA_BRASILEIRA_FORMATTER);
    }
}