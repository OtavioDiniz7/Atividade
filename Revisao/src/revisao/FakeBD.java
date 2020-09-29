/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabiana
 */
public class FakeBD {

    private static Vector<Produto> produtos;

    //leitura excel
    private static void cargaArquivo() {

        if (produtos == null) {
            produtos = new Vector<>();
        } else {
            produtos.clear();
        }

        File arquivoCSV = new File("C:\\Downloads\\produtos.csv");

        try {
            FileReader marcaLeitura = new FileReader(arquivoCSV);

            BufferedReader bufLeitura = new BufferedReader(marcaLeitura);

            //ler
            bufLeitura.readLine();
            String linha = bufLeitura.readLine();

            while (linha != null) {

                String infos[] = linha.split(";");

                int cod = Integer.parseInt(infos[0]);
                String nome = infos[1];
                double preco = Double.parseDouble(infos[2]);
                int quant = Integer.parseInt(infos[3]);

                produtos.add(new Produto(cod, nome, preco, quant));
                linha = bufLeitura.readLine();
            }
            bufLeitura.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo espec. não existe");
        } catch (IOException ex) {
            System.out.println("Arquivo corrompido");
        }

    }

    public static Produto conProdCod(int cod) {

        if (produtos == null) {
            cargaArquivo();
        }

        for (Produto prodI : produtos) {
            if (prodI.getCod() == cod) {
                return prodI;
            }
        }
        return null;
    }

    public static void atualizaArquivo() {

        File arquivo = new File("C:\\Downloads\\produtos.csv");

        try {
            FileWriter escritor = new FileWriter(arquivo);

            BufferedWriter bufEscrita = new BufferedWriter(escritor);

            for (int i = 0; i < produtos.size(); i++) {
                bufEscrita.write(produtos.get(i) + "\n");
            }
            bufEscrita.flush();
            bufEscrita.close();

        } catch (IOException ex) {
            System.out.println("dispositivo com falha");
        }

    }

}
