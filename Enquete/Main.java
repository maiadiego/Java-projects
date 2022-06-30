package Enquete;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Locale loc = new Locale("en", "US");
        ArrayList<Resposta> respostas = new ArrayList<Resposta>();

        // lê as informações do arquivo
        try {
            File f = new File("respostas.txt"); // ou informar o path
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                int qtdPessoas = sc.nextInt();
                double rendaTotal = sc.useLocale(loc).nextDouble();
                String estado = sc.nextLine();
                Resposta resp = new Resposta(qtdPessoas, rendaTotal, estado);
                respostas.add(resp);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Comparator<Resposta> customComparator = new Comparator<Resposta>() {
            @Override
            public int compare(Resposta r1, Resposta r2) {
                if (r1.getEstado().compareTo(r2.getEstado()) == 0) { // empate estado
                    if (r1.getQtdPessoas() == r2.getQtdPessoas()) { // empate qtdpessoas
                        if (r1.getRendaTotal() < r2.getRendaTotal()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    } else { // se não houve empate por qtd pessoas
                        if (r1.getQtdPessoas() > r2.getQtdPessoas()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                } else { // se não empatou no estado
                    return r1.getEstado().compareTo(r2.getEstado());
                }
            }
        };
        // chamada do comparador customizado
        List<Resposta> sortedList = respostas.stream()
                .sorted(customComparator)
                .collect(Collectors.toList());

        for (Resposta s : sortedList) {
            System.out.println("Qtd pessoas na família: " + s.getQtdPessoas());
            System.out.println("Renda total: " + s.getRendaTotal());
            System.out.println("Estado: " + s.getEstado());
            System.out.println("\n");
        }
    }
}
